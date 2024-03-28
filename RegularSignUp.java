import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JTextField;


/**
 * 
 */

/**
 * @author Rudra Patel
 * Date: Jan. 2024
 * Description: Frame that opens up when user hits regular button for sign up
 *  /**
 * RegularSignUp Class
 *
 * Constructors:
 * 1. Default Constructor: RegularSignUp()
 *    - Initializes the RegularSignUp frame for user sign-up.
 *    - Sets up the GUI components and adds action listeners.
 *
 * Methods:
 * 2. void main(String[] args)
 *    - Main method for testing the RegularSignUp frame.
 *    - Creates an instance of RegularSignUp and sets some text for testing.
 *    - Displays the GUI for testing.
 *
 * 3. static class RoundedRectangle extends JComponent
 *    - Custom JComponent for drawing a rounded rectangle.
 *    - Overrides the paintComponent method to draw a rounded rectangle as the background.
 *
 * 4. void actionPerformed(ActionEvent e)
 *    - Action listener for the "Create Account" button.
 *    - Checks if all text fields contain information and validates the input.
 *    - Creates a new Regular account and passes data to the Main_Menu class.
 */

public class RegularSignUp {


    //private variables 
  	private JTextField firstNameField, lastNameField, userNameField, passwordField, emailField;
    private JProgressBar progressBar;
    private JFrame frame;

    public RegularSignUp() {
        frame = new JFrame("Account Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(695, 500);
        frame.setLocation(100, 100);

        JLayeredPane layeredPane = new JLayeredPane();

        // Add a rounded rectangle in the center
        RoundedRectangle centerBox = new RoundedRectangle();
        centerBox.setBackground(Color.BLACK);
        int boxWidth = 450; // Increase the width of the black box
        int boxHeight = 370; // Adjust the height of the black box
        int yOffset = 15; // Adjust the y-coordinate to move the box down
        centerBox.setBounds((frame.getWidth() - boxWidth) / 2, (frame.getHeight() - boxHeight) / 4 + yOffset, boxWidth, boxHeight);
        layeredPane.add(centerBox, JLayeredPane.DEFAULT_LAYER);
        
        // Add spotify logo
        ImageIcon SpotifyIcon = new ImageIcon("LogoS.png"); // Replace with the actual path to your image
        JLabel logo = new JLabel(SpotifyIcon);
        logo.setBounds(centerBox.getX() + 25, centerBox.getY() + 20, SpotifyIcon.getIconWidth(), SpotifyIcon.getIconHeight());
        layeredPane.add(logo, JLayeredPane.POPUP_LAYER);
        
      //welcome title 
        JLabel welcomeTitle = new JLabel("Enter Login Details");
        Font titleFont = new Font("Helvectica BOLD",Font.BOLD, 30);
        welcomeTitle.setFont(titleFont);

        // Add labels and text fields for username and password
        JLabel usernameLabel = new JLabel("Username:");
        userNameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
		passwordField = new JPasswordField();
		
		 // Add labels and text fields for username and password
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();
        
        // Add labels and text fields for username and password
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        

        
      //button to go to the next frame which is the login details 
       JButton accountButton = new JButton("Create Account");
        

        // Set foreground color to white for labels and text fields
        welcomeTitle.setForeground(Color.GREEN);
        usernameLabel.setForeground(Color.WHITE);
        userNameField.setForeground(Color.BLACK);
        passwordLabel.setForeground(Color.WHITE);
        passwordField.setForeground(Color.BLACK);
        firstNameLabel.setForeground(Color.WHITE);
        firstNameField.setForeground(Color.BLACK);
        lastNameLabel.setForeground(Color.WHITE);
        lastNameField.setForeground(Color.BLACK);
        emailLabel.setForeground(Color.WHITE);
        emailField.setForeground(Color.BLACK);
        
        
        
        accountButton.setForeground(Color.BLACK); // Set the text color to green
        accountButton.setBackground(Color.GREEN);
        accountButton.setBorderPainted(false); // Remove the border
        accountButton.setFocusPainted(false); // Remove the focus border
        

        // Set bounds for labels and text fields relative to the rounded rectangle
        int labelWidth = 70;
        int labelHeight = 20;
        int textFieldWidth = 120;
        int textFieldHeight = 20;
        
        welcomeTitle.setBounds(centerBox.getX() + 100, centerBox.getY() + 20, 300, 50);

        usernameLabel.setBounds(centerBox.getX() + 120, centerBox.getY() + 205, labelWidth, labelHeight);
        userNameField.setBounds(centerBox.getX() + 200, centerBox.getY() + 205, textFieldWidth, textFieldHeight);

        passwordLabel.setBounds(centerBox.getX() + 120, centerBox.getY() + 240, labelWidth, labelHeight);
        passwordField.setBounds(centerBox.getX() + 200, centerBox.getY() + 240, textFieldWidth, textFieldHeight);
        
        firstNameLabel.setBounds(centerBox.getX() + 120, centerBox.getY() + 100, labelWidth, labelHeight);
        firstNameField.setBounds(centerBox.getX() + 200, centerBox.getY() + 100, textFieldWidth, textFieldHeight);
        
        lastNameLabel.setBounds(centerBox.getX() + 120, centerBox.getY() + 135, labelWidth, labelHeight);
        lastNameField.setBounds(centerBox.getX() + 200, centerBox.getY() + 135, textFieldWidth, textFieldHeight);
        
        emailLabel.setBounds(centerBox.getX() + 148, centerBox.getY() + 170, labelWidth, labelHeight);
        emailField.setBounds(centerBox.getX() + 200, centerBox.getY() + 170, textFieldWidth, textFieldHeight);
        

        
        accountButton.setBounds(centerBox.getX() + 150, centerBox.getY() + 330, 150, 20);

        // Add labels and text fields to the layered pane
        layeredPane.add(welcomeTitle, JLayeredPane.POPUP_LAYER);
        layeredPane.add(usernameLabel, JLayeredPane.POPUP_LAYER);
        layeredPane.add(userNameField, JLayeredPane.POPUP_LAYER);
        layeredPane.add(passwordLabel, JLayeredPane.POPUP_LAYER);
        layeredPane.add(passwordField, JLayeredPane.POPUP_LAYER);
        layeredPane.add(firstNameLabel, JLayeredPane.POPUP_LAYER);
        layeredPane.add(firstNameField, JLayeredPane.POPUP_LAYER);
        layeredPane.add(lastNameLabel, JLayeredPane.POPUP_LAYER);
        layeredPane.add(lastNameField, JLayeredPane.POPUP_LAYER);
        layeredPane.add(emailLabel, JLayeredPane.POPUP_LAYER);
        layeredPane.add(emailField, JLayeredPane.POPUP_LAYER);

        layeredPane.add(accountButton, JLayeredPane.POPUP_LAYER);

        

        // Add Login button with an image
        ImageIcon settingsIcon = new ImageIcon("dotsWhite.png"); // Replace with the actual path to your image
        JButton settingsButton = new JButton(settingsIcon);
        settingsButton.setBounds(635, 10, settingsIcon.getIconWidth(), settingsIcon.getIconHeight());
        settingsButton.setContentAreaFilled(false); // Remove the background
        settingsButton.setBorderPainted(false); // Remove the border
        settingsButton.setFocusPainted(false); // Remove the focus border
        layeredPane.add(settingsButton, JLayeredPane.POPUP_LAYER);

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPopupMenu popupMenu = new JPopupMenu();

                // Create menu items
                JMenuItem helpItem = new JMenuItem("Help");
                JMenuItem themeItem = new JMenuItem("Theme");
                JMenuItem closeItem = new JMenuItem("Close");

                // Add action listeners
                helpItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "Help clicked!");
                    }
                });

                themeItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "Theme clicked!");
                    }
                });

                closeItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "Close clicked!");
                    }
                });

                // Add items to the popup menu
                popupMenu.add(helpItem);
                popupMenu.add(themeItem);
                popupMenu.add(closeItem);

                // Show the popup menu
                popupMenu.show(settingsButton, 0, settingsButton.getHeight());
            }
        });
        
        
        // Set spotBack image as the background using a JLabel
        ImageIcon backgroundImage = new ImageIcon("spotBack.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        frame.add(layeredPane);
        frame.setVisible(true);
        frame.setResizable(false);
        
        
 
    
    
    
   

    accountButton.addActionListener(new ActionListener() {  //when next is clicked        
        public void actionPerformed(ActionEvent e) {
        	
        	//Checks all textfields to see if they contain information or not. if there is information entered within the textfield, it will dispose current frame, and
        	//pass informatin to the next frame.
        	if (!(firstNameField.getText().isEmpty()) && !(lastNameField.getText().isEmpty()) && !(userNameField.getText().isEmpty()) && !(passwordField.getText().isEmpty()) 
        			&& !(emailField.getText().isEmpty())) { 

				//if the user enters a username that already exist then it displays the according message.
				if (MusicUniversalMethods.check(userNameField.getText(),0,"LoginList.txt") != -1) { 
					JOptionPane.showMessageDialog(frame,"An account with this username already exists!");
				}

				//If username doesnt exist, than it will dispose current frame and call in the next frame for 
				//registering process.
				else { 
					Profile p = new Profile(userNameField.getText() + "/" + passwordField.getText() + "/" +emailField.getText() + "/" +firstNameField.getText() + "/" +lastNameField.getText());
					Regular r = new Regular(p,0);
					Premium pr = null;
					new Main_Menu(pr,r,p);
					// Pass data to the Balance class
					frame.dispose();  // Close the current frame

				}
        	}
        	
        	//If any textfields do not contain any information, it will prompt an error message
        	else { 
        		JOptionPane.showMessageDialog(frame, "Please fill in all textboxs!",
        		"ERROR!",JOptionPane.ERROR_MESSAGE);
        	}
        }
    });
    }
	
    // Custom JComponent for rounded rectangle
    static class RoundedRectangle extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int cornerRadius = 20; // Adjust the corner radius
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(getBackground());
            g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
            g2d.dispose();
        }
    }
  
	
    public static void main(String[] args) {
            // Create an instance of RegularSignUp for testing
            RegularSignUp signUp = new RegularSignUp();
            
            // Add some text to the text fields for testing (optional)
            signUp.firstNameField.setText("John");
            signUp.lastNameField.setText("Doe");
            signUp.userNameField.setText("john.doe");
            signUp.passwordField.setText("password123");
            signUp.emailField.setText("john.doe@example.com");
            
            // Display the GUI for testing
            signUp.frame.setVisible(true);
    }
}
