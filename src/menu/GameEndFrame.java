package menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

/**This GameEndFrame (JFrame) will be terminated when a game in GameFrame (JFrame) ends
 * And, this GameEndFrame (JFrame) will be terminated with keeping the username (String) of the user and point (int) from GameFrame (JFrame)
 * A user can reach to MainMenuFrame (JFrame) which is in "menu" package with this GameEndFrame (JFrame) by the respective button
 */

public class GameEndFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String username;
	private String winner;
	
	/**
	 * This is the getter method for the winner (String) property
	*/public String getWinner() {
		return winner;
	}

	/**
	 * This is the setter method of the winner (String) property
	*/public void setWinner(String winner) {
		this.winner = winner;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEndFrame frame = new GameEndFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameEndFrame() {
		setWinner(GameFrame.getWinner());
		
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
		
		JButton backtomainmenuButton = new JButton("Back to Main Menu");
		backtomainmenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backtomainmenuButton.setBackground(new Color(0, 190, 175));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backtomainmenuButton.setBackground(new Color(56, 171, 252));
			}
		});
		backtomainmenuButton.setBounds(100, 508, 500, 60);
		backtomainmenuButton.setFont(new Font("Courier New", Font.BOLD, 25));
		backtomainmenuButton.setBackground(new Color(56, 171, 252));
		backtomainmenuButton.setForeground(new Color(249, 244, 224));
		backtomainmenuButton.setFocusable(false);
		backtomainmenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MainMenuFrame mainmenuFrame = new MainMenuFrame();
            	mainmenuFrame.setBounds(getBounds());
            	mainmenuFrame.setLocation(getLocation()); 
            	mainmenuFrame.setVisible(true);
            	mainmenuFrame.setUsername(getUsername());
                dispose();
            }
        });
		contentPane.setLayout(null);
		backtomainmenuButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(backtomainmenuButton);
		
		JLabel playerWonFrame = new JLabel("You won the game!");
		String playerWonString = winner + " won with " + GameFrame.getPoint() + " points!";
		playerWonFrame.setText(playerWonString);
		playerWonFrame.setFont(new Font("Tahoma", Font.PLAIN, 25));
		playerWonFrame.setForeground(new Color(255, 255, 255));
		playerWonFrame.setBounds(46, 149, 630, 178);
		contentPane.add(playerWonFrame);
	}
}
