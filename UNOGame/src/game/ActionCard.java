package game;

public class ActionCard extends Card {

    // Constructor for ActionCard 
    public ActionCard(String color, String value) {
        super(color, value);  // Call the constructor of the parent class (Card)
    }

    // Apply the effect of the action card 
    @Override
    public void applyEffect(Game game) {
        String cardValue = getValue();
        
        switch (cardValue) {
            case "Skip":
                game.skipTurn();  // Skip the next player's turn
                break;
            case "Reverse":
                game.reverseDirection();  // Reverse the direction of play
                break;
            case "Draw Two":
                game.drawTwoCards();  // Force the next player to draw two cards
                break;
            default:
                break;
        }
    }
}
