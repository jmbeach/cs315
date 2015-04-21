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
		generateReport();
	}
	
	public void generateReport() {
		System.out.println(person.getName());
		System.out.println(person.getNumber());
		System.out.println(person.getAddress());
		System.out.println(person.getCity());
		System.out.println(person.getState());
		System.out.println(person.getzipCode());
		System.out.println();
		System.out.println("Services Received:");
		System.out.println();
		ArrayList<Record> memberRecords = new ArrayList<Record>();
		memberRecords = person.getServicesReceived();
		for (int i=0; i<memberRecords.size();i++){
			currentRecord = memberRecords.get(i);
			displayRecord();
			System.out.println();
		}
    }
	
	public String getDateTime(){
		return currentRecord.getDate() + " " + currentRecord.getTime();
	}
	
    //returns the member number
    public int getProviderNumber(){
        return currentRecord.getProviderNumber();

    }
    
    public String getProviderName(int number){
    	for (int i=0; i<Database.providers.size();i++){
			if (Database.providers.get(i).getNumber() == number){
				return Database.providers.get(i).getName();
			}
		}
    	return "Invalid Provider Number";
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
		System.out.println(getDateProvided() + "\n" + getProviderName(getProviderNumber()) + "\n" + super.getServiceName(getServiceCode()) );
	}
	
}