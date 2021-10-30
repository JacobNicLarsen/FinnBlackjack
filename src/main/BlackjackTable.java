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
        initialDraws();
        if (isWonForGambler()){
            return "Gambler has won with hand " + gambler;
        }
        else if (isWonForDealer()){
            return "Dealer has won with hand " + dealer;
        }
        else {
            return keepPlaying();
        }
    }
    

    public String keepPlaying() {
        while (gambler.getHandScore() <= 17){
            gambler.addCardToHand(deck.drawCard());
        }
        if (gambler.isHandBust()) {
            return "Gambler has lost " + gambler;
        }
        while (dealer.getHandScore() < gambler.getHandScore()) {
            dealer.addCardToHand(deck.drawCard());
        }
        return determineWinner();
    }

    public String determineWinner(){
        if (gambler.isHandBlackjack()) return "gambler wins with blackjack " + gambler + " " + dealer;
        else if (dealer.isHandBlackjack()) return "gambler wins with blackjack " + dealer + " " + gambler;
        else if (gambler.getHandScore() > dealer.getHandScore() && !gambler.isHandBust()) return "gambler wins " + gambler + " " + dealer;
        else if (dealer.getHandScore() > gambler.getHandScore() && ! dealer.isHandBust()) return "dealer wins " + dealer + " " + gambler;
        else return "something wierd has happend";
    }



    public void initialDraws() {
        for (int i = 0; i < 2; i++) {
            giveGamblersCard();
            giveDealerCard();
        }
    }


    public boolean isWonForDealer(){
        return dealer.isHandBlackjack();
    }

    public boolean isWonForGambler() {
        return gambler.isHandBlackjack();
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
