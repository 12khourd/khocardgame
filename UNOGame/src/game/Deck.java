package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// The Deck class represents a deck of cards used in the game.
public class Deck {
    // List to store all the cards in the deck.
    private List<Card> cards;

    // Constructor to initialize the deck of cards.
    public Deck() {
        cards = new ArrayList<>();
        // Define the available colors for the cards.
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        // Define the possible values for each card.
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};

        // Create cards for each combination of color and value.
        for (String color : colors) {
            for (String value : values) {
                // Add one card of each color and value combination.
                cards.add(new Card(color, value));
                // Add an additional card if the value is not "0" (since there are two of each value, except "0").
                if (!value.equals("0")) {
                    cards.add(new Card(color, value));
                }
            }
        }
        // Shuffle the deck to randomize the order of cards.
        Collections.shuffle(cards);
    }

    // Method to draw a card from the deck.
    public Card drawCard() {
        // Return null if there are no cards left in the deck.
        if (cards.isEmpty()) {
            return null;
        }
        // Remove and return the top card from the deck.
        return cards.remove(0);
    }

    // Method to get the number of cards left in the deck.
    public int cardsLeft() {
        return cards.size();
    }
}
