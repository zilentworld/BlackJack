package com.jiro.model;

import javax.persistence.*;

/**
 * Created by dev-pc on 5/31/16.
 */
@Entity
@Table(name = "game_deck")
public class GameDeck {

    @Id
    @Column(name = "deck_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deckId;

    @Column(name = "full_deck")
    private String fullDeck;

    @Column(name = "deck_size")
    private int deckSize;

    @OneToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public long getDeckId() {
        return deckId;
    }

    public void setDeckId(long deckId) {
        this.deckId = deckId;
    }

    public String getFullDeck() {
        return fullDeck;
    }

    public void setFullDeck(String fullDeck) {
        this.fullDeck = fullDeck;
    }

    public int getDeckSize() {
        return deckSize;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameDeck() {}

    public GameDeck(Deck deck) {
        if(deck != null && deck.getCardList() != null) {
            parseDeck(deck);
        }
        this.game = deck.getGame();
        this.deckSize = deck.getDeckSize();
    }

    public void parseDeck(Deck deck) {
        StringBuilder sb = new StringBuilder();
        int a = 0 ;
        for(Card card : deck.getCardList()) {
            sb.append(card.toDbFormat());
            if(a++ < deck.getCardList().size() - 1)
                sb.append(":");
        }
        fullDeck = sb.toString();
    }

    @Override
    public String toString() {
        return fullDeck;
    }
}
