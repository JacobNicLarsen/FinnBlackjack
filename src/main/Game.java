package main;

import main.playerModules.Dealer;
import main.playerModules.Gambler;
import main.playerModules.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Game {
    public static void main(String[] args) {

        Dealer dealer = new Dealer("Dealer");
        Gambler gambler = new Gambler("Sam");
        BlackjackTable blackjackTable;

        if(args.length == 1) {
            blackjackTable = new BlackjackTable(dealer, gambler, args[0]);
        }
        else {
            blackjackTable = new BlackjackTable(dealer, gambler);
        }
        System.out.println(blackjackTable.fullGame());
    }
}
