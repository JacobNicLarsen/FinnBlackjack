package main;

public class Game {
    public static void main(String[] args) {
        System.out.println("hello");
        Deck deck = new Deck();
        deck.fill();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
    }
}
