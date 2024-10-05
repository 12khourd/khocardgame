package game;

import java.util.Scanner;

// The Game class represents the overall game logic.
public class Game {
    // Deck of cards used in the game.
    private Deck deck;
    // Array to store the players in the game.
    private Player[] players;

    // Constructor to initialize the deck and players.
    public Game() {
        deck = new Deck();
        players = new Player[2];
        // Initialize two players.
        players[0] = new Player("Player 1");
        players[1] = new Player("Player 2");
    }

    // Method to start the game.
    public void start() {
        // Each player draws 7 cards at the start of the game.
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck);
            }
        }

        System.out.println("Starting the game!");
        Scanner scanner = new Scanner(System.in);

        // Main game loop - continues while there are cards left in the deck.
        while (deck.cardsLeft() > 0) {
            for (Player player : players) {
                // Player's turn to play.
                System.out.println(player.getName() + "'s turn.");
                System.out.println("Your hand: " + player.getHand());

                // Prompt the player to choose a card to play or draw a new one.
                System.out.println("Enter the index of the card to play, or -1 to draw a new card:");
                int index = scanner.nextInt();

                if (index == -1) {
                    // Player chooses to draw a card from the deck.
                    player.drawCard(deck);
                } else {
                    // Player chooses to play a card from their hand.
                    player.playCard(index);
                }

                // Check if the player's hand is empty, meaning they have won.
                if (player.getHand().isEmpty()) {
                    System.out.println(player.getName() + " wins!");
                    return; // End the game when a player wins.
                }
            }
        }

        // If the deck is empty and no player has won, the game is a draw.
        System.out.println("The deck is empty. The game is a draw.");
    }
}

