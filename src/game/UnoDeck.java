package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import menu.GameFrame;

public class UnoDeck {
	/**
	 * This method is for creating and returning unoDeck (HashMap<Card,JButton>)
	*/public static HashMap<Card,JButton> createUnoDeck() {
    	HashMap<Card,JButton> unoDeck = new HashMap<Card,JButton>();
        String[] colors = {"Yellow", "Blue", "Green", "Red",};
        for (String color : colors) {
            for (int i = 0; i <= 9; i++) {
                if (i == 0) {
                	 Card card = new Card(color, i, "Number");
                     JButton cardButton = new JButton(String.valueOf(i));
                     cardButton.setForeground(Color.WHITE);
                     if (color.equals("Yellow")) {
                    	 cardButton.setBackground(new Color(255,255,51));
                    	 cardButton.setForeground(Color.BLACK);
                     }
                     else if (color.equals("Blue")) {
                    	 cardButton.setBackground(new Color(0,0,220));
                     }
                     else if (color.equals("Green")) {
                    	 cardButton.setBackground(new Color(0,195,32));
                     }
                     else {
                    	 cardButton.setBackground(new Color(245,22,22));
                     }
                     cardButton.setHorizontalAlignment(SwingConstants.CENTER);
                     cardButton.setOpaque(true);
                     cardButton.setFocusable(false);
                     cardButton.setPreferredSize(new Dimension(45, 35));
                     unoDeck.put(card,cardButton);
                     cardButton.setName(color + String.valueOf(i));
                } else {
                	 Card card1 = new Card(color, i, "Type");
                	 JButton cardButton1 = new JButton(String.valueOf(i));
                	 cardButton1.setForeground(Color.WHITE);
                	 if (color.equals("Yellow")) {
                		 cardButton1.setBackground(new Color(255,255,51));
                		 cardButton1.setForeground(Color.BLACK);
                	 }
                	 else if (color.equals("Blue")) {
                		 cardButton1.setBackground(new Color(0,0,220));
                	 }
                	 else if (color.equals("Green")) {
                		 cardButton1.setBackground(new Color(0,195,32));
                	 }
                	 else {
                		 cardButton1.setBackground(new Color(245,22,22));
                	 }
                	 cardButton1.setHorizontalAlignment(SwingConstants.CENTER);
                	 cardButton1.setOpaque(true);
                	 cardButton1.setFocusable(false);
                	 cardButton1.setPreferredSize(new Dimension(45, 35));
                     unoDeck.put(card1,cardButton1);
                     cardButton1.setName(color + String.valueOf(i));

                	 Card card2 = new Card(color, i, "Type");
                     JButton cardButton2 = new JButton(String.valueOf(i));
                     cardButton2.setForeground(Color.WHITE);
                	 if (color.equals("Yellow")) {
                		 cardButton2.setBackground(new Color(255,255,51));
                		 cardButton2.setForeground(Color.BLACK);
                	 }
                	 else if (color.equals("Blue")) {
                		 cardButton2.setBackground(new Color(0,0,220));
                	 }
                	 else if (color.equals("Green")) {
                		 cardButton2.setBackground(new Color(0,195,32));
                	 }
                	 else {
                		 cardButton2.setBackground(new Color(245,22,22));
                	 }
                	 cardButton2.setHorizontalAlignment(SwingConstants.CENTER);
                	 cardButton2.setOpaque(true);
                	 cardButton2.setFocusable(false);
                	 cardButton2.setPreferredSize(new Dimension(45, 35));
                     unoDeck.put(card2,cardButton2);
                     cardButton2.setName(color + String.valueOf(i));
                }
            }
        }

        for (String color : colors) {
                Card card1 = new Card(color, 20, "Draw 2");
           	 	JButton cardButton1 = new JButton("ii");
           	 	cardButton1.setForeground(Color.WHITE);
           	 	if (color.equals("Yellow")) {
           	 		cardButton1.setBackground(new Color(255,255,51));
           	 		cardButton1.setForeground(Color.BLACK);
           	 	}
           	 	else if (color.equals("Blue")) {
           	 		cardButton1.setBackground(new Color(0,0,220));
           	 	}
           	 	else if (color.equals("Green")) {
           	 		cardButton1.setBackground(new Color(0,195,32));
           	 	}
           	 	else {
           	 		cardButton1.setBackground(new Color(245,22,22));
           	 	}
           	 	cardButton1.setHorizontalAlignment(SwingConstants.CENTER);
           	 	cardButton1.setOpaque(true);
           	 	cardButton1.setFocusable(false);
           	 	cardButton1.setPreferredSize(new Dimension(45, 35));
        	 	unoDeck.put(card1,cardButton1);
           	 	cardButton1.setName(color + "Draw2" + "(1)");
           	 	
           	 	Card card2 = new Card(color, 20, "Draw 2");
        	 	JButton cardButton2 = new JButton("ii");
        	 	cardButton2.setForeground(Color.WHITE);
        	 	if (color.equals("Yellow")) {
        	 		cardButton2.setBackground(new Color(255,255,51));
        	 		cardButton2.setForeground(Color.BLACK);
        	 	}
        	 	else if (color.equals("Blue")) {
        	 		cardButton2.setBackground(new Color(0,0,220));
        	 	}
        	 	else if (color.equals("Green")) {
        	 		cardButton2.setBackground(new Color(0,195,32));
        	 	}
        	 	else {
        	 		cardButton2.setBackground(new Color(245,22,22));
        	 	}
        	 	cardButton2.setHorizontalAlignment(SwingConstants.CENTER);
        	 	cardButton2.setOpaque(true);
        	 	cardButton2.setFocusable(false);
        	 	cardButton2.setPreferredSize(new Dimension(45, 35));
        	 	unoDeck.put(card2,cardButton2);
        	 	cardButton2.setName(color + "Draw2" + "(2)");
        	 	
        	 	Card card3 = new Card(color, 20, "Reverse");
           	 	JButton cardButton3 = new JButton("R");
           	 	cardButton3.setForeground(Color.WHITE);
           	 	if (color.equals("Yellow")) {
           	 		cardButton3.setBackground(new Color(255,255,51));
           	 		cardButton3.setForeground(Color.BLACK);
           	 	}
           	 	else if (color.equals("Blue")) {
           	 		cardButton3.setBackground(new Color(0,0,220));
           	 	}
           	 	else if (color.equals("Green")) {
           	 		cardButton3.setBackground(new Color(0,195,32));
           	 	}
           	 	else {
           	 		cardButton3.setBackground(new Color(245,22,22));
           	 	}
           	 	cardButton3.setHorizontalAlignment(SwingConstants.CENTER);
           	 	cardButton3.setOpaque(true);
           	 	cardButton3.setFocusable(false);
           	 	cardButton3.setPreferredSize(new Dimension(45, 35));
           	 	unoDeck.put(card3,cardButton3);
           	 	cardButton3.setName(color + "Reverse" + "(1)");
           	 	
         	 	Card card4 = new Card(color, 20, "Reverse");
        	 	JButton cardButton4 = new JButton("R");
        	 	cardButton4.setForeground(Color.WHITE);
        	 	if (color.equals("Yellow")) {
        	 		cardButton4.setBackground(new Color(255,255,51));
        	 		cardButton4.setForeground(Color.BLACK);
        	 	}
        	 	else if (color.equals("Blue")) {
        	 		cardButton4.setBackground(new Color(0,0,220));
        	 	}
        	 	else if (color.equals("Green")) {
        	 		cardButton4.setBackground(new Color(0,195,32));
        	 	}
        	 	else {
        	 		cardButton4.setBackground(new Color(245,22,22));
        	 	}
        	 	cardButton4.setHorizontalAlignment(SwingConstants.CENTER);
        	 	cardButton4.setOpaque(true);
        	 	cardButton4.setFocusable(false);
        	 	cardButton4.setPreferredSize(new Dimension(45, 35));
        	 	unoDeck.put(card4,cardButton4);
        	 	cardButton4.setName(color + "Reverse" + "(2)");
        	 	
        	 	Card card5 = new Card(color, 20, "Skip");
           	 	JButton cardButton5 = new JButton("S");
           	 	cardButton5.setForeground(Color.WHITE);
           	 	if (color.equals("Yellow")) {
           	 		cardButton5.setBackground(new Color(255,255,51));
           	 		cardButton5.setForeground(Color.BLACK);
           	 	}
           	 	else if (color.equals("Blue")) {
           	 		cardButton5.setBackground(new Color(0,0,220));
           	 	}
           	 	else if (color.equals("Green")) {
           	 		cardButton5.setBackground(new Color(0,195,32));
           	 	}
           	 	else {
           	 		cardButton5.setBackground(new Color(245,22,22));
           	 	}
           	 	cardButton5.setHorizontalAlignment(SwingConstants.CENTER);
           	 	cardButton5.setOpaque(true);
           	 	cardButton5.setFocusable(false);
           	 	cardButton5.setPreferredSize(new Dimension(45, 35));
           	 	unoDeck.put(card5,cardButton5);
           	 	cardButton5.setName(color + "Skip" + "(1)");
           	 	
           	 	Card card6 = new Card(color, 20, "Skip");
        	 	JButton cardButton6 = new JButton("S");
        	 	cardButton6.setForeground(Color.WHITE);
        	 	if (color.equals("Yellow")) {
        	 		cardButton6.setBackground(new Color(255,255,51));
        	 		cardButton6.setForeground(Color.BLACK);
        	 	}
        	 	else if (color.equals("Blue")) {
        	 		cardButton6.setBackground(new Color(0,0,220));
        	 	}
        	 	else if (color.equals("Green")) {
        	 		cardButton6.setBackground(new Color(0,195,32));
        	 	}
        	 	else {
        	 		cardButton6.setBackground(new Color(245,22,22));
        	 	}
        	 	cardButton6.setHorizontalAlignment(SwingConstants.CENTER);
        	 	cardButton6.setOpaque(true);
        	 	cardButton6.setFocusable(false);
        	 	cardButton6.setPreferredSize(new Dimension(45, 35));
        	 	unoDeck.put(card6,cardButton6);
        	 	cardButton6.setName(color + "Skip" + "(2)");
        }
        

        for (int i = 0; i < 4; i++) {
            Card card1 = new Card("Black", 50, "Wild");
       	 	JButton cardButton1 = new JButton("W");
       	 	cardButton1.setBackground(Color.BLACK);
       	 	cardButton1.setForeground(Color.WHITE);
       	 	cardButton1.setHorizontalAlignment(SwingConstants.CENTER);
       	 	cardButton1.setOpaque(true);
       	 	cardButton1.setFocusable(false);
       	 	cardButton1.setPreferredSize(new Dimension(45, 35));
       	 	unoDeck.put(card1,cardButton1);
       	 	cardButton1.setName("Black" + "(" + String.valueOf(i) + ")");
       	 	
       	 	Card card2 = new Card("Wild", 50, "Wild Draw 4");
    	 	JButton cardButton2 = new JButton("iv");
    	 	cardButton2.setBackground(Color.BLACK);
    	 	cardButton2.setForeground(Color.WHITE);
    	 	cardButton2.setHorizontalAlignment(SwingConstants.CENTER);
    	 	cardButton2.setOpaque(true);
    	 	cardButton2.setFocusable(false);
    	 	cardButton2.setPreferredSize(new Dimension(45, 35));
    	 	unoDeck.put(card2,cardButton2);
    	 	cardButton2.setName("WildDrawFour" + "(" + String.valueOf(i) + ")");
        }
        return unoDeck;
    }
    
	/**
	 * This method is for shuffling and dealing cards in unoDeck (HashMap<Card,JButton>) to the players (Player)
	*/public static void dealCards(HashMap<Card, JButton> unoDeck, GameFrame gameFrame, Player... players) {
        List<Card> deck = new ArrayList<>(unoDeck.keySet());
        Collections.shuffle(deck);

        LinkedList<Card> drawPile = new LinkedList<>();

        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                Card card = deck.remove(0);
                player.getHand().addCard(card);
                if (player.getName().equals("Player")) {
                    gameFrame.addCardToPlayerHand(unoDeck.get(card));
                }
            }
        }

        Card discardPileCard = deck.remove(0);
        JButton discardPileButton = unoDeck.get(discardPileCard);
        
        discardPileButton.setEnabled(false);
        discardPileButton.setFont(new Font("Arial", Font.BOLD, 30));
        
        LinkedList<Card> discardPile = new LinkedList<Card>();
        discardPile.push(discardPileCard);

        drawPile.addAll(deck);

        GameFrame.setDrawPile(drawPile);
        GameFrame.setDiscardPile(discardPile);
        gameFrame.updateDiscardPile(discardPileButton);
    }
}