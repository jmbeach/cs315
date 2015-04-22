//written by Matt Williams
//documentation by Hannah Hoover

public class VerifyUser {
	private Member person;
	private Provider prov;
	
	/**
	 * Constructor for VerifyUser for Member
	 * @param person
	 */
	public VerifyUser(Member person){
		this.person = person;
		
	}
	
	/**
	 * Constructor for VerifyUser for Provider
	 * @param prov
	 */
	public VerifyUser(Provider prov){
		this.prov = prov;
	}
	
	/**
	 * Verifies member's status, member or nonmember
	 * @return
	 */
	public String verifyMember() {
		//System.out.println(this.person.getStatus());
		return person.getStatus();
	}

}
