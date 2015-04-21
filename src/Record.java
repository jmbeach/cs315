import java.util.ArrayList;
import java.util.HashMap;


public class Record {
	protected String date;
	protected String time;
	protected String dateOfServices;
	protected int providerNumber;
	protected int memberNumber;
	protected int serviceCode;
	protected String comments;
	protected Member user;
	protected static ArrayList<ArrayList> serviceRecords = new ArrayList<ArrayList>(); //ArrayList of all records, each record is another ArrayList inside the Master ArrayList
	
	// constructor
	public Record(String dateTime,String dateOfServices,int providerNumber,int memberNumber,int serviceCode,String comments, Member user){
		this.date = dateTime;
		
		this.dateOfServices = dateOfServices;
		this.providerNumber = providerNumber;
		this.memberNumber = memberNumber;
		this.serviceCode = serviceCode;
		this.comments = comments;
		this.user = user;
		
	}
	
	public Record(){
		//constructor with no arguments
	}
	
	public double calculateFee(int servCode){
		if (servCode == 6666665){
			return 50.45;
		}else if (servCode == 4519568){
			return 12.99;
		}else if (servCode == 102865){
			return 21.45;
		}else if (servCode == 551947){
			return 349.99;
		}else if (servCode == 80085){
			return 54.69;
		}
		return 0.00;
	}
	
	// generates the bill report record 
	public void createRecord(){
		ArrayList<String> record = new ArrayList<String>();
		record.add(user.getName());
		record.add(this.date);
		//record.add(this.time);
		record.add(this.dateOfServices);
		record.add(String.valueOf(this.providerNumber));
		record.add(String.valueOf(this.memberNumber));
		record.add(String.valueOf(this.serviceCode));
		record.add(this.comments);
		serviceRecords.add(record);
		
		
		
	}
	
		
	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getDateOfServices() {
		return dateOfServices;
	}

	public int getProviderNumber() {
		return providerNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public int getServiceCode() {
		return serviceCode;
	}

	public String getComments() {
		return comments;
	}

	public Member getUser() {
		return user;
	}

	public static Object getRecords() {
		return serviceRecords;
	}

	// sets the date and time for the record
	public void setDateTime(String newDate){
		date = newDate;
		
	}
	
	// sets the date of services provided for the record
	public void setDateProvided(String providedDate){
		dateOfServices = providedDate;
		
	}
	
	// sets the provider number for the record
	public void setPNumber(int provider){
		providerNumber = provider;
	}
	
	// sets the member number for the record
	public void setUNumber(int member){
		memberNumber = member;
	}
	
	// sets the service code of the services provided
	public void setServiceCode(int code){
		serviceCode = code;
	}
	
	// sets the comments for the record
	public void setComments(String notes){
		comments = notes;
	}
	
	
	// sets the selected user to the member object that is passed in
	public void selectUser(Member person){
		user = person;
		
	}
	
	// loads the selected user, and sets the member number
	public void loadUser() {
		memberNumber = user.getNumber();
	}
	
	//public static void main(String[] args) { //testing purposes, delete later
		//Member user = new Member("Billy Butthole",123456,"123 douche avenue","Buttzville","Alasska","69696");
		//Member user1 = new Member("Billy Butthole",123656,"122 butt","Buttzville","Alasska","69796");
		//Record r1 = new Record("12-12-1987 12:12:34","10-15-1976", 123456, 345678, 113343,"boner",user);
		//Record r2 = new Record("12-12-1996 12:15:34","10-15-1979", 123356, 342678, 113143,"ass",user1);
		//r1.createRecord();
		//r2.createRecord();
		//System.out.println(serviceRecords);
	//}
	
}

