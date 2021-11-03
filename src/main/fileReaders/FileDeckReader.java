package main.fileReaders;

import main.gameItems.Card;
import main.gameItems.Deck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDeckReader {

    public static Deck readDeckFile(String filePath){
        Deck deck = new Deck();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            myReader.useDelimiter(", ");
            while (myReader.hasNext()) {
                String data = myReader.next();
                char[] cardValues = data.toCharArray();
                Card card = new Card(String.valueOf(cardValues[0]), String.valueOf(cardValues[1]));
                deck.add(card);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return deck;
    }
}
