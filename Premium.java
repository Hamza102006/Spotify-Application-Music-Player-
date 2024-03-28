/**
 * 
 */

import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;

/**
 * @author S. Thanush
 * Date: Jan. 2024
 * Description: Premium Account object that inherits from user.
 * 
 * /**
 * Premium Class
 * 
 * Methods:
 * 1. Default Constructor: Premium()
 *    - Initializes a Premium object with default values.
 * 
 * 2. Overloaded Constructor: Premium(Profile c, double fee)
 *    - Initializes a Premium object with specified Profile and fee.
 * 
 * 3. setCurrentDate(Date date)
 *    - Setter method for the currentDate variable.
 * 
 * 4. getCurrentDate()
 *    - Getter method for the currentDate variable.
 * 
 * 5. setAccount(Account account)
 *    - Setter method for the account variable.
 * 
 * 6. getAccount()
 *    - Getter method for the account variable.
 * 
 * 7. subscriptionCheck(Date startDate, Date endDate)
 *    - Checks if the premium subscription has ended based on start and end dates.
 *    - Returns a boolean value indicating the subscription status.
 * 
 * 8. getFee()
 *    - Getter method for the fee variable.
 * 
 * 9. setFee(double fee)
 *    - Setter method for the fee variable.
 * 
 * 10. getSubscriptionEnd()
 *    - Getter method for the subscriptionEnd variable.
 * 
 * 11. setSubscriptionEnd(Date subscriptionEnd)
 *    - Setter method for the subscriptionEnd variable.
 * 
 * 12. main(String[] args)
 *    - Main method for testing the functionality of the Premium class.
 *    - Instantiates a Premium object, performs various tests, and prints the results.
 */

public class Premium extends User{

	/**
	 * Private Instances/Variables
	 */
	private double fee;
	private final boolean unlimitedSkips = true;
	private Date currentDate;
	private Date subscriptionEnd;
	private Account account;								
	
	//Default Constructor
	public Premium() {
		super();
		this.fee = 6.99;
		this.currentDate = Calendar.getInstance().getTime();
		this.account = new Account();

		//Gets date 1 month after the day the premium subscription was bought
		Calendar c = Calendar.getInstance();
		c.setTime(getCurrentDate());
		c.add(Calendar.MONTH,1);
		this.subscriptionEnd = c.getTime();
		
	}
	
	//Overloaded Constructor
	public Premium (Profile c,/*Date date Account account, Date end,*/ double fee) { 
		super(c);
		this.fee = fee;
		//this.account = account; 
	}

	//currentDate variable setter
	public void setCurrentDate (Date date) { 
		this.currentDate = date;
	}

	//currentDate variable getter
	public Date getCurrentDate() {
		return this.currentDate;
	}
	
	//Account variable setter
	public void setAccount (Account account) { 
		this.account = account;
	}

	//Account variable getter
	public Account getAccount() { 
		return this.account;
	}

	//Checks to see if the premium subscription has ended or not. Will return 
	//boolean value accordingly.
	public boolean subscriptionCheck(Date startDate,Date endDate) { 
		if (startDate.getTime() > endDate.getTime()) { 
			return true;
		}
		return false;
	}

	/**
	 * @return the fee
	 */
	public double getFee() {
		return fee;
	}
	/**
	 * @param fee the fee to set
	 */
	public void setFee(double fee) {
		this.fee = fee;
	}
	/**
	 * @return the subscriptionEnd
	 */
	public Date getSubscriptionEnd() {
		return subscriptionEnd;
	}
	/**
	 * @param subscriptionEnd the subscriptionEnd to set
	 */
	public void setSubscriptionEnd(Date subscriptionEnd) {
		this.subscriptionEnd = subscriptionEnd;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 // Test constructor and getters
        Premium testPremium = new Premium();
        System.out.println("Current Date: " + testPremium.getCurrentDate());
        System.out.println("Subscription End Date: " + testPremium.getSubscriptionEnd());
        System.out.println("Fee: " + testPremium.getFee());

        // Test setters
        Date newDate = new Date();
        testPremium.setCurrentDate(newDate);
        System.out.println("Updated Current Date: " + testPremium.getCurrentDate());

        Account newAccount = new Account();
        testPremium.setAccount(newAccount);
        System.out.println("Updated Account: " + testPremium.getAccount().getNumber());

        Date newEndDate = new Date();
        testPremium.setSubscriptionEnd(newEndDate);
        System.out.println("Updated Subscription End Date: " + testPremium.getSubscriptionEnd());

        // Test subscriptionCheck method
        if (testPremium.subscriptionCheck(newDate, newEndDate)) {
            System.out.println("Subscription has ended.");
        } else {
            System.out.println("Subscription is still active.");
        }

	}

}
