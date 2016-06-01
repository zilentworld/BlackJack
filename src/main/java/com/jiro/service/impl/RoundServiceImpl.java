package com.jiro.service.impl;

import com.jiro.constants.Constants;
import com.jiro.dao.RoundDao;
import com.jiro.model.*;
import com.jiro.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        System.out.println("initialCards:"+roundPlayerList.size());
        if (roundPlayerList.size() > 0) {
            Deck playDeck = round.getGame().getPlayDeck();

            if(playDeck == null) {
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

            round.getGame().setPlayDeck(playDeck);
        }
    }

    @Override
    public void givePlayerCards(Round round, Deck playDeck) {
        List<RoundPlayer> roundPlayerList = round.getRoundPlayerList();
        roundPlayerList.forEach(roundPlayer ->
                cardHandService.addCard(
                        roundPlayer.getRoundPlayerCardHandList().get(0).getCardHand()
                        , playDeck, true));
    }

    @Override
    public boolean joinRound(long roundId, long playerId, int initialBet) {
        return joinRound(roundDao.findOne(roundId), accountService.findById(playerId), initialBet);
    }

    @Override
    public boolean joinRound(Round round, Account player, int initialBet) {
        if (round.getRoundPlayerList().size() < Constants.MAX_PLAYER_COUNT)
            if (accountService.canMakeBet(player, initialBet)) {
                accountService.deductChips(player, initialBet);
                round.getRoundPlayerList().add(roundPlayerService.newRoundPlayer(round, player, initialBet));

                return true;
            }

        return false;
    }

    @Override
    public Round findById(long roundId) {
        return roundDao.findOne(roundId);
    }
}