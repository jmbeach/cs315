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
	 * getName method: returns the name of the provider
	 * @return
	 */
	public String getName() { // Returns the User's Name
		return name;
	}

	/**
	 * isSignedIn method: returns if a provider is signed in or not
	 * @return
	 */
	public boolean isSignedIn() {
		return isSignedIn;
	}

	/**
	 * signIN method: sets the provider's sign in status to true
	 */
	public void signIn() {
		isSignedIn = true;
	}

	/**
	 * signOut method: sets the provider's sing in status to false
	 */
	public void signOut() {
		isSignedIn = false;
	}

	/**
	 * addServices method: adds a record of a service that a provider has provided to a member
	 * @param serv
	 */
	public void addServices(Record serv) {
		servicesProvided.add(serv);
	}

	/**
	 * getServices method: returns an arraylist of all of the services that a provider has provided to its members
	 * @return
	 */
	public ArrayList<Record> getServices() {
		return servicesProvided;
	}

	/**
	 * addMoneyEarned method: adds money to the total amount that the provider needs to be paid
	 * @param money
	 */
	public void addMoneyEarned(float money) {
		moneyEarned += money;
	}

	/**
	 * getMoneyEarned method: returns the total amount the provider needs to be paid base on the services they provided
	 * @return
	 */
	public float getMoneyEarned() {
		return moneyEarned;
	}

	/**
	 * clearFees method: sets the money the provider to be paid to $0
	 */
	public void clearFees() {
		moneyEarned = 0;
	}

	/**
	 * setName method: sets the provider's name
	 * @param name
	 */
	public void setName(String name) { // Sets the User's Name
		this.name = name;
	}

	/**
	 * getNumber method: returns the provider's 9 digit provider number
	 * @return
	 */
	public int getNumber() { // Returns the user's 9 digit member number
		return number;
	}

	/**
	 * setNumber method: sets the provider's 9 digit member number
	 * @param number
	 */
	public void setNumber(int number) { // Sets the user's 9 digit member number
		this.number = number;
	}

	/**
	 * getAddress method: returns the provider's address
	 * @return
	 */
	public String getAddress() { // returns the user's address
		return address;
	}

	/**
	 * setAddress method: sets the provider's address
	 * @param address
	 */
	public void setAddress(String address) { // sets the user's address
		this.address = address;
	}

	/**
	 * getCity method: returns the provider's city
	 * @return
	 */
	public String getCity() { // returns the user's city
		return city;
	}

	/**
	 * setCity method: sets the provider's city
	 * @param city
	 */
	public void setCity(String city) { // sets the user's city
		this.city = city;
	}

	/**
	 * getZipCode method: returns the provider's zip code
	 * @return
	 */
	public String getZipCode() { // returns the user's zip code
		return zipCode;
	}

	/**
	 * setZipCode method: sets the provider's zip code
	 * @param zipCode
	 */
	public void setZipCode(String zipCode) { // sets the user's zip code
		this.zipCode = zipCode;
	}

	/**
	 * getState method: returns the provider's state (location)
	 * @return
	 */
	public String getState() { // returns the user's state
		return state;
	}

	/**
	 * setState method: sets the provider's state (location)
	 * @param state
	 */
	public void setState(String state) { // sets the user's state
		this.state = state;
	}
}
