package starting;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import menu.MainMenuFrame;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**A user can reach to SignupFrame (JFrame) and MainFrame (JFrame) which are in "starting" package with this LoginFrame (JFrame)
 * by the respective buttons
 * Log-in system has been coded to the loginButton (JButton) with an ActionListener
 * When a user successfully logs in with this log-in system, the user will reach to MainMenuFrame (JFrame) which is in "menu" package
 * And, this MainMenuFrame (JFrame) will be terminated with keeping the username (String) of the user
 */


public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setForeground(new Color(227, 254, 247));
		setBackground(new Color(6, 23, 41));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		setTitle("Log In Page");
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(6, 23, 41));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton signupButton = new JButton("Sign Up If You Don't Have an Account");
		signupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signupButton.setBackground(new Color(0, 190, 175));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				signupButton.setBackground(new Color(56, 171, 252));
			}
		});
		signupButton.setBounds(50, 493, 600, 50);
		signupButton.setFont(new Font("Courier New", Font.BOLD, 25));
		signupButton.setBackground(new Color(56, 171, 252));
		signupButton.setForeground(new Color(249, 244, 224));
		signupButton.setFocusable(false);
		signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SignupFrame signupFrame = new SignupFrame();
                signupFrame.setBounds(getBounds());
    	        signupFrame.setLocation(getLocation()); 
                signupFrame.setVisible(true);
                dispose();
            }
        });
		signupButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(signupButton);
		
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
		
		JTextPane usernameField = new JTextPane();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		usernameField.setToolTipText("Enter your username");
		usernameField.setBounds(200, 220, 300, 40);
		contentPane.add(usernameField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setToolTipText("Enter your password");
		passwordField.setBounds(200, 320, 300, 40);
		contentPane.add(passwordField);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Courier New", Font.BOLD, 28));
		usernameLabel.setForeground(new Color(249, 244, 224));
		usernameLabel.setBounds(200, 180, 200, 40);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Courier New", Font.BOLD, 28));
		passwordLabel.setForeground(new Color(249, 244, 224));
		passwordLabel.setBounds(200, 280, 200, 40);
		contentPane.add(passwordLabel);
		
		JLabel logintext1Label = new JLabel("Log in with your");
		logintext1Label.setHorizontalAlignment(SwingConstants.CENTER);
		logintext1Label.setFont(new Font("Courier New", Font.BOLD, 40));
		logintext1Label.setForeground(new Color(249, 244, 224));
		logintext1Label.setBounds(0, 30, 700, 60);
		contentPane.add(logintext1Label);
		
		JLabel logintext2Label = new JLabel("username and password");
		logintext2Label.setHorizontalAlignment(SwingConstants.CENTER);
		logintext2Label.setForeground(new Color(249, 244, 224));
		logintext2Label.setFont(new Font("Courier New", Font.BOLD, 40));
		logintext2Label.setBounds(0, 100, 700, 60);
		contentPane.add(logintext2Label);
		
		JLabel errorLabel = new JLabel("Username or password is incorrect! Please try again or sign up.");
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(new Color(255, 0, 0));
		errorLabel.setBounds(125, 263, 450, 26);
		errorLabel.setVisible(false);
		contentPane.add(errorLabel);
		
		JButton loginButton = new JButton("Log In");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginButton.setBackground(new Color(56, 171, 252));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setBackground(new Color(0, 190, 175));
			}
		});
		loginButton.setBounds(250, 400, 200, 40);
		loginButton.setFont(new Font("Courier New", Font.BOLD, 28));
		loginButton.setForeground(new Color(249, 244, 224));
		loginButton.setBackground(new Color(0, 190, 175));
		loginButton.setFocusable(false);
		loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String username = usernameField.getText();
            	String password = new String(passwordField.getPassword());
            	BufferedReader reader = null;
					try {
						reader = new BufferedReader(new FileReader("infos.txt"));
						String line;
						while ((line = reader.readLine()) != null) {
							if (line.equals(username + "seperatorforinfos" + password)) {
								reader.close();
				                MainMenuFrame mainmenuFrame = new MainMenuFrame();
				                mainmenuFrame.setUsername(username);				                
				                mainmenuFrame.setBounds(getBounds());
				    	        mainmenuFrame.setLocation(getLocation());
				                mainmenuFrame.setVisible(true);
				                dispose();
				                return;
							}
						}
						errorLabel.setVisible(true);
					} catch (FileNotFoundException ex) {
	                    ex.printStackTrace();
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                } finally {
	                    if (reader != null) {
	                        try {
	                            reader.close();
	                        } catch (IOException ex) {
	                            ex.printStackTrace();
	                        }
	                    }
	                }
	            }
	        });
		loginButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(loginButton);
	}
}
