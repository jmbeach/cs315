import java.io.Serializable;
import java.util.ArrayList;

public class Provider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int number;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private float moneyEarned;
	private boolean isSignedIn;
	ArrayList<Record> servicesProvided = new ArrayList<Record>();

	/**
	 * Constructor for the Provider class that takes in all of the information required for a Provider object
	 * @param name
	 * @param number
	 * @param address
	 * @param city
	 * @param state
	 * @param zipCode
	 */
	public Provider(String name, int number, String address, String city,
			String state, String zipCode) {
		super();
		this.name = name;
		this.number = number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		moneyEarned = 0;
	}

	/**
	 * Constructor for the Provider class that takes no arguments
	 */
	public Provider() {
		// provider constructor with no arguments given
	}

	/**
	 * method to obtain the name of the provider
	 * @return the name of the provider
	 */
	public String getName() { // Returns the User's Name
		return name;
	}

	/**
	 * detects if a member is signed in.
	 * @return true or false: if a provider is signed in or not
	 */
	public boolean isSignedIn() {
		return isSignedIn;
	}

	/**
	 * sets the provider's sign in status to true
	 */
	public void signIn() {
		isSignedIn = true;
	}

	/**
	 * sets the provider's sing in status to false
	 */
	public void signOut() {
		isSignedIn = false;
	}

	/**
	 * adds a record of a service that a provider has provided to a member
	 * @param serv
	 */
	public void addServices(Record serv) {
		servicesProvided.add(serv);
	}

	/**
	 * obtains the list of services a provider has provided
	 * @return the services that the provider has provided
	 */
	public ArrayList<Record> getServices() {
		return servicesProvided;
	}

	/**
	 * adds money to the total amount that the provider needs to be paid
	 * @param money
	 */
	public void addMoneyEarned(float money) {
		moneyEarned += money;
	}

	/**
	 * obtains the total amount of money the provider has earned
	 * @return the total amount the provider needs based on the services they provided
	 */
	public float getMoneyEarned() {
		return moneyEarned;
	}

	/**
	 * sets the money the provider to be paid to $0
	 */
	public void clearFees() {
		moneyEarned = 0;
	}

	/**
	 * sets the provider's name
	 * @param name
	 */
	public void setName(String name) { // Sets the User's Name
		this.name = name;
	}

	/**
	 * obtains the provider's 9 digit number
	 * @return the provider's 9 digit provider number
	 */
	public int getNumber() { // Returns the user's 9 digit member number
		return number;
	}

	/**
	 * sets the provider's 9 digit member number
	 * @param number
	 */
	public void setNumber(int number) { // Sets the user's 9 digit member number
		this.number = number;
	}

	/**
	 * obtains the address the provider has set as their own
	 * @return the provider's address
	 */
	public String getAddress() { // returns the user's address
		return address;
	}

	/**
	 * sets the provider's address
	 * @param address
	 */
	public void setAddress(String address) { // sets the user's address
		this.address = address;
	}

	/**
	 * obtains the provider's city they have set as their own.
	 * @return the provider's city
	 */
	public String getCity() { // returns the user's city
		return city;
	}

	/**
	 * sets the provider's city
	 * @param city
	 */
	public void setCity(String city) { // sets the user's city
		this.city = city;
	}

	/**
	 * obtains the provider's zip code they have set as their own
	 * @return the provider's zip code
	 */
	public String getZipCode() { // returns the user's zip code
		return zipCode;
	}

	/**
	 * sets the provider's zip code
	 * @param zipCode
	 */
	public void setZipCode(String zipCode) { // sets the user's zip code
		this.zipCode = zipCode;
	}

	/**
	 * obtains the provider's state they have set as their own
	 * @return the provider's state (location)
	 */
	public String getState() { // returns the user's state
		return state;
	}

	/**
	 * sets the provider's state (location)
	 * @param state
	 */
	public void setState(String state) { // sets the user's state
		this.state = state;
	}
}
