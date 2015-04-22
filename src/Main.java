import java.io.Console;

/**
 * 
 * @author Jared
 * 
 */

// comment here
public class Main {
	private static Console _co;
	private static final int _userNumberLength = 6;
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
		// Hard-coded members and providers

		// Made Database class write to db.sav file so these hardcoded values
		// are already in database, but don't delete code in case we need to
		// start over.

		// Provider p = new Provider("Octavius", 123456, "345 anus avenue",
		// "Tuscaloosa", "AL", "35404");
		// Member m = new Member("Dillon", 356661, "417 Prince Acres",
		// "Tuscaloosa", "AL", "35404");
		// Member o = new Member("Matt", 236544, "417 Prince Acres",
		// "Tuscaloosa",
		// "AL", "35404");
		// _db.addMember(m);
		// _db.addMember(o);
		// _db.addProvider(p);
		// _db.saveDb();

		// end Hard-coded members and providers

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
				.print("Menu:\n\t1) sign-in\n\t2) sign-out\n\tn) exit\nchocAn>");
		// read the user's choice from command line
		String choice = _co.readLine();
		handleMainMenuChoice(choice);
	}

	/**
	 * Display's ChocAn's sign-in menu for signing in a member or provider.
	 */
	private static void displaySigninMenu() {
		print("Signing in:\n\tMenu:\n\t\t1) member\n\t\t2) provider\n\t\t3) back\nchocAn>");
		// read in sign-in sub option
		String signInChoice = _co.readLine();
		handleSigninChoice(signInChoice);
	}

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
			checkUserNumberLength(strMemberNumber);
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
			checkUserNumberLength(strProviderNumber);
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
		case "default":
			// correct the user
			println("Your input was invalid.");
			displaySignOutMenu();
			break;
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
	private static void checkUserNumberLength(String strUserNumber) {
		int numberLength = strUserNumber.trim().length();
		// if number too short or too long
		if (numberLength != _userNumberLength) {
			System.out.println("Member number invalid");
			displaySigninMenu();
		}
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

	private static void handleMemberSignin() {
		// handle member sign in
		print("Signing in member:\nEnter member number: ");
		String strMemberNumber = _co.readLine();
		checkUserNumberLength(strMemberNumber);
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
					println("SUSPENDED");
					println("Member is suspended. can't sign in.");
				}
			} else {
				println("Member, " + member.getName() + " is already signed.");
				displayMainMenu();
			}
		} else {
			println("INVALID");
			println("Member could not be found.");
			displaySigninMenu();
		}
	}

	private static void handleProviderSignin() {
		// handle provider sign in
		print("Signing in provider:\nEnter in provider number: ");
		String strProviderNumber = _co.readLine();
		checkUserNumberLength(strProviderNumber);
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

	// Region HELPERS
	private static void println(String message) {
		System.out.println(message);
	}

	private static void print(String message) {
		System.out.print(message);
	}
	// EndRegion

}
