import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;



/*
 * @author Rudra Patel & Thanush
 * Date: Jan. 2024
 * Description: A frame that opens up when user hits company promise button
 * 
 * /**
 * Method List:
 *
 * 1. Company_Promise() - Constructor for the Company_Promise class.
 *    - Initializes and sets up the frame displaying company policies and terms.
 *
 * 2. actionPerformed(ActionEvent e) - Action performed when a button is clicked.
 *    - Handles the action events, such as closing the frame when the "Close" button is clicked.
 *
 * 3. RoundedRectangle class - Custom JComponent for a rounded rectangle.
 *    - Nested static class representing a rounded rectangle for graphical rendering.
 *
 * 4. main(String[] args) - Main method to create an instance of the Company_Promise class.
 *    - Entry point for running the Company_Promise application.
 */


public class Company_Promise extends JFrame implements ActionListener {

	// Private variables
	private JButton close;
	private JFrame frame;

	/**
	 * Constructor for the Company_Promise class.
	 */
	public Company_Promise() {
		// Create a new JFrame
		frame = new JFrame("Policy & Terms");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(695, 500);
		frame.setLocation(100, 100);

		// Create a layered pane for managing components
		JLayeredPane layeredPane = new JLayeredPane();

		// Add a rounded rectangle in the center
		RoundedRectangle centerBox = new RoundedRectangle();
		centerBox.setBackground(Color.BLACK);
		int boxWidth = 450; // Increase the width of the black box
		int boxHeight = 370; // Adjust the height of the black box
		int yOffset = 15; // Adjust the y-coordinate to move the box down
		centerBox.setBounds((frame.getWidth() - boxWidth) / 2, (frame.getHeight() - boxHeight) / 4 + yOffset, boxWidth, boxHeight);
		layeredPane.add(centerBox, JLayeredPane.DEFAULT_LAYER);

		// Add Spotify logo
		ImageIcon SpotifyIcon = new ImageIcon("LogoS.png"); // Replace with the actual path to your image
		JLabel logo = new JLabel(SpotifyIcon);
		logo.setBounds(20, 15, SpotifyIcon.getIconWidth(), SpotifyIcon.getIconHeight());
		layeredPane.add(logo, JLayeredPane.POPUP_LAYER);

		// Add a title for Policy & Terms
		JLabel accountType1 = new JLabel("Policy & Terms");
		accountType1.setBounds(centerBox.getX() + 30, centerBox.getY() + 10, 300, 50);
		Font titleFont = new Font("Helvectica BOLD", Font.BOLD, 30);
		accountType1.setFont(titleFont);
		accountType1.setForeground(Color.WHITE);
		layeredPane.add(accountType1, JLayeredPane.POPUP_LAYER);

		// Add a line separator
		JLabel line = new JLabel("________________________");
		line.setBounds(centerBox.getX() + 15, centerBox.getY() + 20, 500, 50);
		line.setFont(titleFont);
		line.setForeground(Color.WHITE);
		layeredPane.add(line, JLayeredPane.POPUP_LAYER);

		// Add text content
		JLabel text = new JLabel("<html>Music App Quality Assurance Policy:<br/> At Spotify, we are committed to delivering an unparalleled music experience. "
				+ "We promise to provide our users with the highest quality songs, ensuring optimal audio fidelity. "
				+ "Our dedicated team regularly curates and updates our vast music library to guarantee a diverse "
				+ "and exceptional selection.<br/><br/> Terms of Service:<br/>Spotify reserves the right to continually enhance and update the music "
				+ "library to maintain the highest standards.");
		text.setBounds(centerBox.getX() + 30, centerBox.getY() + 10, 400, 330);
		Font font = new Font("monospaced", Font.BOLD, 12);
		text.setFont(font);
		text.setForeground(Color.WHITE);
		layeredPane.add(text, JLayeredPane.POPUP_LAYER);

		// Add another line separator
		line = new JLabel("________________________");
		line.setBounds(centerBox.getX() + 15, centerBox.getY() + 260, 500, 50);
		line.setFont(titleFont);
		line.setForeground(Color.WHITE);
		layeredPane.add(line, JLayeredPane.POPUP_LAYER);

		// Add a Close button
		close = new JButton("Close");
		close.setBounds(centerBox.getX() + 150, centerBox.getY() + 330, 150, 20);
		Font titleFont2 = new Font("Helvectica", Font.BOLD, 15);
		close.setFont(titleFont2);
		close.setForeground(Color.BLACK); // Set the text color to green
		close.setBackground(Color.GREEN);
		close.setBorderPainted(false); // Remove the border
		close.setFocusPainted(false); // Remove the focus border
		layeredPane.add(close, JLayeredPane.POPUP_LAYER);

		// Add action listener for the Close button
		close.addActionListener(this);

		// Set spotBack image as the background using a JLabel
		ImageIcon backgroundImage = new ImageIcon("spotBack.png");
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

		// Add the layered pane to the frame
		frame.add(layeredPane);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	/**
	 * Action performed when a button is clicked.
	 *
	 * @param e ActionEvent object
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == close) {
			frame.dispose();
		}
	}

	/**
	 * Custom JComponent for rounded rectangle.
	 */
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

	/**
	 * Main method to create an instance of the Company_Promise class.
	 *
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		new Company_Promise();
	}
}