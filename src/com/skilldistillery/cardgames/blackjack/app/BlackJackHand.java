package com.skilldistillery.cardgames.blackjack.app;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.AbstractHand;
import com.skilldistillery.cardgames.common.Rank;

public class BlackJackHand extends AbstractHand {

    @Override
    public int getHandValue() {
        int value = 0;
        int aceCount = 0;
        for (Card card : cardsInHand) {
            value += card.getValue();
            if (card.getRank() == Rank.ACE) {
                aceCount++;
            }
        }
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }
        return value;
    }

    @Override
    public void addCard(Card card) {
        cardsInHand.add(card);
    }

    @Override
    public void clear() {
        cardsInHand.clear();
    }

    @Override
    public String toString() {
        return cardsInHand.toString();
    }

    public Card getCard(int index) {
        return cardsInHand.get(index);
    }

    public int getCardCount() {
        return cardsInHand.size();
    }
}
