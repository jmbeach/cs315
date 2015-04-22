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
																						// ArrayList

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

	public Record() {
		// constructor with no arguments
	}
	
	/**
	 * 
	 * @param servCode 
	 * @return
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
	 * 
	 * @return returns date
	 */

	public String getDate() {
		return date;
	}
	
	/**
	 * 
	 * @return returns time
	 */

	public String getTime() {
		return time;
	}
	
	/**
	 * 
	 * @return returns date of services
	 */

	public String getDateOfServices() {
		return dateOfServices;
	}
	
	/**
	 * 
	 * @return returns provider number
	 */

	public int getProviderNumber() {
		return providerNumber;
	}
	
	/**
	 * 
	 * @return returns member number
	 */

	public int getMemberNumber() {
		return memberNumber;
	}
	
	/**
	 * 
	 * @return returns service code
	 */

	public int getServiceCode() {
		return serviceCode;
	}
	
	/**
	 * 
	 * @return returns comments
	 */

	public String getComments() {
		return comments;
	}
	
	/**
	 * 
	 * @return returns user
	 */

	public Member getUser() {
		return user;
	}
	/**
	 * 
	 * @return returns service records
	 */

	public static Object getRecords() {
		return serviceRecords;
	}

	/**
	 * 
	 * @param newDate sets the date and time for the record
	 */
	public void setDateTime(String newDate) {
		date = newDate;

	}

	/**
	 * 
	 * @param providedDate sets the date of services provided for the record
	 */
	public void setDateProvided(String providedDate) {
		dateOfServices = providedDate;

	}

	/**
	 * 
	 * @param provider sets the provider number for the record
	 */
	public void setPNumber(int provider) {
		providerNumber = provider;
	}

	/**
	 * 
	 * @param member sets the member number for the record
	 */
	public void setUNumber(int member) {
		memberNumber = member;
	}

	/**
	 * 
	 * @param code sets the service code of the services provided
	 */
	public void setServiceCode(int code) {
		serviceCode = code;
	}

	/**
	 * 
	 * @param notes sets the comments for the record
	 */
	public void setComments(String notes) {
		comments = notes;
	}

	/**
	 * 
	 * @param person sets the selected user to the member object that is passed in
	 */
	public void selectUser(Member person) {
		user = person;

	}

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
