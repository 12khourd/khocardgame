package game;

public class SpecialCard extends Card {
    private boolean isWild;  // To check if the card is a Wild card

    // Constructor for SpecialCard 
    public SpecialCard(String value) {
        super("Special", value);  // Special cards don't have a color, so set color as "Special"
        this.isWild = value.equals("Wild") || value.equals("Wild Draw Four");
    }

    // Getter to check if the card is Wild
    public boolean isWild() {
        return isWild;
    }

    // Apply the effect of the special card 
    @Override
    public void applyEffect(Game game) {
        if (isWild()) {
            System.out.println("Player played a Wild card. Change the color of the discard pile.");
        }
    }
}
