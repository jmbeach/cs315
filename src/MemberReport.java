import java.util.ArrayList;

/* 
 * CS315 Assignment 4, MemberReport class
 * Author: Hannah Hoover
 */
public class MemberReport extends Database {
	private Member person;
	private Record currentRecord;
	
	    // constructor with no parameters
	public MemberReport(Member personality){
		super();
		this.person = personality;
	}
	
	public void generateReport() {
		ArrayList<Record> memberRecords = new ArrayList<Record>();
		memberRecords = person.getServicesReceived();
		for (int i=0; i<memberRecords.size();i++){
			currentRecord = memberRecords.get(i);
			displayRecord();
		}
    }
	
	public String getDateTime(){
		return currentRecord.getDate() + " " + currentRecord.getTime();
	}
	
    //returns the member number
    public int getProviderNumber(){
        return currentRecord.getProviderNumber();

    }
    
    //returns service
    public int getServiceCode(){
        return currentRecord.getServiceCode();
    }
    
    //return current date and time
    public String getDateProvided(){
        return currentRecord.getDateOfServices();
    }
    
    // returns the comments
	public String getComments(){
		return currentRecord.getComments();
	}
    
	// submits the Member report record
	public void displayRecord(){
		System.out.println(getDateProvided() + "\n" + getProviderNumber() + "\n" + super.getServiceName(getServiceCode()) );
	}
	
	
	
	
	
	
}