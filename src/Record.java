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
	protected static HashMap<String, ArrayList<String>> records = new HashMap<String, ArrayList<String>>();
	
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
	
	
	// generates the bill report record 
	public void createRecord(){
		ArrayList<String> record = new ArrayList<String>();
		record.add(this.date);
		//record.add(this.time);
		record.add(this.dateOfServices);
		record.add(String.valueOf(this.providerNumber));
		record.add(String.valueOf(this.memberNumber));
		record.add(String.valueOf(this.serviceCode));
		record.add(this.comments);
		records.put(user.getName(),record );
		
		
	}
	
		
	// sets the date and time for the record
	public void setDateTime(String newDate, String newTime){
		date = newDate;
		time = newTime;
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
	
	public static void main(String[] args) {
		Member user = new Member("Anus Randy",123456,"123 douche avenue","Buttzville","Alasska","69696");
		Record r1 = new Record("12-12-1987 12:12:34","10-15-1976", 123456, 345678, 113343,"boner",user);
		r1.createRecord();
		System.out.println(records);
	}
	
}

