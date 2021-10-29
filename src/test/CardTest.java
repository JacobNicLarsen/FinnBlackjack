package test;

import main.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void getSuit() {
        Card card = new Card("H","3");
        assertEquals(card.getSuit(), "H");
    }

    @Test
    void getValue() {
        Card card = new Card("H","3");
        assertEquals(card.getValue(), "3");
    }

    @Test
    void getNumericValueTestA() {
        Card card = new Card("H","A");
        assertEquals(card.getNumericValue(), 11);
    }

    @Test
    void getNumericValueTestQ() {
        Card card = new Card("H","Q");
        assertEquals(card.getNumericValue(), 10);
    }

    @Test
    void testToString(){
        Card card = new Card("H","10");
        assertEquals(card.toString(), "H10");
    }
}