// written by Matt Williams


public class ProviderDirectory {
	private String serviceName;
	private String serviceCode;
	private String serviceFee;
	
	
	public ProviderDirectory(String serviceProvided){
		serviceCode = returnCode(serviceProvided);
		serviceFee = returnFee(serviceCode);
		System.out.println(returnDisplay());
	}
	
	public String returnCode(String service){
		if (service == "Excercise Session"){
			return "4519568";
		}else if (service == "Weight-loss Crying Session"){
			return "551947";
		}else if (service == "Massage Session"){
			return "102865";
		}else if (service == "Yoga Session"){
			return "800085";
		}else if (service == "Diet Consultation"){
			return "666665";
		}
		return "Service not found";
	}
	
	public String returnFee(String service){
		if (serviceCode == "4519568"){
			return "12.99";
		}else if (serviceCode == "551947"){
			return "349.99";
		}else if (serviceCode == "102865"){
			return "21.45";
		}else if (serviceCode == "800085"){
			return "54.69";
		}else if (serviceCode == "666665"){
			return "50.45";
		}
		return "Service not found";
	}
	
	public String returnDisplay(){
		return serviceCode + "," + serviceFee;
	}
}
