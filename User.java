import java.awt.Color;
import java.util.UUID;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author S. Thanush
 * Date: Jan. 2024
 * Description: Class that uses profile class and has other instances (profile picture)
 * THIS CLASS HAS BEEN CORRUPTED THROUGH ONE DRIVE SYNC/THUS CODE HAS BEEN ALTERED AND SOME FUNCTIONALITIES OF PROGRAM HAVE BEEN LOST
 * User Class
 *
 * Constructors:
 * 1. Default Constructor: User()
 *    - Initializes a User object with a default Profile instance.
 *
 * 2. Overloaded Constructor: User(Profile profile)
 *    - Initializes a User object with a specified Profile instance.
 *
 * Methods:
 * 3. Profile getProfile()
 *    - Getter method to retrieve the profile associated with the User.
 *
 * 4. void setprofile(Profile profile)
 *    - Setter method to set the profile for the User.
 *
 * 5. void main(String[] args)
 *    - Main method for testing the default and overloaded constructors, as well as the methods.
 */

public class User {
	/**
	 * Private Instances/Variables
	 */
	private Profile profile;
	

	//Default Constructor
	public User() {
		this.profile = new Profile();
	}
	
	//Overloaded Constructor
	public User (Profile profile) { 
		this.profile = profile;
	}

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setprofile(Profile profile) {
		this.profile = profile;
	}

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        // Test default constructor and methods
        User userDefault = new User();
        System.out.println("Default Constructor Output:");
        System.out.println("profile Profile: " + userDefault.getProfile().toString());
        
        // Test overloaded constructor and getters
        Profile profile = new Profile("Tony123/BankAcoount1!/tonycampos55@gmail.com/Tony/Campos");
        User userOverloaded = new User(profile);
        System.out.println("\nOverloaded Constructor Output:");
        System.out.println("profile Profile: " + userOverloaded.getProfile().toString());

	}

}
