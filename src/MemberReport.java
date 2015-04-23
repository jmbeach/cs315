import java.util.ArrayList;

/**
 * 
 * @author Matt
 *
 */
public class MemberReport extends Database {
	private Member person;
	private Record currentRecord;
	
	    // constructor with no parameters
	/**
	 * Constructor for the MemberReportClass: takes in one member object
	 * @param personality
	 */
	public MemberReport(Member personality){
		super();
		this.person = personality;
		generateReport();
	}
	
	/**
	 * generateReport method: generates the report for the member using all of the methods in the class
	 */
	public void generateReport() {
		System.out.println("Member Name: " + person.getName());
		System.out.println("Member Number: " + person.getNumber());
		System.out.println("Member Address: " + person.getAddress());
		System.out.println("Member City: " + person.getCity());
		System.out.println("Member State: " + person.getState());
		System.out.println("Member Zip Code: " + person.getZipCode());
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
	
	/**
	 * getDateTime method: return
	 * @return date
	 */
	public String getDateTime(){
		return currentRecord.getDate() + " " + currentRecord.getTime();
	}
	
    //returns the member number
	/**
	 * getProviderNumber method: returns the Provider Number from record that the class is currently looking at
	 * @return providerNumber
	 */
    public int getProviderNumber(){
        return currentRecord.getProviderNumber();

    }
    
    /**
     * getProviderName method: returns the provider name from record that the class is currently looking at
     * @param number
     * @return providerName
     */
    public String getProviderName(int number){
    	for (int i=0; i<Database.providers.size();i++){
			if (Database.providers.get(i).getNumber() == number){
				return Database.providers.get(i).getName();
			}
		}
    	return "Invalid Provider Number";
    }
    
    //returns service
    /**
     * getServiceCode method: returns the service code from record that the class is currently looking at
     * @return serviceCode
     */
    public int getServiceCode(){
        return currentRecord.getServiceCode();
    }
    
    //return current date and time
    /**
     * getDateProvided method: returns the Date a service was provided from record that the class is currently looking at
     * @return dateProvided
     */
    public String getDateProvided(){
        return currentRecord.getDateOfServices();
    }
    
    // returns the comments
    /**
     * getComments method: returns the comments from record that the class is currently looking at
     * @return comments 
     */
	public String getComments(){
		return currentRecord.getComments();
	}
    
	// submits the Member report record
	/**
	 * displayRecord method: displays all of the details from one specific record, the record that the class is currently looking at
	 */
	public void displayRecord(){
		System.out.println("Date Provided: " + getDateProvided() + "\n" + "Provider Name: " + getProviderName(getProviderNumber()) + "\n" + "Service Name: " + super.getServiceName(getServiceCode()) );
	}
	
}