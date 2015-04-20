
public class BillReport extends Record {
	
	// constructor
	public BillReport(String date,String time,String dateOfServices,int providerNumber,int memberNumber,int serviceCode,String comments){
		super( date, time, dateOfServices, providerNumber, memberNumber, serviceCode, comments);
	}
	
	// constructor with no parameters
	public BillReport(){
		super();
	}
	
	// submits the bill report record
	public void displayRecord(){
		System.out.println(getDateTime() + "\n" + getDateProvided() + "\n" + getPNumber() + "\n" + getUNumber() + "\n" + getServiceCode() + "\n" + getComments() + "\n" );
	}
	
	// returns the date that the services were provided
	public String getDateProvided(){
		return dateOfServices;
	}
	
	
	// returns the current date and time that the bill report was created
	public String getDateTime(){
		return date + " " + time;
	}
	
	// returns the provider number
	public int getPNumber(){
		return providerNumber;
	}
	
	// returns the member number
	public int getUNumber(){
		return memberNumber;
	}
	
	// returns the service code
	public int getServiceCode(){
		return serviceCode;
	}
	
	// returns the comments
	public String getComments(){
		return comments;
	}
	
}
