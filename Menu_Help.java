import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;


/**
 * 
 */

/**
 * @author Hamza Khan & Thanush
 * Date: Jan.2024
 * Description: Frame that opens up to give insight. 
 * /**
 * Method List:
 * 1. Constructor: public Menu_Help()
 *    - Initializes and sets up the Help and Support frame.
 *
 * 2. ActionListener: public void actionPerformed(ActionEvent e)
 *    - Handles button clicks, specifically the "Close" button.
 *
 * 3. Static Class: static class RoundedRectangle extends JComponent
 *    - Custom JComponent for drawing a rounded rectangle.
 *
 * 4. Main Method: public static void main(String[] args)
 *    - Entry point for the application, creates an instance of Menu_Help.
 */

public class Menu_Help extends JFrame implements ActionListener {

    // Private variables
    private JButton close;
    private JFrame frame;

    /**
     * Constructor to create the Menu_Help frame.
     */
    public Menu_Help() {
        // Initialize the frame
        frame = new JFrame("Help and Support");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(695, 500);
        frame.setLocation(100, 100);

        // Create a layered pane for better component layering
        JLayeredPane layeredPane = new JLayeredPane();

        // Add a rounded rectangle in the center as the background
        RoundedRectangle centerBox = new RoundedRectangle();
        centerBox.setBackground(Color.BLACK);
        int boxWidth = 450;
        int boxHeight = 370;
        int yOffset = 15;
        centerBox.setBounds((frame.getWidth() - boxWidth) / 2, (frame.getHeight() - boxHeight) / 4 + yOffset, boxWidth, boxHeight);
        layeredPane.add(centerBox, JLayeredPane.DEFAULT_LAYER);

        // Add Spotify logo
        ImageIcon SpotifyIcon = new ImageIcon("LogoS.png");
        JLabel logo = new JLabel(SpotifyIcon);
        logo.setBounds(20, 15, SpotifyIcon.getIconWidth(), SpotifyIcon.getIconHeight());
        layeredPane.add(logo, JLayeredPane.POPUP_LAYER);

        // Add "Menu Help" title
        JLabel accountType1 = new JLabel("Menu Help");
        accountType1.setBounds(centerBox.getX() + 30, centerBox.getY() + 10, 300, 50);
        Font titleFont = new Font("Helvectica BOLD", Font.BOLD, 30);
        accountType1.setFont(titleFont);
        accountType1.setForeground(Color.WHITE);
        layeredPane.add(accountType1, JLayeredPane.POPUP_LAYER);

        // Add a decorative line under the title
        JLabel line = new JLabel("________________________");
        line.setBounds(centerBox.getX() + 15, centerBox.getY() + 20, 500, 50);
        line.setFont(titleFont);
        line.setForeground(Color.WHITE);
        layeredPane.add(line, JLayeredPane.POPUP_LAYER);

        // Add textual information about app usage and functions
        JLabel text = new JLabel("<html>App Use and Functions:<br/> Home - Where You Can Find The Top Hits of 2023. <br/> "
                + "Search - Where You Can Search For A Specific Song From Our Wide Range Of Songs.<br/>  "
                + "Your Library - Where You Can Create Your Own Preferred Playlist and Sort Them to Your Liking<br/> "
                + "Control Panel - Allows User to Play, Pause, Restart, Adjust Volume and View Song Progress<br/> "
                + "3 Point Drop Down - To View Our Company Promise and Menu Help Page<br/> "
                + "Profile Button - Where You can Change App Appearance and Log Out<br/> "
        );
        text.setBounds(centerBox.getX() + 30, centerBox.getY() + 10, 400, 330);
        Font font = new Font("monospaced", Font.BOLD, 12);
        text.setFont(font);
        text.setForeground(Color.WHITE);
        layeredPane.add(text, JLayeredPane.POPUP_LAYER);

        // Add another decorative line
        line = new JLabel("________________________");
        line.setBounds(centerBox.getX() + 15, centerBox.getY() + 260, 500, 50);
        line.setFont(titleFont);
        line.setForeground(Color.WHITE);
        layeredPane.add(line, JLayeredPane.POPUP_LAYER);

        // Add "Close" button
        close = new JButton("Close");
        close.setBounds(centerBox.getX() + 150, centerBox.getY() + 330, 150, 20);
        Font titleFont2 = new Font("Helvectica", Font.BOLD, 15);
        close.setFont(titleFont2);
        close.setForeground(Color.BLACK);
        close.setBackground(Color.GREEN);
        close.setBorderPainted(false);
        close.setFocusPainted(false);
        layeredPane.add(close, JLayeredPane.POPUP_LAYER);

        // Add action listener for the close button
        close.addActionListener(this);

        // Set background image
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
     * ActionListener implementation for handling button clicks.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == close) {
            // Close the frame when the close button is clicked
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
            int cornerRadius = 20;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(getBackground());
            g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
            g2d.dispose();
        }
    }

    /**
     * Main method to create an instance of Menu_Help.
     */
    public static void main(String[] args) {
        new Menu_Help();
    }
}