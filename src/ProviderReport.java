public class ProviderReport extends Report {
	private Provider person;
	
	    // constructor with no parameters
	public ProviderReport(Provider person){
		super();
		this.person = person;
	}
	
	public void generateReport(int memberNumber) {
    }
	
    //returns the provider number
    public int getPNumber(){
        return person.getNumber();

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
	// 335434 0- 888 - 1010
	
}



// provider gets report for only their services that are being used. 