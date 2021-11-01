package main;

public class Gambler extends Player{

    public Gambler(String name) {
        super(name);
    }

    public void keepPlaying(Deck deck) {
        while (getHandScore() <= 17) {
            addCardToHand(deck.drawCard());
            if (isHandBust()) break;
        }
    }
}
