import java.util.ArrayList;

// written by Matt Willams -
public class Database {
	
	static ArrayList<Member> members = new ArrayList<Member>();
	static ArrayList<Provider> providers = new ArrayList<Provider>();
	static ArrayList<Record> providerBillRecords = new ArrayList<Record>();
	
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
	
	public String getServiceName(int serviceCode){
		if (serviceCode == 666665){
			return "Diet Consultation";
		}else if (serviceCode == 451956){
			return "Excercise Session";
		}else if(serviceCode == 102865){
			return "Massage Session";
		}else if(serviceCode == 551947){
			return "Weight-loss Crying Session";
		}else if(serviceCode == 800085){
			return "Yoga Session";
		}
		return "Incorrect Code";
		
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
