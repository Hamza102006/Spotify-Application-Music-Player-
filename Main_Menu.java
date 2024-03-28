
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.TableRowSorter;
/*
 * Authour; Hamza Khan and Thanush
 * Date; Jan 20
 * Description; The GUI I made was an application which tried to closley resemble Spotify, featuring an intuitive GUI for playing, skipping, 
 * pausing, restarting, adjusting volume, and tracking song progress. The interface grants users access to an extensive collection of tracks 
 * from the top 6 artists of 2023. Beyond essential functionalities, the app provides numerous user-friendly features designed to enhance the 
 * overall music listening experience, making it a comprehensive and enjoyable platform for music enthusiasts.
 * THIS CLASS HAS BEEN CORRUPTED THROUGH ONE DRIVE SYNC/THUS CODE SOME HAS BEEN LSOT AND SOME FUNCTIONALITIES OF PROGRAM HAVE BEEN LOST
 * 
 *  <METHODS>
 *  
 * public static void main(String[] args) {
 * 
 * public Main_Menu() { - main menu constructor 
 * 
 * private static void createPlaybackControls(JFrame mainFrame) { - control panel
 * 
 * private static void play() { - play
 * 
 * private static void pause() { - pause 
 * 
 * private static void restartTrack() { - replay track 
 * 
 * private static void setVolume(int value) { - setting and changing volume 
 * 
 * private static void updateProgressBar() { - updating the prorgess bar constantly 
 * 
 * private static void startProgressUpdateTimer() { - start timer for updating 
 * 
 * private static void stopProgressUpdateTimer() { - stop timer for updating 
 * 
 * private static void resetTimer() { - reset the timer 
 * 
 * private static void skipTrack() { - skip songs
 * 
 * private static void playSelectedSong(JTable table) { - play song within JTable
 * 
 * private static JTable getCurrentTableForPanel(String panelName) { - get the current panel you are on 
 * 
 * private static JPanel createPanel1(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) { - Home/Search Button
 * 
 * private static void createPanel2(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) { - Library, etc
 * 
 * private static void createPanel3(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) { - Home + Panels
 * 
 * private static void updateCurrentPanelLabel(String panelName) { - update what panel we are on 
 * 
 * private static void handleTableSelection(JTable table) { - handle what table row or selection is chosen 
 * 
 * private static void playWavFile(String fileName) { - play wav file
 * 
 * private static String getFilePathForDrakeSong(String songName) { 
 * 
 * private static String getFilePathForSong(String songName) {
 * 
 * private static void customizeTable(JTable table, Color backgroundColor) {
 *  
 * private static void createPlaylistPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) { - panel for artist 
 *  
 * private static void createDrakeHitsPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) { - panel for artist  
 *  
 * private static void createWeekendHitsPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) {- panel for artist 
 *  
 * private static void createScottHitsPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) { - panel for artist 
 *  
 * private static void createSwiftHitsPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) {- panel for artist 
 *  
 * private static void createBeyonceHitsPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) { - panel for artist 
 *  
 * private static void createGrandeHitsPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) { - panel for artist 
 *  
 * static class RoundedRectanglePanel extends JPanel { - method to create the rounded rectangle panel 
 *  
 *  
 *  
 *  <NEW THINGS LEARNED>
 * 
 * 	[CardLayout]
 * 
 * WHY USED?
 * 
 * The CardLayout in Java is beneficial for managing multiple panels within a single container or panel, facilitating easy 
 * switching between views, making it particularly useful for applications with distinct UI states or multiple screens.
 * This is something that I really wanted to add to this GUI as it would not only make it much more user friendly but also 
 * result in a much more concise code. I felt the need of this as in our last GUI for the summative 2 we were forced to make a 
 * lot of frames and to overcome this challenge I made sure to use this CardLayout Feature to not only enhance user experience but also
 * to reduce not needed amounts of code. In terms of how I used it I used it to organize components in a stack-like manner, 
 * allowing easy switching between panels, and only showing one panel at a time within a container.
 * 
 * LINK;
 * https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/layout/card.html
 * https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/awt/CardLayout.html
 * https://stackoverflow.com/questions/43257069/jpanel-on-cardlayout-swing-java
 * 
 * 
 * 
 * [JSlider volumeSlider]
 * 
 * WHY USED?
 * 
 * In my control panel, I incorporated a JSlider component to manage the volume control for the audio files. The JSlider is a graphical
 * component that enables users to interactively adjust a numeric value within a specified range, in this case, representing the volume 
 * level. By associating the JSlider with this action users can smoothly control the volume output of the audio clips by sliding the 
 * JSlider thumb along its track. This user-friendly interface provides an intuitive way to fine-tune the audio experience in my application.
 * 
 * 
 * LINKS;
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JSlider.html
 * https://www.javatpoint.com/java-jslider
 * https://www.youtube.com/watch?v=LvLFekjVJA8
 * 
 * 
 * [JTable]
 * 
 * WHY USED?
 * 
 * I implemented Java's JTable in my Spotify application to create interactive playlists and display detailed song information. 
 * The tables were crucial for organizing and presenting data, enabling users to select songs, facilitating seamless navigation, 
 * and enhancing the overall user experience by providing a structured view of their music libraries. Overall the use of JTable was really
 * useful as JTables in Java work by providing a structured grid-based display for tabular data. They utilize models to manage data, 
 * renderers to customize cell appearances, and listeners to handle user interactions, offering a flexible and interactive way to present 
 * and manipulate data in my graphical user interface.
 * 
 * LINKS:
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/JTable.html
 * https://www.javatpoint.com/java-jtable
 * https://stackoverflow.com/questions/72897755/how-to-include-a-jtable-and-some-text-below-the-table-in-joptionpane-showmessage
 * https://www.youtube.com/watch?v=S6evF1T_lrU
 * 
 * 
 * [stateChanged(ChangeEvent e)]
 * 
 * WHY USED?
 * 
 * I used stateChanged(ChangeEvent e) to respond to changes in the volume slider in my Spotify application. This method is triggered when 
 * the user adjusts the volume slider, allowing me to capture the new volume level from the slider's state and update the audio playback 
 * accordingly.
 * 
 * LINKS;
 * https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/javax/swing/event/ChangeListener.html
 * 
 * 
 * [UI Manager]
 * 
 * WHY USED?
 * 
 * I utilized UIManager in my Spotify application to customize the appearance of the progress bar. By setting various UIManager properties, 
 * such as background and foreground colors, I could modify the progress bar's visual elements. Different properties like "ProgressBar.background" 
 * and "ProgressBar.foreground" allowed me to change the background and progress colors, providing flexibility in adjusting the progress bar's 
 * overall look. Other properties like "ProgressBar.selectionBackground" and "ProgressBar.selectionForeground" controlled the colors of the 
 * "not yet progressed" part and text, respectively. Additionally, I removed the border using "ProgressBar.border" for a cleaner appearance. 
 * 
 * LINKS;
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/UIManager.html
 * https://stackoverflow.com/questions/56243020/uimanager-how-to-get-values-of-different-lookandfeels
 * https://www.youtube.com/watch?v=el1q0_a6jLI
 * 
 * 
 * 
 * [setMicroseconPostion and setMicrosecondLength]
 * 
 *  WHY USED?
 * 
 * I incorporated the methods setMicrosecondPosition and setMicrosecondLength in my Spotify application to manage the playback position and 
 * total duration of audio clips. These methods, part of the Java Sound API, allow control over the audio playback.setMicrosecondPosition 
 * enables me to set the position within the audio clip in microseconds, facilitating actions like restarting a track to the beginning. 
 * On the other hand, setMicrosecondLength allows setting the total duration of the audio clip. These methods are beneficial for controlling 
 * playback, implementing features like restarting a track, skipping to specific positions, and accurately updating progress bars based on the 
 * audio's duration. Overall, they provide benificial control over audio playback in the application.
 * 
 * LINKS;
 * https://stackoverflow.com/questions/503877/how-can-i-measure-time-with-microsecond-precision-in-java
 * https://www.tabnine.com/code/java/methods/javax.sound.sampled.Clip/setMicrosecondPosition
 * https://www.youtube.com/watch?v=JEI-fcfnFkc
 * 
 * 
 * [FloatControl and MasterGain]
 * 
 * 
 * WHY USED?
 * 
 * I utilized the FloatControl interface and its subtype MasterGain in my Spotify application to manipulate the audio volume dynamically. 
 * The FloatControl.Type.MASTER_GAIN control specifically allows adjustment of the master gain or volume level. By obtaining the FloatControl 
 * for the audio clip, I could set the gain using the formula float gain = (float) (Math.log(value / 100.0) / Math.log(10.0) * 20.0). 
 * This calculation converts the desired volume percentage to a logarithmic scale suitable for audio gain control. 
 * Applying this gain value with setValue(gain) dynamically adjusts the audio volume. This feature provides users with a smooth and 
 * responsive way to control volume levels within the application
 * 
 * LINKS;
 * https://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/FloatControl.html
 * https://stackoverflow.com/questions/30490259/using-float-and-double-for-calculation-giving-different-results
 * https://www.youtube.com/watch?v=sLQOP1DvbXo
 * https://www.youtube.com/watch?v=abjWlB6j6eQ
 * https://stackoverflow.com/questions/14301618/can-java-sound-be-used-to-control-the-system-volume\
 * https://www.youtube.com/watch?v=SyZQVJiARTQ
 * 
 * 
 * [TRIM()]
 * 
 * WHY USED?
 * 
 * I used the trim() method when obtaining the current panel's label text to accurately identify the corresponding JTable in my 
 * Spotify application. This ensured that any leading or trailing whitespaces in the panel label text were removed, contributing to 
 * reliable matching and enhancing the accuracy of the program's logic. As this was an issue that I repeatdly faced, and was not able 
 * to identitfy the correct Panel and JTable to play the correct songs fro the correct artist.
 * 
 * LINKS;
 * https://www.w3schools.com/jsref/jsref_trim_string.asp
 * https://www.javatpoint.com/javascript-string-trim
 * 
 * 
 * 
 * [FocusListener and DocumentListener]
 * 
 * WHY USED?
 * 
 * I incorporated a FocusListener into the JTextField searchBar of my Spotify application to implement a placeholder text feature. 
 * This allowed the placeholder text "Search for All Available Songs Here" to disappear when the JTextField gained focus, enhancing 
 * user interaction. Additionally, I employed a DocumentListener on the search bar for dynamic filtering, enabling real-time updates 
 * to the displayed songs based on user input. The filtering mechanism utilizes RowFilter.regexFilter("(?i)" + text) to match the input 
 * case-insensitively and adapt the displayed results accordingly. This feature enhances the search functionality by providing users with
 * immediate and responsive results as they type.
 * 
 * LINKS;
 * https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/awt/event/FocusListener.html
 * https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/events/focuslistener.html
 * https://stackoverflow.com/questions/5359955/simple-focus-listener-in-java
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/event/DocumentListener.html
 * https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/events/documentlistener.html
 * https://stackoverflow.com/questions/10757555/java-documentlistener
 * 
 * 
 * [DefaultTableModel]
 * 
 * WHY USED?
 * 
 * I employed the DefaultTableModel class to manage the data structure for my JTable in the Spotify application. This specific instance of 
 * DefaultTableModel was customized to ensure that cells within the JTable remained uneditable. By extending the DefaultTableModel class, 
 * I could easily control the behavior of the JTable, such as preventing user modifications, and efficiently handle updates to the table's data. 
 * This approach contributed to a much more and user-friendly interface for browsing and interacting with song playlists.
 * 
 * LINKS;
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/table/DefaultTableModel.html
 * https://stackoverflow.com/questions/13851788/why-cant-i-use-defaulttablemodel-am-i-missing-something-obvious-java
 * https://docs.jboss.org/teiid/6.1/apidocs/com/metamatrix/toolbox/ui/widget/table/DefaultTableModel.html
 * 
 * 
 * [TableRowSorter]
 * 
 * WHY USED?
 * 
 * I incorporated the TableRowSorter class to enable sorting functionality for the JTable in my Spotify application. By creating an instance 
 * of TableRowSorter and associating it with the underlying DefaultTableModel, users could sort the displayed songs based on 
 * different criteria. This feature significantly enhanced the usability of the application, providing an intuitive way for users to 
 * organize and explore their music libraries. This played a crucial role in sorting all songs available in the GUI and Program.
 * 
 * LINKS;
 * https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/javax/swing/table/TableRowSorter.html
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/DefaultRowSorter.html
 * https://stackoverflow.com/questions/28823670/how-to-sort-jtable-in-shortest-way
 * 
 * 
 * [RoundedRectanglePanel, RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON]
 * 
 * WHY USED?
 * 
 * In my Spotify application, I employed the RoundedRectanglePanel class and integrated rendering hints 
 * (RenderingHints.KEY_ANTIALIASING and RenderingHints.VALUE_ANTIALIAS_ON) to enhance the visual appeal of my custom panels. 
 * The RoundedRectanglePanel is a subclass of JPanel that overrides the paintComponent method to draw rounded rectangles. 
 * The use of rendering hints, specifically enabling anti-aliasing, ensures that the edges of these rectangles are rendered smoothly, 
 * minimizing the jagged and sharp appearance.
 * 
 * Furthermore, This approach contributes to a more polished and modern user interface by eliminating harsh edges and providing a softer, 
 * more visually pleasing look to the panels. The rounded corners add a great touch to the overall design. 
 * The customization is particularly noticeable in areas where panels serve as containers for various components, 
 * contributing to an improved user experience and a more aesthetically pleasing interface in the Spotify application
 * 
 * 
 * LINKS;
 * https://stackoverflow.com/questions/15025092/border-with-rounded-corners-transparency
 * https://forums.oracle.com/ords/apexds/post/jpanel-border-with-rounded-corners-0946
 * https://docs.oracle.com/javase/8/docs/api/java/awt/RenderingHints.html
 * https://docs.oracle.com/javase%2Ftutorial%2F/2d/advanced/quality.html
 * https://www.youtube.com/watch?v=4PRqBDDixWE
 * https://www.youtube.com/watch?v=_QOcRu98rKU
 * 
 * 
 * 
 * 
 * NOTE: THERE ARE SOME OTHER MINIOR THINGS THAT HAVE LEARNED IMPLEMNTED WITHIN THE CODE HOWEVER A DETAIL EXPLANTAION WAS NESSACRY AS IT WAS 
 * PRETTY SELF EXPLANATORY BECAUSE THEY WOULD BE THINGS THAT WORK WITH EVERYTHING ABOVE HAND IN HAND. IF THERE ARE AREA THAT DID WERE NOT COVERED
 * THEY ARE LIKELY TO HAVE MORE COMMENTING IN ALL THE CODE BELOW
 * 
 * 
 * 2nd NOTE; IN TERMS THE HIGH NUMBER OF ACTION LISTENERS, WE DID THAT AS A BENIFIT TO US AND ANTOTHER LOOKING AT THE CODE 
 * AS THE DIFFERNT LISTENERS SHOW HOW, WHAT, WHERE COMPONENTS ARE USED FOR. IT WAS BENIFICAL FOR US 
 * 
 */

//Main_Menu class for the main GUI of the music player application
public class Main_Menu {

	// Private instances/variables
	private static JFrame mainFrame;
	private static CardLayout cardLayout;
	private static JPanel cardPanel;
	private static Clip audioClip;
	private static JButton playButton;
	private static JButton pauseButton;
	private static JButton restartButton;
	private static JButton skipButton;
	private static JSlider volumeSlider;
	private static JProgressBar progressBar;
	private static JTable currentTable; // Reference to the currently displayed table
	private static JTable drakeTable, weekendTable, scottTable, beeTable, grandeTable, swiftTable, playlistTable, searchTable,songsTable;
	private static DefaultTableModel playlistTableModel, songsTableModel,drakeTableModel, weekendTableModel,scottTableModel,grandeTableModel,swiftTableModel,beeTableModel;
	private static JLabel currentSongLabel;
	private static JLabel currentPanelLabel;
	private static Timer progressUpdateTimer;
	private static JComboBox playlistOrder;
	private static boolean isPlaying = false;
	private static boolean isSkipping = false;
	private static Regular regular;
	private static Premium premium;
	private static Profile profile;
	private static MusicList list;

	private static boolean deleteSong;
	private static boolean deletePlaylist;

	// Main method for creating the GUI and initializing variables
	public Main_Menu(Premium premium, Regular regular, Profile profile) {

		// Initialize frame and set some default parameters
		mainFrame = new JFrame("MultiFrame Example");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.profile = profile;
		list = new MusicList();

		// Check if the user is a regular user or premium user and set appropriate variables
		if (premium == null) { 
			this.regular = regular;
			this.regular.setprofile(profile);
		} else {
			this.premium = premium;
			this.premium.setprofile(profile);
		}

		// Initialize some flags for later use
		deleteSong = false;
		deletePlaylist = false;

		// Initialize table models for different tables
		songsTableModel = new DefaultTableModel(new Object[] {"Song","Artist","Album","Duration"},0) { 
			@Override
			public boolean isCellEditable(int row, int column) {
				// Make all cells uneditable
				return false;
			}
		};

		// Initialize a table for displaying songs
		songsTable = new JTable(songsTableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Make all cells uneditable
				return false;
			}
		};

		// Set a dark gray color for consistency
		Color darkGrey = new Color(75, 75, 75);

		// Create and position different panels within the main frame
		JPanel panel1 = createPanel1(mainFrame, "Panel 1", darkGrey, 20, 30, 250, 90);
		createPanel2(mainFrame, "Panel 2", darkGrey, 20, 125, 250, 350);
		createPanel3(mainFrame, "Panel 3", darkGrey, 285, 30, 585, 445);

		mainFrame.getContentPane().setBackground(Color.BLACK);

		// Set the size of the main frame
		mainFrame.setSize(900, 600);

		// Create playback controls like play, pause, etc.
		createPlaybackControls(mainFrame);

		// Create panels for different artists or playlists
		createDrakeHitsPanel(mainFrame, "Drake Hit's", darkGrey, 535, 30, 350, 445);
		createWeekendHitsPanel(mainFrame, "The Weekend Hit's", darkGrey, 535, 30, 350, 445);
		createScottHitsPanel(mainFrame, "Travis Scott Hit's", darkGrey, 535, 30, 350, 445);
		createSwiftHitsPanel(mainFrame, "Taylor Swift Hit's", darkGrey, 535, 30, 350, 445);
		createBeyonceHitsPanel(mainFrame, "Beyonce Hit's", darkGrey, 535, 30, 350, 445);
		createGrandeHitsPanel(mainFrame, "Ariana Grande Hit's", darkGrey, 535, 30, 350, 445);
		createPlaylistPanel(mainFrame, "Your Playlists", darkGrey, 535, 30, 350, 445);

		// Add a settings button to the frame
		ImageIcon settingsIcon = new ImageIcon("dotsWhite.png"); // Replace with the actual path to your image
		JButton settingsButton = new JButton(settingsIcon);
		settingsButton.setBounds(5, -10, settingsIcon.getIconWidth(), settingsIcon.getIconHeight());
		settingsButton.setContentAreaFilled(false);
		settingsButton.setBorderPainted(false);
		settingsButton.setFocusPainted(false);

		// Add action listener to the settings button
		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create and show a popup menu on button click
				JPopupMenu popupMenu = new JPopupMenu();
				JMenuItem helpItem = new JMenuItem("Help");
				JMenuItem promiseItem = new JMenuItem("Company Promise");

				// Add action listeners to menu items
				helpItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new Menu_Help();
					}
				});

				promiseItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new Company_Promise();
					}
				});

				// Add items to the popup menu
				popupMenu.add(helpItem);
				popupMenu.add(promiseItem);

				// Show the popup menu at the button location
				popupMenu.show(settingsButton, 0, settingsButton.getHeight());
			}
		});

		// Add the settings button to the main frame
		mainFrame.add(settingsButton);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);

		// Make the table headers non-reorderable
		songsTable.getTableHeader().setReorderingAllowed(false);
		playlistTable.getTableHeader().setReorderingAllowed(false);
		songsTable.setVisible(true);
		playlistTable.setVisible(true);
	}

	// Method for customizing the appearance of a JTable
	private static void customizeTable(JTable table, Color backgroundColor) {
	    // Customize cell rendering
	    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	    cellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Center-align cell content
	    cellRenderer.setForeground(new Color(29, 185, 84)); // Dark green similar to Spotify
	    cellRenderer.setBackground(backgroundColor); // Set background color for cells
	    Font font = new Font("Monospaced", Font.BOLD, 16); // Customize font
	    cellRenderer.setFont(font);

	    // Apply the renderer to each column
	    for (int i = 0; i < table.getColumnCount(); i++) {
	        table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
	    }

	    // Customize header rendering
	    JTableHeader header = table.getTableHeader();
	    header.setBackground(Color.BLACK); // Set header background color to black
	    header.setForeground(Color.WHITE); // Set header text color to white
	    Font headerFont = new Font("Monospaced", Font.BOLD, 18); // Customize header font
	    header.setFont(headerFont);
	}

	// Method for creating a playlist panel in the main frame
	private static void createPlaylistPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) {
	    // Create a panel with rounded corners
	    JPanel panel3Playlist = new RoundedRectanglePanel(bgColor);
	    panel3Playlist.setLayout(null);

	    // Load and add the DrakeTitle image in panel3Drake
	    ImageIcon playTitleIcon = new ImageIcon("DrakeTitle.png"); // Adjust the path accordingly
	    JLabel playTitleLabel = new JLabel(playTitleIcon);
	    playTitleLabel.setBounds(-10, -10, playTitleIcon.getIconWidth(), playTitleIcon.getIconHeight());
	    panel3Playlist.add(playTitleLabel);

	    // Call the customizeTable method to apply customization to songsTable
	    customizeTable(songsTable, Color.BLACK);

	    // Create a scroll pane for the songsTable
	    JScrollPane playScrollPane = new JScrollPane(songsTable);
	    playScrollPane.setBounds(10, 200, 560, 192);
	    panel3Playlist.add(playScrollPane);

	    // Disable row selection highlighting
	    songsTable.setRowSelectionAllowed(false);

	    // Set the current table reference to songsTable
	    currentTable = songsTable;

	    // Add buttons for adding and deleting songs
	    ImageIcon addIcon = new ImageIcon("addBUT.png");
	    JButton addButton = new JButton(addIcon);
	    addButton.setBounds(430, 400, 50, 30);
	    addButton.setContentAreaFilled(false);
	    addButton.setBorderPainted(false);
	    addButton.setFocusPainted(false);
	    panel3Playlist.add(addButton);

	    ImageIcon minusIcon = new ImageIcon("minusBUT.png");
	    JButton minusButton = new JButton(minusIcon);
	    minusButton.setBounds(490, 400, 50, 30);
	    minusButton.setContentAreaFilled(false);
	    minusButton.setBorderPainted(false);
	    minusButton.setFocusPainted(false);
	    panel3Playlist.add(minusButton);

	    // Add action listeners to the buttons
	    addButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            JOptionPane.showMessageDialog(null, "The song's you add to the file must BE In this format\n(Song Name/Artist/Album/Duration in seconds)\nIf not in this format, song addition will be unsuccessful!");
	            FileNameExtensionFilter filter = new FileNameExtensionFilter("Song Files", "wav");
	            JFileChooser fileChooser = new JFileChooser(".");
	            fileChooser.setFileFilter(filter);

	            int response = fileChooser.showOpenDialog(null); // Select file to open
	            if (response == JFileChooser.APPROVE_OPTION) {
	                File file = fileChooser.getSelectedFile();
	                MusicUniversalMethods.addSongs(file, list, songsTableModel);
	                String songs = "";
	                MusicUniversalMethods.updateSongs(list, profile.getUsername() + "Database.txt");
	            }
	        }
	    });

	    minusButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            deleteSong = true;
	            JOptionPane.showMessageDialog(null, "Click the song you want to delete!\nIf song is deleted while playing, it will continue playing till the end!");
	        }
	    });

	    // Add selection listener for the songsTable
	    songsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent e) {
	            try {
	                if (!e.getValueIsAdjusting()) {
	                    deletePlaylist = false;
	                    int selectedRow = songsTable.getSelectedRow();
	                    if (selectedRow != -1) {
	                        String song = list.getList()[selectedRow].getSongName().toString();
	                        String artist = list.getList()[selectedRow].getArtist().toString();
	                        String album = list.getList()[selectedRow].getAlbum().toString();
	                        int duration = list.getList()[selectedRow].getDuration();
	                        MusicRecord1 temp = new MusicRecord1(song, artist, album, duration);
	                        if (deleteSong) {
	                            int option = JOptionPane.showOptionDialog(null, "Are you sure you want to delete the song:\n" + song + " by " + artist + "?", "DELETE", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);

	                            if (option == 0) {
	                                songsTableModel.removeRow(selectedRow);
	                                list.delete(temp);
	                                MusicUniversalMethods.updateSongs(list, profile.getUsername() + "Database.txt");
	                            }
	                            deleteSong = false;
	                        } else {
	                            Main_Menu.playWavFile(temp.toString() + ".wav");
	                        }
	                        songsTable.removeRowSelectionInterval(selectedRow, 0);
	                    }
	                }
	            } catch (Exception error) {
	            }
	        }
	    });

	    // Load songs from the database file and add them to the songs table
	    MusicUniversalMethods.getSongs(profile.getUsername() + "Database.txt", list);
	    for (int i = 0; i < list.getSize(); i++) {
	        Object[] songs = { list.getList()[i].getSongName(), list.getList()[i].getArtist(), list.getList()[i].getAlbum(), list.getList()[i].getDuration() };
	        songsTableModel.addRow(songs);
	    }

	    // Add the playlist panel to the cardPanel
	    cardPanel.add(panel3Playlist, "Your Playlist's");

	    // Load an ImageIcon for the back button (adjust the path accordingly)
	    ImageIcon backIcon = new ImageIcon("iconBack.png");

	    // Create a JButton for going back to the "Home" panel with the backIcon
	    JButton backButton = new JButton(backIcon);
	    backButton.setBounds(10, 390, backIcon.getIconWidth(), backIcon.getIconHeight());

	    // Set properties to have no background and no highlight
	    backButton.setContentAreaFilled(false);
	    backButton.setBorderPainted(false);

	    // Add the back button to the playlist panel
	    panel3Playlist.add(backButton);

	    // Add ActionListener to the backButton for switching to the "Home" panel
	    backButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "Home");
	        }
	    });
	}



	// Method for creating a panel displaying Drake's hit songs in the main frame
	private static void createDrakeHitsPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) {
	    // Create a panel with rounded corners
	    JPanel panel3Drake = new RoundedRectanglePanel(bgColor);
	    panel3Drake.setLayout(null);

	    // Load and add the DrakeTitle image in panel3Drake
	    ImageIcon drakeTitleIcon = new ImageIcon("DrakeTitle.png"); // Adjust the path accordingly
	    JLabel drakeTitleLabel = new JLabel(drakeTitleIcon);
	    drakeTitleLabel.setBounds(0, -10, drakeTitleIcon.getIconWidth(), drakeTitleIcon.getIconHeight());
	    panel3Drake.add(drakeTitleLabel);

	    // Create a table model and table for Drake's hit songs
	    drakeTableModel = new DefaultTableModel(new Object[] { "Song", "Artist", "Album", "Duration" }, 0) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            // all cells false
	            return false;
	        }
	    };

	    drakeTable = new JTable(drakeTableModel) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false; // Make the cells uneditable
	        }
	    };

	    // Set the row count to 0 and initialize the MusicList
	    drakeTableModel.setRowCount(0);
	    list = new MusicList();
	    list.setPlaylist("Drake Hits");
	    MusicUniversalMethods.getSongs("TopArtistDatabase.txt", list);

	    // Add Drake's hit songs to the table model
	    for (int i = 0; i < list.getSize(); i++) {
	        Object[] songs = { list.getList()[i].getSongName(), list.getList()[i].getArtist(), list.getList()[i].getAlbum(), list.getList()[i].getDuration() };
	        drakeTableModel.addRow(songs);
	    }

	    // Call the customizeTable method to apply customization to drakeTable
	    customizeTable(drakeTable, Color.BLACK);

	    // Load an ImageIcon for the back button (adjust the path accordingly)
	    ImageIcon backIcon = new ImageIcon("iconBack.png");

	    // Create a JButton for going back to panel3Home with the backIcon
	    JButton backButton = new JButton(backIcon);
	    backButton.setBounds(10, 390, backIcon.getIconWidth(), backIcon.getIconHeight()); // Adjust the bounds based on the icon size

	    // Set properties to have no background and no highlight
	    backButton.setContentAreaFilled(false);
	    backButton.setBorderPainted(false);

	    // Add the back button to the Drake hits panel
	    panel3Drake.add(backButton);

	    // Add ActionListener to the backButton for switching to the "Home" panel
	    backButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "Home");
	        }
	    });

	    // Create a scroll pane for the Drake's hit songs table
	    JScrollPane drakeScrollPane = new JScrollPane(drakeTable);
	    drakeScrollPane.setBounds(10, 200, 560, 192);
	    panel3Drake.add(drakeScrollPane);

	    // Disable row selection highlighting
	    drakeTable.setRowSelectionAllowed(false);

	    // Set the current table reference to drakeTable
	    currentTable = drakeTable;

	    // Add selection listener for the Drake hits table
	    drakeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent e) {
	            handleTableSelection(drakeTable);
	            playSelectedSong(drakeTable);
	        }
	    });

	    // Add the Drake hits panel to the cardPanel
	    cardPanel.add(panel3Drake, "Drake Hit's");
	}

	// Method for creating a panel displaying The Weeknd's hit songs in the main frame
	private static void createWeekendHitsPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) {
	    // Create a panel with rounded corners
	    JPanel panel3Weekend = new RoundedRectanglePanel(bgColor);
	    panel3Weekend.setLayout(null);

	    // Load and add The WeekndTitle image in panel3Weekend
	    ImageIcon weekendTitle = new ImageIcon("weekendTitle.png"); // Adjust the path accordingly
	    JLabel weekendTitleLabel = new JLabel(weekendTitle);
	    weekendTitleLabel.setBounds(-10, -10, weekendTitle.getIconWidth(), weekendTitle.getIconHeight());
	    panel3Weekend.add(weekendTitleLabel);

	    // Create a table model and table for The Weeknd's hit songs
	    weekendTableModel = new DefaultTableModel(new Object[] { "Song", "Artist", "Album", "Duration" }, 0) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            // all cells false
	            return false;
	        }
	    };

	    weekendTable = new JTable(weekendTableModel) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false; // Make the cells uneditable
	        }
	    };

	    // Set the row count to 0 and initialize the MusicList
	    weekendTableModel.setRowCount(0);
	    list = new MusicList();
	    list.setPlaylist("The Weekend Hits");
	    MusicUniversalMethods.getSongs("TopArtistDatabase.txt", list);

	    // Add The Weeknd's hit songs to the table model
	    for (int i = 0; i < list.getSize(); i++) {
	        Object[] songs = { list.getList()[i].getSongName(), list.getList()[i].getArtist(), list.getList()[i].getAlbum(), list.getList()[i].getDuration() };
	        weekendTableModel.addRow(songs);
	    }

	    // Call the customizeTable method to apply customization to weekendTable
	    customizeTable(weekendTable, Color.BLACK);

	    // Load an ImageIcon for the back button (adjust the path accordingly)
	    ImageIcon backIcon = new ImageIcon("iconBack.png");

	    // Create a JButton for going back to panel3Home with the backIcon
	    JButton backButton = new JButton(backIcon);
	    backButton.setBounds(10, 390, backIcon.getIconWidth(), backIcon.getIconHeight()); // Adjust the bounds based on the icon size

	    // Set properties to have no background and no highlight
	    backButton.setContentAreaFilled(false);
	    backButton.setBorderPainted(false);

	    // Add the back button to the Weekend hits panel
	    panel3Weekend.add(backButton);

	    // Add ActionListener to the backButton for switching to the "Home" panel
	    backButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "Home");
	        }
	    });

	    // Create a scroll pane for The Weeknd's hit songs table
	    JScrollPane weekendScrollPane = new JScrollPane(weekendTable);
	    weekendScrollPane.setBounds(10, 200, 560, 192);
	    panel3Weekend.add(weekendScrollPane);

	    // Disable row selection highlighting
	    weekendTable.setRowSelectionAllowed(false);

	    // Set the current table reference to weekendTable
	    currentTable = weekendTable;

	    // Add selection listener for The Weeknd hits table
	    weekendTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent e) {
	            handleTableSelection(weekendTable);
	        }
	    });

	    // ... (Existing code for other components in the panel)

	    // Add the Weekend hits panel to the cardPanel
	    cardPanel.add(panel3Weekend, "The Weekend Hit's");
	}

	// Method for creating a panel displaying Travis Scott's hit songs in the main frame
	private static void createScottHitsPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) {
	    // Create a panel with rounded corners
	    JPanel panel3Scott = new RoundedRectanglePanel(bgColor);
	    panel3Scott.setLayout(null);

	    // Load and add the ScottTitle image in panel3Scott
	    ImageIcon scottTitle = new ImageIcon("scottTitle.png"); // Adjust the path accordingly
	    JLabel scottTitleLabel = new JLabel(scottTitle);
	    scottTitleLabel.setBounds(-5, -10, scottTitle.getIconWidth(), scottTitle.getIconHeight());
	    panel3Scott.add(scottTitleLabel);

	    // Create a table model and table for Travis Scott's hit songs
	    scottTableModel = new DefaultTableModel(new Object[] { "Song", "Artist", "Album", "Duration" }, 0) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            // all cells false
	            return false;
	        }
	    };

	    scottTable = new JTable(scottTableModel) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false; // Make the cells uneditable
	        }
	    };

	    // Set the row count to 0 and initialize the MusicList
	    scottTableModel.setRowCount(0);
	    list = new MusicList();
	    list.setPlaylist("Travis Scott Hits");
	    MusicUniversalMethods.getSongs("TopArtistDatabase.txt", list);

	    // Add Travis Scott's hit songs to the table model
	    for (int i = 0; i < list.getSize(); i++) {
	        Object[] songs = { list.getList()[i].getSongName(), list.getList()[i].getArtist(), list.getList()[i].getAlbum(), list.getList()[i].getDuration() };
	        scottTableModel.addRow(songs);
	    }

	    // Call the customizeTable method to apply customization to scottTable
	    customizeTable(scottTable, Color.BLACK);

	    // Load an ImageIcon for the back button (adjust the path accordingly)
	    ImageIcon backIcon = new ImageIcon("iconBack.png");

	    // Create a JButton for going back to panel3Home with the backIcon
	    JButton backButton = new JButton(backIcon);
	    backButton.setBounds(10, 390, backIcon.getIconWidth(), backIcon.getIconHeight()); // Adjust the bounds based on the icon size

	    // Set properties to have no background and no highlight
	    backButton.setContentAreaFilled(false);
	    backButton.setBorderPainted(false);

	    // Add the back button to the Travis Scott hits panel
	    panel3Scott.add(backButton);

	    // Add ActionListener to the backButton for switching to the "Home" panel
	    backButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "Home");
	        }
	    });

	    // Create a scroll pane for Travis Scott's hit songs table
	    JScrollPane scottScrollPane = new JScrollPane(scottTable);
	    scottScrollPane.setBounds(10, 200, 560, 192);
	    panel3Scott.add(scottScrollPane);

	    // Disable row selection highlighting
	    scottTable.setRowSelectionAllowed(false);

	    // Set the current table reference to scottTable
	    currentTable = scottTable;

	    // Add selection listener for Travis Scott hits table
	    scottTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent e) {
	            handleTableSelection(scottTable);
	        }
	    });

	    // Add the Travis Scott hits panel to the cardPanel
	    cardPanel.add(panel3Scott, "Travis Scott Hit's");
	}

	// Method for creating a panel displaying Taylor Swift's hit songs in the main frame
	private static void createSwiftHitsPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) {
	    // Create a panel with rounded corners
	    JPanel panel3Swift = new RoundedRectanglePanel(bgColor);
	    panel3Swift.setLayout(null);

	    // Load and add the SwiftTitle image in panel3Swift
	    ImageIcon swiftTitle = new ImageIcon("swiftTitle.png"); // Adjust the path accordingly
	    JLabel swiftTitleLabel = new JLabel(swiftTitle);
	    swiftTitleLabel.setBounds(-5, -10, swiftTitle.getIconWidth(), swiftTitle.getIconHeight());
	    panel3Swift.add(swiftTitleLabel);

	    // Create a table model and table for Taylor Swift's hit songs
	    swiftTableModel = new DefaultTableModel(new Object[] { "Song", "Artist", "Album", "Duration" }, 0) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            // all cells false
	            return false;
	        }
	    };

	    swiftTable = new JTable(swiftTableModel) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false; // Make the cells uneditable
	        }
	    };

	    // Set the row count to 0 and initialize the MusicList
	    swiftTableModel.setRowCount(0);
	    list = new MusicList();
	    list.setPlaylist("Taylor Swift Hits");
	    MusicUniversalMethods.getSongs("TopArtistDatabase.txt", list);

	    // Add Taylor Swift's hit songs to the table model
	    for (int i = 0; i < list.getSize(); i++) {
	        Object[] songs = { list.getList()[i].getSongName(), list.getList()[i].getArtist(), list.getList()[i].getAlbum(), list.getList()[i].getDuration() };
	        swiftTableModel.addRow(songs);
	    }

	    // Call the customizeTable method to apply customization to swiftTable
	    customizeTable(swiftTable, Color.BLACK);

	    // Assuming "iconBack.png" is the path to your image file
	    ImageIcon backIcon = new ImageIcon("iconBack.png");

	    // Add button for going back to panel3Home with no background and no highlight
	    JButton backButton = new JButton(backIcon);
	    backButton.setBounds(10, 390, backIcon.getIconWidth(), backIcon.getIconHeight()); // Adjust the bounds based on the icon size

	    // Set properties to have no background and no highlight
	    backButton.setContentAreaFilled(false);
	    backButton.setBorderPainted(false);

	    panel3Swift.add(backButton);

	    // Add ActionListener to the backButton
	    backButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "Home");
	        }
	    });

	    JScrollPane swiftScrollPane = new JScrollPane(swiftTable);
	    swiftScrollPane.setBounds(10, 200, 560, 192);
	    panel3Swift.add(swiftScrollPane);

	    // Disable row selection highlighting
	    swiftTable.setRowSelectionAllowed(false);

	    currentTable = swiftTable; // Set the current table reference

	    // Add selection listener for the Swift hits table
	    swiftTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent e) {
	            handleTableSelection(swiftTable);
	        }
	    });

	    // ... (Existing code for other components in the panel)

	    cardPanel.add(panel3Swift, "Taylor Swift Hit's");
	}


	// Method for creating a panel displaying Beyonce's hit songs in the main frame
	private static void createBeyonceHitsPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) {
	    // Create a panel with rounded corners
	    JPanel panel3Beyonce = new RoundedRectanglePanel(bgColor);
	    panel3Beyonce.setLayout(null);

	    // Load and add the BeyonceTitle image in panel3Beyonce
	    ImageIcon beeTitle = new ImageIcon("beeTitle.png"); // Adjust the path accordingly
	    JLabel beeTitleLabel = new JLabel(beeTitle);
	    beeTitleLabel.setBounds(0, -10, beeTitle.getIconWidth(), beeTitle.getIconHeight());
	    panel3Beyonce.add(beeTitleLabel);

	    // Create a table model and table for Beyonce's hit songs
	    beeTableModel = new DefaultTableModel(new Object[] { "Song", "Artist", "Album", "Duration" }, 0) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            // all cells false
	            return false;
	        }
	    };

	    beeTable = new JTable(beeTableModel) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false; // Make the cells uneditable
	        }
	    };

	    // Set the row count to 0 and initialize the MusicList
	    beeTableModel.setRowCount(0);
	    list = new MusicList();
	    list.setPlaylist("Beyonce Hits");
	    MusicUniversalMethods.getSongs("TopArtistDatabase.txt", list);

	    // Add Beyonce's hit songs to the table model
	    for (int i = 0; i < list.getSize(); i++) {
	        Object[] songs = { list.getList()[i].getSongName(), list.getList()[i].getArtist(), list.getList()[i].getAlbum(), list.getList()[i].getDuration() };
	        beeTableModel.addRow(songs);
	    }

	    // Call the customizeTable method to apply customization to beeTable
	    customizeTable(beeTable, Color.BLACK);

	    // Assuming "iconBack.png" is the path to your image file
	    ImageIcon backIcon = new ImageIcon("iconBack.png");

	    // Add button for going back to panel3Home with no background and no highlight
	    JButton backButton = new JButton(backIcon);
	    backButton.setBounds(10, 390, backIcon.getIconWidth(), backIcon.getIconHeight()); // Adjust the bounds based on the icon size

	    // Set properties to have no background and no highlight
	    backButton.setContentAreaFilled(false);
	    backButton.setBorderPainted(false);

	    // Add ActionListener to the backButton for switching to the "Home" panel
	    backButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "Home");
	        }
	    });

	    // Add the back button to the Beyonce hits panel
	    panel3Beyonce.add(backButton);

	    // Create a scroll pane for Beyonce's hit songs table
	    JScrollPane beeScrollPane = new JScrollPane(beeTable);
	    beeScrollPane.setBounds(10, 200, 560, 192);
	    panel3Beyonce.add(beeScrollPane);

	    // Disable row selection highlighting
	    beeTable.setRowSelectionAllowed(false);

	    // Set the current table reference to beeTable
	    currentTable = beeTable;

	    // Add selection listener for Beyonce hits table
	    beeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent e) {
	            handleTableSelection(beeTable);
	        }
	    });

	    // Add the Beyonce hits panel to the cardPanel
	    cardPanel.add(panel3Beyonce, "Beyonce Hit's");
	}

	// Method for creating a panel displaying Ariana Grande's hit songs in the main frame
	private static void createGrandeHitsPanel(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) {
	    // Create a panel with rounded corners
	    JPanel panel3Grande = new RoundedRectanglePanel(bgColor);
	    panel3Grande.setLayout(null);

	    // Load and add the GrandeTitle image in panel3Grande
	    ImageIcon gradeTitle = new ImageIcon("grandeTitle.png"); // Adjust the path accordingly
	    JLabel grandeTitleLabel = new JLabel(gradeTitle);
	    grandeTitleLabel.setBounds(0, -10, gradeTitle.getIconWidth(), gradeTitle.getIconHeight());
	    panel3Grande.add(grandeTitleLabel);

	    // Create a table model and table for Ariana Grande's hit songs
	    grandeTableModel = new DefaultTableModel(new Object[] { "Song", "Artist", "Album", "Duration" }, 0) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            // all cells false
	            return false;
	        }
	    };

	    grandeTable = new JTable(grandeTableModel) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false; // Make the cells uneditable
	        }
	    };

	    // Set the row count to 0 and initialize the MusicList
	    grandeTableModel.setRowCount(0);
	    list = new MusicList();
	    list.setPlaylist("Ariana Grande Hits");
	    MusicUniversalMethods.getSongs("TopArtistDatabase.txt", list);

	    // Add Ariana Grande's hit songs to the table model
	    for (int i = 0; i < list.getSize(); i++) {
	        Object[] songs = { list.getList()[i].getSongName(), list.getList()[i].getArtist(), list.getList()[i].getAlbum(), list.getList()[i].getDuration() };
	        grandeTableModel.addRow(songs);
	    }

	    // Call the customizeTable method to apply customization to grandeTable
	    customizeTable(grandeTable, Color.BLACK);

	    // Assuming "iconBack.png" is the path to your image file
	    ImageIcon backIcon = new ImageIcon("iconBack.png");

	    // Add button for going back to panel3Home with no background and no highlight
	    JButton backButton = new JButton(backIcon);
	    backButton.setBounds(10, 390, backIcon.getIconWidth(), backIcon.getIconHeight()); // Adjust the bounds based on the icon size

	    // Set properties to have no background and no highlight
	    backButton.setContentAreaFilled(false);
	    backButton.setBorderPainted(false);

	    // Add ActionListener to the backButton
	    backButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "Home");
	        }
	    });

	    // Add the back button to the Ariana Grande hits panel
	    panel3Grande.add(backButton);

	    // Create a scroll pane for Ariana Grande's hit songs table
	    JScrollPane grandeScrollPane = new JScrollPane(grandeTable);
	    grandeScrollPane.setBounds(10, 200, 560, 192);
	    panel3Grande.add(grandeScrollPane);

	    // Disable row selection highlighting
	    grandeTable.setRowSelectionAllowed(false);

	    // Set the current table reference to grandeTable
	    currentTable = grandeTable;

	    // Add selection listener for Ariana Grande hits table
	    grandeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent e) {
	            handleTableSelection(grandeTable);
	        }
	    });

	    // ... (Existing code for other components in the panel)

	    // Add the Ariana Grande hits panel to the cardPanel
	    cardPanel.add(panel3Grande, "Ariana Grande Hit's");
	}

	// Method for creating playback controls panel in the main frame
	private static void createPlaybackControls(JFrame mainFrame) {
	    // Create a panel with rounded corners and dark green color
	    JPanel playbackPanel = new RoundedRectanglePanel(new Color(0, 100, 0)); // Dark green
	    playbackPanel.setLayout(null);
	    playbackPanel.setBounds(20, 485, 850, 60);

	    // Create and customize the progress bar
	    progressBar = new JProgressBar();
	    progressBar.setStringPainted(true);

	    // Customize the appearance of the progress bar
	    UIManager.put("ProgressBar.background", Color.WHITE); // Background color
	    UIManager.put("ProgressBar.foreground", Color.BLACK); // Progress color
	    UIManager.put("ProgressBar.selectionBackground", Color.GREEN); // Color of the "not yet progressed" part
	    UIManager.put("ProgressBar.selectionForeground", Color.GREEN); // Text color
	    UIManager.put("ProgressBar.border", BorderFactory.createEmptyBorder()); // Remove border

	    // Set the positions using setBounds for the modified progress bar
	    progressBar.setBounds(100, 10, 50, 5);

	    // Set the preferred size to make the progress bar shorter
	    Dimension preferredSize = new Dimension(progressBar.getPreferredSize().width, 3); // Adjust the height (e.g., 3 pixels)
	    progressBar.setPreferredSize(preferredSize);

	    // Create playback control buttons with icons and actions
	    playButton = new JButton("",  new ImageIcon("iconCPlay.png"));
	    playButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            play();
	        }
	    });

	    // Set content area filled property to false
	    playButton.setContentAreaFilled(false);
	    // Make the button opaque
	    playButton.setOpaque(false);
	    playButton.setBorderPainted(false);

	    // Create and customize the "Pause" button
	    pauseButton = new JButton("",  new ImageIcon("iconPause.png"));
	    pauseButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            pause();
	        }
	    });

	    // Set content area filled property to false
	    pauseButton.setContentAreaFilled(false);
	    // Make the button opaque
	    pauseButton.setOpaque(false);
	    pauseButton.setBorderPainted(false);

	    // Create and customize the "Restart" button
	    restartButton = new JButton("", new ImageIcon("iconRestart.png"));
	    restartButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            restartTrack();
	        }
	    });

	    // Set content area filled property to false
	    restartButton.setContentAreaFilled(false);
	    // Make the button opaque
	    restartButton.setOpaque(false);
	    restartButton.setBorderPainted(false);

	    // Create and customize the "Skip Track" button
	    skipButton = new JButton("", new ImageIcon("iconSkip.png"));
	    skipButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            skipTrack();
	        }
	    });

	    // Set content area filled property to false
	    skipButton.setContentAreaFilled(false);
	    // Make the button opaque
	    skipButton.setOpaque(false);
	    skipButton.setBorderPainted(false);

	    // Create and customize the volume slider
	    volumeSlider = new JSlider(0, 100, 50);
	    volumeSlider.addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            setVolume(volumeSlider.getValue());
	        }
	    });

	    // Set the volume slider properties
	    volumeSlider.setMajorTickSpacing(25); // Add major ticks every 25 units
	    volumeSlider.setMinorTickSpacing(0); // Add minor ticks every 5 units
	    volumeSlider.setPaintTicks(false);
	    volumeSlider.setPaintLabels(false);

	    // Change the color of the volume slider
	    volumeSlider.setBackground(Color.WHITE); // Adjust the color as needed

	    // Set the positions using setBounds for the modified volume slider
	    volumeSlider.setBounds(430, 10, 200, 50); // Adjust the width and height as needed
	    volumeSlider.setForeground(Color.GREEN); // Adjust the color as needed

	    // Create a timer to update the progress bar at regular intervals
	    progressUpdateTimer = new Timer(1000, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            updateProgressBar();
	        }
	    });

	    // Add a MouseListener to reset the timer when the user clicks on the progress bar
	    progressBar.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            resetTimer();
	        }
	    });

	    // Create a new progress bar for current song progress
	    progressBar = new JProgressBar();
	    progressBar.setStringPainted(true);

	    // Create and customize the label for the currently playing song
	    currentSongLabel = new JLabel("Playing Song: ");
	    currentSongLabel.setForeground(Color.WHITE);
	    Font labelFont = new Font(Font.MONOSPACED, Font.ITALIC, 10);
	    currentSongLabel.setFont(labelFont);

	    // Create and customize the label for the volume adjuster
	    JLabel volumeLabel = new JLabel("Volume Adjuster");
	    volumeLabel.setForeground(Color.WHITE);
	    Font labelFontVol = new Font(Font.MONOSPACED, Font.ITALIC, 10);
	    volumeLabel.setFont(labelFontVol);

	    // Create and customize the label for the current panel
	    currentPanelLabel = new JLabel("Panel: Home");
	    currentPanelLabel.setForeground(Color.WHITE);

	    // Add components to the playback panel
	    playbackPanel.add(playButton);
	    playbackPanel.add(pauseButton);
	    playbackPanel.add(restartButton);
	    playbackPanel.add(skipButton);
	    playbackPanel.add(volumeLabel);
	    playbackPanel.add(volumeSlider);
	    playbackPanel.add(progressBar);
	    playbackPanel.add(playButton);
	    playbackPanel.add(currentSongLabel);
	    playbackPanel.add(currentPanelLabel);

	    // Set positions using setBounds for each component
	    playButton.setBounds(40, 10, 80, 35);
	    pauseButton.setBounds(130, 10, 80, 35);
	    restartButton.setBounds(220, 10, 80, 35);
	    skipButton.setBounds(300, 10, 100, 35);
	    volumeLabel.setBounds(470, 35, 200, 30);
	    volumeSlider.setBounds(410, 12, 200, 30);
	    progressBar.setBounds(640, 12, 200, 30);
	    currentSongLabel.setBounds(650, 23, 600, 50);

	    // Add the playback panel to the main frame
	    mainFrame.add(playbackPanel);
	}
	// Start playing the audio clip
	public static void play() {
	    if (audioClip != null && !isPlaying) {
	        audioClip.start();
	        isPlaying = true;
	        startProgressUpdateTimer(); // Start the timer when playing
	    }
	}

	// Pause the currently playing audio clip
	private static void pause() {
	    if (audioClip != null) {
	        audioClip.stop();
	        isPlaying = false;
	        stopProgressUpdateTimer(); // Stop the timer when paused
	    }
	}

	// Restart the currently playing track
	private static void restartTrack() {
	    if (audioClip != null) {
	        audioClip.stop();
	        audioClip.setMicrosecondPosition(0);
	        isPlaying = false;
	        startProgressUpdateTimer(); // Start the timer after restarting
	        play();
	    }
	}

	// Set the volume of the audio clip based on the provided value
	private static void setVolume(int value) {
	    if (audioClip != null) {
	        FloatControl gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
	        float gain = (float) (Math.log(value / 100.0) / Math.log(10.0) * 20.0);
	        gainControl.setValue(gain);
	        updateProgressBar();
	    }
	}

	// Update the progress bar based on the current audio clip position
	private static void updateProgressBar() {
	    if (audioClip != null && isPlaying) {
	        int currentPosition = (int) (audioClip.getMicrosecondPosition() / 1000000);
	        int totalDuration = (int) (audioClip.getMicrosecondLength() / 1000000);
	        progressBar.setMaximum(totalDuration);
	        progressBar.setValue(currentPosition);

	        // Check if the song has completed
	        if (currentPosition >= totalDuration) {
	            skipTrack();
	        }
	    }
	}

	// Start the progress update timer
	private static void startProgressUpdateTimer() {
	    progressUpdateTimer.start();
	}

	// Stop the progress update timer
	private static void stopProgressUpdateTimer() {
	    progressUpdateTimer.stop();
	}

	// Reset the progress update timer
	private static void resetTimer() {
	    if (audioClip != null && isPlaying) {
	        stopProgressUpdateTimer();
	        startProgressUpdateTimer();
	    }
	}

	// Skip to the next track in the playlist
	private static void skipTrack() {
	    if (audioClip != null && !isSkipping) {
	        isSkipping = true;

	        // Stop the progress update timer before skipping
	        stopProgressUpdateTimer();

	        audioClip.stop();

	        // Use the appropriate table based on the current panel
	        JTable currentTable = getCurrentTableForPanel(currentPanelLabel.getText().trim());

	        int selectedRow = currentTable.getSelectedRow();
	        int nextRow = (selectedRow + 1) % currentTable.getRowCount();
	        currentTable.setRowSelectionInterval(nextRow, nextRow);

	        playSelectedSong(currentTable);  // Play the selected song directly

	        isSkipping = false;
	    }
	}

	// Play the selected song from the specified table
	private static void playSelectedSong(JTable table) {
	    try {
	        if (audioClip != null) {
	            audioClip.stop();

	            int selectedRow = table.getSelectedRow();
	            playWavFile(list.getList()[selectedRow].toString()+ ".wav");
	            isPlaying = true;
	            startProgressUpdateTimer();
	        }
	    } catch (Exception e) { 
	        // Display an error message if the song cannot be found
	        JOptionPane.showMessageDialog(null, "Song could not be found within database! Check files!" ,"ERROR",JOptionPane.ERROR_MESSAGE);
	    }
	}


	//METHOD TO OBTAIN WHICH PANEL USER IS CURRENTLY USING 


	private static JTable getCurrentTableForPanel(String panelName) {
		switch (panelName) {
		case "Panel: Drake Hit's":
			return drakeTable;

		case "Panel: The Weekend Hit's":
			return weekendTable;

		case "Panel: Travis Scott Hit's":
			return scottTable;

		case "Panel: Beyonce Hit's":
			return beeTable;

		case "Panel: Ariana Grande Hit's":
			return grandeTable;

		case "Panel: Taylor Swift Hit's":
			return swiftTable;
			// Add more cases for other panels as needed

		case "Panel: My Playlist's":
			return swiftTable;
			// Add more cases for other panels as needed

		default:
			// Default to using the Drake table if the current panel is not recognized
			return drakeTable;
		}
	}














	//PANEL 1 WHICH IS THE BUTTONS TO GUIDE BETWEEN SEARCH AND HOME


	private static JPanel createPanel1(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) {
		JPanel panel = new RoundedRectanglePanel(bgColor);

		ImageIcon homeIcon = new ImageIcon("iconHouse.png");
		JButton button1 = new JButton("   Home", homeIcon);
		button1.setBounds(10, 10, 150, 30);
		button1.setFont(new Font("Monospaced", Font.BOLD, 16));
		button1.setForeground(Color.WHITE);
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);

		ImageIcon searchIcon = new ImageIcon("iconMag.png");
		JButton button2 = new JButton("   Search", searchIcon);
		button2.setBounds(10, 50, 160, 30);
		button2.setFont(new Font("Monospaced", Font.BOLD, 16));
		button2.setForeground(Color.WHITE);
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);

		panel.setBounds(x, y, width, height);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Home");
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				list = new MusicList();
				MusicUniversalMethods.readSongs("TopArtistDatabase.txt", list);
				cardLayout.show(cardPanel, "Search");
			}
		});

		panel.setLayout(null);
		panel.add(button1);
		panel.add(button2);

		mainFrame.add(panel);
		return panel;
	}













	//PANEL 2 WHICH HOLDS JTABLE WHICH HOLD CREATED LIBRARIES SUCH AS CREATED PLAYLIST OR FAVOURITE SONGS 





	private static void createPanel2(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) {
		JPanel panel = new RoundedRectanglePanel(bgColor);

		ImageIcon libraryIcon = new ImageIcon("iconLib.png");
		JLabel libraryLabel = new JLabel(libraryIcon);
		libraryLabel.setBounds(10, 10, libraryIcon.getIconWidth(), libraryIcon.getIconHeight());

		JLabel titleLabel = new JLabel("Your Library");
		titleLabel.setBounds(80, 15, 300, 30);
		titleLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		titleLabel.setForeground(Color.WHITE);

		JLabel playlistLabel = new JLabel("Playlists;");
		playlistLabel.setBounds(10, 75, 300, 30);
		playlistLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
		playlistLabel.setForeground(Color.WHITE);



		String [] order = {"Alpha", "Total Songs"};

		playlistOrder = new JComboBox(order);  		

		playlistOrder.setBounds(125, 78, 120, 25);
		playlistOrder.setFont(new Font("Monospaced", Font.BOLD, 12));
		playlistOrder.setForeground(Color.BLACK);


		JLabel createPlaylistLabel = new JLabel("Add/Delete Playlist -->");
		createPlaylistLabel.setBounds(10, 110, 200, 30);
		createPlaylistLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
		createPlaylistLabel.setForeground(Color.WHITE);

		ImageIcon addIcon = new ImageIcon("addBUT.png");
		JButton addButton = new JButton(addIcon);
		addButton.setBounds(175, 110, 50, 30);
		addButton.setContentAreaFilled(false);
		addButton.setBorderPainted(false);
		addButton.setFocusPainted(false);

		ImageIcon minusIcon = new ImageIcon("minusBUT.png");
		JButton minusButton = new JButton(minusIcon);
		minusButton.setBounds(205, 110, 50, 30);
		minusButton.setContentAreaFilled(false);
		minusButton.setBorderPainted(false);
		minusButton.setFocusPainted(false);


		// Add action listeners to the menu items
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					deletePlaylist = false;
					deleteSong = false;
					String playlistName = JOptionPane.showInputDialog("Enter the name of your new Playlist!");
					if (playlistName.equals("")) { 
						JOptionPane.showMessageDialog(null,"ERROR! Please enter something for your new playlist!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else { 
						Object [] playlist = {playlistName};
						playlistTableModel.addRow(playlist);
						MusicUniversalMethods.updatePlaylist(false,profile.getUsername() + "Database.txt",playlistName);
					}
				} catch (NullPointerException error) { 
				}
			}
		});


		minusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deletePlaylist = true;
				JOptionPane.showMessageDialog(null,"Click the playlist you want to delete!\n "
						+ "If a playlist is deleted while a song is playing, it will continue playing till the end!");
			}

		});

		playlistTableModel = new DefaultTableModel(new Object[] {"Playlist's"},0) { 
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		playlistTable = new JTable(playlistTableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {

				return false; // Make the cells uneditable
			}
		};


		// Call the customizeTable method to apply customization to drakeTable
		customizeTable(playlistTable, Color.BLACK);


		JScrollPane scrollPane = new JScrollPane(playlistTable);
		scrollPane.setBounds(5, 150, 240, 192);
		panel.add(scrollPane);

		// Disable row selection highlighting
		playlistTable.setRowSelectionAllowed(false);

		currentTable = playlistTable; // Set the current table reference

		System.out.println(profile.getUsername() + "Database.txt");

		if (!(MusicUniversalMethods.getPlaylist(profile.getUsername() + "Database.txt", playlistTableModel))) {
			String fileName = profile.getUsername() + "Database.txt";
			try { 
				BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
				writer.write("EOF");
				writer.close();
			}catch (Exception e) { 
			}
		}

		// Add selection listener for the Drake hits table
		playlistTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					deleteSong = false;
					int selectedRow = playlistTable.getSelectedRow();
					if (selectedRow != -1) {
						// Assuming the first column contains the string you want to retrieve
						list.setPlaylist(playlistTableModel.getValueAt(selectedRow, 0).toString());

						if (deletePlaylist) { 
							int option = JOptionPane.showOptionDialog(null, "Are you sure you want to delete the playlist:"
									+ list.getPlaylist() + "?", "DELETE", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);

							if (option == 0) { 
								playlistTableModel.removeRow(selectedRow);
								songsTableModel.setRowCount(0);
								MusicUniversalMethods.updatePlaylist(true, "test.txt",list.getPlaylist());
								list = new MusicList();
							}
							deletePlaylist = false;
						}

						else {
							cardLayout.show(cardPanel, "Your Playlist's");
							updateCurrentPanelLabel("Your Playlist's");
							songsTableModel.setRowCount(0);
							list = new MusicList();
							list.setPlaylist(playlistTableModel.getValueAt(selectedRow, 0).toString());
							//	(selectedValue.toString());
							MusicUniversalMethods.getSongs("test.txt",list);

							for (int i = 0; i < list.getSize(); i++) { 
								Object[] songs = {list.getList()[i].getSongName(),list.getList()[i].getArtist(),list.getList()[i].getAlbum(),list.getList()[i].getDuration()};
								songsTableModel.addRow(songs);
							}
						}
					}
				}



			}
		});

		currentTable = songsTable;


		panel.setBounds(x, y, width, height);
		panel.setLayout(null);
		panel.add(libraryLabel);
		panel.add(titleLabel);
		panel.add(playlistLabel);
		panel.add(playlistOrder);
		panel.add(createPlaylistLabel);
		panel.add(addButton);

		mainFrame.add(panel);
	}














	//PANEL 3 WHICH DISPLAYS THE HOME PAGE WITH TOP 2023 ARTISTS





	private static void createPanel3(JFrame mainFrame, String title, Color bgColor, int x, int y, int width, int height) {

		cardPanel = new RoundedRectanglePanel(bgColor);
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);

		JPanel panel3Home = new RoundedRectanglePanel(Color.GRAY);
		panel3Home.setLayout(null);

		JLabel welcomeLabel = new JLabel("Welcome Back, Hamza Khan");
		welcomeLabel.setFont(new Font("Monospaced", Font.BOLD, 26));
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setBounds(10, 15, 600, 30);
		panel3Home.add(welcomeLabel);

		JLabel forYou = new JLabel("TOP ARTISTS OF 2023;");
		forYou.setFont(new Font("Monospaced", Font.BOLD, 20));
		forYou.setForeground(Color.WHITE);
		forYou.setBounds(10, 50, 600, 30);
		panel3Home.add(forYou);

		// Create a button for the dropdown
		ImageIcon profile = new ImageIcon("iconProfile.png");
		JButton profileButton = new JButton(profile);
		profileButton.setBounds(525, 10, 80, 30);
		profileButton.setContentAreaFilled(false);
		profileButton.setBorderPainted(false);
		panel3Home.add(profileButton);

		// Create a popup menu for the dropdown
		JPopupMenu optionsMenu = new JPopupMenu();
		JMenuItem lightThemeItem = new JMenuItem("Light Theme");
		JMenuItem darkThemeItem = new JMenuItem("Dark Theme");
		JMenuItem logoutItem = new JMenuItem("Logout");


		// Add action listeners to the menu items
		logoutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LogIn();
				mainFrame.dispose();
				JOptionPane.showMessageDialog(mainFrame, "Logged Out!");

			}
		});

		lightThemeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getContentPane().setBackground(Color.WHITE);
				JOptionPane.showMessageDialog(mainFrame, "Switched to Light Theme");
			}
		});

		darkThemeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getContentPane().setBackground(Color.BLACK);
				JOptionPane.showMessageDialog(mainFrame, "Switched to Dark Theme");
			}
		});

		// Add menu items to the popup menu
		optionsMenu.add(lightThemeItem);
		optionsMenu.add(darkThemeItem);
		optionsMenu.add(logoutItem);


		// Add an action listener to the options button to show the popup menu
		profileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optionsMenu.show(profileButton, profileButton.getWidth(), 0);
			}
		});

		//DRAKE 
		ImageIcon drakeIcon = new ImageIcon("DRAKE.png");
		JButton drakeButton = new JButton(drakeIcon);
		drakeButton.setBounds(10, 90, drakeIcon.getIconWidth(), drakeIcon.getIconHeight());
		drakeButton.setContentAreaFilled(false);
		drakeButton.setBorderPainted(false);
		drakeButton.setFocusPainted(false);
		panel3Home.add(drakeButton);

		drakeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				list = new MusicList();
				list.setPlaylist("Drake Hits");
				MusicUniversalMethods.getSongs("TopArtistDatabase.txt",list);
				cardLayout.show(cardPanel, "Drake Hit's");				
				updateCurrentPanelLabel("Drake Hit's");


			}
		});

		JLabel drakeLabel = new JLabel("Drake Hit's");
		drakeLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		drakeLabel.setForeground(Color.WHITE);
		drakeLabel.setBounds(-110 + drakeIcon.getIconWidth(), 225, 200, 50);
		panel3Home.add(drakeLabel);







		//SCOTT
		ImageIcon scottIcon = new ImageIcon("SCOTT.png");
		JButton scottButton = new JButton(scottIcon);
		scottButton.setBounds(210, 90, scottIcon.getIconWidth(), scottIcon.getIconHeight());
		scottButton.setContentAreaFilled(false);
		scottButton.setBorderPainted(false);
		scottButton.setFocusPainted(false);
		panel3Home.add(scottButton);

		scottButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				list = new MusicList();
				list.setPlaylist("Travis Scott Hits");
				MusicUniversalMethods.getSongs("TopArtistDatabase.txt",list);
				cardLayout.show(cardPanel, "Travis Scott Hit's");
				updateCurrentPanelLabel("Travis Scott Hit's");

			}
		});


		JLabel scottLabel = new JLabel("Travis Scott Hit's");
		scottLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
		scottLabel.setForeground(Color.WHITE);
		scottLabel.setBounds(60 + scottIcon.getIconWidth(), 225, 200, 50);
		panel3Home.add(scottLabel);

		//WEEKEND
		ImageIcon weekendIcon = new ImageIcon("WEEKEND.png");
		JButton weekendButton = new JButton(weekendIcon);
		weekendButton.setBounds(410, 90, weekendIcon.getIconWidth(), weekendIcon.getIconHeight());
		weekendButton.setContentAreaFilled(false);
		weekendButton.setBorderPainted(false);
		weekendButton.setFocusPainted(false);
		panel3Home.add(weekendButton);

		weekendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				list = new MusicList();
				list.setPlaylist("The Weekend Hits");
				MusicUniversalMethods.getSongs("TopArtistDatabase.txt",list);
				cardLayout.show(cardPanel, "The Weekend Hit's");
				updateCurrentPanelLabel("The Weekend Hit's");

			}
		});


		JLabel weekendLabel = new JLabel("The Weekend Hit's");
		weekendLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
		weekendLabel.setForeground(Color.WHITE);
		weekendLabel.setBounds(265 + weekendIcon.getIconWidth(), 225, 200, 50);
		panel3Home.add(weekendLabel);



		//GRANDE
		ImageIcon grandeIcon = new ImageIcon("GRANDE.png");
		JButton grandeButton = new JButton(grandeIcon);
		grandeButton.setBounds(410, 270, grandeIcon.getIconWidth(), grandeIcon.getIconHeight());
		grandeButton.setContentAreaFilled(false);
		grandeButton.setBorderPainted(false);
		grandeButton.setFocusPainted(false);
		panel3Home.add(grandeButton);

		grandeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				list = new MusicList();
				list.setPlaylist("Ariana Grande Hits");
				MusicUniversalMethods.getSongs("TopArtistDatabase.txt",list);
				cardLayout.show(cardPanel, "Ariana Grande Hit's");
				updateCurrentPanelLabel("Ariana Grande Hit's");

			}
		});


		JLabel grandeLabel = new JLabel("Ariana Grande Hit's");
		grandeLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
		grandeLabel.setForeground(Color.WHITE);
		grandeLabel.setBounds(250 + grandeIcon.getIconWidth(), 405, 200, 50);
		panel3Home.add(grandeLabel);




		//SWIFT
		ImageIcon swiftIcon = new ImageIcon("SWIFT.png");
		JButton swiftButton = new JButton(swiftIcon);
		swiftButton.setBounds(210, 270, swiftIcon.getIconWidth(), swiftIcon.getIconHeight());
		swiftButton.setContentAreaFilled(false);
		swiftButton.setBorderPainted(false);
		swiftButton.setFocusPainted(false);
		panel3Home.add(swiftButton);

		swiftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				list = new MusicList();
				list.setPlaylist("Taylor Swift Hits");
				MusicUniversalMethods.getSongs("TopArtistDatabase.txt",list);
				cardLayout.show(cardPanel, "Taylor Swift Hit's");
				updateCurrentPanelLabel("Taylor Swift Hit's");

			}
		});


		JLabel swiftLabel = new JLabel("Taylor Swift Hit's");
		swiftLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
		swiftLabel.setForeground(Color.WHITE);
		swiftLabel.setBounds(60 + swiftIcon.getIconWidth(), 405, 200, 50);
		panel3Home.add(swiftLabel);





		//BEYONCE
		ImageIcon beeIcon = new ImageIcon("BEE.png");
		JButton beeButton = new JButton(beeIcon);
		beeButton.setBounds(10, 270, beeIcon.getIconWidth(), beeIcon.getIconHeight());
		beeButton.setContentAreaFilled(false);
		beeButton.setBorderPainted(false);
		beeButton.setFocusPainted(false);
		panel3Home.add(beeButton);

		beeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				list = new MusicList();
				list.setPlaylist("Beyonce Hits");
				MusicUniversalMethods.getSongs("TopArtistDatabase.txt",list);
				cardLayout.show(cardPanel, "Beyonce Hit's");
				updateCurrentPanelLabel("Beyonce Hit's");

			}
		});


		JLabel beeLabel = new JLabel("Beyonce Hit's");
		beeLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
		beeLabel.setForeground(Color.WHITE);
		beeLabel.setBounds(-115 + beeIcon.getIconWidth(), 405, 200, 50);
		panel3Home.add(beeLabel);


		// SEARCH PANEL

		JPanel panel3Search = new RoundedRectanglePanel(Color.GRAY);
		panel3Search.setLayout(null);

		JTextField searchBar = new JTextField();
		searchBar.setBounds(10, 10, 200, 30); // Adjust the bounds as needed
		searchBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		searchBar.setBackground(Color.LIGHT_GRAY);
		// Set placeholder text
		searchBar.setForeground(Color.GRAY);
		searchBar.setText("Search for All Available Songs Here");

		// Add FocusListener to make placeholder text disappear when the JTextField gains focus
		searchBar.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (searchBar.getText().equals("Search for All Available Songs Here")) {
					searchBar.setText("");
					searchBar.setForeground(Color.BLACK); // Change text color when typing
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (searchBar.getText().isEmpty()) {
					searchBar.setText("");
					searchBar.setForeground(Color.GRAY);
				}
			}
		});

		// Add the JTextField to the panel or frame
		panel3Search.add(searchBar);

		DefaultTableModel tableModel = new DefaultTableModel(new Object[] {"Song","Artist","Album","Duration"},0) { 
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		searchTable = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {

				return false; // Make the cells uneditable
			}
		};

		tableModel.setRowCount(0);
		list = new MusicList();
		//	(selectedValue.toString());
		MusicUniversalMethods.readSongs("TopArtistDatabase.txt",list);
		for (int i = 0; i < list.getSize(); i++) { 
			Object[] songs = {list.getList()[i].getSongName(),list.getList()[i].getArtist(),list.getList()[i].getAlbum(),list.getList()[i].getDuration()};
			tableModel.addRow(songs);
		}

		searchTable = new JTable(tableModel);
		JScrollPane tableScrollPane = new JScrollPane(searchTable);
		tableScrollPane.setBounds(10, 50, 550, 350);  // Adjust the bounds as needed
		panel3Search.add(tableScrollPane);

		// Add an empty border to create space between search bar and table
		panel3Search.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Customize the table
		customizeTable(searchTable, Color.BLACK);

		// Add the search bar to the NORTH position of the BorderLayout
		panel3Search.add(searchBar, BorderLayout.NORTH);

		// Add the table to the CENTER position of the BorderLayout
		panel3Search.add(tableScrollPane, BorderLayout.CENTER);
		// Enable sorting for the table
		TableRowSorter sorter = new TableRowSorter(tableModel);
		searchTable.setRowSorter(sorter);




		// Add a DocumentListener to the search bar for dynamic filtering
		searchBar.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateFilter();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateFilter();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateFilter();
			}

			private void updateFilter() {
				String text = searchBar.getText();
				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
		});

		// Create a 2D array to hold data
		Object[][] data = new Object[list.getList().length][4];

		// Populate the 2D array with MusicRecord1 data
		for (int i = 0; i < list.getSize(); i++) {
			if (list.getList()[i] != null) {

				data[i][0] = list.getList()[i].getSongName();
				data[i][1] = list.getList()[i].getArtist();
				data[i][2] = list.getList()[i].getAlbum();
				data[i][3] = list.getList()[i].getDuration();
			}
		}
		// Add data to the table model
		for (Object[] row : data) {
			tableModel.addRow(row);
		}

		// Add selection listener for the Weekend hits table
		searchTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				handleTableSelection(searchTable);
			}
		});

		// Create an ImageIcon from the "iconMag.png" file
		ImageIcon icon = new ImageIcon("iconMag.png");

		// Create a JLabel with the ImageIcon
		JLabel iconLabel = new JLabel(icon);

		// Set the position and size of the iconLabel
		iconLabel.setBounds(220, 10, 30, 30); // Adjust the bounds as needed

		// Add the JLabel to the panel
		panel3Search.add(iconLabel);


		// Add the table to the search panel
		panel3Search.add(tableScrollPane, BorderLayout.CENTER);
		// Add the search panel to the card panel
		cardPanel.add(panel3Home, "Home");
		cardPanel.add(panel3Search, "Search");

		// Load an ImageIcon for the back button (adjust the path accordingly)
		ImageIcon backIcon = new ImageIcon("iconBack.png");


		// Create a JButton for going back to panel3Home with the backIcon
		JButton backButton = new JButton(backIcon);
		backButton.setBounds(10, 395, backIcon.getIconWidth(), backIcon.getIconHeight()); // Adjust the bounds based on the icon size

		// Set properties to have no background and no highlight
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);

		// Add the back button to the Drake hits panel
		panel3Search.add(backButton);

		// Add ActionListener to the backButton for switching to the "Home" panel
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Home");
			}
		});

		cardLayout.show(cardPanel, "Home");

		cardPanel.setBounds(x, y, width, height);

		mainFrame.add(cardPanel);
	}










	//METHOD TO UPDATE THE CURRENT PANEL LABEL FOR THE PROGRAM TO DETMEINE LIBRARIES 


	private static void updateCurrentPanelLabel(String panelName) {
		currentPanelLabel.setText("  Panel: " + panelName);
	}


	//METHOD TO GET WHAT ROW OR SONG IS SELECTED 


	private static void handleTableSelection(JTable table) {
		try { 
			if (!table.getSelectionModel().isSelectionEmpty()) {

				int selectedRow = table.getSelectedRow();
				playWavFile(list.getList()[selectedRow].toString() + ".wav");

			}
		} catch (Exception e) { 
			JOptionPane.showMessageDialog(null, "Song could not be found within database! Check files!" ,"ERROR",JOptionPane.ERROR_MESSAGE);

		}
	}

	//METHOD TO PLAY WAV FILE

	public static void playWavFile(String fileName) {
		try {
			File file = new File(fileName);
			if (file.exists()) {
				// Stop the currently playing audio
				if (audioClip != null && audioClip.isRunning()) {
					audioClip.stop();
				}

				// Play the new audio
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
				audioClip = clip;


				currentSongLabel.setText("Playing Song: " + file.getName());

			} else {
				System.out.println("File not found: " + fileName);
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}


	//OBTAINING WHICH FILE PATH TO USE BASED ON CURRENT PANEL USER IS ON 

	//PAINT METHOD TO GIVE SHARP RECTANGLE ROUNDED EDGES 


	static class RoundedRectanglePanel extends JPanel {
		private Color bgColor;

		public RoundedRectanglePanel(Color bgColor) {
			this.bgColor = bgColor;
			setOpaque(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			int cornerRadius = 20;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(bgColor);
			g2d.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
			g2d.dispose();
		}
	}


	//MAIN METHOD 
	public static void main(String[] args) {
		Regular r = null;
		Profile p = new Profile();
		p.processRecord("Thanush/Thanush@123/Thanush@gmail.com/Thanush/Supramaniam");
		new Main_Menu(new Premium(),r, p);
	}
}
