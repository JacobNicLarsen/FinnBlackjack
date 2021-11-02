package test;

import main.Card;
import main.Deck;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void setDeck() {
        Card card1 = new Card("H", "3");
        Card card2 = new Card("S", "A");
        Deck deck = new Deck();
        Stack<Card> initDeck = new Stack<>();
        initDeck.add(card1);
        initDeck.add(card2);
        deck.setDeck(initDeck);
        assertAll("Creating deck",
                () -> assertEquals(card2, deck.drawCard()),
                () -> assertEquals(card1, deck.drawCard())
                );

    }

    @Test
    void testAdd() {
        Card card = new Card("S", "A");
        Deck deck = new Deck();
        deck.add(card);
        assertFalse(deck.isEmpty());
    }

    @Test
    void getTopAndRemove() {
        Card card = new Card("S", "A");
        Deck deck = new Deck();
        deck.add(card);
        assertAll("Returning card and removing",
                () -> assertEquals(card, deck.drawCard()),
                () -> assertTrue(deck.isEmpty())
                );
    }

    @Test
    void getTopAndKeep() {
        Card card = new Card("S", "A");
        Deck deck = new Deck();
        deck.add(card);
        assertAll("Returning card and removing",
                () -> assertEquals(card, deck.getTopAndKeep()),
                () -> assertFalse(deck.isEmpty())
        );
    }

    @Test
    void isEmpty() {
        Card card = new Card("S", "A");
        Deck deck = new Deck();
        deck.add(card);
        assertAll("Checking if remove works",
                () -> assertFalse(deck.isEmpty()),
                () -> {deck.drawCard(); assertTrue(deck.isEmpty());}
        );
    }

    @Test
    void size() {
        Card card1 = new Card("H", "Q");
        Card card2 = new Card("S", "A");
        Deck deck = new Deck();
        deck.add(card1);
        assertEquals(1, deck.size());
        deck.add(card2);
        assertEquals(2, deck.size());
    }

    @Test
    void fillDeckCheckingIf52Cards() {
        Deck deck = new Deck();
        deck.fill();
        assertEquals(52, deck.size());
    }

    @Test
    void shuffleDeck() {
        Deck deck = new Deck();
        deck.fill();
        String notShuffledDeck = deck.toString();
        deck.shuffle();
        String shuffledDeck = deck.toString();
        assertNotEquals(shuffledDeck, notShuffledDeck);
    }

}