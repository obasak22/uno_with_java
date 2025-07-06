package game;

public class Player {
    private String name;
    private Hand hand;

    /**
	 * This is the constructor for Player objects
	*/public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

	/**
	 * This is the getter method for the name (String) property of Player objects
	*/public String getName() {
        return name;
    }

	/**
	 * This is the getter method for the hand (Hand) property of Player objects
	*/public Hand getHand() {
        return hand;
    }
}