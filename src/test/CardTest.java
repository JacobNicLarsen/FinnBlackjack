package test;

import main.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void getSuit() {
        Card card = new Card("H","3");
        assertEquals("H", card.getSuit());
    }

    @Test
    void getValue() {
        Card card = new Card("H","3");
        assertEquals("3", card.getValue());
    }

    @Test
    void getNumericValueTestA() {
        Card card = new Card("H","A");
        assertEquals(11, card.getNumericValue());
    }

    @Test
    void getNumericValueTestQ() {
        Card card = new Card("H","Q");
        assertEquals(10, card.getNumericValue());
    }

    @Test
    void testToString(){
        Card card = new Card("H","10");
        assertEquals("H10", card.toString());
    }
}