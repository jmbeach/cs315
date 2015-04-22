import java.util.HashMap;
import java.util.Map;

// written by Matt Willams -
public class Database implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// hashed on member number
	static Map<Integer, Member> members = new HashMap<Integer, Member>();
	// Hashed on provider number
	static Map<Integer, Provider> providers = new HashMap<Integer, Provider>();
	// Hashed on provider number
	static Map<Integer, Record> providerBillRecords = new HashMap<Integer, Record>();

	public Database() {

	}

	public void addMember(Member person) {
		members.put(person.getNumber(), person);
	}

	public void removeMember(Member person) {
		members.remove(person.getNumber());
	}

	public void addProvider(Provider person) {
		providers.put(person.getNumber(), person);
	}

	public void removeProvider(Provider person) {
		providers.remove(person.getNumber());
	}

	public void addProviderBillRecord(Record report) {
		providerBillRecords.put(report.providerNumber, report);
	}

	public void removeBillRecord(Record report) {
		providerBillRecords.remove(report.providerNumber);
	}

	public Member getMember(int memberId) {
		return members.get(memberId);
	}

	public String getServiceName(int serviceCode) {
		if (serviceCode == 666665) {
			return "Diet Consultation";
		} else if (serviceCode == 451956) {
			return "Excercise Session";
		} else if (serviceCode == 102865) {
			return "Massage Session";
		} else if (serviceCode == 551947) {
			return "Weight-loss Crying Session";
		} else if (serviceCode == 800085) {
			return "Yoga Session";
		}
		return "Incorrect Code";

	}

	public Provider getProvider(int providerNumber) {
		return providers.get(providerNumber);
	}

	public Record getProviderBillRecord(int providerNumber) {
		return providerBillRecords.get(providerNumber);
	}

}
