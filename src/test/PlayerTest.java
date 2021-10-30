package test;

import main.Card;
import main.Dealer;
import main.Gambler;
import main.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        Player gambler = new Gambler("Sam");
        assertEquals(gambler.getName(), "Sam");
    }

    @Test
    void setName() {
        Player gambler = new Gambler("Sam");
        gambler.setName("Jon");
        assertEquals(gambler.getName(), "Jon");
    }

    @Test
    void getHandScore() {
        Card card1 = new Card(Card.suits[0], "3");
        Card card2 = new Card(Card.suits[1], "A");
        Player dealer = new Dealer("Dealer");
        dealer.addCardToHand(card1);
        dealer.addCardToHand(card2);
        assertEquals(dealer.getHandScore(), 14);
    }

    @Test
    void addCardToHand() {
        Card card1 = new Card(Card.suits[0], "3");
        Card card2 = new Card(Card.suits[1], "A");
        Player dealer = new Dealer("Dealer");
        dealer.addCardToHand(card1);
        assertEquals(dealer.getHand().size(), 1);
        dealer.addCardToHand(card2);
        assertEquals(dealer.getHand().size(), 2);
    }

    @Test
    void checkWin() {
        Card card1 = new Card(Card.suits[0], "A");
        Card card2 = new Card(Card.suits[1], "Q");
        Player dealer = new Dealer("Dealer");
        dealer.addCardToHand(card1);
        assertFalse(dealer.isHandBlackjack());

        dealer.addCardToHand(card2);
        assertTrue(dealer.isHandBlackjack());
    }

    @Test
    void checkBust() {
        Card card1 = new Card(Card.suits[0], "A");
        Card card2 = new Card(Card.suits[1], "A");
        Player dealer = new Dealer("Dealer");
        dealer.addCardToHand(card1);
        assertFalse(dealer.isHandBust());

        dealer.addCardToHand(card2);
        assertTrue(dealer.isHandBust());
    }
}