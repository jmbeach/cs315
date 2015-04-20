public class ProviderReport extends Report {
	public void generateReport(int memberNumber) {
    }
    
    // constructor with no parameters
	public ProviderReport(){
		super();
	}
	
    //returns the provider number
    public int getPNumber(){
        //return providerNumber;
    	return 5; // delete after test
    }
    
    //returns service
    public int getServiceCode(){
        //return serviceProvided;
    	return 5;// delete after test
    }
    
    //return current date and time
    public String getDateProvided(){
        //return dateOfServices;
    	return "hello"; // delete after test
    }
    
    // returns the comments
	public String getComments(){
		//return comments;
		return "hello"; // delete after test
	}
    
	// submits the provider report record
	public void displayRecord(){
		//System.out.println(getDateTime() + "\n" + getDateProvided() + "\n" + getPNumber() + "\n" + "\n" + getServiceCode() + "\n" + getComments() + "\n" );
	}
	//test 23
	
}



// provider gets report for only their services that are being used. 