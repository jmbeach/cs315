/* 
 * CS315 Assignment 4, MemberReport class
 * Author: Hannah Hoover
 */
public class MemberReport extends Report {
	private Member person;
	
	    // constructor with no parameters
	public MemberReport(Member person){
		super();
		this.person = person;
	}
	
	public void generateReport(int memberNumber) {
    }
	
    //returns the member number
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
    
	// submits the Member report record
	public void displayRecord(){
		System.out.println(getDateTime() + "\n" + getDateProvided() + "\n" + getPNumber() + "\n" + "\n" + getServiceCode() + "\n" + getComments() + "\n" );
	}
	// 335434 0- 888 - 1010
	
}