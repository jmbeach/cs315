import java.io.Console;

/**
 * 
 * @author Team8
 * 
 */
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
		displayMainMenu();
	}

	/**
	 * Display's ChocAn's sign-in menu for signing in a member or provider.
	 */
	public static void displayMainMenu() {
		System.out
				.println("Welcome to ChocAn!\nMenu:\n\t1) sign-in\n\tn) exit");
		// read the user's choice from command line
		String choice = _co.readLine();
		handleMainMenuChoice(choice);
	}

	/**
	 * Uses the user's input at the Main menu to help navigate through ChocAn.
	 * 
	 * @param choice
	 *            the user's input at the main-menu
	 */
	public static void handleMainMenuChoice(String choice) {
		switch (choice) {
		case "1":
		case "sign-in":
			System.out
					.println("Signing in:\nMenu:\n\t1) member\n\t2) provider\n\t3) back");
			// read in sign-in sub option
			String signInChoice = _co.readLine();
			handleSigninChoice(signInChoice);
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
	public static void checkUserNumberLength(String strUserNumber) {
		int numberLength = strUserNumber.trim().length();
		// if number too short or too long
		if (numberLength != _userNumberLength) {
			System.out.println("Member number invalid");
			displaySigninMenu();
		}
	}

	/**
	 * Display's ChocAn's sign-in menu for signing in a member or provider.
	 */
	public static void displaySigninMenu() {
		System.out
				.println("\tSigning in:\n\tMenu:\n\t\t1) member\n\t\t2) provider\n\t\t3) back");
		// read in sign-in sub option
		String signInChoice = _co.readLine();
		handleSigninChoice(signInChoice);
	}

	/**
	 * Uses the user input at the sign-in menu and tries to begin the sign-in
	 * process.
	 * 
	 * @param signInChoice
	 *            The user's command line input from the sign-in menu
	 */
	public static void handleSigninChoice(String signInChoice) {
		switch (signInChoice) {
		case "1":
		case "member":
			// handle member sign in
			println("Signing in member:\n\t\t Enter member number.");
			String strMemberNumber = _co.readLine();
			checkUserNumberLength(strMemberNumber);
			Integer memberNumber = null;
			try {
				memberNumber = Integer.parseInt(strMemberNumber);
			} catch (Exception e) {
				println("Member number format not valid.");
				displaySigninMenu();
			}
			println("Finding member in database...");
			// TODO: Need to bounce memberNumber off of database here
			System.out.println("Signing in member:\n\t\t Enter member number.");
			Member member = _db.getMember(memberNumber);
			if (member != null) {
				println("Signin successful!\nWelcome, " + member.getName());
			}
			break;
		case "2":
		case "provider":
			// handle provider sign in
			println("Signing in provider:\n\t\t Enter in provider number. ");
			String strProviderNumber = _co.readLine();
			checkUserNumberLength(strProviderNumber);
			Integer providerNumber;
			try {
				providerNumber = Integer.parseInt(strProviderNumber);
			} catch (Exception e) {
				println("Provider number format not valid.");
				displaySigninMenu();
			}
			println("Finding provider in database...");
			// TODO: Need to bounce providerNumber off of database here
			System.out
					.println("Signing in provider:\n\t\t Enter in provider number. ");
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

	private static void println(String message) {
		System.out.println(message);
	}

}
