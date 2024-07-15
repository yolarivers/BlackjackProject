package com.skilldistillery.cardgames.blackjack.app;

import com.skilldistillery.cardgames.common.Card;

public class Player {
    protected BlackJackHand hand;

    public Player() {
        this.hand = new BlackJackHand();
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public int getHandValue() {
        return hand.getHandValue();
    }

    public boolean isOver21() {
        return hand.getHandValue() > 21;
    }

    public String getHandDetails() {
        return hand.toString();
    }

    public BlackJackHand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "Player's hand: " + hand.toString();
    }
}
