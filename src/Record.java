
public class Record {
	private String date;
	private String time;
	private String dateOfServices;
	private String providerNumber;
	private String memberNumber;
	private String serviceCode;
	private String comments;
	private Member user;
	
	
	public void setDateTime(String newDate, String newTime){
		date = newDate;
		time = newTime;
	}
	
	public void setDateProvided(String providedDate){
		dateOfServices = providedDate;
		
	}
	
	public void setPNumber(String provider){
		providerNumber = provider;
	}
	
	public void setUNumber(String member){
		memberNumber = member;
	}
	
	public void setServiceCode(String code){
		serviceCode = code;
	}
	
	public void setComments(String notes){
		comments = notes;
	}
	
	public void selectUser(Member person){
		user = person;
	}
	
	public void loadUser() {
		
	}
	
}
