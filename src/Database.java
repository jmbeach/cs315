import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

// written by Matt Willams -
public class Database implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String strSavePath = System.getProperty("user.dir");
	private static final String strMemberSavePath = isWindows()? strSavePath
			+ "\\member.sav" : strSavePath + "/member.sav";
	private static final String strProviderSavePath = isWindows()? strSavePath
			+ "\\provider.sav" : strSavePath + "/provider.sav";
	private static final String strRecordSavePath = isWindows()? strSavePath
			+ "\\record.sav" : strSavePath + "/record.sav";

	// hashed on member number
	static Map<Integer, Member> members = new HashMap<Integer, Member>();
	// Hashed on provider number
	static Map<Integer, Provider> providers = new HashMap<Integer, Provider>();
	// Hashed on provider number
	static Map<Integer, Record> providerBillRecords = new HashMap<Integer, Record>();

	public Database() {
		System.out.println(strMemberSavePath);
		members = loadMembers();
		providers = loadProviders();
		providerBillRecords = loadProviderBillRecords();
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

	public void saveDb() {
		saveMembers();
		saveProviderRecords();
		saveProviders();
	}

	private void saveMembers() {
		saveObject(strMemberSavePath, members);
	}

	private Map<Integer, Member> loadMembers() {
		Map<Integer, Member> members = (Map<Integer, Member>) loadObject(strMemberSavePath);
		if (members == null) {
			return new HashMap<Integer, Member>();
		}
		return members;
	}

	private void saveProviders() {
		saveObject(strProviderSavePath, providers);
	}

	private Map<Integer, Provider> loadProviders() {
		Map<Integer, Provider> providers = (Map<Integer, Provider>) loadObject(strProviderSavePath);
		if (providers == null) {
			return new HashMap<Integer, Provider>();
		}
		return providers;
	}

	private void saveProviderRecords() {
		saveObject(strRecordSavePath, providerBillRecords);
	}

	private Map<Integer, Record> loadProviderBillRecords() {
		Map<Integer, Record> providerBillRecords = (Map<Integer, Record>) loadObject(strRecordSavePath);
		if (providerBillRecords == null) {
			return new HashMap<Integer, Record>();
		}
		return providerBillRecords;
	}

	private void saveObject(String path, Object toSave) {
		try {
			FileOutputStream stream = new FileOutputStream(path);
			ObjectOutputStream objectStream = new ObjectOutputStream(stream);
			objectStream.writeObject(toSave);
			objectStream.close();
			stream.close();
		} catch (IOException e) {
			System.out
					.println("The database could not be found. Are you running the program from the correct location?");
		}
	}

	private static Object loadObject(String path) {
		try {
			FileInputStream stream = new FileInputStream(path);
			ObjectInputStream objectStream = new ObjectInputStream(stream);
			Object obj = objectStream.readObject();
			objectStream.close();
			stream.close();
			return obj;
		} catch (IOException | ClassNotFoundException e) {
			System.out
					.println("Could not load database. Are you running the program from the correct location?");
		}
		return null;
	}
	private static boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().indexOf("win") > 0;
	}
}
