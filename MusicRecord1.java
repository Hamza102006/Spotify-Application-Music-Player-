/**
 * 
 */

/**
 * @author Rudra Patel & Thanush
 * Date: Jan. 2024
 * Description: An object that holds import song related information. Functions like a song.
 * 
 * /**
 * Method List:
 * 1. Constructor: public MusicRecord1()
 *    - Initializes a MusicRecord1 with default values.
 * 2. Constructor: public MusicRecord1(String name, String artist, String album, int duration)
 *    - Initializes a MusicRecord1 with specified values.
 * 3. Method: public String toString()
 *    - Returns a String representation of the MusicRecord1.
 * 4. Method: public void processRecord(String record)
 *    - Processes a formatted record String to set the attributes of the MusicRecord1.
 * 5. Getter: public String getAlbum()
 *    - Returns the album of the MusicRecord1.
 * 6. Setter: public void setAlbum(String album)
 *    - Sets the album of the MusicRecord1.
 * 7. Getter: public String getSongName()
 *    - Returns the song name of the MusicRecord1.
 * 8. Setter: public void setSongName(String songName)
 *    - Sets the song name of the MusicRecord1.
 * 9. Getter: public String getArtist()
 *    - Returns the artist of the MusicRecord1.
 * 10. Setter: public void setArtist(String artist)
 *     - Sets the artist of the MusicRecord1.
 * 11. Getter: public int getDuration()
 *     - Returns the duration of the MusicRecord1.
 * 12. Setter: public void setDuration(int duration)
 *     - Sets the duration of the MusicRecord1.
 * 13. Main Method: public static void main(String[] args)
 *     - Example usage of the MusicRecord1 class for testing.
 */
 
public class MusicRecord1 {

	/**
	 * Private instances/variables
	 */
	private String album;
	private String songName;
	private String artist;
	private int duration;

	/**
	 * 
	 */
	public MusicRecord1() {
		//Initialize the attributes
		this.album = "";
		this.songName = "";
		this.artist = "";
		this.duration = 0;
	}
	
	public MusicRecord1(String name, String artist, String album, int duration) { 
		this.album = album;
		this.songName = name;
		this.artist = artist;
		this.duration = duration;
	}

	/**
	 * String representation of the Object
	 */
	public String toString() {
		return songName + "_" + artist + "_"  + album + "_" + duration;
	}

	public void processRecord (String record) {
		String word[];
		word = record .split("_");
		this.songName = word[0];
		this.artist = word[1];
		this.album= word[2];
		this.duration = Integer.parseInt(word[3]);
		
	}

	/**
	 * @return the album
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	/**
	 * @return the songName
	 */
	public String getSongName() {
		return songName;
	}

	/**
	 * @param songName the songName to set
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create an object based on a record
		String rec = "Time Flies_Drake_Dark Lane Demo Tapes_180";


		//create an object
		MusicRecord1 sInfo = new MusicRecord1();

		//test the toString
		System.out.println(sInfo.toString());

		// process the record
		sInfo.processRecord(rec);

		//Display 
		System.out.println(sInfo.toString());

	}

}
