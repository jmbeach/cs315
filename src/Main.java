import java.io.Console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * @author Jared
 * 
 */

// comment here
public class Main {
	private static Console _co;
	private static final int _userNumberLength = 9;
	private static final String strCancel = "cancel";
	// load db from db.sav file
	// Creating a new db will overwrite this file.
	private static Database _db = new Database();

	// private static Database _db = Database.loadDb();

	/**
	 * Starts the ChocAn terminal
	 * 
	 * @param args
	 *            There are no command line arguments
	 */
	// open console to bin folder and run "java Main"
	public static void main(String[] args) {
		_co = System.console();

		// Region Hard-coded members and providers

		// Made Database class write to db.sav file so these hardcoded values
		// are already in database, but don't delete code in case we need to
		// start over.

		// Provider p = new Provider("Octavius", 123456789, "345 avenue",
		// "Tuscaloosa", "AL", "35404");
		// Member m = new Member("Dillon", 356661111, "417 Prince Acres",
		// "Tuscaloosa", "AL", "35404");
		// Member o = new Member("Matt", 236544444, "417 Prince Acres",
		// "Tuscaloosa", "AL", "35404");
		// _db.addMember(m);
		// _db.addMember(o);
		// _db.addProvider(p);
		// _db.saveDb();

		// EndRegion Hard-coded members and providers

		// display welcome message
		println("Welcome to ChocAn!");
		displayMainMenu();
	}

	// Region MENU_DISPLAYS
	/**
	 * Display's ChocAn's sign-in menu for signing in a member or provider.
	 */
	private static void displayMainMenu() {
		System.out
				.print("Menu:\n\t1) sign-in\n\t2) sign-out\n\t3) provider-menu\n\tn) exit\n\nchocAn>");
		// read the user's choice from command line
		String choice = _co.readLine();
		handleMainMenuChoice(choice);
	}

	/**
	 * Displays ChocAn's sign-in menu for signing in a member or provider.
	 */
	private static void displaySigninMenu() {
		print("Signing in:\n\tMenu:\n\t\t1) member\n\t\t2) provider\n\t\t3) back\nchocAn>");
		// read in sign-in sub option
		String signInChoice = _co.readLine();
		handleSigninChoice(signInChoice);
	}

	/**
	 * Displays ChocAn's sign-out menu for signing out a member or provider
	 */

	private static void displaySignOutMenu() {
		print("Signing out:\nMenu:\n\t1) member\n\t2) provider\n\t3) back\n\nchocAn>");
		// read in sign-out option
		String signOutChoice = _co.readLine();
		// handle choice
		switch (signOutChoice) {
		case "1":
		case "member":
			// do sign-out
			print("Signing out member:\nEnter member number: ");
			String strMemberNumber = _co.readLine();
			if (!isNumberLengthValid(strMemberNumber)) {
				displaySignOutMenu();
				return;
			}
			Integer memberNumber = 0;
			try {
				memberNumber = Integer.parseInt(strMemberNumber);
			} catch (Exception e) {
				println("Member number format not valid.");
				displaySignOutMenu();
			}
			println("Finding member in database...");
			Member member = _db.getMember(memberNumber);
			if (member != null) {
				// if member not signed in
				if (member.isSignedIn()) {
					println("Sign out successful!\nGood-bye, "
							+ member.getName() + ".");
					member.signOut();
					_db.saveDb();
					displayMainMenu();
				} else {
					println("Member, " + member.getName()
							+ " is already signed out.");
					displayMainMenu();
				}
			} else {
				println("Member could not be found.");
				displaySignOutMenu();
			}
			break;
		case "2":
		case "provider":
			// do sign-out
			print("Signing out provider:\nEnter in provider number: ");
			String strProviderNumber = _co.readLine();
			if (!isNumberLengthValid(strProviderNumber)) {
				displaySignOutMenu();
				return;
			}
			Integer providerNumber = 0;
			try {
				providerNumber = Integer.parseInt(strProviderNumber);
			} catch (Exception e) {
				println("Provider number format not valid.");
				displaySignOutMenu();
			}
			println("Finding provider in database...");
			Provider provider = _db.getProvider(providerNumber);
			if (provider != null) {
				if (!provider.isSignedIn()) {
					println("Sign out successful!\nGoodbye, "
							+ provider.getName() + ".");
					provider.signOut();
					_db.saveDb();
					displayMainMenu();
				} else {
					println("Provider, " + provider.getName()
							+ " already signed out.");
					displayMainMenu();
				}
			} else {
				println("Provider could not be found.");
				displaySignOutMenu();
			}
			break;
		case "3":
		case "back":
			// go back to main menu
			displayMainMenu();
			break;
		default:
			// correct the user
			println("Your input was invalid.");
			displaySignOutMenu();
			break;
		}
	}

	private static void displayProviderMenu() {
		print("Provider menu:\n\t1) info-update\n\t2) bill\n\t3) add-user\n\t4) delete-user\n\t5) back\n\t6) request report\n\t7)EFT report\n\nchocAn>");
		String choice = _co.readLine();
		switch (choice) {
		case "1":
		case "info-update":
			// do info update
			// display info update menu
			displayInfoUpdateMenu();
			break;
		case "2":
		case "bill":
			// bill chcocAn
			displayBillChocAnMenu();
			break;
		case "3":
		case "add-user":
			// add user menu
			displayAddUserMenu();
			break;
		case "4":
		case "delete-user":
			System.out
					.println("Delete Member or Provider? Enter member or provider");
			String memProvChoice = _co.readLine();
			if (memProvChoice.equals("member")) {
				print("Request Report:\nEnter member number: ");
				String strMemberNumber = _co.readLine();
				if (!isNumberLengthValid(strMemberNumber)) {
					displayProviderMenu();
					return;
				}
				Integer memberNumber = 0;
				try {
					memberNumber = Integer.parseInt(strMemberNumber);
				} catch (Exception e) {
					println("Member number format not valid.");
					displayProviderMenu();
				}
				println("Finding member in database...");
				Member member = _db.getMember(memberNumber);
				if (member != null) {
					_db.removeMember(member);
					System.out.println("Member Removed");

					displayProviderMenu();
				} else {
					print("Request Report:\nEnter provider number: ");
					String strProviderNumber = _co.readLine();
					if (!isNumberLengthValid(strProviderNumber)) {
						displayProviderMenu();
						return;
					}
					Integer providerNumber = 0;
					try {
						providerNumber = Integer.parseInt(strProviderNumber);
					} catch (Exception e) {
						println("Provider number format not valid.");
						displayProviderMenu();
					}
					println("Finding provider in database...");
					Provider provider = _db.getProvider(providerNumber);
					if (provider != null) {
						_db.removeProvider(provider);
						System.out.println("Provider Removed");

						displayProviderMenu();

					}

				}
			}
			break;
		case "5":
		case "back":
			displayMainMenu();
			break;
		case "6":
			print("Request Report:\nEnter provider number: ");
			String strProviderNumber1 = _co.readLine();
			if (!isNumberLengthValid(strProviderNumber1)) {
				displayProviderMenu();
				return;
			}
			Integer providerNumber1 = 0;
			try {
				providerNumber1 = Integer.parseInt(strProviderNumber1);
			} catch (Exception e) {
				println("Provider number format not valid.");
				displayProviderMenu();
			}
			println("Finding provider in database...");
			Provider provider1 = _db.getProvider(providerNumber1);
			if (provider1 != null) {
				ProviderReport provRep = new ProviderReport(provider1);
				System.out.println("Return to Menu? Enter yes");
				String choice1 = _co.readLine();
				if (choice1.equals("yes")) {
					displayProviderMenu();
				} else {
				}

			}
			break;
		case "7":
			print("Request Report:\nEnter provider number: ");
			String strProviderNumber11 = _co.readLine();
			if (!isNumberLengthValid(strProviderNumber11)) {
				displayProviderMenu();
				return;
			}
			Integer providerNumber11 = 0;
			try {
				providerNumber11 = Integer.parseInt(strProviderNumber11);
			} catch (Exception e) {
				println("Provider number format not valid.");
				displayProviderMenu();
			}
			println("Finding provider in database...");
			Provider provider11 = _db.getProvider(providerNumber11);
			if (provider11 != null) {
				EFTReport provRep = new EFTReport(provider11);
				System.out.println("Return to Menu? Enter yes");
				String choice1 = _co.readLine();
				if (choice1.equals("yes")) {
					displayProviderMenu();
				} else {
				}
			}
		default:
			// correct the input
			println("Input invalid");
			displayProviderMenu();
			break;
		}
	}

	private static void displayAddUserMenu() {
		print("Add user menu:\n\t1) member\n\t2) provider\n\t3) back\n\nchockAn>");
		String choice = _co.readLine();
		switch (choice) {
		case "1":
		case "member":
			// display add member
			displayAddMember();
			break;
		case "2":
		case "provider":
			displayAddProvider();
			break;
		case "3":
		case "back":
			displayProviderMenu();
			break;
		default:
			println("Input invalid");
			displayProviderMenu();
			break;
		}
	}

	private static void displayAddProvider() {
		print("Enter (9-digit) provider number");
		String number = _co.readLine();
		if (!isNumberLengthValid(number)) {
			displayAddProvider();
			return;
		}
		Integer memberNumber = 0;
		try {
			memberNumber = Integer.parseInt(number);
		} catch (Exception e) {
			println("Number format not valid.");
			displayAddMember();
		}
		Provider newMember = new Provider();
		newMember.setNumber(memberNumber);
		print("Enter name: ");
		String name = _co.readLine();
		newMember.setName(name);
		print("Enter address: ");
		String address = _co.readLine();
		newMember.setAddress(address);
		print("Enter city: ");
		String city = _co.readLine();
		newMember.setAddress(city);
		print("Enter state: ");
		String state = _co.readLine();
		newMember.setState(state);
		print("Enter zip-code: ");
		String zip = _co.readLine();
		newMember.setZipCode(zip);
		_db.addProvider(newMember);
		_db.saveDb();
		println("New provider " + newMember.getName() + " created.");
	}

	private static void displayAddMember() {
		print("Enter (9-digit) member number");
		String number = _co.readLine();
		if (!isNumberLengthValid(number)) {
			displayAddMember();
			return;
		}
		Integer memberNumber = 0;
		try {
			memberNumber = Integer.parseInt(number);
		} catch (Exception e) {
			println("Member number format not valid.");
			displayAddMember();
		}
		Member newMember = new Member();
		newMember.setNumber(memberNumber);
		print("Enter member name: ");
		String name = _co.readLine();
		newMember.setName(name);
		print("Enter member address: ");
		String address = _co.readLine();
		newMember.setAddress(address);
		print("Enter member city: ");
		String city = _co.readLine();
		newMember.setAddress(city);
		print("Enter member state: ");
		String state = _co.readLine();
		newMember.setState(state);
		print("Enter member zip-code: ");
		String zip = _co.readLine();
		newMember.setZipCode(zip);
		_db.addMember(newMember);
		_db.saveDb();
		println("New member " + newMember.getName() + " created.");
	}

	private static void displayInfoUpdateMenu() {
		print("Info Update Menu:\n\t1) member\n\t2) provider\n\t3) back\n\nchocAn>");
		String choice = _co.readLine();
		switch (choice) {
		case "1":
		case "member":
			// show member update menu
			displayMemberInfoUpdateMenu();
			break;
		case "2":
		case "provider":
			// show provider update menu
			displayProviderInfoUpdateMenu();
			break;
		case "3":
		case "back":
			displayProviderMenu();
			break;
		default:
			// correct the input
			println("Input invalid");
			displayInfoUpdateMenu();
			break;
		}
	}

	private static void displayProviderInfoUpdateMenu() {
		print("Provider lookup:\nEnter provider number: ");
		String strProviderNumber = _co.readLine();
		if (!isNumberLengthValid(strProviderNumber)) {
			displayInfoUpdateMenu();
			return;
		}
		Integer providerNumber = 0;
		try {
			providerNumber = Integer.parseInt(strProviderNumber);
		} catch (Exception e) {
			println("Provider number format not valid.");
			displayInfoUpdateMenu();
		}
		println("Finding provider in database...");
		Provider provider = _db.getProvider(providerNumber);
		if (provider != null) {
			// display member info update menu
			displaySpecificProviderUpdateMenu(provider);
		} else {
			println("Invalid Number");
			println("Member could not be found.");
			displayInfoUpdateMenu();
		}
	}

	public static void displayMemberInfoUpdateMenu() {
		print("Member lookup:\nEnter member number: ");
		String strMemberNumber = _co.readLine();
		if (!isNumberLengthValid(strMemberNumber)) {
			displayInfoUpdateMenu();
			return;
		}
		Integer memberNumber = 0;
		try {
			memberNumber = Integer.parseInt(strMemberNumber);
		} catch (Exception e) {
			println("Member number format not valid.");
			displayInfoUpdateMenu();
		}
		println("Finding member in database...");
		Member member = _db.getMember(memberNumber);
		if (member != null) {
			// display member info update menu
			displaySpecificMemberUpdateMenu(member);
		} else {
			println("Invalid Number");
			println("Member could not be found.");
			displayInfoUpdateMenu();
		}
	}

	private static void displaySpecificProviderUpdateMenu(Provider provider) {
		print("Editing provider: "
				+ provider.getName()
				+ "\nMenu:\n\t1) name\n\t2) number\n\t3) address\n\t4) city\n\t5) state\n\t6) zip-code\n\t7) back\n\nchocAn>");
		String infoChoice = _co.readLine();
		switch (infoChoice) {
		case "1":
		case "name":
			// ask for edits or cancel
			print("\nInput new name or type \"cancel\": ");
			String newName = _co.readLine();
			if (newName.equals(strCancel)) {
				println("Canceled.");
				displaySpecificProviderUpdateMenu(provider);
			} else {
				provider.setName(newName);
				println("\nNew name set successfully to: " + newName + "\n");
				displaySpecificProviderUpdateMenu(provider);
				_db.saveDb();
			}
			break;
		case "2":
		case "number":
			print("\nInput new (9-digit) number or type \"cancel\": ");
			String strInput = _co.readLine();
			if (isCanceled(strInput)) {
				displaySpecificProviderUpdateMenu(provider);
				return;
			}
			if (!isNumberLengthValid(strInput)) {
				displaySpecificProviderUpdateMenu(provider);
				return;
			}
			Integer newNumber = 0;
			try {
				newNumber = Integer.parseInt(strInput);
			} catch (Exception e) {
				println("\nUser number format not valid.");
				displaySpecificProviderUpdateMenu(provider);
			}
			int oldNumber = provider.getNumber();
			provider.setNumber(newNumber);
			_db.removeProvider(oldNumber);
			_db.addProvider(provider);
			_db.saveDb();
			println("\nProvider number successfully set to " + newNumber + "\n");
			displaySpecificProviderUpdateMenu(provider);
			break;
		case "3":
		case "address":
			print("\nInput new provider address or type \"cancel\": ");
			String newAddress = _co.readLine();
			if (isCanceled(newAddress)) {
				displaySpecificProviderUpdateMenu(provider);
				return;
			}
			provider.setAddress(newAddress);
			_db.saveDb();
			println("\nSuccessfully saved new address: " + newAddress + "\n");
			displaySpecificProviderUpdateMenu(provider);
			break;
		case "4":
		case "city":
			print("\nInput new city or type \"cancel\": ");
			String newCity = _co.readLine();
			if (isCanceled(newCity)) {
				displaySpecificProviderUpdateMenu(provider);
				return;
			}
			provider.setCity(newCity);
			_db.saveDb();
			println("\nSuccessfully saved new city: " + newCity + "\n");
			displaySpecificProviderUpdateMenu(provider);
			break;
		case "5":
		case "state":
			print("\nInput new state or type \"cancel\": ");
			String newState = _co.readLine();
			if (isCanceled(newState)) {
				displaySpecificProviderUpdateMenu(provider);
				return;
			}
			provider.setState(newState);
			_db.saveDb();
			println("\nSuccessfully saved new state: " + newState + "\n");
			displaySpecificProviderUpdateMenu(provider);
			break;
		case "6":
		case "zip-code":
			print("\nInput new zip-code or type \"cancel\": ");
			String newZip = _co.readLine();
			if (isCanceled(newZip)) {
				displaySpecificProviderUpdateMenu(provider);
				return;
			}
			provider.setZipCode(newZip);
			println("\nSuccessfully saved new zip-code: " + newZip + "\n");
			_db.saveDb();
			displaySpecificProviderUpdateMenu(provider);
			break;
		case "7":
		case "back":
			displayProviderMenu();
			break;
		default:
			// correct user;
			println("Input invalid.");
			displaySpecificProviderUpdateMenu(provider);
			break;
		}
	}

	private static void displaySpecificMemberUpdateMenu(Member member) {
		print("Editing member: "
				+ member.getName()
				+ "\nMenu:\n\t1) name\n\t2) number\n\t3) address\n\t4) city\n\t5) state\n\t6) zip-code\n\t7) suspension\n\t8) back\n\nchocAn>");
		String infoChoice = _co.readLine();
		switch (infoChoice) {
		case "1":
		case "name":
			// ask for edits or cancel
			print("\nInput new name or type \"cancel\": ");
			String newName = _co.readLine();
			if (newName.equals(strCancel)) {
				println("Canceled.");
				displaySpecificMemberUpdateMenu(member);
			} else {
				member.setName(newName);
				println("\nNew name set successfully to: " + newName + "\n");
				displaySpecificMemberUpdateMenu(member);
				_db.saveDb();
			}
			break;
		case "2":
		case "number":
			print("\nInput new (9-digit) number or type \"cancel\": ");
			String strInput = _co.readLine();
			if (isCanceled(strInput)) {
				displaySpecificMemberUpdateMenu(member);
				return;
			}
			if (!isNumberLengthValid(strInput)) {
				displaySpecificMemberUpdateMenu(member);
				return;
			}
			Integer newNumber = 0;
			try {
				newNumber = Integer.parseInt(strInput);
			} catch (Exception e) {
				println("\nMember number format not valid.");
				displaySpecificMemberUpdateMenu(member);
			}
			int oldNumber = member.getNumber();
			member.setNumber(newNumber);
			_db.removeMember(oldNumber);
			_db.addMember(member);
			_db.saveDb();
			println("\nMember number successfully set to " + newNumber + "\n");
			displaySpecificMemberUpdateMenu(member);
			break;
		case "3":
		case "address":
			print("\nInput new member address or type \"cancel\": ");
			String newAddress = _co.readLine();
			if (isCanceled(newAddress)) {
				displaySpecificMemberUpdateMenu(member);
				return;
			}
			member.setAddress(newAddress);
			_db.saveDb();
			println("\nSuccessfully saved new address: " + newAddress + "\n");
			displaySpecificMemberUpdateMenu(member);
			break;
		case "4":
		case "city":
			print("\nInput new member city or type \"cancel\": ");
			String newCity = _co.readLine();
			if (isCanceled(newCity)) {
				displaySpecificMemberUpdateMenu(member);
				return;
			}
			member.setCity(newCity);
			_db.saveDb();
			println("\nSuccessfully saved new city: " + newCity + "\n");
			displaySpecificMemberUpdateMenu(member);
			break;
		case "5":
		case "state":
			print("\nInput new member state or type \"cancel\": ");
			String newState = _co.readLine();
			if (isCanceled(newState)) {
				displaySpecificMemberUpdateMenu(member);
				return;
			}
			member.setState(newState);
			_db.saveDb();
			println("\nSuccessfully saved new state: " + newState + "\n");
			displaySpecificMemberUpdateMenu(member);
			break;
		case "6":
		case "zip-code":
			print("\nInput new member zip-code or type \"cancel\": ");
			String newZip = _co.readLine();
			if (isCanceled(newZip)) {
				displaySpecificMemberUpdateMenu(member);
				return;
			}
			member.setZipCode(newZip);
			println("\nSuccessfully saved new zip-code: " + newZip + "\n");
			_db.saveDb();
			displaySpecificMemberUpdateMenu(member);
			break;
		case "7":
		case "suspension":
			displayMemberSuspensionMenu(member);
			break;
		case "8":
		case "back":
			displayProviderMenu();
			break;
		default:
			// correct user;
			println("Input invalid.");
			displaySpecificMemberUpdateMenu(member);
			break;
		}
	}

	private static void displayMemberSuspensionMenu(Member member) {
		// display member suspension menu
		print("\nMember suspension menu:\n\t1) suspend\n\t2) un-suspend\n\t3) check\n\t4) back\n\nchocAn>");
		String choice = _co.readLine();
		switch (choice) {
		case "1":
		case "suspend":
			// suspend member
			member.suspend();
			_db.saveDb();
			println("Member suspended.");
			displaySpecificMemberUpdateMenu(member);
			break;
		case "2":
		case "un-suspend":
			// unsuspend member
			member.unSuspend();
			_db.saveDb();
			println("Member un-suspended.");
			displaySpecificMemberUpdateMenu(member);
			break;
		case "3":
		case "check":
			// check member suspension status
			if (member.isSuspended()) {
				println("Member is suspended.");
			} else {
				println("Member is not suspended.");
			}
			displaySpecificMemberUpdateMenu(member);
			break;
		case "4":
		case "back":
			displaySpecificMemberUpdateMenu(member);
			break;
		default:
			// correct the user.
			println("\nInput invalid\n");
			displayMemberSuspensionMenu(member);
			break;
		}
	}

	public static void displayBillChocAnMenu() {
		print("Billing ChocAn:\nEnter provider number: ");
		String strProviderNumber = _co.readLine();
		if (!isNumberLengthValid(strProviderNumber)) {
			displayProviderMenu();
			return;
		}
		Integer providerNumber = 0;
		try {
			providerNumber = Integer.parseInt(strProviderNumber);
		} catch (Exception e) {
			println("Provider number format not valid.");
			displayProviderMenu();
		}
		println("Finding provider in database...");
		Provider provider = _db.getProvider(providerNumber);
		if (provider != null) {
			// provider enters date
			Record newRec = new Record();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			newRec.setDateTime(dateFormat.format(cal.getTime()));
			println("Please enter the date service was provided in the form:\nMM-DD-YYYY");
			try {
				String date = _co.readLine();
				newRec.setDateProvided(date);
			} catch (Exception e) {
				println("Date format not valid.");
				displayProviderMenu();
			}
			println("Please enter the member number");
			try {
				String memNum = _co.readLine();
				int intMemNum = Integer.parseInt(memNum);
				newRec.setUNumber(intMemNum);
			} catch (Exception e) {
				println("Date format not valid.");
				displayProviderMenu();
			}
			// provider looks up service code
			println("look up the service code in the Provider Directory:");
			ProviderDirectory provdir = new ProviderDirectory();
			try {
				String servCode = _co.readLine();
				int intServCode = Integer.parseInt(servCode);
				newRec.setServiceCode(intServCode);
				println("Service code correct? enter yes or no");
				System.out.println(provdir.returnService(intServCode));
				String agreeIsValid = _co.readLine();
				if (agreeIsValid.equals("yes")) {
					newRec.setServiceCode(intServCode);
					newRec.setPNumber(provider.getNumber());
					System.out.println("Enter comments? Enter yes or no");
					String commentDecision = _co.readLine();
					if (commentDecision.equals("yes")) {
						System.out.println("enter comments:");
						String comments = _co.readLine();
						newRec.setComments(comments);

					} else {
						newRec.setComments("");
					}
					System.out.println();
				} else {
					println("Service Code not Valid");
					displayProviderMenu();
				}
			} catch (Exception e) {
				println("Service Code not Valid");
				displayProviderMenu();
			}
			System.out.println("Is the record correct? Enter yes or no");
			System.out.println(newRec.getDate());
			System.out.println(newRec.getDateOfServices());
			System.out.println(newRec.getProviderNumber());
			System.out.println(newRec.getMemberNumber());
			System.out.println(newRec.getServiceCode());
			System.out.println(newRec.getComments());
			String correctDecision = _co.readLine();
			if (correctDecision.equals("yes")) {
				Member member = _db.getMember(newRec.getMemberNumber());
				newRec.selectUser(member);
				double fee = newRec.calculateFee(newRec.getServiceCode());
				newRec.createRecord();
				System.out.println("Record created, returning to menu");
				// double fee = newRec.calculateFee(newRec.getServiceCode());
				System.out.println("Total fee: " + fee);
				provider.addMoneyEarned((float) fee);
				_db.saveDb();
				displayProviderMenu();
			} else {
				System.out.println("Returning to menu");
				displayProviderMenu();
			}
			// ask for verification of service code
			// optionally enters comments

			// record is submitted and saved with db

			// software looks up and displays fees

		} else {
			println("Provider could not be found.");
			displaySigninMenu();
		}
	}

	// EndRegion

	/**
	 * Uses the user's input at the Main menu to help navigate through ChocAn.
	 * 
	 * @param choice
	 *            the user's input at the main-menu
	 */
	private static void handleMainMenuChoice(String choice) {
		switch (choice) {
		case "1":
		case "sign-in":
			displaySigninMenu();
			break;
		case "2":
		case "sign-out":
			// display sign-out menu
			displaySignOutMenu();
		case "3":
		case "provider-menu":
			displayProviderMenu();
			break;
		case "n":
		case "exit":
			// Print exit message
			System.out.println("Bye!");
			// end the program
			return;
		default:
			// The user did not input any of the options we listed
			System.out.println("Your choice was invalid. Please try again.");
			// Wait for the user to try again
			String choiceAttempt = _co.readLine();
			// Call this method recursively until a listed choice is input
			handleMainMenuChoice(choiceAttempt);
		}
	}

	/**
	 * Checks to make sure the passed in user number is the right length. If
	 * not, displays sign-in menu
	 * 
	 * @param strUserNumber
	 *            the user number read from the command line as a string
	 */
	private static boolean isNumberLengthValid(String strUserNumber) {
		int numberLength = strUserNumber.trim().length();
		// if number too short or too long
		if (numberLength != _userNumberLength) {
			System.out.println("\nMember number invalid\n");
			return false;
		}
		return true;
	}

	/**
	 * Uses the user input at the sign-in menu and tries to begin the sign-in
	 * process.
	 * 
	 * @param signInChoice
	 *            The user's command line input from the sign-in menu
	 */
	private static void handleSigninChoice(String signInChoice) {
		switch (signInChoice) {
		case "1":
		case "member":
			handleMemberSignin();
			break;
		case "2":
		case "provider":
			handleProviderSignin();
			break;
		case "3":
		case "back":
			// return back to main menu
			displayMainMenu();
			break;
		default:
			println("Your choice was invalid. Please try again.");
			displaySigninMenu();
		}
	}

	/**
	 * allows the member to enter his/her member number to be validated
	 */

	private static void handleMemberSignin() {
		// handle member sign in
		print("Signing in member:\nEnter member number: ");
		String strMemberNumber = _co.readLine();
		if (!isNumberLengthValid(strMemberNumber)) {
			displaySigninMenu();
			return;
		}
		Integer memberNumber = 0;
		try {
			memberNumber = Integer.parseInt(strMemberNumber);
		} catch (Exception e) {
			println("Member number format not valid.");
			displaySigninMenu();
		}
		println("Finding member in database...");
		Member member = _db.getMember(memberNumber);
		if (member != null) {
			// if member not signed in
			if (!member.isSignedIn()) {
				if (!member.isSuspended()) {
					println("VALID");
					println("Signin successful!\nWelcome, " + member.getName());
					member.signIn();
					_db.saveDb();
					displayMainMenu();
				} else {
					println("Member Suspended");
					println("Member is suspended. can't sign in.");
				}
			} else {
				println("Member, " + member.getName() + " is already signed.");
				displayMainMenu();
			}
		} else {
			println("Invalid Number");
			println("Member could not be found.");
			displaySigninMenu();
		}
	}

	/**
	 * allows the provider to enter his/her member number to be validated
	 */

	private static void handleProviderSignin() {
		// handle provider sign in
		print("Signing in provider:\nEnter in provider number: ");
		String strProviderNumber = _co.readLine();
		if (!isNumberLengthValid(strProviderNumber)) {
			displaySigninMenu();
			return;
		}
		Integer providerNumber = 0;
		try {
			providerNumber = Integer.parseInt(strProviderNumber);
		} catch (Exception e) {
			println("Provider number format not valid.");
			displaySigninMenu();
		}
		println("Finding provider in database...");
		Provider provider = _db.getProvider(providerNumber);
		if (provider != null) {
			if (!provider.isSignedIn()) {
				println("Signin successful!\nWelcome, " + provider.getName());
				provider.signIn();
				_db.saveDb();
				displayMainMenu();
			} else {
				println("Provider, " + provider.getName()
						+ " already signed in.");
				displayMainMenu();
			}
		} else {
			println("Provider could not be found.");
			displaySigninMenu();
		}
	}

	/**
	 * helper function to print a message
	 * 
	 * @param message
	 */
	// Region HELPERS
	private static void println(String message) {
		System.out.println(message);
	}

	/**
	 * helper function to print a message
	 * 
	 * @param message
	 */
	private static void print(String message) {
		System.out.print(message);
	}

	private static boolean isCanceled(String strInput) {
		if (strInput.equals(strCancel)) {
			println("\nCanceled.\n");
			return true;
		}
		return false;
	}
	// EndRegion

}
