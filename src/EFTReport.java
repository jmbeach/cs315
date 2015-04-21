
public class EFTReport {
	private Provider person;
	
	public EFTReport(Provider person) {
		this.person = person;
		generateReport();
	}
	
	public void generateReport(){
		System.out.println("Provider Name: " + person.getName());
		System.out.println("Provider Number: " +  person.getNumber());
		System.out.println("Amount to be Paid: " + "$" + person.getMoneyEarned());
	}
}
