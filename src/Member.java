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
	private boolean isMemberSuspended;
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
		isMemberSuspended = false;
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
	 * @return  the member's signed in status
	 * 
	 * boolean class that checks to see if a member is signed in or not
	 * if the member is signed in,  true, else it  false
	 */
	public boolean isSignedIn() {
		return isSignedIn;
	}

	/**
	 * sets the member sign-in status to true
	 */
	public void signIn() {
		isSignedIn = true;
	}

	/**
	 * sets the member sing-in status to false
	 */
	public void signOut() {
		isSignedIn = false;
	}

	/**
	 * 
	 * @param additionalFunding
	 * 
	 * adds additional funding to the member's accounts
	 */
	public void addFunds(float additionalFunding) {
		accountFunds += additionalFunding;
	}

	/**
	 * 
	 * @param amountToTake
	 * 
	 * removes funds from the member's account
	 */
	public void subtractFunds(float amountToTake) {
		accountFunds -= amountToTake;
	}

	/**
	 *  the amount of funds that the member has in their account
	 * @return  the funds in the member's account
	 */
	public float getAccountFunds() {
		return accountFunds;
	}


	/**
	 *  sets the member status to valid
	 */
	public void Suspend() {
		isMemberSuspended = true;
	}


	/**
	 * setStatusToInvalid method that sets the member status to Invalid
	 */
	public void UnSuspend() {
		isMemberSuspended = false;

	}

	public boolean isSuspended() {
		return isMemberSuspended;
	}

	/**
	 * addServiceReceived method adds a record of a service that the member previously received to the member's object.
	 * @param serv
	 */
	public void addServiceReceived(Record serv) {
		servicesReceived.add(serv);
	}
	
	/**
	 *  an ArrayList of all of the services that the member has previously received
	 * @return  an ArrayList of all of the services that the member has previously received
	 */
	public ArrayList<Record> getServicesReceived() {
		return servicesReceived;
	}

	/**
	 *  the name of the member
	 * @return  the name of the member
	 */
	public String getName() { //  the User's Name
		return name;
	}

	/**
	 * sets the name of a user to the passed in parameter
	 * @param name
	 */
	public void setName(String name) { // Sets the User's Name
		this.name = name;
	}

	/**
	 *  the member's 9 digit member number
	 * @return  the member's 9-digit number
	 */
	public int getNumber() { //  the user's 9 digit member number
		return number;
	}

	/**
	 * sets the member's 9 digit member number
	 * @param number
	 */
	public void setNumber(int number) { // Sets the user's 9 digit member number
		this.number = number;
	}

	/**
	 * the member's address
	 * @return  the member's address
	 */
	public String getAddress() { //  the user's address
		return address;
	}

	/**
	 * sets the member's address
	 * @param address
	 */
	public void setAddress(String address) { // sets the user's address
		this.address = address;
	}

	/**
	 * the member's city (location)
	 * @return city
	 */
	public String getCity() { //  the user's city
		return city;
	}

	/**
	 * sets the member's city
	 * @param city
	 */
	public void setCity(String city) { // sets the user's city
		this.city = city;
	}

	/**
	 * the member's zip code
	 * @return member's zipCode
	 */
	public String getzipCode() { //  the user's zip code
		return zipCode;
	}

	/**
	 * sets the member's zip code
	 * @param zipCode
	 */
	public void setZip_Code(String zipCode) { // sets the user's zip code
		this.zipCode = zipCode;
	}

	/**
	 * the member's state (location)
	 * @return member's state (Location)
	 */
	public String getState() { //  the user's state
		return state;
	}

	/**
	 * sets the member's state (location)
	 * @param state
	 */
	public void setState(String state) { // sets the user's state
		this.state = state;
	}

}
