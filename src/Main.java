import java.io.Console;

/**
 * 
 * @author Team8
 * 
 */
public class Main {
	private static Console _co;
	private static final int _userNumberLength = 6;
	private static Database _db = new Database();

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
		Provider p = new Provider("Octavius", 123456, "345 anus avenue",
				"Tuscaloosa", "AL", "35404");
		Member m = new Member("Dillon", 356661, "417 Prince Acres",
				"Tuscaloosa", "AL", "35404");
		Member o = new Member("Matt", 236544, "417 Prince Acres", "Tuscaloosa",
				"AL", "35404");
		_db.addMember(m);
		_db.addMember(o);
		_db.addProvider(p);
		// Member mem = d.getMember(o.getNumber());
		// System.out.println(mem.getName());
		// System.out.println(d.getProviders());
		displayMainMenu();
	}

	/**
	 * Display's ChocAn's main menu
	 */
	public static void displayMainMenu() {
		System.out.println("Welcome to ChocAn!\nMenu:\n\t1) signin\n\tn) exit");
		// read the user's choice from command line
		String choice = _co.readLine();
		handleMainMenuChoice(choice);
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
	 * Uses the user's input at the Main menu to help navigate through ChocAn.
	 * 
	 * @param choice
	 *            the user's input at the main-menu
	 */
	public static void handleMainMenuChoice(String choice) {
		MainMenuChoice menuChoice = MainMenuChoice.valueOf(choice);
		switch (menuChoice) {
		case signin:
			displaySigninMenu();
			break;
		case exit:
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
	 * Uses the user input at the sign-in menu and tries to begin the sign-in
	 * process.
	 * 
	 * @param signInChoice
	 *            The user's command line input from the sign-in menu
	 */
	public static void handleSigninChoice(String signInChoice) {
		SigninChoice choice = SigninChoice.valueOf(signInChoice);
		switch (choice) {
		case member:
			// handle member sign in
			System.out
					.println("\tSigning in member:\n\t\t Enter member number.");
			String strMemberNumber = _co.readLine();
			checkUserNumberLength(strMemberNumber);
			Integer memberNumber;
			try {
				memberNumber = Integer.parseInt(strMemberNumber);
			} catch (Exception e) {
				System.out.println("Member number format not valid.");
				displaySigninMenu();
			}
			println("\tFinding member in database...");
			// TODO: Need to bounce memberNumber off of database here
			break;
		case provider:
			// handle provider sign in
			System.out
					.println("\tSigning in provider:\n\t\t Enter in provider number. ");
			String strProviderNumber = _co.readLine();
			checkUserNumberLength(strProviderNumber);
			Integer providerNumber;
			try {
				providerNumber = Integer.parseInt(strProviderNumber);
			} catch (Exception e) {
				System.out.println("Provider number format not valid.");
				displaySigninMenu();
			}
			println("\tFinding provider in database...");
			// TODO: Need to bounce providerNumber off of database here
			break;
		case back:
			// return back to main menu
			displayMainMenu();
			break;
		default:
			// The user didn't type in a valid option
			println("\tYour input is invalid.");
			displaySigninMenu();
			break;
		}

	}

	private static void println(String message) {
		System.out.println(message);
	}
}
