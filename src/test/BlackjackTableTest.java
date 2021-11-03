package test;

import main.BlackjackTable;
import main.gameItems.Card;
import main.gameItems.Deck;
import main.playerModules.Dealer;
import main.playerModules.Gambler;
import main.playerModules.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackTableTest {

    @Test
    void initialDraws() {
        Dealer dealer = new Dealer("Dealer");
        Gambler gambler = new Gambler("Sam");
        BlackjackTable blackjackTable = new BlackjackTable(dealer, gambler);

        blackjackTable.initialDraws();
        assertEquals(blackjackTable.getGambler().getHand().size(), 2);
        assertEquals(blackjackTable.getDealer().getHand().size(), 2);
    }

    @Test
    void readCardsFromFile() {
        Dealer dealer = new Dealer("Dealer");
        Gambler gambler = new Gambler("Sam");
        String filePath = "src/testCardInput.txt";
        BlackjackTable blackjackTable = new BlackjackTable(dealer, gambler, filePath);
        assertFalse(blackjackTable.getDeck().isEmpty());
    }

    @Test
    void determineInitialWinnerBoughtBust() {
        Card cardAce1 = new Card("C", "A");
        Card cardAce2 = new Card("D", "A");
        Card cardAce3 = new Card("H", "A");
        Card cardAce4 = new Card("S", "A");
        Deck deckBustDealerWins = new Deck();
        deckBustDealerWins.addAdd(cardAce1,cardAce2,cardAce3,cardAce4);
        BlackjackTable blackjackTable = generateBlackjackTableWithCustomDeck(deckBustDealerWins);

        blackjackTable.initialDraws();
        Player winner;
        winner = blackjackTable.determineInitialWinner();
        assertEquals(blackjackTable.getDealer(), winner);
    }

    @Test
    void determineGamblerInitialWinner() {
        Card cardAce1 = new Card("C", "A");
        Card cardQueen1 = new Card("D", "Q");
        Card cardAce2 = new Card("H", "A");
        Card cardQueen2 = new Card("S", "Q");

        Deck deckGamblerBlackjack = new Deck();
        deckGamblerBlackjack.addAdd(cardAce1, cardAce2, cardQueen1, cardQueen2);

        BlackjackTable blackjackTable = generateBlackjackTableWithCustomDeck(deckGamblerBlackjack);

        blackjackTable.setDeck(deckGamblerBlackjack);
        blackjackTable.initialDraws();
        Player winner;
        winner = blackjackTable.determineInitialWinner();
        assertAll("Checking if gambler has 21, dealer 21 and gambler wins",
                () -> assertEquals(21, blackjackTable.getGambler().getHandScore()) ,
                () -> assertEquals(21, blackjackTable.getDealer().getHandScore()) ,
                () -> assertEquals(blackjackTable.getGambler(), winner)
                );
    }

    @Test
    void determineDealerInitialWinner() {
        Card cardAce1 = new Card("C", "A");
        Card cardAce2 = new Card("H", "A");
        Card cardThree = new Card("D", "3");
        Card cardQueen2 = new Card("S", "Q");

        Deck deckGamblerBlackjack = new Deck();
        deckGamblerBlackjack.addAdd(cardAce1, cardAce2, cardQueen2, cardThree);

        BlackjackTable blackjackTable = generateBlackjackTableWithCustomDeck(deckGamblerBlackjack);

        blackjackTable.setDeck(deckGamblerBlackjack);
        blackjackTable.initialDraws();
        Player winner;
        winner = blackjackTable.determineInitialWinner();

        assertAll("Checking if gambler has 14, dealer 21, and dealers wins",
                () -> assertEquals(14, blackjackTable.getGambler().getHandScore()),
                () -> assertEquals(21, blackjackTable.getDealer().getHandScore()),
                () -> assertEquals( blackjackTable.getDealer(), winner)
                );
    }

    @Test
    void gamblerKeepPlayingAndBust() {
        Card card1 = new Card("C", "10");
        Card card2 = new Card("C", "5");
        Card card3 = new Card("C", "7");
        Deck deck = new Deck();
        deck.addAdd(card3, card2, card1);

        BlackjackTable blackjackTable = generateBlackjackTableWithCustomDeck(deck);
        Player winner = blackjackTable.gamblerKeepPlaying();
        assertAll("Checking if gambler bust and winner is dealer",
                () -> assertEquals(22, blackjackTable.getGambler().getHandScore()),
                () -> assertEquals(blackjackTable.getDealer(), winner)
                );
    }

    @Test
    void gamblerKeepPlayingStay() {
        Card card1 = new Card("C", "10");
        Card card2 = new Card("C", "4");
        Card card3 = new Card("C", "3");
        Deck deck = new Deck();
        deck.addAdd(card3, card2, card1);

        BlackjackTable blackjackTable = generateBlackjackTableWithCustomDeck(deck);
        Player winner = blackjackTable.gamblerKeepPlaying();
        assertAll("Checking if gambler bust and winner is dealer",
                () -> assertEquals(17, blackjackTable.getGambler().getHandScore()),
                () -> assertNull(winner)
                );
    }


    @Test
    void dealerKeepPlayingAndBust() {
        Card gamblerCard1 = new Card("H", "Q");
        Card gamblerCard2 = new Card("C", "7");

        Card card1 = new Card("C", "Q");
        Card card2 = new Card("S", "7");
        Card card3 = new Card("C", "5");

        Deck deck = new Deck();
        deck.addAdd(card3, card2, card1);

        BlackjackTable blackjackTable = generateBlackjackTableWithCustomDeck(deck);
        blackjackTable.getGambler().getHand().add(gamblerCard1);
        blackjackTable.getGambler().getHand().add(gamblerCard2);

        Player winner = blackjackTable.dealerKeepPlaying();
        assertAll("Checking gambler hand is 17 dealer draws 17 then bust",
                () -> assertEquals(17, blackjackTable.getGambler().getHandScore()),
                () -> assertEquals(blackjackTable.getGambler(), winner)
                );
    }



    private BlackjackTable generateBlackjackTableWithCustomDeck(Deck deck) {
        Dealer dealer = new Dealer("Dealer");
        Gambler gambler = new Gambler("Sam");
        BlackjackTable blackjackTable = new BlackjackTable(dealer, gambler);
        blackjackTable.setDeck(deck);
        return blackjackTable;
    }
}