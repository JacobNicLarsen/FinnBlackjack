package main;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        Gambler gambler = new Gambler("Sam");
        Dealer dealer = new Dealer("Dealer");

        BlackjackTable blackjackTable = new BlackjackTable(dealer, gambler);

        System.out.println(blackjackTable.fullGame());
    }
}
