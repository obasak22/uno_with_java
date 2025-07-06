package game;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    /**
	 * This is the constructor for Hand objects
	*/public Hand() {
        cards = new ArrayList<>();
    }

	/**
	 * This method is for adding a Card object to the cards (ArrayList<Card>)
	*/public void addCard(Card card) {
        cards.add(card);
    }

	/**
	 * This method is for removing a Card object from the cards (ArrayList<Card>)
	*/public void removeCard(Card card) {
        cards.remove(card);
    }

    /**
	 * This is the getter method for the cards (ArrayList<Card>) property
	*/public ArrayList<Card> getCards() {
        return cards;
    }

	/**
	 * This method is for getting the size of cards (ArrayList<Card>) as an integer
	*/public int getCardCount() {
        return cards.size();
    }
}
