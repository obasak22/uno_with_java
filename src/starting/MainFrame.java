package starting;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**A user can reach to the all JFrames in "starting" package with this MainFrame (JFrame) by the respective buttons
 */

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		getContentPane().setFont(new Font("Tekton Pro Ext", Font.BOLD, 16));
		getContentPane().setBackground(new Color(0, 60, 67));
		
		JButton loginButton = new JButton("Log In");
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
		loginButton.setBounds(100, 493, 200, 50);
		loginButton.setFont(new Font("Courier New", Font.BOLD, 28));
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
		
		JButton signupButton = new JButton("Sign Up");
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
		signupButton.setBounds(400, 493, 200, 50);
		signupButton.setFont(new Font("Courier New", Font.BOLD, 28));
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
		
		JButton aboutgameButton = new JButton("About Game");
		aboutgameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				aboutgameButton.setBackground(new Color(0, 190, 175));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				aboutgameButton.setBackground(new Color(56, 171, 252));
			}
		});
		aboutgameButton.setBounds(200, 553, 300, 50);
		aboutgameButton.setFont(new Font("Courier New", Font.BOLD, 28));
		aboutgameButton.setForeground(new Color(249, 244, 224));
		aboutgameButton.setBackground(new Color(56, 171, 252));
		aboutgameButton.setFocusable(false);
		aboutgameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AboutgameFrame aboutgameFrame = new AboutgameFrame();
                aboutgameFrame.setBounds(getBounds());
    	        aboutgameFrame.setLocation(getLocation()); 
                aboutgameFrame.setVisible(true);
                dispose();
            }
        });
		aboutgameButton.setBorder(BorderFactory.createLineBorder(new Color(249, 244, 224)));
		getContentPane().add(aboutgameButton);
		
		ImageIcon backgroundIcon = new ImageIcon("background.png");
	    JLabel backgroundLabel = new JLabel(backgroundIcon);
	    backgroundLabel.setBounds(0, 0, 700, 650);
	    getContentPane().add(backgroundLabel);
		
		setResizable(false);
		setBackground(new Color(0, 60, 67));
		setForeground(new Color(227, 254, 247));
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		setTitle("Starting Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
	}
}
