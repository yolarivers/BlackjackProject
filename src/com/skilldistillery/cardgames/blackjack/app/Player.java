package com.skilldistillery.cardgames.blackjack.app;

import com.skilldistillery.cardgames.common.Card;

public class Player {
    // Player HAS-A Hand
    // DO NOT ADD A getHand();
    private BlackJackHand hand;
    // NO List<Card>, hand has one

    public Player() {
        this.hand = new BlackJackHand();
    }

    public void addCardToHand(Card card) {
        // hand.addCard(card);
    }
    public int getHandValue() {
    	
    	return hand.getHandValue();
    }
}
