package game;

import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player[] players;

    public Game() {
        deck = new Deck();
        players = new Player[2];
        players[0] = new Player("Player 1");
        players[1] = new Player("Player 2");
    }

    public void start() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck);
            }
        }

        System.out.println("Starting the game!");
        Scanner scanner = new Scanner(System.in);

        while (deck.cardsLeft() > 0) {
            for (Player player : players) {
                System.out.println(player.getName() + "'s turn.");
                System.out.println("Your hand: " + player.getHand());

                System.out.println("Enter the index of the card to play, or -1 to draw a new card:");
                int index = scanner.nextInt();

                if (index == -1) {
                    player.drawCard(deck);
                } else {
                    player.playCard(index);
                }

                if (player.getHand().isEmpty()) {
                    System.out.println(player.getName() + " wins!");
                    return;
                }
            }
        }

        System.out.println("The deck is empty. The game is a draw.");
    }
}
