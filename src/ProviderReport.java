public class ProviderReport extends Report {
	public void generateReport(int memberNumber) {
    }
    
    // constructor with no parameters
	public ProviderReport(){
		super();
	}
	
    //returns the provider number
    public int getPNumber(){
        return providerNumber;

    }
    
    //returns service
    public int getServiceCode(){
        return serviceProvided;
    }
    
    //return current date and time
    public String getDateProvided(){
        return dateOfServices;
    }
    
    // returns the comments
	public String getComments(){
		return comments;
	}
    
	// submits the provider report record
	public void displayRecord(){
		System.out.println(getDateTime() + "\n" + getDateProvided() + "\n" + getPNumber() + "\n" + "\n" + getServiceCode() + "\n" + getComments() + "\n" );
	}
	
	
}



// provider gets report for only their services that are being used. 