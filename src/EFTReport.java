/**
 * 
 * @author Kaylyn-Wright
 * EFT Report class.
 */
public class EFTReport {
	private Provider person;
	/**
	 * constructor for EFTReport, takes in a Provider object
	 * @param person
	 */
	public EFTReport(Provider person) {
		this.person = person;
		generateReport();
	}
	
	/**
	 * Generates the EFT Report, which contains the provider's name, number, and 
	 * amount to be paid for the week
	 */
	public void generateReport(){
		System.out.println("Provider Name: " + person.getName());
		System.out.println("Provider Number: " +  person.getNumber());
		System.out.println("Amount to be Paid: " + "$" + person.getMoneyEarned());
	}
}
