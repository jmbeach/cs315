import java.util.ArrayList;
import java.util.HashMap;


public class Record {
	public String date;
	public String time;
	public String dateOfServices;
	public int providerNumber;
	public int memberNumber;
	public int serviceCode;
	public String comments;
	public Member user;
	public static HashMap records = new HashMap();
	
	// constructor
	public Record(String date,String time,String dateOfServices,int providerNumber,int memberNumber,int serviceCode,String comments, Member user){
		this.date = date;
		this.time = time;
		this.dateOfServices = dateOfServices;
		this.providerNumber = providerNumber;
		this.memberNumber = memberNumber;
		this.serviceCode = serviceCode;
		this.comments = comments;
		this.user = user;
		//this.user = user;
	}
	
	public Record(){
		//constructor with no arguments
	}
	
	// generates the bill report record 
	public void createRecord(){
		ArrayList<String> record = new ArrayList<String>();
		record.add(date);
		record.add(time);
		record.add(dateOfServices);
		record.add(String.valueOf(providerNumber));
		record.add(String.valueOf(memberNumber));
		record.add(String.valueOf(serviceCode));
		record.add(comments);
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
	
}
