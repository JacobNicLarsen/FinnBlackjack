package main.playerModules;

import main.Deck;
import main.playerModules.Player;

public class Gambler extends Player {

    public Gambler(String name) {
        super(name);
    }

    public void keepPlaying(Deck deck) {
        while (getHandScore() <= 17) {
            addCardToHandFromDeck(deck);
            if (isHandBust()) break;
        }
    }
}
