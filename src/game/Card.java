package game;

public class Card {
    private String color;
    private int point;
    private String type;

    /**
	 * This is the constructor for Card objects
	*/public Card(String color, int point, String type) {
        this.color = color;
        this.point = point;
        this.type = type;
    }

	/**
	 * This is the getter method for the color (String) property of Card objects
	*/public String getColor() {
        return color;
    }

	/**
	 * This is the setter method for the color (String) property of Card objects
	*/public void setColor(String color) {
        this.color = color;
    }

	/**
	 * This is the getter method for the point (int) property of Card objects
	*/public int getPoint() {
        return point;
    }

	/**
	 * This is the setter method for the point (int) property of Card objects
	*/public void setPoint(int point) {
        this.point = point;
    }

	/**
	 * This is the getter method for the type (String) property of Card objects
	*/public String getType() {
        return type;
    }

	/**
	 * This is the setter method for the type (String) property of Card objects
	*/public void setType(String type) {
        this.type = type;
    }
}