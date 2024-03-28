/**
 * 
 */

/**
 * @author 723101
 *
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;


/*
 * Authour; Hamza Khan & Rudra Patel & Thanush
 * Date; Jan 2024
 * Description: Frame that pops up gving two options of either premium or regular sign up;
 * 
 * /**
 * SignUp Class
 *
 * Constructors:
 * 1. Default Constructor: SignUp()
 *    - Initializes the SignUp frame for user account selection.
 *    - Sets up the GUI components and adds action listeners.
 *
 * Methods:
 * 2. void actionPerformed(ActionEvent e)
 *    - Action listener for the "Start for Free" and "Buy Now" buttons.
 *    - Disposes the current frame and opens either the RegularSignUp or PremiumSignUp frame accordingly.
 *
 * 3. static class RoundedRectangle extends JComponent
 *    - Custom JComponent for drawing a rounded rectangle.
 *    - Overrides the paintComponent method to draw a rounded rectangle as the background.
 *
 * 4. void main(String[] args)
 *    - Main method to create an instance of SignUp and display the GUI.
 */


public class SignUp extends JFrame implements ActionListener {
  
	
	//private variables 
	private JButton pType, rType;
    private JFrame frame;
   
    
    public SignUp() {
    	frame = new JFrame("Account Selection");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLocation(100, 100);

        JLayeredPane layeredPane = new JLayeredPane();

        // Add a rounded rectangle in the center
        RoundedRectangle centerBox = new RoundedRectangle();
        centerBox.setBackground(Color.BLACK);
        int boxWidth = 300; // Increase the width of the black box
        int boxHeight = 370; // Adjust the height of the black box
        int yOffset = 15; // Adjust the y-coordinate to move the box down
        centerBox.setBounds((frame.getWidth() - boxWidth) - 120, (frame.getHeight() - boxHeight) / 4 + yOffset, boxWidth, boxHeight);
        layeredPane.add(centerBox, JLayeredPane.DEFAULT_LAYER);
        
        // Add a rounded rectangle in the center
        centerBox = new RoundedRectangle();
        centerBox.setBackground(Color.BLACK);
        centerBox.setBounds((frame.getWidth() - boxWidth) / 7, (frame.getHeight() - boxHeight) / 4 + yOffset, boxWidth, boxHeight);
        layeredPane.add(centerBox, JLayeredPane.DEFAULT_LAYER);
        
        // Add spotify logo
        ImageIcon SpotifyIcon = new ImageIcon("LogoS.png"); // Replace with the actual path to your image
        JLabel logo = new JLabel(SpotifyIcon);
        logo.setBounds(820, 400, SpotifyIcon.getIconWidth(), SpotifyIcon.getIconHeight());
        layeredPane.add(logo, JLayeredPane.POPUP_LAYER);

        JLabel accountType1 = new JLabel("Regular");
        accountType1.setBounds(centerBox.getX() + 30, centerBox.getY() + 10, 300, 50);
        Font titleFont = new Font("Helvectica BOLD",Font.BOLD, 30);
        accountType1.setFont(titleFont);
        accountType1.setForeground(Color.WHITE);
        layeredPane.add(accountType1, JLayeredPane.POPUP_LAYER);
        
        JLabel line = new JLabel("________________");
        line.setBounds(centerBox.getX() + 15, centerBox.getY() + 20, 300, 50);
        line.setFont(titleFont);
        line.setForeground(Color.WHITE);
        layeredPane.add(line, JLayeredPane.POPUP_LAYER);
        
        JLabel text = new JLabel("<html> · Free for Lifetime<br/><br/>· 6 skips for hour<br/><br/>· Limited Playlist<br/><br/>· Limited Songs<br/>");
        text.setBounds(centerBox.getX() + 30, centerBox.getY() + 20, 300, 300);
        Font font = new Font("Helvectica BOLD",Font.BOLD, 15);
        text.setFont(font);
        text.setForeground(Color.WHITE);
        layeredPane.add(text, JLayeredPane.POPUP_LAYER);
        
        line = new JLabel("________________");
        line.setBounds(centerBox.getX() + 15, centerBox.getY() + 260, 300, 50);
        line.setFont(titleFont);
        line.setForeground(Color.WHITE);
        layeredPane.add(line, JLayeredPane.POPUP_LAYER);
        
        
        accountType1 = new JLabel("Premium");
        accountType1.setBounds(centerBox.getX() + 430, centerBox.getY() + 10, 300, 50);
        accountType1.setFont(titleFont);
        accountType1.setForeground(Color.WHITE);
        layeredPane.add(accountType1, JLayeredPane.POPUP_LAYER);
        
        line = new JLabel("________________");
        line.setBounds(centerBox.getX() + 410, centerBox.getY() + 20, 300, 50);
        line.setFont(titleFont);
        line.setForeground(Color.WHITE);
        layeredPane.add(line, JLayeredPane.POPUP_LAYER);
        
        text = new JLabel("<html> · Monthly Payments<br/><br/>· Unlimited Skips<br/><br/>· Unlimited Playlist<br/><br/>· Unlimited Songs<br/>");
        text.setBounds(centerBox.getX() + 430, centerBox.getY() + 20, 300, 300);
        text.setFont(font);
        text.setForeground(Color.WHITE);
        layeredPane.add(text, JLayeredPane.POPUP_LAYER);
        
        line = new JLabel("________________");
        line.setBounds(centerBox.getX() + 410, centerBox.getY() + 260, 300, 50);
        line.setFont(titleFont);
        line.setForeground(Color.WHITE);
        layeredPane.add(line, JLayeredPane.POPUP_LAYER);


        // Add Signup button with green text and transparent background
        rType = new JButton("Start for Free");
        rType.setBounds(centerBox.getX() + 45, centerBox.getY() + 320, 200, 30);
        Font titleFont2 = new Font("Helvectica",Font.BOLD, 15);
        rType.setFont(titleFont2);
        rType.setForeground(Color.BLACK); // Set the text color to green
        rType.setBackground(Color.GREEN);
        rType.setBorderPainted(false); // Remove the border
        rType.setFocusPainted(false); // Remove the focus border
        layeredPane.add(rType, JLayeredPane.POPUP_LAYER);
        
        // Add Signup button with green text and transparent background
        pType = new JButton("Buy Now");
        pType.setBounds(centerBox.getX() + 445, centerBox.getY() + 320, 200, 30);
        pType.setFont(titleFont2);
        pType.setForeground(Color.BLACK); // Set the text color to green
        pType.setBackground(Color.GREEN);
        pType.setBorderPainted(false); // Remove the border
        pType.setFocusPainted(false); // Remove the focus border
        layeredPane.add(pType, JLayeredPane.POPUP_LAYER);

        
        //all action listners
      	pType.addActionListener(this);
      	rType.addActionListener(this);

      
        
        // Set spotBack image as the background using a JLabel
        ImageIcon backgroundImage = new ImageIcon("background.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        frame.add(layeredPane);
        frame.setVisible(true);
        frame.setResizable(false);
    }

            public void actionPerformed(ActionEvent e) {
            	if (e.getSource()== pType){
            		frame.dispose();
        			new PremiumSignUp(); //if about us clicked open about us frame
        			
        		}
            	if (e.getSource()== rType){
            		frame.dispose();
        			new RegularSignUp(); //if about us clicked open about us frame
        			
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
    //register info
    public static void main(String[] args) {
        new SignUp();
    }
}
