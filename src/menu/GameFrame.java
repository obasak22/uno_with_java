package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import data.UserStatistics;
import game.Card;
import game.Player;
import game.UnoDeck;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**When this GameFrame (JFrame) terminates, the user will be able to play the Uno game
 * Game's logic has been implemented in JButtons with ActionListeners
 */

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel middle;
	private JPanel playerHand;
	private JButton playButton;
	private JButton drawButton;
	private boolean hasDrawnCard = false;
	private boolean hasPlayedCard = false;
	private int currentplayerIndex = 100;
	private static LinkedList<Card> discardPile;
	private static Player[] players = {new Player("Player"), new Player("Bot1"), new Player("Bot2"), new Player("Bot3")};
	private static HashMap<Card, JButton> unoDeck;
    private static LinkedList<Card> drawPile;
    private static JButton discardPileButton;
    private boolean gameDirection = true;
    private JLabel normal;
    private JLabel counter;
    private JLabel playerTurn;
    private JLabel bot1Turn;
    private JLabel bot2Turn;
    private JLabel bot3Turn;
    private JLabel botCardNumber;
    private boolean isGameRunning = true;
    private static String winner;
    private static int point = 0;
    private String username;
    
    /**
	 * This is the getter method for the point (int) property
	*/public static int getPoint() {
    	return point;
    }
    
	/**
	 * This method is for keeping the first card of discardPile (LinkedList<Card>) in discardPile (LinkedList<Card>)
	 * And, shuffling other cards and putting them to the drawPile (LinkedList<Card>) 
	*/public static void updateDrawPileFromDiscardPile() {
    	 Card firstCard = discardPile.removeFirst();
    	 drawPile.addAll(discardPile);
    	 Collections.shuffle(drawPile);
    	 discardPile.clear();
    	 discardPile.add(firstCard);
    }
    
	/**
	 * This method is for calculating the point of the winner when a game ends
	*/public void calculatePoint() {
    	if (winner.equals(players[0].getName())) {
	    	for (int i = 0; i < players.length; i++) {
	    		if (i != 0) {
	    			for (Card card : players[i].getHand().getCards()) {
		    			point += card.getPoint();
		    		}
	    		}
	    	}
    	}
    	else if (winner.equals(players[1].getName())) {
	    	for (int i = 0; i < players.length; i++) {
	    		if (i != 1) {
	    			for (Card card : players[i].getHand().getCards()) {
		    			point += card.getPoint();
		    		}
	    		}
	    	}
    	}
    	else if (winner.equals(players[2].getName())) {
	    	for (int i = 0; i < players.length; i++) {
	    		if (i != 2) {
	    			for (Card card : players[i].getHand().getCards()) {
		    			point += card.getPoint();
		    		}
	    		}
	    	}
    	}
    	else {
	    	for (int i = 0; i < players.length; i++) {
	    		if (i != 3) {
	    			for (Card card : players[i].getHand().getCards()) {
		    			point += card.getPoint();
		    		}
	    		}
	    	}
    	}
    }
    
    /**
	 * This is the getter method for the winner (String) property
	*/public static String getWinner() {
		return winner;
	}

    /**
	 * This is the getter method for the username (String) property
	*/public String getUsername() {
		return username;
	}

	/**
	 * This is the setter method of the username (String) property
	*/public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * This method is for checking if a Card can be played on another Card
	*/public boolean canPlay(Card card, Card discardCard) {
		if (card.getPoint() == 50) {
			return true;
		}
		if (card.getColor().equals(discardCard.getColor())) {
			return true;
		}
		if (card.getPoint() < 10 && card.getPoint() == discardCard.getPoint()) {
			return true;
		}
		if (card.getPoint() == 20 && card.getType().equals(discardCard.getType())) {
			return true;
		}
		if (discardCard.getPoint() == 50) {
			return true;
		}
		return false;
	}
    
	/**
	 * This method is for updating isGameRunning (boolean) and winner (String)
	 * If a player has no cards, isGameRunning (boolean) updates as false and winner (String) updates as name of the player with no cards
	*/public void updateIsGameRunning() {
    	if (players[0].getHand().getCardCount() == 0 || players[1].getHand().getCardCount() == 0 || 
    			players[2].getHand().getCardCount() == 0 || players[3].getHand().getCardCount() == 0) {
    		isGameRunning = false;
    		if (players[0].getHand().getCardCount() == 0) {
    			winner = players[0].getName();
    		}
    		else if (players[1].getHand().getCardCount() == 0) {
    			winner = players[1].getName();
    		}
    		else if (players[2].getHand().getCardCount() == 0) {
    			winner = players[2].getName();
    		}
    		else {
    			winner = players[3].getName();
    		}
    	}
    	else{
    		isGameRunning = true;
    	}
    }
    
	/**
	 * This method is for updating botCardNumber (JLabel)
	*/public void updateBotCardCounts() {
    	if (gameDirection) {
    		botCardNumber.setText(players[1].getName() + " : " + players[1].getHand().getCardCount() + " | " + players[2].getName() + " : " +
            		+ players[2].getHand().getCardCount() + " | " + players[3].getName() + " : " + players[3].getHand().getCardCount());
    	}
    	else {
    		botCardNumber.setText(players[3].getName() + " : " + players[3].getHand().getCardCount() + " | " + players[2].getName() + " : " +
            		+ players[2].getHand().getCardCount() + " | " + players[1].getName() + " : " + players[1].getHand().getCardCount());
    	}
        
        contentPane.revalidate();
        contentPane.repaint();
    }

	/**
	 * This method is for setting one of these JLabels visible and others not visible respect to the game turn:
	 * playerTurn (JLabel)
	 * bot1Turn (JLabel)
	 * bot2Turn (JLabel)
	 * bot3Turn (JLabel)
	*/public void whoseTurn(int currentplayerIndex) {
    	if (gameDirection) {
    		if (currentplayerIndex % 4 == 0) {
        		playerTurn.setVisible(true);
        		bot1Turn.setVisible(false);
        		bot2Turn.setVisible(false);
        		bot3Turn.setVisible(false);
        	}
        	else if (currentplayerIndex % 4 == 1) {
        		playerTurn.setVisible(false);
        		bot1Turn.setVisible(true);
        		bot2Turn.setVisible(false);
        		bot3Turn.setVisible(false);
        	}
        	else if (currentplayerIndex % 4 == 2) {
        		playerTurn.setVisible(false);
        		bot1Turn.setVisible(false);
        		bot2Turn.setVisible(true);
        		bot3Turn.setVisible(false);
        	}
        	else {
        		playerTurn.setVisible(false);
        		bot1Turn.setVisible(false);
        		bot2Turn.setVisible(false);
        		bot3Turn.setVisible(true);
        	}
    	}
    	else {
    		if (currentplayerIndex % 4 == 0) {
        		playerTurn.setVisible(true);
        		bot1Turn.setVisible(false);
        		bot2Turn.setVisible(false);
        		bot3Turn.setVisible(false);
        	}
        	else if (currentplayerIndex % 4 == 1) {
        		playerTurn.setVisible(false);
        		bot1Turn.setVisible(false);
        		bot2Turn.setVisible(false);
        		bot3Turn.setVisible(true);
        	}
        	else if (currentplayerIndex % 4 == 2) {
        		playerTurn.setVisible(false);
        		bot1Turn.setVisible(false);
        		bot2Turn.setVisible(true);
        		bot3Turn.setVisible(false);
        	}
        	else {
        		playerTurn.setVisible(false);
        		bot1Turn.setVisible(true);
        		bot2Turn.setVisible(false);
        		bot3Turn.setVisible(false);
        	}
    	}
    }
    
	/**
	 * This method is for setting cards' buttons actions
	*/public void setCardButtons(HashMap<Card, JButton> unoDeck) {
        for (Map.Entry<Card, JButton> entry : unoDeck.entrySet()) {
            Card card = entry.getKey();
            JButton button = entry.getValue();
            button.putClientProperty("card", card);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	JButton clickedButton = (JButton) e.getSource();
                    Card clickedCard = (Card) clickedButton.getClientProperty("card");                    
                    if (currentplayerIndex % 4 == 0 && canPlay(clickedCard, discardPile.getFirst()) && !hasPlayedCard) {
                        playCard(clickedCard, clickedButton);
                        hasPlayedCard = true;
                    }
                }
            });
        }
    }
    
	/**
	 * This is the setter for the drawPile (LinkedList<Card>)
	*/public static void setDrawPile(LinkedList<Card> pile) {
        drawPile = pile;
    }

	/**
	 * This method is for adding a Card to start of the discardPile (LinkedList<Card>)
	*/public void addToDiscardPile(Card discardPileCard) {
        discardPile.push(discardPileCard);
    }

	/**
	 * This is the setter for the discardPile (LinkedList<Card>)
	*/public static void setDiscardPile(LinkedList<Card> pile) {
		discardPile = pile;
	}


	/**
	 * This method is for adding a card's button (JButton) to playerHand (JPanel)
	*/public void addCardToPlayerHand(JButton cardButton) {
        playerHand.add(cardButton);
        playerHand.revalidate();
        playerHand.repaint();
    }

	/**
	 * This method is for removing everything from middle (JPanel) and adding a card's button
	*/public void updateDiscardPile(JButton discardPileButton) {
        middle.removeAll();
        middle.add(discardPileButton);
        middle.revalidate();
        middle.repaint();
    }
    
	/**
	 * This method is for dealing cards randomly to the players
	*/public static void startGame(GameFrame frame) {
	    unoDeck = UnoDeck.createUnoDeck();
        UnoDeck.dealCards(unoDeck, frame, players);
    }
    
	/**
	 * This method is applying true actions when a card has been played by the user
	 * "Draw 2", "Wild Draw 4", "Skip", and "Reverse" special cards' actions are in this method
	*/public void playCard(Card card, JButton cardButton) {
        if (hasPlayedCard) {
            return;
        }
        if (discardPile == null) {
            discardPile = new LinkedList<>();
        }
        playerHand.remove(cardButton);
        playerHand.revalidate();
        playerHand.repaint();
        players[currentplayerIndex % 4].getHand().removeCard(card);
        discardPile.push(card);
        updateDiscardPile(cardButton);
        cardButton.setEnabled(false);
        cardButton.setFont(new Font("Arial", Font.BOLD, 30));
        if (card.getType().equals("Draw 2")) {
        	currentplayerIndex++;
        	Card drawnCard1 = drawPile.poll();
            players[currentplayerIndex % 4].getHand().addCard(drawnCard1);
            Card drawnCard2 = drawPile.poll();
            players[currentplayerIndex % 4].getHand().addCard(drawnCard2);
        }
        if (card.getType().equals("Wild Draw 4")) {
        	currentplayerIndex++;
        	Card drawnCard1 = drawPile.poll();
            players[currentplayerIndex % 4].getHand().addCard(drawnCard1);
            Card drawnCard2 = drawPile.poll();
            players[currentplayerIndex % 4].getHand().addCard(drawnCard2);
            Card drawnCard3 = drawPile.poll();
            players[currentplayerIndex % 4].getHand().addCard(drawnCard3);
            Card drawnCard4 = drawPile.poll();
            players[currentplayerIndex % 4].getHand().addCard(drawnCard4);
        }
        if (card.getType().equals("Skip")) {
        	currentplayerIndex++;
        }
        if (card.getType().equals("Reverse")) {
        	gameDirection = !gameDirection;
        	updateGameDirection();
        	reversePlayers();
        }
    }
    
	/**
	 * This method is for setting one of these JLabels visible and others not visible respect to the gameDirection (boolean):
	 * normal (JLabel)
	 * counter (JLabel)
	*/public void updateGameDirection() {
    	if (gameDirection) {
    		normal.setVisible(true);
    		counter.setVisible(false);
    	}
    	else {
    		normal.setVisible(false);
    		counter.setVisible(true);
    	}
    }
    
	/**
	 * This method is for changing the order of the players (Player[]) correctly when the user plays a "Reverse" card
	*/public void reversePlayers() {
        Player temp1 = players[1];
        players[1] = players[3];
        players[3] = temp1;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */

	public GameFrame() {
		unoDeck = UnoDeck.createUnoDeck();
		setCardButtons(unoDeck);
		
	    setForeground(new Color(227, 254, 247));
	    setBackground(new Color(6, 23, 41));
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
	    setTitle("Game");
	    setBounds(100, 100, 700, 650);
	    contentPane = new JPanel();
	    contentPane.setForeground(new Color(227, 254, 247));
	    contentPane.setBackground(new Color(6, 23, 41));
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    playerHand = new JPanel();
	    playerHand.setBounds(50, 500, 600, 100);
	    playerHand.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    contentPane.add(playerHand);
	    
	    middle = new JPanel();
	    middle.setBounds(300, 200, 100, 150);
	    middle.setLayout(new BorderLayout());
	    contentPane.add(middle);
	    
	    discardPileButton = new JButton();
	    discardPileButton.setBounds(300, 200, 100, 150);
	    middle.add(discardPileButton, BorderLayout.CENTER);
	    
	    normal = new JLabel("Game direction: Clockwise");
	    normal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	    normal.setHorizontalAlignment(SwingConstants.CENTER);
	    normal.setForeground(new Color(255, 255, 255));
	    normal.setBounds(50, 138, 600, 35);
	    normal.setVisible(true);
	    contentPane.add(normal);
	    
	    counter = new JLabel("Game direction: Counter-clockwise");
	    counter.setHorizontalAlignment(SwingConstants.CENTER);
	    counter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	    counter.setForeground(Color.WHITE);
	    counter.setBounds(50, 138, 600, 35);
	    counter.setVisible(false);
	    contentPane.add(counter);
	    
	    playButton = new JButton("Play");
	    playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playButton.setBackground(new Color(0, 190, 175));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				playButton.setBackground(new Color(56, 171, 252));
			}
		});
		playButton.setBounds(50, 417, 150, 50);
		playButton.setFont(new Font("Courier New", Font.BOLD, 25));
		playButton.setBackground(new Color(56, 171, 252));
		playButton.setForeground(new Color(249, 244, 224));
		playButton.setFocusable(false);
	    playButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if (hasPlayedCard && currentplayerIndex % 4 == 0) {
	            	currentplayerIndex++;
		            hasPlayedCard = false;
		            hasDrawnCard = false;
		            if (currentplayerIndex % 4 != 0) {
		                boolean played = false;
		                for (Card botCard : players[currentplayerIndex % 4].getHand().getCards()) {
		                    if (canPlay(botCard, discardPile.getFirst())) {
		                        players[currentplayerIndex % 4].getHand().removeCard(botCard);
		                        addToDiscardPile(botCard);
		                        JButton botCardButton = unoDeck.get(botCard);
		                        updateDiscardPile(botCardButton);
		                        botCardButton.setEnabled(false);
		                        botCardButton.setFont(new Font("Arial", Font.BOLD, 30));
		                        played = true;
		                        if (botCard.getType().equals("Skip")) {
		                        	currentplayerIndex++;
		                        }
		                        break;
		                    }
		                }
		                if (!played) {
		                    Card drawnCard = drawPile.poll();
		                    players[currentplayerIndex % 4].getHand().addCard(drawnCard);
		                    if (canPlay(drawnCard, discardPile.getFirst())) {
		                        players[currentplayerIndex % 4].getHand().removeCard(drawnCard);
		                        addToDiscardPile(drawnCard);
		                        JButton drawnCardButton = unoDeck.get(drawnCard);
		                        updateDiscardPile(drawnCardButton);
		                        drawnCardButton.setEnabled(false);
		                        drawnCardButton.setFont(new Font("Arial", Font.BOLD, 30));
		                        if (drawnCard.getType().equals("Skip")) {
		                        	currentplayerIndex++;
		                        }
		                    }
		                }
		            }
	            }
	            else if (!hasPlayedCard && hasDrawnCard && currentplayerIndex % 4 == 0) {
	            	currentplayerIndex++;
	            	hasPlayedCard = false;
	            	hasDrawnCard = false;
	            	if (currentplayerIndex % 4 != 0) {
		                boolean played = false;
		                for (Card botCard : players[currentplayerIndex % 4].getHand().getCards()) {
		                    if (canPlay(botCard, discardPile.getFirst())) {
		                        players[currentplayerIndex % 4].getHand().removeCard(botCard);
		                        addToDiscardPile(botCard);
		                        JButton botCardButton = unoDeck.get(botCard);
		                        updateDiscardPile(botCardButton);
		                        botCardButton.setEnabled(false);
		                        botCardButton.setFont(new Font("Arial", Font.BOLD, 30));
		                        played = true;
		                        if (botCard.getType().equals("Skip")) {
		                        	currentplayerIndex++;
		                        }
		                        break;
		                    }
		                }
		                if (!played) {
		                    Card drawnCard = drawPile.poll();
		                    players[currentplayerIndex % 4].getHand().addCard(drawnCard);
		                    if (canPlay(drawnCard, discardPile.getFirst())) {
		                        players[currentplayerIndex % 4].getHand().removeCard(drawnCard);
		                        addToDiscardPile(drawnCard);
		                        JButton drawnCardButton = unoDeck.get(drawnCard);
		                        updateDiscardPile(drawnCardButton);
		                        drawnCardButton.setEnabled(false);
		                        drawnCardButton.setFont(new Font("Arial", Font.BOLD, 30));
		                        if (drawnCard.getType().equals("Skip")) {
		                        	currentplayerIndex++;
		                        }
		                        
		                    }
		                }
		            }
	            }	      
	            else if (currentplayerIndex % 4 != 0 && currentplayerIndex % 4 != 3) {
	            	currentplayerIndex++;
	            	hasPlayedCard = false;
	            	hasDrawnCard = false;
	            	if (currentplayerIndex % 4 != 0) {
		                boolean played = false;
		                for (Card botCard : players[currentplayerIndex % 4].getHand().getCards()) {
		                    if (canPlay(botCard, discardPile.getFirst())) {
		                        players[currentplayerIndex % 4].getHand().removeCard(botCard);
		                        addToDiscardPile(botCard);
		                        JButton botCardButton = unoDeck.get(botCard);
		                        updateDiscardPile(botCardButton);
		                        botCardButton.setEnabled(false);
		                        botCardButton.setFont(new Font("Arial", Font.BOLD, 30));
		                        played = true;
		                        if (botCard.getType().equals("Skip")) {
		                        	currentplayerIndex++;
		                        }
		                        break;
		                    }
		                }
		                if (!played) {
		                    Card drawnCard = drawPile.poll();
		                    players[currentplayerIndex % 4].getHand().addCard(drawnCard);
		                    if (canPlay(drawnCard, discardPile.getFirst())) {
		                        players[currentplayerIndex % 4].getHand().removeCard(drawnCard);
		                        addToDiscardPile(drawnCard);
		                        JButton drawnCardButton = unoDeck.get(drawnCard);
		                        updateDiscardPile(drawnCardButton);
		                        drawnCardButton.setEnabled(false);
		                        drawnCardButton.setFont(new Font("Arial", Font.BOLD, 30));
		                        if (drawnCard.getType().equals("Skip")) {
		                        	currentplayerIndex++;
		                        }
		                    }
		                }
		            }
	            }
	            else if (currentplayerIndex % 4 == 3) {
	            	currentplayerIndex++;
	            	hasPlayedCard = false;
	            	hasDrawnCard = false;
	            }
	            whoseTurn(currentplayerIndex);
	            updateBotCardCounts();
	            updateIsGameRunning();
	            if (!isGameRunning) {
	            	calculatePoint();
	            	if (winner.equals("Player")) {
	            		String string = UserStatistics.userStatistics.get(username);
	            		String[] parts = string.split("\\.");
	            		int winNumber = Integer.parseInt(parts[0]);
	            		int loseNumber = Integer.parseInt(parts[1]);
	            		int totalPoints = Integer.parseInt(parts[2]);
	            		winNumber++;
	            		totalPoints += point;
	            		String newString = winNumber + "." + loseNumber + "." + totalPoints;
	            		UserStatistics.userStatistics.put(username, newString);
	            		UserStatistics.saveStatistics();
	            	}
	            	else {
	            		String string = UserStatistics.userStatistics.get(username);
	            		String[] parts = string.split("\\.");
	            		int winNumber = Integer.parseInt(parts[0]);
	            		int loseNumber = Integer.parseInt(parts[1]);
	            		int totalPoints = Integer.parseInt(parts[2]);
	            		loseNumber++;
	            		String newString = winNumber + "." + loseNumber + "." + totalPoints;
	            		UserStatistics.userStatistics.put(username, newString);
	            		UserStatistics.saveStatistics();
	            	}
	            	GameEndFrame gameEndFrame = new GameEndFrame();
	            	gameEndFrame.setUsername(username);
	            	gameEndFrame.setBounds(getBounds());
	            	gameEndFrame.setLocation(getLocation()); 
	            	gameEndFrame.setVisible(true);
	                dispose();
	            }
	        }
	    });
	    playButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
	    contentPane.add(playButton);
	    
	    drawButton = new JButton("Draw");
	    drawButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				drawButton.setBackground(new Color(0, 190, 175));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				drawButton.setBackground(new Color(56, 171, 252));
			}
		});
		drawButton.setBounds(500, 417, 150, 50);
		drawButton.setFont(new Font("Courier New", Font.BOLD, 25));
		drawButton.setBackground(new Color(56, 171, 252));
		drawButton.setForeground(new Color(249, 244, 224));
		drawButton.setFocusable(false);
	    drawButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (!hasDrawnCard && currentplayerIndex % 4 == 0 && !hasPlayedCard) {
	    			Card drawnCard = drawPile.poll();
	    			players[currentplayerIndex % 4].getHand().addCard(drawnCard);
	    			addCardToPlayerHand(unoDeck.get(drawnCard));
	    			hasDrawnCard = true;
	    		}
	    	}
        });
	    drawButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
	    contentPane.add(drawButton);
	    
	    playerTurn = new JLabel("Who's turn? Player");
	    playerTurn.setHorizontalAlignment(SwingConstants.CENTER);
	    playerTurn.setFont(new Font("Tahoma", Font.ITALIC, 25));
	    playerTurn.setForeground(new Color(255, 255, 255));
	    playerTurn.setBounds(50, 72, 600, 33);
	    playerTurn.setVisible(true);
	    contentPane.add(playerTurn);
	    
	    bot1Turn = new JLabel("Bot1 has played.");
	    bot1Turn.setFont(new Font("Tahoma", Font.ITALIC, 25));
	    bot1Turn.setHorizontalAlignment(SwingConstants.CENTER);
	    bot1Turn.setForeground(Color.WHITE);
	    bot1Turn.setBounds(50, 72, 600, 33);
	    bot1Turn.setVisible(false);
	    contentPane.add(bot1Turn);
	    
	    bot2Turn = new JLabel("Bot2 has played.");
	    bot2Turn.setHorizontalAlignment(SwingConstants.CENTER);
	    bot2Turn.setFont(new Font("Tahoma", Font.ITALIC, 25));
	    bot2Turn.setForeground(Color.WHITE);
	    bot2Turn.setBounds(50, 72, 600, 33);
	    bot2Turn.setVisible(false);
	    contentPane.add(bot2Turn);
	    
	    bot3Turn = new JLabel("Bot3 has played.");
	    bot3Turn.setHorizontalAlignment(SwingConstants.CENTER);
	    bot3Turn.setFont(new Font("Tahoma", Font.ITALIC, 25));
	    bot3Turn.setForeground(Color.WHITE);
	    bot3Turn.setBounds(50, 72, 600, 33);
	    bot3Turn.setVisible(false);
	    contentPane.add(bot3Turn);
	    
	    botCardNumber = new JLabel("Bot1 : 7  | Bot2 : 7 | Bot3 : 7");
	    botCardNumber.setHorizontalAlignment(SwingConstants.CENTER);
	    botCardNumber.setFont(new Font("Courier New", Font.BOLD, 30));
	    botCardNumber.setForeground(Color.WHITE);
	    botCardNumber.setBounds(0,0,686,62);
	    contentPane.add(botCardNumber);
	    
	    middle.revalidate();
	    middle.repaint();
	    
	    startGame(this);
	}
}
