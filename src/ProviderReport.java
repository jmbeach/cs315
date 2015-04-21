import java.util.ArrayList;

public class ProviderReport extends Database {
	private Member person;
	private Record currentRecord;
	private int numOfConsultations;
	private int totalFees;
	
	    // constructor with no parameters
	public ProviderReport(Member personality){
		super();
		this.person = personality;
		numOfConsultations = 0;
		totalFees = 0;
	}
	
	public void generateReport() {
		System.out.println(person.getName());
		System.out.println(person.getNumber());
		System.out.println(person.getAddress());
		System.out.println(person.getCity());
		System.out.println(person.getState());
		System.out.println(person.getzipCode());
		System.out.println();
		System.out.println("Services Provided:");
		System.out.println();
		ArrayList<Record> providerRecords = new ArrayList<Record>();
		providerRecords = person.getServicesReceived();
		for (int i=0; i<providerRecords.size();i++){
			currentRecord = providerRecords.get(i);
			displayRecord();
			System.out.println();
			numOfConsultations += 1;
			System.out.println();
			System.out.println("Number of Consultations: " + numOfConsultations);
			System.out.println("Total Fee for week: " + "$" + totalFees);
		}
    }
	
	public String getDateTime(){
		return currentRecord.getDate() + " " + currentRecord.getTime();
	}
	
	public String getDateOfService(){
		return currentRecord.getDateOfServices();
	}
	
    //returns the member number
    public int getMemberNumber(){
        return currentRecord.getMemberNumber();

    }
    
    public String getMemberName(int number){
    	for (int i=0; i<Database.members.size();i++){
			if (Database.members.get(i).getNumber() == number){
				return Database.members.get(i).getName();
			}
		}
    	return "Invalid Member Number";
    }
    
    //returns service
    public int getServiceCode(){
        return currentRecord.getServiceCode();
    }
    
    public double getServiceFee(){
    	totalFees += currentRecord.calculateFee(getServiceCode());
    	return currentRecord.calculateFee(getServiceCode());
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
		//System.out.println(getDateProvided() + "\n" + getProviderName(getProviderNumber()) + "\n" + super.getServiceName(getServiceCode()) );
		System.out.println(getDateOfService() + "\n" + getDateTime() + "\n" + getMemberName(getMemberNumber()) + "\n" + getMemberNumber() + "\n" + getServiceCode() + "\n" + getServiceFee());
	}
	
}