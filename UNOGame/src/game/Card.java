package game;

// The Card class represents a single card with a color and a value.
public class Card {
    // Fields to store the color and value of the card.
    private String color;
    private String value;

    // Constructor to initialize the card with a specified color and value.
    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    // Getter method to retrieve the color of the card.
    public String getColor() {
        return color;
    }

    // Getter method to retrieve the value of the card.
    public String getValue() {
        return value;
    }

    // Overrides the toString method to return a string representation of the card.
    @Override
    public String toString() {
        return color + " " + value;
    }
}


