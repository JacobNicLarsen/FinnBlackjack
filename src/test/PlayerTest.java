package test;

import main.*;
import main.playerModules.Gambler;
import main.playerModules.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        Player gambler = new Gambler("Sam");
        assertEquals("Sam", gambler.getName());
    }

    @Test
    void setName() {
        Player gambler = new Gambler("Sam");
        gambler.setName("Jon");
        assertEquals("Jon", gambler.getName());
    }

    @Test
    void addCardToHand() {
        Player gambler = new Gambler("Sam");
        Card card1 = new Card("H", "3");
        Card card2 = new Card("H", "5");
        assertEquals(0, gambler.getHand().size());
        gambler.addCardToHand(card1);
        assertEquals(1, gambler.getHand().size());
        gambler.addCardToHand(card2);
        assertEquals(2, gambler.getHand().size());
    }

    @Test
    void getHandScore() {
        Player gambler = new Gambler("Sam");
        Card card1 = new Card("H", "3");
        Card card2 = new Card("H", "A");
        gambler.addCardToHand(card1);
        assertEquals(3, gambler.getHandScore());
        gambler.addCardToHand(card2);
        assertEquals(14, gambler.getHandScore());
    }

    @Test
    void addCardToHandFromDeck() {
        Deck deck = new Deck();
        Player gambler = new Gambler("Sam");
        assertThrows(IndexOutOfBoundsException.class,
                () -> gambler.addCardToHandFromDeck(deck));
        deck.fill();
        gambler.addCardToHandFromDeck(deck);
        assertEquals(1, gambler.getHand().size());
    }

    @Test
    void isHandBlackjack() {
        Player gambler = new Gambler("Sam");
        Card card1 = new Card("H", "Q");
        Card card2 = new Card("H", "A");
        Card card3 = new Card("H", "2");
        assertFalse(gambler.isHandBlackjack());
        gambler.addCardToHand(card1);
        assertFalse(gambler.isHandBlackjack());
        gambler.addCardToHand(card2);
        assertTrue(gambler.isHandBlackjack());
        gambler.addCardToHand(card3);
        assertFalse(gambler.isHandBlackjack());
    }

    @Test
    void isHandBust() {
        Player gambler = new Gambler("Sam");
        Card card1 = new Card("H", "Q");
        Card card2 = new Card("H", "A");
        Card card3 = new Card("H", "2");
        assertFalse(gambler.isHandBust());
        gambler.addCardToHand(card1);
        assertFalse(gambler.isHandBust());
        gambler.addCardToHand(card2);
        assertFalse(gambler.isHandBust());
        gambler.addCardToHand(card3);
        assertTrue(gambler.isHandBust());
    }
}