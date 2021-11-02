package main.playerModules;

import main.Card;
import main.Deck;

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

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void addCardToHandFromDeck(Deck deck) {
        if(!deck.isEmpty()){
            hand.add(deck.drawCard());
        }
        else throw new IndexOutOfBoundsException("Deck is empty");
    }

    public boolean isHandBlackjack() {
        return getHandScore() == 21;
    }

    public boolean isHandBust() {
        return getHandScore() > 21;
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

    @Override
    public String toString() {
        return  name + ": " + hand.toString();
    }
}
