package com.skilldistillery.cardgames.blackjack.app;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;

public class Dealer extends Player {
    private Deck deck;

    public Dealer() {
        super();
        deck = new Deck();
    }

    public Card dealCard() {
        return deck.dealCard();
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

   
}
