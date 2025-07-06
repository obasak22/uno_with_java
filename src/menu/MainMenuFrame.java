package menu;

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
import data.UserStatistics;
import java.awt.Color;

/**A user can reach to GameFrame (JFrame), LeaderboardFrame (JFrame), and StatisticsFrame (JFrame)
 * which are in "menu" package with this MainMenu (JFrame) by the respective buttons
 */

public class MainMenuFrame extends JFrame {

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
					MainMenuFrame frame = new MainMenuFrame();
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
	public MainMenuFrame() {
		UserStatistics.startWithStatistics();
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
		JButton newgameButton = new JButton("Start a New Uno Game");
		newgameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newgameButton.setBackground(new Color(0, 190, 175));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				newgameButton.setBackground(new Color(56, 171, 252));
			}
		});
		newgameButton.setBounds(100, 82, 500, 60);
		newgameButton.setFont(new Font("Courier New", Font.BOLD, 25));
		newgameButton.setBackground(new Color(56, 171, 252));
		newgameButton.setForeground(new Color(249, 244, 224));
		newgameButton.setFocusable(false);
		newgameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	GameFrame gameFrame = new GameFrame();
                gameFrame.setUsername(getUsername());
                gameFrame.setBounds(getBounds());
                gameFrame.setLocation(getLocation()); 
                gameFrame.setVisible(true);
                dispose();
            }
        });
		contentPane.setLayout(null);
		newgameButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(newgameButton);
		
		JButton loadgameButton = new JButton("Load Your Saved Uno Game");
		loadgameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loadgameButton.setBackground(new Color(0, 190, 175));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				loadgameButton.setBackground(new Color(56, 171, 252));
			}
		});
		loadgameButton.setBounds(100, 224, 500, 60);
		loadgameButton.setFont(new Font("Courier New", Font.BOLD, 25));
		loadgameButton.setBackground(new Color(56, 171, 252));
		loadgameButton.setForeground(new Color(249, 244, 224));
		loadgameButton.setFocusable(false);
		loadgameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           
            }
        });
		contentPane.setLayout(null);
		loadgameButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(loadgameButton);
		
		JButton leaderboardButton = new JButton("View the Game Leaderboard");
		leaderboardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leaderboardButton.setBackground(new Color(0, 190, 175));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leaderboardButton.setBackground(new Color(56, 171, 252));
			}
		});
		leaderboardButton.setBounds(100, 366, 500, 60);
		leaderboardButton.setFont(new Font("Courier New", Font.BOLD, 25));
		leaderboardButton.setBackground(new Color(56, 171, 252));
		leaderboardButton.setForeground(new Color(249, 244, 224));
		leaderboardButton.setFocusable(false);
		leaderboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	LeaderboardFrame leaderboardFrame = new LeaderboardFrame();
            	leaderboardFrame.setUsername(getUsername());
            	leaderboardFrame.setBounds(getBounds());
           	 	leaderboardFrame.setLocation(getLocation()); 
           	 	leaderboardFrame.setVisible(true);
                dispose();
            }
        });
		contentPane.setLayout(null);
		leaderboardButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(leaderboardButton);
		
		JButton statisticsButton = new JButton("View Your Game Statistics");
		statisticsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				statisticsButton.setBackground(new Color(0, 190, 175));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				statisticsButton.setBackground(new Color(56, 171, 252));
			}
		});
		statisticsButton.setBounds(100, 508, 500, 60);
		statisticsButton.setFont(new Font("Courier New", Font.BOLD, 25));
		statisticsButton.setBackground(new Color(56, 171, 252));
		statisticsButton.setForeground(new Color(249, 244, 224));
		statisticsButton.setFocusable(false);
		statisticsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	StatisticsFrame statisticsFrame = new StatisticsFrame();
            	statisticsFrame.setUsername(getUsername());
            	statisticsFrame.setBounds(getBounds());
            	statisticsFrame.setLocation(getLocation()); 
            	statisticsFrame.setVisible(true);
                dispose();
            }
        });
		contentPane.setLayout(null);
		statisticsButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(statisticsButton);
	}		
}
