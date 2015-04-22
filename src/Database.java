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
	private static final String strMemberSavePath = strSavePath
			+ "\\member.sav";
	private static final String strProviderSavePath = strSavePath
			+ "\\provider.sav";
	private static final String strRecordSavePath = strSavePath
			+ "\\record.sav";

	// hashed on member number
	static Map<Integer, Member> members = new HashMap<Integer, Member>();
	// Hashed on provider number
	static Map<Integer, Provider> providers = new HashMap<Integer, Provider>();
	// Hashed on provider number
	static Map<Integer, Record> providerBillRecords = new HashMap<Integer, Record>();

	/**
	 * Database loads members, providers, and the provider's bill records
	 */
	
	public Database() {
		members = loadMembers();
		providers = loadProviders();
		providerBillRecords = loadProviderBillRecords();
	}
	
	/**
	 * 
	 * @param person adds member to system with member number
	 */

	public void addMember(Member person) {
		members.put(person.getNumber(), person);
	}

	/**
	 * 
	 * @param person removes member from system
	 */
	
	public void removeMember(Member person) {
		members.remove(person.getNumber());
	}
	
	/**
	 * 
	 * @param person adds provider to system with provider number
	 */

	public void addProvider(Provider person) {
		providers.put(person.getNumber(), person);
	}
	
	/**
	 * 
	 * @param person removes provider from system based on provider number
	 */

	public void removeProvider(Provider person) {
		providers.remove(person.getNumber());
	}
	
	/**
	 * 
	 * @param report adds billing records from provider based on provider number
	 */

	public void addProviderBillRecord(Record report) {
		providerBillRecords.put(report.providerNumber, report);
	}
	
	/**
	 * 
	 * @param report removes bill records based on provider number
	 */

	public void removeBillRecord(Record report) {
		providerBillRecords.remove(report.providerNumber);
	}
	
	/**
	 * 
	 * @param memberId retrieves member ID
	 * @return returns the member ID that was retrived
	 */

	public Member getMember(int memberId) {
		return members.get(memberId);
	}
	
	/**
	 * 
	 * @param serviceCode uses service code provided to check against listed service codes
	 * @return if service code matches, returns the provided service name
	 */

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
	
	/**
	 * 
	 * @param providerNumber looks up provider based on supplied provider number
	 * @return returns the name of the provider number
	 */

	public Provider getProvider(int providerNumber) {
		return providers.get(providerNumber);
	}
	
	/**
	 * 
	 * @param providerNumber uses supplied provider number to look up bill records
	 * @return returns bill records based on the provider number supplied
	 */

	public Record getProviderBillRecord(int providerNumber) {
		return providerBillRecords.get(providerNumber);
	}
	
	/**
	 * saves members, providers, and provider records to database
	 */

	public void saveDb() {
		saveMembers();
		saveProviderRecords();
		saveProviders();
	}
	
	/**
	 * saves members to database
	 */

	private void saveMembers() {
		saveObject(strMemberSavePath, members);
	}
	
	/**
	 * 
	 * @return loads members in database
	 */

	private Map<Integer, Member> loadMembers() {
		Map<Integer, Member> members = (Map<Integer, Member>) loadObject(strMemberSavePath);
		if (members == null) {
			return new HashMap<Integer, Member>();
		}
		return members;
	}
	
	/**
	 * saves providers to database
	 */

	private void saveProviders() {
		saveObject(strProviderSavePath, providers);
	}
	
	/**
	 * 
	 * @return loads providers in database
	 */

	private Map<Integer, Provider> loadProviders() {
		Map<Integer, Provider> providers = (Map<Integer, Provider>) loadObject(strProviderSavePath);
		if (providers == null) {
			return new HashMap<Integer, Provider>();
		}
		return providers;
	}
	
	/**
	 * saves provider records to database
	 */

	private void saveProviderRecords() {
		saveObject(strRecordSavePath, providerBillRecords);
	}
	
	/**
	 * 
	 * @return loads bill records for provider services
	 */

	private Map<Integer, Record> loadProviderBillRecords() {
		Map<Integer, Record> providerBillRecords = (Map<Integer, Record>) loadObject(strRecordSavePath);
		if (providerBillRecords == null) {
			return new HashMap<Integer, Record>();
		}
		return providerBillRecords;
	}
	
	/**
	 * 
	 * @param path determines where to save object provided
	 * @param toSave object provided to be saved at path
	 */

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
	
	/**
	 * 
	 * @param path determines where to load object from
	 * @return returns object loaded from path, If no path, returns nothing
	 */

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
}
