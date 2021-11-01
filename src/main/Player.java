package main;

import java.util.ArrayList;

public abstract class Player {
    private String name;
    private ArrayList<Card> hand;



    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public int getHandScore() {
        int handScore = 0;
        for (Card card : hand) {
            handScore += card.getNumericValue();
        }
        return handScore;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public boolean isHandBlackjack() {
        return getHandScore() == 21;
    }

    public boolean isHandBust() {
        return getHandScore() > 21;
    }

    @Override
    public String toString() {
        return  name + ": " + hand.toString();
    }
}
