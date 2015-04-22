/*
 * CS315 Assignment 4, EFTReport class
 * Hannah Hoover 
 */
public class EFTReport {
	private Provider person;
	
	public EFTReport(Provider person) {
		this.person = person;
		generateReport();
	}
	
	/**
	 * Generates the EFT Report
	 */
	public void generateReport(){
		System.out.println("Provider Name: " + person.getName());
		System.out.println("Provider Number: " +  person.getNumber());
		System.out.println("Amount to be Paid: " + "$" + person.getMoneyEarned());
	}
}
