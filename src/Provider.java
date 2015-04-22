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

	public Provider() {
		// provider constructor with no arguments given
	}

	public String getName() { // Returns the User's Name
		return name;
	}

	public boolean isSignedIn() {
		return isSignedIn;
	}

	public void signIn() {
		isSignedIn = true;
	}

	public void signOut() {
		isSignedIn = false;
	}

	public void addServices(Record serv) {
		servicesProvided.add(serv);
	}

	public ArrayList<Record> getServices() {
		return servicesProvided;
	}

	public void addMoneyEarned(float money) {
		moneyEarned += money;
	}

	public float getMoneyEarned() {
		return moneyEarned;
	}

	public void clearFees() {
		moneyEarned = 0;
	}

	public void setName(String name) { // Sets the User's Name
		this.name = name;
	}

	public int getNumber() { // Returns the user's 9 digit member number
		return number;
	}

	public void setNumber(int number) { // Sets the user's 9 digit member number
		this.number = number;
	}

	public String getAddress() { // returns the user's address
		return address;
	}

	public void setAddress(String address) { // sets the user's address
		this.address = address;
	}

	public String getCity() { // returns the user's city
		return city;
	}

	public void setCity(String city) { // sets the user's city
		this.city = city;
	}

	public String getZipCode() { // returns the user's zip code
		return zipCode;
	}

	public void setZipCode(String zipCode) { // sets the user's zip code
		this.zipCode = zipCode;
	}

	public String getState() { // returns the user's state
		return state;
	}

	public void setState(String state) { // sets the user's state
		this.state = state;
	}
}
