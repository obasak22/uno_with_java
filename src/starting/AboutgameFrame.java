package starting;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**A user can reach to MainFrame (JFrame) which is in "starting" package with this AboutgameFrame (JFrame) by the respective button
 * This AboutgameFrame (JFrame) is for viewing game rules
 */


public class AboutgameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutgameFrame frame = new AboutgameFrame();
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
	public AboutgameFrame() {
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
		
		JLabel cardsLabel = new JLabel();
		cardsLabel.setIcon(new ImageIcon("cardrules.png"));
		cardsLabel.setBounds(0, 100, 690, 425);
		cardsLabel.setVisible(false);
		contentPane.add(cardsLabel);
		
		JLabel gameplayLabel = new JLabel();
		gameplayLabel.setIcon(new ImageIcon("gameplayrules.png"));
		gameplayLabel.setBounds(0, 100, 690, 425);
		gameplayLabel.setVisible(false);
		contentPane.add(gameplayLabel);
		
		JLabel scoringLabel = new JLabel();
		scoringLabel.setIcon(new ImageIcon("scoringrules.png"));
		scoringLabel.setBounds(0, 100, 690, 425);
		scoringLabel.setVisible(false);
		contentPane.add(scoringLabel);
		
		JButton cardsButton = new JButton("Cards");
		cardsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cardsButton.setBackground(new Color(56, 171, 252));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cardsButton.setBackground(new Color(0, 190, 175));
			}
		});
		cardsButton.setBounds(55, 25, 160, 50);
		cardsButton.setFont(new Font("Courier New", Font.BOLD, 25));
		cardsButton.setBackground(new Color(0, 190, 175));
		cardsButton.setForeground(new Color(249, 244, 224));
		cardsButton.setFocusable(false);
		cardsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (!cardsLabel.isVisible()) {
            		cardsLabel.setVisible(true);
                } else {
                	cardsLabel.setVisible(false);
                }
            	gameplayLabel.setVisible(false);
            	scoringLabel.setVisible(false);
            }
        });
		cardsButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(cardsButton);
		
		JButton gameplayButton = new JButton("Gameplay");
		gameplayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				gameplayButton.setBackground(new Color(56, 171, 252));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gameplayButton.setBackground(new Color(0, 190, 175));
			}
		});
		gameplayButton.setBounds(270, 25, 160, 50);
		gameplayButton.setFont(new Font("Courier New", Font.BOLD, 25));
		gameplayButton.setBackground(new Color(0, 190, 175));
		gameplayButton.setForeground(new Color(249, 244, 224));
		gameplayButton.setFocusable(false);
		gameplayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cardsLabel.setVisible(false);
            	if (!gameplayLabel.isVisible()) {
            		gameplayLabel.setVisible(true);
                } else {
                	gameplayLabel.setVisible(false);
                }
            	scoringLabel.setVisible(false);
            }
        });
		gameplayButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(gameplayButton);
		
		JButton scoringButton = new JButton("Scoring");
		scoringButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				scoringButton.setBackground(new Color(56, 171, 252));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				scoringButton.setBackground(new Color(0, 190, 175));
			}
		});
		scoringButton.setBounds(485, 25, 160, 50);
		scoringButton.setFont(new Font("Courier New", Font.BOLD, 25));
		scoringButton.setBackground(new Color(0, 190, 175));
		scoringButton.setForeground(new Color(249, 244, 224));
		scoringButton.setFocusable(false);
		scoringButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cardsLabel.setVisible(false);
            	gameplayLabel.setVisible(false);
            	if (!scoringLabel.isVisible()) {
            		scoringLabel.setVisible(true);
                } else {
                	scoringLabel.setVisible(false);
                }
            }
        });
		scoringButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(scoringButton);
		
		JButton backtomainframeButton = new JButton("Back to the Starting Page");
		backtomainframeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backtomainframeButton.setBackground(new Color(0, 190, 175));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backtomainframeButton.setBackground(new Color(56, 171, 252));
			}
		});
		backtomainframeButton.setBounds(125, 553, 450, 50);
		backtomainframeButton.setFont(new Font("Courier New", Font.BOLD, 28));
		backtomainframeButton.setBackground(new Color(56, 171, 252));
		backtomainframeButton.setForeground(new Color(249, 244, 224));
		backtomainframeButton.setFocusable(false);
		backtomainframeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setBounds(getBounds());
    	        mainFrame.setLocation(getLocation()); 
                mainFrame.setVisible(true);
                dispose();
            }
        });
		backtomainframeButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		contentPane.add(backtomainframeButton);
	}
}
