package main;

import main.playerModules.Dealer;
import main.playerModules.Gambler;
import main.playerModules.Player;

public class BlackjackTable {
    private Deck deck;
    private Gambler gambler;
    private Dealer dealer;

    public BlackjackTable(Dealer dealer, Gambler gambler) {
        this.dealer = dealer;
        this.gambler = gambler;
        this.deck = new Deck();
        deck.fill();
        deck.shuffle();
    }

    public BlackjackTable(Dealer dealer, Gambler gambler, String filePath) {
        this.dealer = dealer;
        this.gambler = gambler;
        this.deck = FileDeckReader.readDeckFile(filePath);
    }

    public String fullGame() {
        Player winner;
        initialDraws();
        winner = determineInitialWinner();
        if (winner != null) return formatOutput(winner);

        winner = gamblerKeepPlaying();
        if (winner != null) return formatOutput(winner);

        winner = dealerKeepPlaying();
        if (winner != null) return formatOutput(winner);
        return "This should not happen";
    }

    public void initialDraws() {
        for (int i = 0; i < 2; i++) {
            gambler.addCardToHandFromDeck(deck);
            dealer.addCardToHandFromDeck(deck);
        }
    }

    public Player determineInitialWinner() {
        if (gambler.isHandBlackjack()) return gambler;
        else if (dealer.isHandBlackjack()) return dealer;
        else if (gambler.isHandBust() && dealer.isHandBust()) return dealer;
        else return null;
    }

    public Player gamblerKeepPlaying() {
        while (gambler.getHandScore() < 17) {
            gambler.addCardToHandFromDeck(deck);
            if (gambler.isHandBust()) return dealer;
        }
        return null;
    }

    public Player dealerKeepPlaying() {
        while (dealer.getHandScore() <= gambler.getHandScore()) {
            dealer.addCardToHandFromDeck(deck);
            if (dealer.isHandBust()) return gambler;
        }
        return dealer;
    }


    public String formatOutput(Player winner) {
        return winner.getName() + "\n" + gambler + "\n" + dealer;
    }


    public Deck getDeck() {
        return deck;
    }

    public Gambler getGambler() {
        return gambler;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
