package menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import data.UserStatistics;

/**A user can reach to MainMenuFrame (JFrame) which is in "menu" package with this StatisticsFrame (JFrame) by the respective button
 * This frame shows the table of users' statistics of the Uno game by reading data from "statistics.txt" file
 */

public class StatisticsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String username;
	

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
					StatisticsFrame frame = new StatisticsFrame();
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
	public StatisticsFrame() {
		setForeground(new Color(227, 254, 247));
		setBackground(new Color(6, 23, 41));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		setTitle("Game Infos");
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(227, 254, 247));
		contentPane.setBackground(new Color(6, 23, 41));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		contentPane.add(backtomainmenuButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setFont(new Font("Courier New", Font.PLAIN, 20));
		textArea.setBackground(new Color(6, 23, 41));
		textArea.setBounds(100, 59, 500, 400);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(100,59,500,400);
		contentPane.add(scrollPane);
		
		for (Map.Entry<String, String> entry : UserStatistics.userStatistics.entrySet()) {
		    String value = entry.getValue();
    		String[] parts = value.split("\\.");
    		int winNumber = Integer.parseInt(parts[0]);
		    int loseNumber = Integer.parseInt(parts[1]);
		    int totalPoints = Integer.parseInt(parts[2]);
		    textArea.append("Username: " + entry.getKey() + "\n    Win: " + winNumber + " Lose: " + loseNumber + " Total Points: " + totalPoints + "\n");
		}
	}
}
