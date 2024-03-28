

/**
 *
 */

/**
 * @author S. Thanush
 * Date: Dec. 2023
 * Description: Represents a record for user of Spotify.
 * THIS CLASS HAS BEEN CORRUPTED THROUGH ONE DRIVE SYNC/THUS CODE SOME HAS BEEN LSOT AND SOME FUNCTIONALITIES OF PROGRAM HAVE BEEN LOST
 * 
 * Method List:
 * public Profile() - Default constructor
 * public Profile(String username, String password, String firstName, String lastName, String address, long phone, int sin) - Overload Constructor
 * public String getUsername() - getters for Profile info variables
 * public String toString() - method to represent object in string
 * public void processRecord (String record) - process the data in the object
 * public static void main (String args[]) - self-testing main
 *
 *
 */
public class Profile
{

	/*
	 * Private Instances/Variables.
	 */
	private String username;
	private String email;
	private String password;
	private String firstName;
	private String lastName;


	public Profile()  // default constructor to initialize data
	{
		// intializes the data
		this.username = "";
		this.password = "";
		this.email = "";
		this.firstName = "";
		this.lastName = "";
	}

	//Overloaded Constructor initializes the client information with specific information.
	public Profile(String info)  
	{
		processRecord(info);
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Converts object info into string
	 */
	public String toString() {
		return username + "/" + password + "/" + email + "/" + firstName + "/" + lastName;
	}

	/**
	 * Method to process record in this format (Username/Password/Email/FirstName/LastName <- MIGHT REMOVE
	 *
	 */
	public void processRecord (String record) {
		String word[];
		word = record .split("/");
		this.username = word[0];
		this.password = word[1];
		this.email = word[2];
		this.firstName = word[3];
		this.lastName = word[4];

	}
	//self-testing main
	public static void main (String args[])
	{
		  // Test default constructor
        Profile defaultProfile = new Profile();
        System.out.println("Default Constructor Output: " + defaultProfile.toString());

        // Test overloaded constructor
        String record = "Tony123/BankAcoount1!/tonycampos55@gmail.com/Tony/Campos";
        Profile overloadedProfile = new Profile(record);
        System.out.println("Overloaded Constructor Output: " + overloadedProfile.toString());

        // Test setters
        overloadedProfile.setUsername("Rudra123");
        overloadedProfile.setPassword("Patel!");
        overloadedProfile.setEmail("rudrapatel1@gmail.com");
        overloadedProfile.setFirstName("Rudra");
        overloadedProfile.setLastName("Patel");

        System.out.println("After Setter Methods: " + overloadedProfile.toString());

        // Test getters
        System.out.println("Username: " + overloadedProfile.getUsername());
        System.out.println("Password: " + overloadedProfile.getPassword());
        System.out.println("Email: " + overloadedProfile.getEmail());
        System.out.println("First Name: " + overloadedProfile.getFirstName());
        System.out.println("Last Name: " + overloadedProfile.getLastName());

        // Test processRecord method
        Profile processRecordProfile = new Profile();
        processRecordProfile.processRecord("Alice123/Password123/alice@example.com/Alice/Johnson");
        System.out.println("After Process Record Method: " + processRecordProfile.toString());

	}



}