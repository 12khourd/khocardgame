package game;

import java.util.Scanner;

public class Game {
    private Deck deck;  // The deck of cards used in the game
    private Player[] players;  // Array of players in the game
    private int currentPlayerIndex;  // Index of the player whose turn it is
    private boolean isClockwise;  // Direction of play (clockwise or counterclockwise)

    // Constructor to initialize the deck, players, and game settings
    public Game() {
        deck = new Deck();  // Create a new deck of cards
        players = new Player[2];  // Create two players
        players[0] = new Player("Player 1");  // Initialize Player 1
        players[1] = new Player("Player 2");  // Initialize Player 2
        currentPlayerIndex = 0;  // Set Player 1 as the starting player
        isClockwise = true;  // Set the direction of play to clockwise
    }

    // Method to start the game and manage the main game loop
    public void start() {
        // Deal 7 cards to each player at the beginning of the game
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck);  // Draw a card from the deck for each player
            }
        }

        System.out.println("Starting the game!");  // Notify the players that the game has started
        Scanner scanner = new Scanner(System.in);  // Create a scanner to read player input

        // Main game loop - continues until the deck is empty
        while (deck.cardsLeft() > 0) {
            Player player = players[currentPlayerIndex];  // Get the current player
            System.out.println(player.getName() + "'s turn.");  // Display the current player's turn
            System.out.println("Your hand: " + player.getHand());  // Show the player's current hand

            // Prompt the player to choose a card to play or draw a new one
            System.out.println("Enter the index of the card to play, or -1 to draw a new card:");
            int index = scanner.nextInt();  

            if (index == -1) {
                player.drawCard(deck);  // Draw a card from the deck if the player chooses to draw
            } else {
                // Validate the index to ensure the player is playing a valid card
                if (index < 0 || index >= player.getHand().size()) {
                    System.out.println("Invalid card index, try again.");
                    continue;  
                }

                // If the player plays a valid card from their hand
                Card playedCard = player.getHand().get(index);  // Get the card the player wants to play
                player.playCard(index);  // Remove the card from the player's hand

                // Apply the effect of the played card
                playedCard.applyEffect(this);  // Apply the effect of the card on the game

                // If the player has no cards left, they win the game
                if (player.getHand().isEmpty()) {
                    System.out.println(player.getName() + " wins!");  // Announce the winner
                    return;
                }
            }

            // Move to the next player in the current direction (clockwise or counterclockwise)
            currentPlayerIndex = getNextPlayerIndex();
        }

        // If the deck runs out of cards and no player wins, it's a draw
        System.out.println("The deck is empty. The game is a draw.");
    }

    // Method to skip the current player's turn and move to the next player
    public void skipTurn() {
        System.out.println("Skipping the next player's turn.");  // Notify that the next player's turn is skipped
        currentPlayerIndex = getNextPlayerIndex();  // Skip to the next player
    }

    // Method to reverse the direction of play (clockwise to counterclockwise or vice versa)
    public void reverseDirection() {
        isClockwise = !isClockwise;  // The direction of play
        System.out.println("Reversing direction of play.");  // Notify the direction change
    }

    // Method to make the next player draw two cards
    public void drawTwoCards() {
        System.out.println("Next player must draw two cards.");  // Notify that the next player will draw two cards
        Player nextPlayer = players[getNextPlayerIndex()];  // Get the next player in turn
        nextPlayer.drawCard(deck);  // Draw the first card for the next player
        nextPlayer.drawCard(deck);  // Draw the second card for the next player
    }

    private int getNextPlayerIndex() {
        // If the game is clockwise, move to the next player in the array
        // If the game is counterclockwise, move to the previous player
        if (isClockwise) {
            return (currentPlayerIndex + 1) % players.length;  // Move to the next player 
        } else {
            return (currentPlayerIndex - 1 + players.length) % players.length;  // Move to the previous player 
        }
    }
}
