import java.util.ArrayList;

// written by Matt Williams
public class Database {
	
	ArrayList<Member> members = new ArrayList<Member>();
	ArrayList<Provider> providers = new ArrayList<Provider>();
	ArrayList<Record> providerBillRecords = new ArrayList<Record>();
	
	public Database(){
		
	}
	
	public void addMember(Member person){
		members.add(person);
	}
	
	public void removeMember(Member person){
		members.remove(person);
	}
	
	public void addProvider(Provider person){
		providers.add(person);
	}
	
	public void removeProvider(Provider person){
		providers.remove(person);
	}
	
	public void addBillRecord(Record report){
		providerBillRecords.add(report);
	}
	
	public void removeBillRecord(Record report){
		providerBillRecords.remove(report);
	}
	
	public ArrayList<Member> getMembers(){
		return members;
	}
	
	public Member getMember(int memberNumber){
		for (int i=0; i<members.size();i++){
			if (members.get(i).getNumber() == memberNumber){
				return members.get(i);
			}
		}
		return null;
	}
	
	public Provider getProvider(int providerNumber){
		for (int i=0; i<providers.size();i++){
			if (providers.get(i).getNumber() == providerNumber){
				return providers.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Provider> getProviders(){
		return providers;
	}
	
	public ArrayList<Record> getRecords(){
		return providerBillRecords;
	}
}