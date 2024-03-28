import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Rudra Patel & Thanush
 * Date: Jan. 2024
 * Description: A list that holds an array of MusicRecord objects. Functions like a Playlist.
 *
 *
 * Method List:
 * 1. Constructor: public MusicList()
 *    - Initializes a MusicList with default values.
 * 2. Constructor: public MusicList(int maxSize, String name)
 *    - Initializes a MusicList with a specified max size and playlist name.
 * 3. Getter: public int getMaxSize()
 *    - Returns the max size of the MusicList.
 * 4. Setter: public void setMaxSize(int maxSize)
 *    - Sets the max size of the MusicList.
 * 5. Getter: public String getPlaylist()
 *    - Returns the name of the playlist.
 * 6. Setter: public void setPlaylist(String playlistName)
 *    - Sets the name of the playlist.
 * 7. Setter: public void setList(MusicRecord1[] list)
 *    - Sets the array of MusicRecord1 objects in the MusicList.
 * 8. Setter: public void setSize(int size)
 *    - Sets the size of the MusicList.
 * 9. Getter: public MusicRecord1[] getList()
 *    - Returns the array of MusicRecord1 objects.
 * 10. Getter: public int getSize()
 *    - Returns the current size of the MusicList.
 * 11. Method: public boolean insert(MusicRecord1 record)
 *    - Inserts a MusicRecord1 into the MusicList.
 * 12. Method: public boolean delete(MusicRecord1 record)
 *    - Deletes a MusicRecord1 from the MusicList.
 * 13. Method: public String toString()
 *    - Returns a String representation of the MusicList.
 * 14. Method: public void bubbleSort()
 *    - Sorts the MusicList in alphabetical order using the bubble sort algorithm.
 * 15. Method: public int binarySearch(String searchKey)
 *    - Performs a binary search on the sorted MusicList.
 * 16. Main Method: public static void main(String[] args)
 *    - Example usage of the MusicList class for testing.
 */


public class MusicList {

	private MusicRecord1 [] list;
	private int maxSize; 			//the maximum number of records the list can hold
	private int size;				// the actual usable size of actual object
	private String playlist;
	/**
	 * 
	 */
	public MusicList() {
		// Initialize attributes
		this.maxSize = 10;
		this.size = 0;
		this.list = new MusicRecord1[maxSize];
		this.playlist = "";
	}
	
	public MusicList(int maxSize,String name) {
		this.maxSize = maxSize;
		this.size = 0;
		this.list = new MusicRecord1 [maxSize];
		this.playlist = name;
	}

	
	
	/**
	 * @return the maxSize
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * @param maxSize the maxSize to set
	 */
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * @return the playlistName
	 */
	public String getPlaylist() {
		return playlist;
	}

	/**
	 * @param playlistName the playlistName to set
	 */
	public void setPlaylist(String playlistName) {
		this.playlist = playlistName;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(MusicRecord1[] list) {
		this.list = list;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the list
	 */
	public MusicRecord1[] getList() {
		return list;
	}


	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Method to insert a record into the list
	 * check if the size is below the maxSize
	 * If so, increases the size by 1
	 * and adds the record to the location just below the size
	 * returns true if successful
	 */
	public boolean insert(MusicRecord1 record) {
	    // Check if the size is below the current max size
	    if (size < maxSize) {
	        // If there is space, increase the size by 1 and insert the record
	        size++;
	        list[size - 1] = record;
	        return true;
	    } else {
	        // If the current max size is reached, increase the max size
	        int newMaxSize = maxSize + 1;

	        // Create a new array with the increased size
	        MusicRecord1[] newList = new MusicRecord1[newMaxSize];

	        // Copy existing records to the new array
	        for (int i = 0; i < size; i++) {
	            newList[i] = list[i];
	        }

	        // Initialize the new elements in the list
	        for (int i = size; i < newMaxSize; i++) {
	            newList[i] = null;
	        }

	        // Update the list reference to point to the new array
	        list = newList;

	        // Increase the size by 1 and insert the new record
	        size++;
	        list[size - 1] = record;

	        // Update the max size to the new size
	        maxSize = newMaxSize;

	        return true;
	    }
	}


	/*
	 * method to delete
	 * loops through the list
	 * if it finds the record,
	 *
	 * deletes it by
	 * replacing the record to be deleted
	 * with the last record of the list
	 * and
	 * decreases size by 1
	 */
	public boolean delete (MusicRecord1 record){
		for (int i = 0; i < this.getSize(); i++) {
			if (this.list[i].getSongName().equalsIgnoreCase(record.getSongName())) {
				list[i] = list[size-1];
				size--;
				return true; // found the record
			}
		}
		return false; // reached the end of the list without finding the record
	}


	// Method to represent the List as a String.
	public String toString() {
		String theList = "";
		for (int i = 0; i < this.getSize(); i++){
			theList = theList + "Record " + i + " " + list[i].toString() +"\n";
		} 
		return theList;
	}


	/**
	 * The bubbleSort method to sort by name in alpha order
	 */
	public void bubbleSort() {
		// loop to control how many times we pass through the list
		for(int i = 0; i < size; i++) {
			//loop to compare each element to the next
			for(int j = 0; j < size - 1; j++) {
				//compare to check if they are alpha order
				if (list[j].getSongName().compareTo(list[j+1].getSongName()) > 0) {
					//out of alpha order for student names
					MusicRecord1 temp; //temporary variable for the swapping

					//swap the elements
					temp = list[j];
					list[j] = list [j+1];
					list[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * Binary search method
	 * searches for a name
	 * assumes that the list is sorted in alpha order
	 */
	public int  binarySearch(String searchKey) {
		int low = 0;
		int high = size - 1;
		int middle;
		
		//while low is below the high value
		while (low <= high) {
			middle = (high + low) / 2;
			
			//check if the middle element is the one we are looking for
			if (searchKey.compareToIgnoreCase(list[middle].getSongName()) == 0) {
				// found it!
				return middle;
			}
			else if (searchKey.compareToIgnoreCase(list[middle].getSongName()) < 0) { //lower in the alpha 0 to middle
				high = middle - 1; // chnage the high end of the list 
			}
			else { //higher in the alpha middle to high
				low = middle + 1; //change the low end of the list
			}
		}
		return - 1; //could not find searchKey
	}


	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MusicList students = new MusicList(); // create the record object

		// loop forever
		while (true){
			// get the first char of the command
			char command = JOptionPane.showInputDialog(null,
					"enter i - insert a song\n" +
							"enter p - to print the list\n" +
							"enter d - to delete a song\n"+
							"enter s - to sort by alpha order\n"+
							"enter b - Binary Search\n"+
							"enter q - quit", "i").charAt(0);

			if (command == 'q'){
				break;
			}

			switch (command){
			case 'i':{
				String record = JOptionPane.showInputDialog(null,
						"Enter <song name,artist,album,duration>",
						"Time Flies_Drake_Dark Demo_180");
				MusicRecord1 sInfo = new MusicRecord1(); // create a StudentRecord
				sInfo.processRecord(record); // process the record
				if (students.insert(sInfo)){ // insert the record
					// added
					JOptionPane.showMessageDialog(null,"Insert successful");
				}
				else {
					// not added
					JOptionPane.showMessageDialog(null,"Insert NOT successful");
				}
				break;
			}
			case 'p':{
				JOptionPane.showMessageDialog(null, students.toString());
				break;
			}
			case 'd':{
				String record = JOptionPane.showInputDialog(null,
						"Enter <song name,artist,album,duration>",
						"Time Flies_Drake_Dark Demo_180");
				MusicRecord1 sInfo = new MusicRecord1();
				sInfo.processRecord(record);
				if (students.delete(sInfo)){
					JOptionPane.showMessageDialog(null, "Record deleted");
				}
				else {
					JOptionPane.showMessageDialog(null, "Record not found");
				}
				break;
			}
			default :{
				JOptionPane.showMessageDialog(null, "Invalid Command");
			}
			
			case 's':{
				students.bubbleSort();
				break;
			}
			case 'b':{
				String nameToFind = JOptionPane.showInputDialog(null, "Enter a name to find", "Time Flies");
				
				int location = students.binarySearch(nameToFind);
				
				//check if it is found
				if (location >= 0) {
					JOptionPane.showMessageDialog(null, nameToFind + " Found!");
					}
				else {
					JOptionPane.showMessageDialog(null,  nameToFind + " NOT found!");
				}
				break;
			}
			}// switch
		}// while true

	}

}
