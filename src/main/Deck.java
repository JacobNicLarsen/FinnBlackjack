package main;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;
import java.util.StringJoiner;

public class Deck {
    private Stack<Card> deck;

    public Deck() {
        this.deck = new Stack<Card>();
    }

    public void setDeck(Stack<Card> deck) {
        this.deck = deck;
    }

    public Card drawCard() {
        return deck.pop();
    }

    public Card getTopAndKeep(){
        return deck.peek();
    }


    public void add(Card card) {
        this.deck.add(card);
    }

    public boolean isEmpty() {
        return this.deck.isEmpty();
    }

    public int size() {
        return this.deck.size();
    }

    public void fill() {
        for(int i = 0; i<4; i++){
            String suit = Card.suits[i];
            for(int k = 2; k <= 10; k++){
                String value = String.valueOf(k);
                deck.add(new Card(suit, value));
            }
            for(String highCards : Card.highCards){
                deck.add(new Card(suit, highCards));
            }
            deck.add(new Card(suit, Card.ace));
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(", ");
        for (Card card : deck) {
            out.add(card.toString());
        }
        return out.toString();
    }

}
