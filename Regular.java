/**
 * 
 */

import javax.swing.ImageIcon;


/**
 * @author S. Thanush
 * Date: Jan. 2024
 * Description: Regular account object that inherits from user.
 * 
 * /**
 * Regular Class
 *
 * Constructors:
 * 1. Default Constructor: Regular()
 *    - Initializes a Regular account with default values.
 *    - Calls the default constructor of the superclass (User).
 *
 * 2. Overloaded Constructor: Regular(Profile profile, int skips)
 *    - Initializes a Regular account with the provided Profile and skips.
 *    - Calls the overloaded constructor of the superclass (User) with the given Profile.
 *    - Sets the skips variable based on the provided parameter.
 *
 * Methods:
 * 3. void setSkips(int skips)
 *    - Setter method for the skips variable.
 *    - Updates the number of skips for the Regular account.
 *
 * 4. int getSkips()
 *    - Getter method for the skips variable.
 *    - Returns the number of skips for the Regular account.
 *
 * 5. boolean checkSkips()
 *    - Checks if the number of skips is less than the maximum allowed.
 *    - Returns true if the user can still skip songs; otherwise, returns false.
 */
public class Regular extends User {

	/**
	 * Private Instances/Variables
	 */
	private final boolean unlimitedSkips = false;
	private final int maxSkips = 6;
	private int skips; 
	
	//Default Constructor
	public Regular() {
		super();
		this.skips = 0;
	}

	//Overloaded Constructor
	public Regular (Profile c, int skips) { 
		super(c);
		this.skips = skips;
	}

	//skips variable setter
	public void setSkips (int skips) { 
		this.skips = skips;
	}

	//skips variable getter
	public int getSkips() { 
		return this.skips;
	}

	//Checks to see if the number of times the user has skipped is less than the max
	//amount they can do
	public boolean checkSkips () { 
		if (this.skips < this.maxSkips) { 
			return true;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        // Test constructor and getters
        Regular testRegular = new Regular();
        System.out.println("Skips: " + testRegular.getSkips());

        // Test setters
        testRegular.setSkips(3);
        System.out.println("Updated Skips: " + testRegular.getSkips());


        // Test checkSkips method
        if (testRegular.checkSkips()) {
            System.out.println("User can still skip songs.");
        } else {
            System.out.println("User has reached the maximum number of skips.");
        }


	}

}
