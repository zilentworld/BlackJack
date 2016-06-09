package com.jiro.service.impl;

import com.jiro.constants.Constants;
import com.jiro.dao.RoundDao;
import com.jiro.enums.CardHandStatus;
import com.jiro.enums.WinType;
import com.jiro.model.*;
import com.jiro.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by dev-pc on 5/30/16.
 */
@Service
public class RoundServiceImpl implements RoundService {

    @Autowired
    private RoundDao roundDao;
    @Autowired
    private CardHandService cardHandService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private GameService gameService;
    @Autowired
    private GameDeckService gameDeckService;
    @Autowired
    private RoundPlayerService roundPlayerService;
    @Autowired
    private RoundDealerCardsService roundDealerCardsService;
    @Autowired
    private RoundPlayerCardsService roundPlayerCardsService;


    @Override
    public Round createNewRound(long gameId) {
        return createNewRound(gameService.findById(gameId));
    }

    @Override
    public Round createNewRound(Game game) {
        Round round = new Round(game);
        round.setDealer(game.getDealer());
        game.getRoundList().add(round);
        roundDao.save(round);
        game.getRoom().incRoundCount();

        return round;
    }

    @Override
    public void startRound(long roundId) {
        Round round = roundDao.findOne(roundId);
        distributeInitialCards(round);

        System.out.println("Displaying Round:");
        System.out.println(round.toString());
    }

    /**
     * Distributes two visible cards for every participating player,
     * and one visible and one invisible card for the dealer.
     * Order of distribution is dealerInvi -> playerCards -> dealerVisi -> playerCards
     *
     * @param round = round to distribute cards.
     */
    @Override
    public void distributeInitialCards(Round round) {
        List<RoundPlayer> roundPlayerList = round.getRoundPlayerList();
        System.out.println("initialCards:" + roundPlayerList.size());
        if (roundPlayerList.size() > 0) {
            Deck playDeck = round.getGame().getPlayDeck();

            if (playDeck == null) {
                System.out.println("deck is NULL");
                playDeck = gameDeckService.getDeck(round.getGame().getGameDeck().getDeckId());
            }

            CardHand dealerHand = round.getDealerHand();

            //get dealer first hand. not visible
            cardHandService.addCard(dealerHand, playDeck, true);
            //get 1st card for all players
            givePlayerCards(round, playDeck);

            //get dealer second hand. visible
            cardHandService.addCard(dealerHand, playDeck, true);
            //get 2nd card for all players
            givePlayerCards(round, playDeck);

            gameDeckService.updateGameDeck(round.getGame().getGameDeck(), playDeck);

            System.out.println("save dealer card");
            roundDealerCardsService.saveDealerCards(round);

            System.out.println("save player cards");
            roundPlayerList.forEach(roundPlayer ->
                    roundPlayer.getRoundPlayerCardHandList().forEach(roundPlayerCardHand ->
                            roundPlayerCardsService.saveRoundPlayerCardHand(roundPlayerCardHand)
                    )
            );

            round.getGame().setPlayDeck(playDeck);
        } else {
            System.out.println("EMPTY ROUND");
        }
    }

    @Override
    public void givePlayerCards(Round round, Deck playDeck) {
        List<RoundPlayer> roundPlayerList = round.getRoundPlayerList();
        roundPlayerList.forEach(roundPlayer ->
                cardHandService.addCard(
                        roundPlayer.getRoundPlayerCardHandList().get(0).getCardHand(),
                        playDeck, true)
        );
    }

    @Override
    public boolean joinRound(long roundId, long playerId, int initialBet) {
        try {
            return joinRound(roundDao.findOne(roundId), accountService.findById(playerId), initialBet);
        } catch (RemoteException e) {
            System.out.println("remote exception");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean joinRound(Round round, Account player, int initialBet) {
        System.out.println("join round");
        if (round.getRoundPlayerList().size() < Constants.MAX_PLAYER_COUNT) {
            if (accountService.canMakeBet(player, initialBet)) {
                accountService.deductChips(player, initialBet);
                round.getRoundPlayerList().add(roundPlayerService.newRoundPlayer(round, player, initialBet));

                return true;
            } else
                System.out.println("Player is poor");
        } else
            System.out.println("Room is Full");

        return false;
    }

    @Override
    public Round findById(long roundId) {
        return roundDao.findOne(roundId);
    }

    @Override
    public void finishDealerHand(long roundId) {
        System.out.println("FinishDealerHand:roundId:"+roundId);
        Round round = roundDao.findOne(roundId);
        System.out.println("found round");
        CardHand cardHand = round.getDealerHand();
        cardHand.getCards().forEach(card -> card.setVisible(true));
        while (cardHand.getHandValue() < 17) {
            roundDealerCardsService.addDealerCard(
                    round, cardHandService.addCard(cardHand,
                            round.getGame().getPlayDeck(), true)
            );
        }
    }

    @Override
    public void finishRound(long roundId) {
        System.out.println("finish round");
        Round round = roundDao.findOne(roundId);
        round.getRoundPlayerList().forEach(roundPlayer ->
                roundPlayer.getRoundPlayerCardHandList().forEach(
                        roundPlayerCardHand -> updateWinLoss(roundPlayerCardHand, round)
                )
        );
    }

    private void updateWinLoss(RoundPlayerCardHand roundPlayerCardHand, Round round) {
        System.out.println("Update winloss");
        Account player = roundPlayerCardHand.getRoundPlayer().getPlayer();
        int betAmount = roundPlayerCardHand.getBetAmount();
        int chipsEarned;
        switch (updateCardHandStatus(roundPlayerCardHand, round.getDealerHand())) {
            case PLAYER_BLACKJACK:
                chipsEarned = amountWon(betAmount, Constants.BLACKJACK_PAYOUT);
                break;
            case PLAYER_WIN:
                chipsEarned = amountWon(betAmount, Constants.DEFAULT_PAYOUT);
                break;
            case BLACKJACK_PUSH:
            case PUSH:
                chipsEarned = betAmount;
                break;
            default:
                chipsEarned = 0;
        }
        accountService.increaseChips(player, chipsEarned);
    }

    private int amountWon(int betAmount, double multiplier) {
        return betAmount + (int) (betAmount * multiplier);
    }

    private WinType updateCardHandStatus(RoundPlayerCardHand roundPlayerCardHand, CardHand dealerHand) {
        WinType winType;
        CardHand playerCardHand = roundPlayerCardHand.getCardHand();
        int playerCardCount = roundPlayerCardHand.getCardHandCount();
        int dealerCardCount = dealerHand.getHandValue();
        if (roundPlayerCardHand.getCardHandStatus() == CardHandStatus.LOST)
            winType = WinType.DEALER_WIN;
        else {
            if (dealerCardCount == 21 && playerCardCount == 21
                    && dealerHand.getCards().size() == 2
                    && playerCardHand.getCards().size() == 2) {
                roundPlayerCardHand.setCardHandStatus(CardHandStatus.PUSH);
                winType = WinType.BLACKJACK_PUSH;
            } else if (dealerCardCount == 21 && dealerHand.getCards().size() == 2) {
                roundPlayerCardHand.setCardHandStatus(CardHandStatus.LOST);
                winType = WinType.DEALER_BLACKJACK;
            } else if (playerCardCount == 21 && playerCardHand.getCards().size() == 2) {
                roundPlayerCardHand.setCardHandStatus(CardHandStatus.BLACKJACK);
                winType = WinType.PLAYER_BLACKJACK;
            } else if (dealerCardCount == playerCardCount) {
                roundPlayerCardHand.setCardHandStatus(CardHandStatus.PUSH);
                winType = WinType.PUSH;
            } else if (playerCardCount > dealerCardCount && playerCardCount <= 21) {
                roundPlayerCardHand.setCardHandStatus(CardHandStatus.WON);
                winType = WinType.PLAYER_WIN;
            } else if (playerCardCount < dealerCardCount && dealerCardCount <= 21) {
                roundPlayerCardHand.setCardHandStatus(CardHandStatus.LOST);
                winType = WinType.DEALER_WIN;
            } else
                winType = WinType.PUSH;
        }

        roundPlayerCardsService.saveRoundPlayerCardHand(roundPlayerCardHand);
        return winType;
    }

    @Override
    public List<Round> getDealerRounds(long dealerId) {
        return roundDao.findByDealerId(dealerId);
    }
}