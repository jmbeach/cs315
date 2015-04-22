//written by Matt Williams

public class verifyUser {
	private Member person;
	private Provider prov;
	public verifyUser(Member person){
		this.person = person;
		
	}
	public verifyUser(Provider prov){
		this.prov = prov;
	}
	public String verifyMember() {
		//System.out.println(this.person.getStatus());
		return person.getStatus();
	}

}
