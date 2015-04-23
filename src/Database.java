import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Database Class
 * 
 * @author Matt
 * 
 */
public class Database implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private static final String strSavePath = System.getProperty("user.dir");
	private static final String strMemberSavePath = isWindows() ? strSavePath
			+ "\\member.sav" : strSavePath + "/member.sav";
	private static final String strProviderSavePath = isWindows() ? strSavePath
			+ "\\provider.sav" : strSavePath + "/provider.sav";
	private static final String strRecordSavePath = isWindows() ? strSavePath
			+ "\\record.sav" : strSavePath + "/record.sav";

	// // hashed on member number
	static Map<Integer, Member> members = new HashMap<Integer, Member>();
	// Hashed on provider number
	static Map<Integer, Provider> providers = new HashMap<Integer, Provider>();
	// Hashed on provider number
	static Map<Integer, Record> providerBillRecords = new HashMap<Integer, Record>();

	/**
	 * Database loads members, providers, and the provider's bill records
	 */

	public Database() {
		// System.out.println(strMemberSavePath);
		members = loadMembers();
		providers = loadProviders();
		providerBillRecords = loadProviderBillRecords();
	}

	/**
	 * 
	 * @param person
	 *            This method adds a member to the hashmap members
	 */

	public void addMember(Member person) {
		members.put(person.getNumber(), person);
	}

	/**
	 * 
	 * @param person
	 *            This method removes a member from the hashmap members
	 */

	public void removeMember(Member person) {
		members.remove(person.getNumber());
	}

	public void removeMember(int memberNumber) {
		// comment test
		members.remove(memberNumber);
	}

	/**
	 * 
	 * @param person
	 *            adds provider to system with provider number
	 */

	public void addProvider(Provider person) {
		providers.put(person.getNumber(), person);
	}

	/**
	 * 
	 * @param person
	 *            removes provider from system based on provider number
	 */

	public void removeProvider(Provider person) {
		providers.remove(person.getNumber());
	}

	/**
	 * 
	 * @param report
	 *            adds billing records from provider based on provider number
	 */

	public void addProviderBillRecord(Record report) {
		providerBillRecords.put(report.providerNumber, report);
	}

	/**
	 * 
	 * @param report
	 *            removes bill records based on provider number
	 */

	public void removeBillRecord(Record report) {
		providerBillRecords.remove(report.providerNumber);
	}

	/**
	 * This method takes in a member ID number, and returns the member object
	 * 
	 * @param memberId
	 * @return the member ID that was retrieved
	 */

	public Member getMember(int memberId) {
		return members.get(memberId);
	}

	/**
	 * 
	 * @param serviceCode
	 *            uses service code provided to check against listed service
	 *            codes
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
	 * This method takes in a provider number, and returns a Provider object
	 * 
	 * @param providerNumber
	 * @return the selected provider object
	 */

	public Provider getProvider(int providerNumber) {
		return providers.get(providerNumber);
	}

	/**
	 * @param providerNumber
	 *            uses supplied provider number to look up bill records
	 * @return returns bill records based on the provider number supplied
	 */

	public Record getProviderBillRecord(int providerNumber) {
		return providerBillRecords.get(providerNumber);
	}

	/**
	 * This method saves the members, providers, and provider bill records to
	 * the database
	 */

	public void saveDb() {
		saveMembers();
		saveProviderRecords();
		saveProviders();
	}

	/**
	 * This method saves the members to the database
	 */

	private void saveMembers() {
		saveObject(strMemberSavePath, members);
	}

	/**
	 * This method loads members in database
	 * 
	 * @return a hashmap of members
	 */

	private Map<Integer, Member> loadMembers() {
		Map<Integer, Member> members = (Map<Integer, Member>) loadObject(strMemberSavePath);
		if (members == null) {
			return new HashMap<Integer, Member>();
		}
		return members;
	}

	/**
	 * This method saves providers to database
	 */

	private void saveProviders() {
		saveObject(strProviderSavePath, providers);
	}

	/**
	 * This method loads providers in database
	 * 
	 * @return a hashmap of providers
	 */

	private Map<Integer, Provider> loadProviders() {
		Map<Integer, Provider> providers = (Map<Integer, Provider>) loadObject(strProviderSavePath);
		if (providers == null) {
			return new HashMap<Integer, Provider>();
		}
		return providers;
	}

	/**
	 * This method saves provider records to database
	 */

	private void saveProviderRecords() {
		saveObject(strRecordSavePath, providerBillRecords);
	}

	/**
	 * This method loads bill records for provider services
	 * 
	 * @return a hashmap of provider bill records
	 */

	private Map<Integer, Record> loadProviderBillRecords() {
		Map<Integer, Record> providerBillRecords = (Map<Integer, Record>) loadObject(strRecordSavePath);
		if (providerBillRecords == null) {
			return new HashMap<Integer, Record>();
		}
		return providerBillRecords;
	}

	/**
	 * This method determines where to save object provided to save to path
	 * 
	 * @param path
	 * @param toSave
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
	 * @param path
	 *            determines where to load object from
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

	/**
	 * This method determines is the user is using windows or no
	 * 
	 * @return true if operating system is windows, false otherwise
	 */
	private static boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().indexOf("win") > -1;
	}
}
