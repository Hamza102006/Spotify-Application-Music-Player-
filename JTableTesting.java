import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/*
 * @author S. Thanush
 * Date: Jan. 2024
 * Description: A Self-Testing class that tests most to nearly all universal methods.
 * THIS CLASS HAS BEEN CORRUPTED THROUGH ONE DRIVE SYNC/THUS CODE SOME HAS BEEN LSOT AND SOME FUNCTIONALITIES OF PROGRAM HAVE BEEN LOST
 * 
 *
 * Method List:
 *
 * 1. JTableTesting() - Constructor that creates two frames for playlists and songs.
 *    - Initializes and sets up the frames, JTables, and buttons for managing playlists and songs.
 *
 * 2. actionPerformed(ActionEvent e) - Action performed when a button is clicked.
 *    - Handles the action events, such as adding or deleting songs and playlists.
 *
 * 3. main(String[] args) - Main method to create an instance of the JTableTesting class.
 *    - Entry point for running the JTableTesting application.
 */


public class JTableTesting extends JFrame implements ActionListener {

    private MusicList musicList;
    private DefaultTableModel playlistTableModel, songTableModel;
    private JTable playlistTable, songTable;
    private JButton addSongButton, deleteSongButton;
    private JButton addPlaylistButton, deletePlaylistButton;
    private JFrame songFrame;
    private boolean deleteSong;
    private boolean deletePlaylist;

    // Constructor that creates the two frames
    public JTableTesting() {
        // Another frame for the songs to be displayed
        songFrame = new JFrame();
        musicList = new MusicList();

        // Create the table model with column names for playlists
        playlistTableModel = new DefaultTableModel(new Object[]{"Playlist"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // All cells are not editable
                return false;
            }
        };

        // Create the table model with column names for songs
        songTableModel = new DefaultTableModel(new Object[]{"Song", "Artist", "Album", "Duration"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // All cells are not editable
                return false;
            }
        };

        deleteSong = false;
        deletePlaylist = false;

        // Create the JTable with the table model for playlists
        playlistTable = new JTable(playlistTableModel);

        // Create the JTable with the table model for songs
        songTable = new JTable(songTableModel);

        // Create a JScrollPane to hold the JTable for playlists
        JScrollPane playlistScrollPane = new JScrollPane(playlistTable);

        // Create a JScrollPane to hold the JTable for songs
        JScrollPane songScrollPane = new JScrollPane(songTable);

        // Add components to the frame for playlists
        add(playlistScrollPane, BorderLayout.CENTER);

        // Add components to the frame for songs
        songFrame.add(songScrollPane, BorderLayout.CENTER);

        // Add buttons to add and delete playlists
        addPlaylistButton = new JButton("New Playlist");
        deletePlaylistButton = new JButton("Delete Playlist");

        // Panel for playlist buttons
        JPanel playlistButtonPanel = new JPanel();
        playlistButtonPanel.add(addPlaylistButton);
        playlistButtonPanel.add(deletePlaylistButton);
        add(playlistButtonPanel, BorderLayout.SOUTH);

        // Add buttons to add and delete songs
        addSongButton = new JButton("Add Song");
        deleteSongButton = new JButton("Delete Song");

        // Panel for song buttons
        JPanel songButtonPanel = new JPanel();
        songButtonPanel.add(addSongButton);
        songButtonPanel.add(deleteSongButton);
        songFrame.add(songButtonPanel, BorderLayout.SOUTH);

        // Get playlists from the file
        MusicUniversalMethods.getPlaylist("test.txt", playlistTableModel);

        // Adds listener to the JTable based on what row is selected for playlists
        playlistTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    deleteSong = false;
                    int selectedRow = playlistTable.getSelectedRow();
                    if (selectedRow != -1) {
                        // Assuming the first column contains the string you want to retrieve
                        musicList.setPlaylist(playlistTableModel.getValueAt(selectedRow, 0).toString());

                        if (deletePlaylist) {
                            // Display a confirmation dialog before deleting the playlist
                            int option = JOptionPane.showOptionDialog(songFrame,
                                    "Are you sure you want to delete the playlist: " + musicList.getPlaylist() + "?",
                                    "DELETE", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);

                            if (option == 0) {
                                playlistTableModel.removeRow(selectedRow);
                                songTableModel.setRowCount(0);
                                MusicUniversalMethods.updatePlaylist(true, "test.txt", musicList.getPlaylist());
                                musicList = new MusicList();
                            }
                            deletePlaylist = false;
                        } else {
                            // Display songs in the selected playlist
                            songTableModel.setRowCount(0);
                            musicList = new MusicList();
                            musicList.setPlaylist(playlistTableModel.getValueAt(selectedRow, 0).toString());
                            MusicUniversalMethods.getSongs("test.txt", musicList);

                            for (int i = 0; i < musicList.getSize(); i++) {
                                Object[] songs = {musicList.getList()[i].getSongName(), musicList.getList()[i].getArtist(),
                                        musicList.getList()[i].getAlbum(), musicList.getList()[i].getDuration()};
                                songTableModel.addRow(songs);
                            }
                        }
                    }
                }
            }
        });

        // Adds listener to the Jtable based on what row is selected for songs
        songTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    if (!e.getValueIsAdjusting()) {
                        deletePlaylist = false;
                        int selectedRow = songTable.getSelectedRow();
                        if (selectedRow != -1) {
                            String song = musicList.getList()[selectedRow].getSongName().toString();
                            String artist = musicList.getList()[selectedRow].getArtist().toString();
                            String album = musicList.getList()[selectedRow].getAlbum().toString();
                            int duration = musicList.getList()[selectedRow].getDuration();

                            MusicRecord1 temp = new MusicRecord1(song, artist, album, duration);
                            if (deleteSong) {
                                // Display a confirmation dialog before deleting the song
                                int option = JOptionPane.showOptionDialog(songFrame,
                                        "Are you sure you want to delete the song:\n" + song + " by " + artist + "?",
                                        "DELETE", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);

                                if (option == 0) {
                                    songTableModel.removeRow(selectedRow);
                                    musicList.delete(temp);
                                    MusicUniversalMethods.updateSongs(musicList, "test.txt");
                                }
                                deleteSong = false;
                            } else {
                                // You may want to implement this functionality
                                // Main_Menu.play(temp.toString() + ".wav");
                            }
                            songTable.removeRowSelectionInterval(selectedRow, 0);
                        }
                    }
                } catch (Exception error) {
                    // Handle the exception, if any
                }
            }
        });

        // Add actionListener to buttons
        addSongButton.addActionListener(this);
        deleteSongButton.addActionListener(this);
        addPlaylistButton.addActionListener(this);
        deletePlaylistButton.addActionListener(this);

        // Set playlist frame properties
        setTitle("Music Playlist");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);

        // Set song frames properties
        songFrame.setTitle("Songs");
        songFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        songFrame.setLocationRelativeTo(null); // Center the frame
        songFrame.setVisible(true);
        songFrame.pack();

        // Disable column reordering
        songTable.getTableHeader().setReorderingAllowed(false);
        playlistTable.getTableHeader().setReorderingAllowed(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addSongButton) {
            // Prompt the user to select a song file
            JOptionPane.showMessageDialog(songFrame, "The songs you add to the file must be in this format:\n" +
                    "(Song Name/Artist/Album/Duration in seconds)\n" +
                    "If not in this format, song addition will be unsuccessful!");

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Song Files", "wav");
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null); // select file to open
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                MusicUniversalMethods.addSongs(file, musicList, songTableModel);
                MusicUniversalMethods.updateSongs(musicList, "test.txt");
            }
        }

        if (e.getSource() == deleteSongButton) {
            // Set the flag to indicate that a song should be deleted
            deleteSong = true;
            JOptionPane.showMessageDialog(songFrame, "Click the song you want to delete!\n" +
                    "If a song is deleted while playing, it will continue playing till the end!");
        }

        if (e.getSource() == addPlaylistButton) {
            try {
                String playlistName = JOptionPane.showInputDialog("Enter the name of your new Playlist!");
                if (playlistName == null || playlistName.trim().isEmpty()) {
                    // Show an error message if the playlist name is empty
                    JOptionPane.showMessageDialog(this, "ERROR! Please enter something for your new playlist!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Add a new playlist to the table
                    Object[] playlist = {playlistName};
                    playlistTableModel.addRow(playlist);
                    MusicUniversalMethods.updatePlaylist(false, "test.txt", playlistName);
                }
            } catch (NullPointerException error) {
                // Handle null pointer exception, if any
            }
        }

        if (e.getSource() == deletePlaylistButton) {
            // Set the flag to indicate that a playlist should be deleted
            deletePlaylist = true;
            JOptionPane.showMessageDialog(this, "Click the playlist you want to delete!\n" +
                    "If a playlist is deleted while a song is playing, it will continue playing till the end!");
        }
    }

    public static void main(String[] args) {
        new JTableTesting();
    }
}
