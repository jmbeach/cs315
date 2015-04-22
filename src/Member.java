import java.io.Serializable;
import java.util.ArrayList;

/*
 * CS315 Assignment 4, Member class
 * Dillon Wastrack 
 */

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int number;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String memberStatus;
	private boolean isSignedIn;
	private float accountFunds;
	ArrayList<Record> servicesReceived = new ArrayList<Record>();

	/**
	 * 
	 * @param name
	 * @param number
	 * @param address
	 * @param city
	 * @param state
	 * @param zipCode
	 * 
	 * Constructor for the member class
	 * 
	 */
	public Member(String name, int number, String address, String city,
			String state, String zipCode) {
		this.name = name;
		this.number = number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		memberStatus = "VALID";
		this.isSignedIn = false;
		accountFunds = 0f;
	}

	/**
	 * Constructor for the member class with no arguments
	 */
	public Member() {
		// Member constructor with no arguments
	}
	
	/**
	 * 
	 * @return
	 * 
	 * boolean class that checks to see if a member is signed in or not
	 * if the member is signed in, returns true, else it returns false
	 */
	public boolean isSignedIn() {
		return isSignedIn;
	}

	/**
	 * Sign in method that sets the member sign-in status to true
	 */
	public void signIn() {
		isSignedIn = true;
	}

	/**
	 * Sign-out method that sets the member sing-in status to false
	 */
	public void signOut() {
		isSignedIn = false;
	}

	/**
	 * 
	 * @param additionalFunding
	 * 
	 * addFunds method that adds additional funding to the member's accounts
	 */
	public void addFunds(float additionalFunding) {
		accountFunds += additionalFunding;
	}

	/**
	 * 
	 * @param amountToTake
	 * 
	 * subtractFunds method that removes funds from the member's account
	 */
	public void subtractFunds(float amountToTake) {
		accountFunds -= amountToTake;
	}

	/**
	 * getAccountFunds method that returns the amount of funds that the member has in their account
	 * @return
	 */
	public float getAccountFunds() {
		return accountFunds;
	}

	/**
	 *setStatusToValid method that sets the member status to valid
	 */
	public void setStatusToValid() {
		memberStatus = "VALID";
	}

	/**
	 * setStatusToInvalid method that sets the member status to Invalid
	 */
	public void setStatusToInvalid() {
		memberStatus = "INVALID";
	}

	/**
	 * setStatusToSuspended method that sets the member status to Suspended
	 */
	public void setStatusToSuspended() {
		memberStatus = "SUSPENDED";
	}
	
	/**
	 * getStatus method that returns the value of the member's current status
	 * @return
	 */
	public String getStatus() {
		return memberStatus;
	}

	/**
	 * addServiceReceived method adds a record of a service that the member previously received to the member's object.
	 * @param serv
	 */
	public void addServiceReceived(Record serv) {
		servicesReceived.add(serv);
	}
	
	/**
	 * getServicesReceived method that returns an ArrayList of all of the services that the member has previously recieved
	 * @return
	 */
	public ArrayList<Record> getServicesReceived() {
		return servicesReceived;
	}

	/**
	 * getName class: that returns the name of the member
	 * @return
	 */
	public String getName() { // Returns the User's Name
		return name;
	}

	/**
	 * setName method: sets the name of a user to the passed in parameter
	 * @param name
	 */
	public void setName(String name) { // Sets the User's Name
		this.name = name;
	}

	/**
	 * getNumber method: returns the member's 9 digit member number
	 * @return
	 */
	public int getNumber() { // Returns the user's 9 digit member number
		return number;
	}

	/**
	 * setNumber method: sets the member's 9 digit member number
	 * @param number
	 */
	public void setNumber(int number) { // Sets the user's 9 digit member number
		this.number = number;
	}

	/**
	 * getAddress method: returns the member's address
	 * @return
	 */
	public String getAddress() { // returns the user's address
		return address;
	}

	/**
	 * setAddress method: sets the member's address
	 * @param address
	 */
	public void setAddress(String address) { // sets the user's address
		this.address = address;
	}

	/**
	 * getCity method: returns the member's city (location)
	 * @return
	 */
	public String getCity() { // returns the user's city
		return city;
	}

	/**
	 * setCity method: sets the member's city
	 * @param city
	 */
	public void setCity(String city) { // sets the user's city
		this.city = city;
	}

	/**
	 * getzipCode method: returns the member's zip code
	 * @return
	 */
	public String getzipCode() { // returns the user's zip code
		return zipCode;
	}

	/**
	 * setZip_Code method: sets the member's zip code
	 * @param zipCode
	 */
	public void setZip_Code(String zipCode) { // sets the user's zip code
		this.zipCode = zipCode;
	}

	/**
	 * getState method: returns the member's state (location)
	 * @return
	 */
	public String getState() { // returns the user's state
		return state;
	}

	/**
	 * setState method: sets the member's state (location)
	 * @param state
	 */
	public void setState(String state) { // sets the user's state
		this.state = state;
	}

}
