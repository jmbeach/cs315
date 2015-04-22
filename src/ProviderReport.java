// written by Matt Williams

import java.util.ArrayList;

/**
 * Provider Report Class that prints a report for the provider each week
 * @author Matt
 *
 */
public class ProviderReport extends Database {
	private Provider person;
	private Record currentRecord;
	private int numOfConsultations;
	private int totalFees;
	
	/**
	 * Constructor for the Provider Report
	 * @param p
	 */
	public ProviderReport(Provider p){
		super();
		this.person = p;
		numOfConsultations = 0;
		totalFees = 0;
		generateReport();
		p.addMoneyEarned(totalFees);
	}
	
	/**
	 * generateReport method: prints the weekly report for a provider
	 */
	public void generateReport() {
		System.out.println("Provider Name: " + person.getName());
		System.out.println("Provider Number: " + person.getNumber());
		System.out.println("Provider Address: " + person.getAddress());
		System.out.println("Provider City: " + person.getCity());
		System.out.println("Provider State: " + person.getState());
		System.out.println("Provider Zip Code: " + person.getZipCode());
		System.out.println();
		System.out.println("Services Provided:");
		System.out.println();
		ArrayList<Record> providerRecords = new ArrayList<Record>();
		providerRecords = person.getServices();
		for (int i=0; i<providerRecords.size();i++){
			currentRecord = providerRecords.get(i);
			displayRecord();
			System.out.println();
			numOfConsultations += 1;
		}
		System.out.println();
		System.out.println("Number of Consultations: " + numOfConsultations);
		System.out.println("Total Fee for week: " + "$" + totalFees);
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
    }
	
	/**
	 * getDateTime method: returns the current date and time from record that the class is currently looking at
	 * @return date + time
	 */
	public String getDateTime(){
		return currentRecord.getDate() + " " + currentRecord.getTime();
	}
	
	/**
	 * getDateOfService method: returns the date of service from record that the class is currently looking at
	 * @return dateOfService
	 */
	public String getDateOfService(){
		return currentRecord.getDateOfServices();
	}
	
    //returns the member number
	/**
	 * getMemberNumber method: returns the member number from record that the class is currently looking at
	 * @return memberNumber
	 */
    public int getMemberNumber(){
        return currentRecord.getMemberNumber();

    }
    
    /**
     * getMemberName method: returns the member name from record that the class is currently looking at
     * @param number
     * @return memberName
     */
    public String getMemberName(int number){
    	for (int i=0; i<Database.members.size();i++){
			if (Database.members.get(i).getNumber() == number){
				return Database.members.get(i).getName();
			}
		}
    	return "Invalid Member Number";
    }
    
    //returns service
    /**
     * getServiceCode method: returns the service code from record that the class is currently looking at
     * @return serviceCode
     */
    public int getServiceCode(){
        return currentRecord.getServiceCode();
    }
    
    /**
     * getServiceFee method: returns the service fee from record that the class is currently looking at
     * @return serviceFee
     */
    public double getServiceFee(){
    	totalFees += currentRecord.calculateFee(getServiceCode());
    	return currentRecord.calculateFee(getServiceCode());
    }
    
    //return current date and time
    /**
     * getDateProvided method: returns the date provided from record that the class is currently looking at
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
	 * displayRecord method: prints all of the information for one record that goes on the total report
	 * 
	 */
	public void displayRecord(){
		//System.out.println(getDateProvided() + "\n" + getProviderName(getProviderNumber()) + "\n" + super.getServiceName(getServiceCode()) );
		System.out.println("Date of Service: " + getDateOfService() + "\n" + "Date and Time: " 
		+ getDateTime() + "\n" + "Member Name: " + getMemberName(getMemberNumber()) + "\n" 
				+ "Member Number: " + getMemberNumber() + "\n" + "Service Code: " 
		+ getServiceCode() + "\n" + "Service Fee: " + "$" + getServiceFee());
	}
	
}