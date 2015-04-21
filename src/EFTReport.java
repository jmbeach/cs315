
public class EFTReport {
	private Provider person;
	
	public EFTReport(Provider person) {
		this.person = person;
		generateReport();
	}
	
	public void generateReport(){
		System.out.println(person.getName());
		System.out.println(person.getNumber());
		System.out.println(person.getMoneyEarned());
	}
}
