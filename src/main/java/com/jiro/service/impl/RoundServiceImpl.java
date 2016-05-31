package com.jiro.service.impl;

import com.jiro.constants.Constants;
import com.jiro.dao.RoundDao;
import com.jiro.dao.RoundPlayerCardHandDao;
import com.jiro.dao.RoundPlayerDao;
import com.jiro.model.*;
import com.jiro.service.AccountService;
import com.jiro.service.CardHandService;
import com.jiro.service.GameService;
import com.jiro.service.RoundService;
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
    private RoundPlayerDao roundPlayerDao;
    @Autowired
    private RoundPlayerCardHandDao roundPlayerCardHandDao;


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
            CardHand dealerHand = round.getDealerHand();

            //TODO
            //get dealer first hand. not visible
            cardHandService.addCard(dealerHand, playDeck, false);
            //get 1st card for all players
            roundPlayerList.forEach(roundPlayer ->
                    cardHandService.addCard(
                            roundPlayer.getRoundPlayerCardHandList().get(0).getCardHand()
                            , playDeck, true));

            //get dealer second hand. visible
            cardHandService.addCard(dealerHand, playDeck, true);
            //get 2nd card for all players
            roundPlayerList.forEach(roundPlayer ->
                    cardHandService.addCard(
                            roundPlayer.getRoundPlayerCardHandList().get(0).getCardHand()
                            , playDeck, true));
        }
    }

    @Override
    public boolean joinRound(long roundId, long playerId, int initialBet) {
        return joinRound(roundDao.findOne(roundId), accountService.findById(playerId), initialBet);
    }

    @Override
    public boolean joinRound(Round round, Account player, int initialBet) {
        if (round.getRoundPlayerList().size() < Constants.MAX_PLAYER_COUNT)
            if (accountService.makeBet(player, initialBet)) {
                RoundPlayer roundPlayer = new RoundPlayer(round, player, initialBet);
                roundPlayerDao.save(roundPlayer);
                roundPlayerCardHandDao.save(roundPlayer.getRoundPlayerCardHandList().get(0));
                round.getRoundPlayerList().add(roundPlayer);

                return true;
            }

        return false;
    }

    @Override
    public Round findById(long roundId) {
        return roundDao.findOne(roundId);
    }
}