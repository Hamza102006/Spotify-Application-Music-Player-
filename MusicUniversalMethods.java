import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.swing.table.DefaultTableModel;

/**
 * 
 */

/**
 * @author Thanush
 * Date: Jan. 2024
 * Description: Class that holds all methods that are used universally.
 * THIS CLASS HAS BEEN CORRUPTED THROUGH ONE DRIVE SYNC/THUS CODE SOME HAS BEEN LSOT AND SOME FUNCTIONALITIES OF PROGRAM HAVE BEEN LOST
 * Method List:
 * 1. Method: public static void openAccount(int location, Profile profile, String filename)
 *    - Opens an "information" file, processes information into a Profile object, and sets the profile.
 * 2. Method: public static int check(String check, int index, String fileName)
 *    - Checks if customer-entered information exists in a "database" file and returns the location if found.
 * 3. Method: public static int checkPassword(String password, int location, String filename)
 *    - Checks if the entered password matches the password at a specified location in a file.
 * 4. Method: public static int checkLogin(String username, String password, String filename)
 *    - Checks if the entered username and password are found in an "information" file and returns the location if found.
 * 5. Method: public static boolean getPlaylist(String file, DefaultTableModel table)
 *    - Reads playlists from a user's "database file" and adds them to a DefaultTableModel.
 * 6. Method: public static int fileSize(String fileName)
 *    - Calculates the number of lines before a file reaches EOF.
 * 7. Method: public static boolean getSongs(String file, MusicList list)
 *    - Reads songs from a file and adds them to a MusicList.
 * 8. Method: public static void updateSongs(MusicList list, String filename)
 *    - Updates the songs section in the user's "database file" with the current MusicList.
 * 9. Method: public static void updatePlaylist(boolean delete, String filename, String playlist)
 *    - Updates the playlist section in the user's "database file" based on the specified action.
 * 10. Method: public static void writeFile(String info, String fileName)
 *     - Writes information into a file.
 * 11. Method: public static void addSongs(File file, MusicList list, DefaultTableModel table)
 *     - Adds songs to a MusicList and updates the table in a DefaultTableModel.
 * 12. Method: public static void readSongs(String file, MusicList list)
 *     - Reads songs from a file and adds them to a MusicList.
 * 13. Main Method: public static void main(String[] args)
 *     - Entry point for the MusicUniversalMethods class.
 */
public class MusicUniversalMethods {

	//Method to open all "information" files and process that information
	//into objects accordingly. In short, open the user's account.
	public static void openAccount(int location, Profile profile, String filename) { 
		try {

			//Opens file to be read
			BufferedReader input = new BufferedReader(new FileReader (filename));
			//skips every line and stops right before the location
			for (int i = 0; i < location; i++) { 
				input.readLine();		
			}
			//reads and processes info
			profile.processRecord(input.readLine());
			//closes file
			input.close();		

			//catches error
		}catch (IOException e) { 
			e.printStackTrace();
		}
	}

	//Method to check if customer entered information already exists within "database"
	//returns location with CustomerList.txt file if found, else returns -1 if not found
	public static int check (String check, int index, String fileName) { 
		try {
			//gets file size from filesize method
			int size = fileSize(fileName);

			//opens file to be read
			BufferedReader input2 = new BufferedReader(new FileReader(fileName));
			//for loop that checks to see if the user entered info already exists within
			//"database", if yes it will return location, if not, it will return -1.
			for (int i = 0; i < size; i++) { 
				//splits info into array
				String info[] = input2.readLine().split("/");

				//hard coded to wear index 0 is username , index 1 is password,... etc
				if (check.equals(info[index])) { 
					//System.out.println(check + " " + info[index] + " \nLocation" + i);
					return i;
				}
			}
			//closes file
			input2.close();
			return -1;
			//catches error
		} catch (IOException e) {
			return -1;
		}
	}
	
	
	//Method to check if password at certain line of code is the same as user entered
	//password (seperate method required due to possible chance of multiple users with the 
	//same password)
	public static int checkPassword (String password, int location, String filename) { 
		try  { 
			
			//opens file to be read
			BufferedReader input = new BufferedReader(new FileReader(filename));
			
			//skips every line right before the location
			for (int i = 0; i < location; i++) { 
				input.readLine();
			}
			
			//splits that info into an array
			String check[] = input.readLine().split("/");
			//closes file
			input.close();
			//hard coded to wear index 1 is password, and checks
			//to see if use entered password is the same, returns original
			//location value if true,if false returns -1.
			if (password.equals(check[1]))  { 
				return location;
			}
			return -1;
			//catches error
		} catch (IOException e) { 
			return -1;
		}
	}

	//Checks if entered username and password is found within "information" held files using check methods
	//Returns location within file if found, else, returns -1;
	public static int checkLogin (String username, String password,String filename) { 
		
		//gets location of username within file
		int location = check(username,0, filename);
		//gets location of password within file
		int location2 = checkPassword(password,location,filename);
		
		//if username and password location are the same and are greater than -1 
		//meaning they exist within the file, it will return the location of its
		//info
		if ((location == location2) && location > -1 && location2 > -1) { 
			return location;
		}
		
		//else,it will return -1
		return -1;
	}

	//Method that gets the playlists from the user's "database file"
	public static boolean getPlaylist (String file, DefaultTableModel table) { 

		try { 
			int size = fileSize(file);

			//System.out.println(size);
			BufferedReader input2 = new BufferedReader(new FileReader(file));

			for (int i = 0; i < size; i++) {
				String temp = input2.readLine();
				if (temp.equalsIgnoreCase("!@#$%")) { 
					Object[] playlist = {input2.readLine()};
					table.addRow(playlist);
				}
				else if (temp.equalsIgnoreCase("EOF")) { 
					break;
				}
			}
			input2.close();		
			return true;

		} catch (FileNotFoundException e) { 
			return false;
		}
		catch (Exception e) { 
			e.printStackTrace();
			return false;
		}
	}


	//Method to calculate the number of lines before file reaches EOF.
	//Returns size if file can be found, or -1 if it cant be found.
	public static int fileSize (String fileName) { 
		try {
			//open the file in fileName to read
			BufferedReader input = new BufferedReader(new FileReader (fileName));
			int size = 0;
			//finds max size of record list 
			while (!input.readLine().equalsIgnoreCase("EOF")) { 
				size++;
			}
			//closes file
			input.close();

			//returns size of file
			return size;

		} catch (IOException e) { 
			return -1;
		}
	}

	public static boolean getSongs(String file, MusicList list) {
	    try (BufferedReader input = new BufferedReader(new FileReader(file))) {
	        int size = fileSize(file);
	        String line;

	        while ((line = input.readLine()) != null) {
	            System.out.println(line);

	            if ("!@#$%".equals(line)) {
	                if ((line = input.readLine()) != null && list.getPlaylist().equals(line)) {
	                    for (int j = 0; j < size; j++) {
	                        String song = input.readLine();

	                        if (song != null && !("!@#$%".equalsIgnoreCase(song)) && !("EOF".equalsIgnoreCase(song))) {
	                            System.out.println(song);
	                            MusicRecord1 temp = new MusicRecord1();
	                            temp.processRecord(song);
	                            list.insert(temp);
	                        } else {
	                            break;
	                        }
	                    }
	                    break;
	                }
	            }
	        }
	        return true;
	    } catch (FileNotFoundException e) {
	        return false;
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return false;
	}


	public static void updateSongs(MusicList list, String filename) {
		try {
			// Read the content of the file
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String info = "";
			String line;

			// Find the playlist section and update it
			while ((line = br.readLine()) != null && !(line.equals("EOF"))) {

				if (line.equals("!@#$%")) {
					// Playlist section begins
					line = br.readLine(); // Read playlist name
					if (line.equals(list.getPlaylist())) {
						// Playlist found, update it
						info += "!@#$%\n" + line + "\n"; // Add playlist name

						for (int i = 0; i < list.getSize();i++) { 
							info += list.getList()[i].toString() + "\n";
						}
						// Read and append existing songs
						while ((line = br.readLine()) != null) {
							if (line.equals("!@#$%")) { 
								info += line + "\n";
								break;
							}
						}
					} 
					else {
						// Playlist not found, add existing lines as they are
						info += "!@#$%\n"  + line + "\n";
					}
				}
				else {
					info += line + "\n"; // Add playlist name
				}
			} 
			info += "EOF";

			// Close the reader
			br.close();

			// Write the modified content back to the file
			writeFile(info,filename);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void updatePlaylist(boolean delete,String filename, String playlist) { 
		try {
			// Read the content of the file
			BufferedReader input = new BufferedReader(new FileReader(filename));
			String info = "";
			int size = fileSize(filename);

			if (delete) { 
				String line = "";
				while ((line = input.readLine()) != null && !(line.equals("EOF"))) {
					System.out.println(info);
					if (line.equals("!@#$%")) {

						if ((line = input.readLine()).equals(playlist)) {
							while ((line = input.readLine()) != null && !(line.equals("!@#$%") && !(line.equals("EOF")))) { 
							}
							if (line != null) {
								if (line.equals("!@#$%")) { 
									info += line + "\n";
								}
							}
						}
						else { 
							info += "!@#$%\n" + line + "\n";
						}
					}
					else { 
						info += line + "\n";
					}
				}
				info += "EOF";
			}

			else { 
				for (int i = 0; i < size; i++) { 
					info += input.readLine() + "\n";
				}
				info += "!@#$%\n" + playlist + "\nEOF";
			}
			System.out.println(info);
			writeFile(info,filename);

		} catch (IOException e) { 
			e.printStackTrace();
		}

	}




	//Method that writes information into a file
	public static void writeFile (String info, String fileName) { 
		try  { 
			//creates new file to write to
			PrintWriter wFile = new PrintWriter(new FileWriter(fileName));
			//writes info into file
			wFile.print(info);
			//closes file
			wFile.close();
			//catches error
		} catch (IOException e) { 

		}
	}

	public static void addSongs (File file,MusicList list, DefaultTableModel table) { 
		MusicRecord1 temp = new MusicRecord1();
		temp.processRecord(file.getName().split(".wav")[0]);
		list.insert(temp);
		table.setRowCount(0);
		for (int i = 0; i < list.getSize(); i++) { 
			Object[] songs = {list.getList()[i].getSongName(),list.getList()[i].getArtist(),list.getList()[i].getAlbum(),list.getList()[i].getDuration()};
			table.addRow(songs);
		}
	}
	
    public static void readSongs(String file,MusicList list) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.equals("!@#$%")) {  // Skip playlist names and separators
                    String[] songData = line.split("_");
                    if (songData.length == 4) {
                        MusicRecord1 temp = new MusicRecord1(songData[0], songData[1], songData[2], Integer.parseInt(songData[3]));
                        list.insert(temp);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();  // Handle exceptions appropriately in your application
        }

    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
