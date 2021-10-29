package main;

import java.util.Arrays;

public class Card {
    private final String suit;
    private final String value;
    public static final String[] highCards = {"J", "Q", "K"};
    public static final String ace = "A";
    public static final String[] suits = {"C", "D", "H", "S"};


    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public int getNumericValue() {
        if (Arrays.asList(highCards).contains(this.value)) {
            return 10;
        }
        else if (this.value.equals(ace)) {
            return 11;
        }
        else return Integer.parseInt(this.value);
    }

    @Override
    public String toString() {
        return this.suit + this.value;
    }
}
