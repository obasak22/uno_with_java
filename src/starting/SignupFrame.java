package starting;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import data.UserStatistics;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**A user can reach to LoginFrame (JFrame) and MainFrame (JFrame) which are in "starting" package with this SignupFrame (JFrame)
 * by the respective buttons
 * Sign-up system has been coded to the signupButton (JButton) with an ActionListener
 */

public class SignupFrame extends JFrame {

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
					SignupFrame frame = new SignupFrame();
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
	public SignupFrame() {
		setForeground(new Color(227, 254, 247));
		setBackground(new Color(6, 23, 41));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		setTitle("Sign Up Page");
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(227, 254, 247));
		contentPane.setBackground(new Color(6, 23, 41));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton loginButton = new JButton("Log In If You Already Have an Account");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginButton.setBackground(new Color(0, 190, 175));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setBackground(new Color(56, 171, 252));
			}
		});
		loginButton.setBounds(50, 493, 600, 50);
		loginButton.setFont(new Font("Courier New", Font.BOLD, 25));
		loginButton.setForeground(new Color(249, 244, 224));
		loginButton.setBackground(new Color(56, 171, 252));
		loginButton.setFocusable(false);
		loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setBounds(getBounds());
    	        loginFrame.setLocation(getLocation()); 
                loginFrame.setVisible(true);
                dispose();
            }
        });
		loginButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(loginButton);
		
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
		
		JLabel logintext1Label = new JLabel("Sign up with your");
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
		
		JLabel signedupLabel = new JLabel("Signed up successfuly! You can log in now.");
		signedupLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signedupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signedupLabel.setForeground(new Color(0, 255, 0));
		signedupLabel.setBounds(125, 263, 450, 26);
		signedupLabel.setVisible(false);
		contentPane.add(signedupLabel);
		
		JLabel cannotsignedupLabel = new JLabel("Cannot signed up! Username already exists.");
		cannotsignedupLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cannotsignedupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cannotsignedupLabel.setForeground(new Color(255, 0, 0));
		cannotsignedupLabel.setBounds(125, 263, 450, 26);
		cannotsignedupLabel.setVisible(false);
		contentPane.add(cannotsignedupLabel);
		
		JButton signupButton = new JButton("Sign Up");
		signupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signupButton.setBackground(new Color(56, 171, 252));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				signupButton.setBackground(new Color(0, 190, 175));
			}
		});
		signupButton.setBounds(250, 400, 200, 40);
		signupButton.setFont(new Font("Courier New", Font.BOLD, 28));
		signupButton.setForeground(new Color(249, 244, 224));
		signupButton.setBackground(new Color(0, 190, 175));
		signupButton.setFocusable(false);
		signupButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String username = usernameField.getText();
		        String password = new String(passwordField.getPassword());
		        BufferedReader reader = null;
		        boolean usernameExists = false;
		        try {
		            reader = new BufferedReader(new FileReader("infos.txt"));
		            String line;
		            while ((line = reader.readLine()) != null) {
		                if (line.startsWith(username + "seperatorforinfos")) {
		                    usernameExists = true;
		                    break;
		                }
		            }
		            if (usernameExists) {
		                cannotsignedupLabel.setVisible(true);
		                signedupLabel.setVisible(false);
		            } else {
		                BufferedWriter writer = new BufferedWriter(new FileWriter("infos.txt", true));
		                writer.write(username + "seperatorforinfos" + password + "\n");
		                writer.close();
		                cannotsignedupLabel.setVisible(false);
		                signedupLabel.setVisible(true);
		                UserStatistics.userStatistics.put(username,"0.0.0");
		                UserStatistics.saveStatistics();
		            }
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        } finally {
		            try {
		                reader.close();
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		});
		signupButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(signupButton);
	}
}
