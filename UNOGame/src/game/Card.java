package game;

public class Card {
    private String color;
    private String value;

    // Constructor to initialize the card with color and value
    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    // Getter for color
    public String getColor() {
        return color;
    }

    // Getter for value
    public String getValue() {
        return value;
    }

    // Overridden toString() method to represent the card as a string
    @Override
    public String toString() {
        return color + " " + value;
    }

    // Default applyEffect method in the base Card class
    public void applyEffect(Game game) {
    }
}
