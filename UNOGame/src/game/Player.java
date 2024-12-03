package game;

import java.util.ArrayList;
import java.util.List;

// The Player class represents a player in the game.
public class Player {
    // The name of the player.
    private String name;
    // The hand of cards held by the player.
    private List<Card> hand;

    // Constructor to initialize the player with a name.
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    // Method for the player to draw a card from the deck and add it to their hand.
    public void drawCard(Deck deck) {
        Card drawnCard = deck.drawCard();
        if (drawnCard != null) {
            hand.add(drawnCard);
        }
    }

    // Method to get the list of cards in the player's hand.
    public List<Card> getHand() {
        return hand;
    }

    // Method to get the player's name.
    public String getName() {
        return name;
    }

    // Method for the player to play a card from their hand.
    public void playCard(int index) {
        if (index >= 0 && index < hand.size()) {
            Card playedCard = hand.remove(index);
            System.out.println(name + " played: " + playedCard);
        }
    }
}

