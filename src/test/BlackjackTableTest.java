package test;

import main.BlackjackTable;
import main.Dealer;
import main.Gambler;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackTableTest {

    @Test
    void initialDraws() {
        Dealer dealer = new Dealer("Dealer");
        Gambler gambler = new Gambler("Sam");
        BlackjackTable blackjackTable = new BlackjackTable(dealer, gambler);

        blackjackTable.initialDraws();
        assertEquals(blackjackTable.getGambler().getHand().size(), 2);
    }
}