package main;

public class Game {
    public static void main(String[] args) {
        Gambler gambler = new Gambler("Sam");
        Dealer dealer = new Dealer("Dealer");
        String filePath = "src/testCardInput.txt";

        BlackjackTable blackjackTable = new BlackjackTable(dealer, gambler, filePath);

        System.out.println(blackjackTable.fullGame());
    }
}
