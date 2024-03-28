import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;




/*
 * @author Rudra Patel & Thanush Supramaniam
 * Date: Jan. 2024
 * Description: First frame that opens up to prompt user to log in with their account information
 * 
 * /**
 * Method List:
 *
 * 1. LogIn() - Constructor that creates a JFrame for the login interface.
 *    - Initializes and sets up the login frame, including buttons, text fields, and listeners.
 *
 * 2. actionPerformed(ActionEvent e) - Action performed when a button is clicked.
 *    - Handles the action events for login and signup buttons.
 *
 * 3. main(String[] args) - Main method to create an instance of the LogIn class.
 *    - Entry point for running the LogIn application.
 */


public class LogIn implements ActionListener {

    private JFrame frame;
    private JButton loginButton, signUpButton;
    private JTextField usernameField;
    private JPasswordField passwordText;
    private Profile profile;

    public LogIn() {
        frame = new JFrame("Sign In");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(695, 500);
        frame.setLocation(100, 100);
        profile = new Profile();

        JLayeredPane layeredPane = new JLayeredPane();

        // Add a rounded rectangle in the center
        RoundedRectangle centerBox = new RoundedRectangle();
        centerBox.setBackground(Color.BLACK);
        int boxWidth = 450; // Increase the width of the black box
        int boxHeight = 370; // Adjust the height of the black box
        int yOffset = 15; // Adjust the y-coordinate to move the box down
        centerBox.setBounds((frame.getWidth() - boxWidth) / 2, (frame.getHeight() - boxHeight) / 4 + yOffset, boxWidth, boxHeight);
        
        // Add spotify logo
        ImageIcon SpotifyIcon = new ImageIcon("LogoS.png"); // Replace with the actual path to your image
        JLabel logo = new JLabel(SpotifyIcon);
        logo.setBounds(centerBox.getX() + 210, centerBox.getY() + 20, SpotifyIcon.getIconWidth(), SpotifyIcon.getIconHeight());
        layeredPane.add(logo, JLayeredPane.POPUP_LAYER);
        layeredPane.add(centerBox, JLayeredPane.DEFAULT_LAYER);
        
        //welcome title 
        JLabel welcomeTitle = new JLabel("Log in to Spotify");
        Font titleFont = new Font("Helvectica BOLD",Font.BOLD, 35);
        welcomeTitle.setFont(titleFont);

        // Add labels and text fields for username and password
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
		passwordText = new JPasswordField("");
        
   

        // Set foreground color to white for labels and text fields
	
        welcomeTitle.setForeground(Color.WHITE);
        usernameLabel.setForeground(Color.WHITE);
        usernameField.setForeground(Color.BLACK);
        passwordLabel.setForeground(Color.WHITE);
        passwordText.setForeground(Color.BLACK);
        

        // Set bounds for labels and text fields relative to the rounded rectangle
        int labelWidth = 70;
        int labelHeight = 20;
        int textFieldWidth = 120;
        int textFieldHeight = 20;

        welcomeTitle.setBounds(centerBox.getX() + 100, centerBox.getY() + 80, 300, 50);
        
        usernameLabel.setBounds(centerBox.getX() + 170, centerBox.getY() + 140, labelWidth, labelHeight);
        usernameField.setBounds(centerBox.getX() + 170, centerBox.getY() + 160, textFieldWidth, textFieldHeight);

        passwordLabel.setBounds(centerBox.getX() + 170, centerBox.getY() + 180, labelWidth, labelHeight);
        passwordText.setBounds(centerBox.getX() + 170, centerBox.getY() + 200, textFieldWidth, textFieldHeight);

        // Add labels and text fields to the layered pane
        layeredPane.add(welcomeTitle, JLayeredPane.POPUP_LAYER);
        layeredPane.add(usernameLabel, JLayeredPane.POPUP_LAYER);
        layeredPane.add(usernameField, JLayeredPane.POPUP_LAYER);
        layeredPane.add(passwordLabel, JLayeredPane.POPUP_LAYER);
        layeredPane.add(passwordText, JLayeredPane.POPUP_LAYER);
        

        // Add Show Password checkbox with smaller size and font
        JCheckBox showPassword = new JCheckBox("Show Password");
        showPassword.setBackground(Color.BLACK);
        showPassword.setForeground(Color.WHITE);
        showPassword.setFont(new Font("Arial", Font.PLAIN, 10));
        showPassword.setBounds(centerBox.getX() + 180, centerBox.getY() + 225, 120, 20);
        layeredPane.add(showPassword, JLayeredPane.POPUP_LAYER);
        
    
        //ACTION LISTENER FOR THE CHECK BOX TO SHOW PASSWORD
        showPassword.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
      				if (showPassword.isSelected()) { //if the check box is clicked
      					
      					passwordText.setEchoChar((char) 0); // Show the password
      				} else {
      					passwordText.setEchoChar('*'); // Hide the password
      				}
      			}
      		});

       
        // Add Login button with an image
        ImageIcon loginIcon = new ImageIcon("LOGBUTTON (1).png"); // Replace with the actual path to your image
        loginButton = new JButton(loginIcon);
        loginButton.setBounds(centerBox.getX() + 155, centerBox.getY() + 265, loginIcon.getIconWidth(), loginIcon.getIconHeight());
        loginButton.setContentAreaFilled(false); // Remove the background
        loginButton.setBorderPainted(false); // Remove the border
        loginButton.setFocusPainted(false); // Remove the focus border
        loginButton.addActionListener(this);
        layeredPane.add(loginButton, JLayeredPane.POPUP_LAYER);

        // Add "New to App -->" label with smaller font size
        JLabel signUpLabel = new JLabel("New to App --->");
        signUpLabel.setForeground(Color.WHITE);
        signUpLabel.setFont(new Font("Arial", Font.PLAIN + Font.ITALIC, 12)); // Set a smaller font size
        signUpLabel.setBounds(centerBox.getX() + 150, centerBox.getY() + 335, 100, 20);
        layeredPane.add(signUpLabel, JLayeredPane.POPUP_LAYER);

        // Add Signup button with green text and transparent background
        signUpButton = new JButton("Signup");
        signUpButton.setBounds(centerBox.getX() + 220, centerBox.getY() + 333, 80, 20);
        signUpButton.setForeground(Color.GREEN); // Set the text color to green
        signUpButton.setContentAreaFilled(false); // Remove the background
        signUpButton.setBorderPainted(false); // Remove the border
        loginButton.setFocusPainted(false); // Remove the focus border
        signUpButton.addActionListener(this);
        layeredPane.add(signUpButton, JLayeredPane.POPUP_LAYER);

        
        
        
        // Set spotBack image as the background using a JLabel
        ImageIcon backgroundImage = new ImageIcon("spotBack.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        frame.add(layeredPane);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== loginButton){
			
			String username = usernameField.getText(); //get the user name 
			String password = new String(passwordText.getPassword()); //get the password 
			
			//If entered username or password is not empty, it will do the code below.
			if (!(username.isEmpty()) && !(password.isEmpty())) { 
				
				//Finds location of user information within "information" files 
				//using checkLogin method.
				int location = MusicUniversalMethods.checkLogin(username, password,"LoginList.txt");
				//System.out.println("Location within Sign in Frame: " + location);
				//If value returned isnt -1, meaning user info was found, it will
				//open account data using openAccount method, dispose current frame,
				//than open homepage frame with user info
				if (location > -1) { 
					
					MusicUniversalMethods.openAccount(location,profile,"LoginList.txt" );
					new Main_Menu(new Premium(profile,6.99),new Regular(profile,0),profile);
					frame.dispose();
				}
				//If value returned is -1, meaning user info was not found, it will
				//display appropriate message
				else { 
					JOptionPane.showMessageDialog(frame, "Username OR Password is Incorrect!\nSign up if don't have an account!","ERROR!",JOptionPane.ERROR_MESSAGE);
				}
			}
			//if one or both textboxs are empty, it will prompt an error message
			else { 
           		JOptionPane.showMessageDialog(frame, "Please fill in all textboxs!",
                		"ERROR!",JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource()== signUpButton){
			frame.dispose();
			new SignUp();
		}

		
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
        new LogIn();
    }

    
    
  

	
}

