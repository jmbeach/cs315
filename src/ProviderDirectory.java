// written by Matt Williams

/**
 * Provider Directory class that holds the information of Services, Service Code, and Service prices
 * @author Matt
 *
 */
public class ProviderDirectory {
	
	/**
	 * Constructor for the Provider Directory
	 */
	public ProviderDirectory(){
		returnInfo();
		
	}
	
	/**
	 * prints the information of all of the services, their service code, and their prices
	 */
	public void returnInfo(){
		System.out.println("Diet Consultation"+", "+ "666665"+", "+ "50.45");
		System.out.println("Exercise Session"+", "+ "4519568"+", "+ "12.99");
		System.out.println("Massage Session"+", "+ "102865"+", "+ "21.45");
		System.out.println("Weight-loss Crying Session"+", "+ "551947"+", "+ "349.99");
		System.out.println("Yoga Session"+", "+ "800085"+", "+ "54.69");
	}
	public String returnService(int serviceCode){
		if (serviceCode == 666665){
			return ("Diet Consultation");
		}
		else if (serviceCode == 4519568){
			return ("Exercise Session");
		}
		else if (serviceCode == 102865){
			return ("Massage Session");
		}
		else if (serviceCode == 551947){
			return ("Weight-loss Crying Session");
		}
		else if (serviceCode ==800085){
			return ("Yoga Session");
		}
		else{
			return ("Invalid service code");
		}
	}
	
	// test
}
