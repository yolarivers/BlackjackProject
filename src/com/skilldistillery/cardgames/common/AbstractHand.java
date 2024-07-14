package com.skilldistillery.cardgames.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHand {
    protected List<Card> cardsInHand;

    public AbstractHand() {
        this.cardsInHand = new ArrayList<>();
    }

    public abstract int getHandValue();

    public abstract void addCard(Card card);

    public abstract void clear();
}
