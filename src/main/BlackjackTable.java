package main;

public class BlackjackTable {
    private Deck deck;
    private Gambler gambler;
    private Dealer dealer;

    public BlackjackTable(Dealer dealer, Gambler gamblers) {
        this.dealer = dealer;
        this.gambler = gamblers;
        this.deck = new Deck();
        this.deck.fill();
        this.deck.shuffle();
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

    public String formatOutput(Player winner) {
        return winner.getName() + "\n" + gambler + "\n" + dealer;
    }

    public void initialDraws() {
        for (int i = 0; i < 2; i++) {
            giveGamblersCard();
            giveDealerCard();
        }
    }

    public Player determineInitialWinner() {
        if (gambler.isHandBlackjack()) return gambler;
        else if (dealer.isHandBlackjack()) return dealer;
        else return null;
    }

    public Player gamblerKeepPlaying() {
        while (gambler.getHandScore() <= 17) {
            gambler.addCardToHand(deck.drawCard());
            if (gambler.isHandBust()) return dealer;
        }
        return null;
    }

    public Player dealerKeepPlaying() {
        while (dealer.getHandScore() < gambler.getHandScore()) {
            dealer.addCardToHand(deck.drawCard());
            if (dealer.isHandBust()) return gambler;
        }
        return dealer;
    }



    private void giveGamblersCard() {
        gambler.addCardToHand(deck.drawCard());
    }

    private void giveDealerCard() {
        dealer.addCardToHand(deck.drawCard());
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
}
