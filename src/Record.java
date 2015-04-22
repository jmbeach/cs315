import java.io.Serializable;
import java.util.ArrayList;

public class Record implements Serializable {
	protected String date;
	protected String time;
	protected String dateOfServices;
	protected int providerNumber;
	protected int memberNumber;
	protected int serviceCode;
	protected String comments;
	protected Member user;
	protected static ArrayList<ArrayList> serviceRecords = new ArrayList<ArrayList>(); // ArrayList
																						// of
																						// all
																						// records,
																						// each
																						// record
																						// is
																						// another
																						// ArrayList
																						// inside
																						// the
																						// Master
	/**
	 * constructor for the record class with parameters																					// ArrayList
	 * @param dateTime
	 * @param dateOfServices
	 * @param providerNumber
	 * @param memberNumber
	 * @param serviceCode
	 * @param comments
	 * @param user
	 */

	/**
	 * 
	 * @param dateTime date and time provided
	 * @param dateOfServices date of services provided
	 * @param providerNumber input of the provider number
	 * @param memberNumber input of the member number
	 * @param serviceCode input of the service code for service provided
	 * @param comments input of comments associated for service provided
	 * @param user input for member associated with record
	 */
	public Record(String dateTime, String dateOfServices, int providerNumber,
			int memberNumber, int serviceCode, String comments, Member user) {
		this.date = dateTime;

		this.dateOfServices = dateOfServices;
		this.providerNumber = providerNumber;
		this.memberNumber = memberNumber;
		this.serviceCode = serviceCode;
		this.comments = comments;
		this.user = user;

	}
	/**
	 * constructor for the record class without parameters
	 */
	public Record() {
		// constructor with no arguments
	}
	/**
	 * calculateFee: calculates fees for different services based on their code
	 * @param servCode
	 * @return totalFees
	 *
	 */

	public double calculateFee(int servCode) {
		if (servCode == 6666665) {
			return 50.45;
		} else if (servCode == 4519568) {
			return 12.99;
		} else if (servCode == 102865) {
			return 21.45;
		} else if (servCode == 551947) {
			return 349.99;
		} else if (servCode == 800085) {
			return 54.69;
		}
		return 0.00;
	}
	/**
	 * createRecord: creates a record for the info passed in
	 */

	// generates the bill report record
	public void createRecord() {
		ArrayList<String> record = new ArrayList<String>();
		record.add(user.getName());
		record.add(this.date);
		// record.add(this.time);
		record.add(this.dateOfServices);
		record.add(String.valueOf(this.providerNumber));
		record.add(String.valueOf(this.memberNumber));
		record.add(String.valueOf(this.serviceCode));
		record.add(this.comments);
		serviceRecords.add(record);

	}
	/**
	 * getDate: returns the date
	 * @return  date
	 */

	public String getDate() {
		return date;
	}
	
	/**
	 * 
	 * @return  time
	 */

	/**
	 * getTime: returns the time.
	 * @return time
	 */
	public String getTime() {
		return time;
	}

	
	/**
	 * 
	 * @return  date of services
	 */

	public String getDateOfServices() {
		return dateOfServices;
	}

	/**
	 * returns the provider number
	 * @return provider number

	 */

	public int getProviderNumber() {
		return providerNumber;
	}

	/**
	 * returns the member number
	 * @return memberNumber

	 */

	public int getMemberNumber() {
		return memberNumber;
	}

	/**
	 * returns the service code
	 * @return serviceCode
	 */

	public int getServiceCode() {
		return serviceCode;
	}

	/**
	 * returns the comments of the record
	 * @return comments

	 */

	public String getComments() {
		return comments;
	}

	/**
	 * returns the member object
	 * @return member

	 */

	public Member getUser() {
		return user;
	}
	/**

	 * returns the records
	 * @return records

	 */

	public static Object getRecords() {
		return serviceRecords;
	}
	/**
	 * setDateTime: sets the date and time
	 * @param newDate
	 */

	/**
	 * 
	 * @param newDate sets the date and time for the record
	 */
	public void setDateTime(String newDate) {
		date = newDate;

	}
	/**
	 * setDateProvided: sets the date the service was provided
	 * @param providedDate
	 */

	/**
	 * 
	 * @param providedDate sets the date of services provided for the record
	 */
	public void setDateProvided(String providedDate) {
		dateOfServices = providedDate;

	}
	/**
	 * setPNumber: sets the provider number
	 * @param provider
	 */

	/**
	 * 
	 * @param provider sets the provider number for the record
	 */
	public void setPNumber(int provider) {
		providerNumber = provider;
	}
	/**
	 * setUNumber: sets the member number
	 * @param member
	 */

	/**
	 * 
	 * @param member sets the member number for the record
	 */
	public void setUNumber(int member) {
		memberNumber = member;
	}
	/**
	 * setServiceCode: sets the service code
	 * @param code
	 */

	/**
	 * 
	 * @param code sets the service code of the services provided
	 */
	public void setServiceCode(int code) {
		serviceCode = code;
	}
	/**
	 * setComments: sets the comments for the record
	 * @param notes
	 */

	/**
	 * 
	 * @param notes sets the comments for the record
	 */
	public void setComments(String notes) {
		comments = notes;
	}
	/**
	 * selectUser: selects the user for the record
	 * @param person
	 */

	/**
	 * 
	 * @param person sets the selected user to the member object that is passed in
	 */
	public void selectUser(Member person) {
		user = person;

	}
	/**
	 * loadUser: loads the user based on their number
	 */

	/**
	 *  loads the selected user, and sets the member number
	 */
	public void loadUser() {
		memberNumber = user.getNumber();
	}

	// public static void main(String[] args) { //testing purposes, delete later
	// Member user = new
	// Member("Billy Butthole",123456,"123 douche avenue","Buttzville","Alasska","69696");
	// Member user1 = new
	// Member("Billy Butthole",123656,"122 butt","Buttzville","Alasska","69796");
	// Record r1 = new Record("12-12-1987 12:12:34","10-15-1976", 123456,
	// 345678, 113343,"boner",user);
	// Record r2 = new Record("12-12-1996 12:15:34","10-15-1979", 123356,
	// 342678, 113143,"ass",user1);
	// r1.createRecord();
	// r2.createRecord();
	// System.out.println(serviceRecords);
	// }

}
