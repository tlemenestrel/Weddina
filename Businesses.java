package weddina.week1;

import java.util.*;

public class Businesses{

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static ArrayList <String> catererNames = new ArrayList <String>();
	public static ArrayList <String> catererPrices = new ArrayList <String>();
	public static ArrayList <String> catererDescriptions = new ArrayList <String>();
	public static ArrayList <String> catererPasswords = new ArrayList <String>();
	public static ArrayList <String> catererEmails = new ArrayList <String>();

	public static ArrayList <String> bandNames = new ArrayList <String>();
	public static ArrayList <String> bandPrices = new ArrayList <String>();
	public static ArrayList <String> bandDescriptions = new ArrayList <String>();
	public static ArrayList <String> catererPasswords = new ArrayList <String>();
	public static ArrayList <String> catererEmails = new ArrayList <String>();

	public static ArrayList <String> venueNames = new ArrayList <String>();
	public static ArrayList <String> venuePrices = new ArrayList <String>();
	public static ArrayList <String> venueDescriptions = new ArrayList <String>();
	public static ArrayList <String> catererPasswords = new ArrayList <String>();
	public static ArrayList <String> catererEmails = new ArrayList <String>();

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void handlingBusinesses (ArrayList <String> listNames,ArrayList <String> listDescriptions ,ArrayList <String> listPrices,ArrayList <String> listEmails,ArrayList <String> listPasswords) {

		boolean condition1 = true;

		Scanner scanner = new Scanner(System.in);

		welcomeMessagesBusinesses();

		while (condition1) {

			char input = scanner.next().charAt(0); 
			scanner.nextLine();

			if (input == 'y') {

				existingBusiness(listNames,listDescriptions,listPrices,listEmails,listPasswords);
				condition1 = false;

			}

			else if (input == 'n') {

				nonExistingBusiness(listNames,listDescriptions,listPrices,listEmails,listPasswords);
				existingBusiness(listNames,listDescriptions,listPrices,listEmails,listPasswords);
				condition1 = false;

			}

			else {

				System.out.println("Wrong input");

			}

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void nonExistingBusiness (ArrayList <String> listNames,ArrayList <String> listDescriptions ,ArrayList <String> listPrices,ArrayList <String> listEmails,ArrayList <String> listPasswords) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("");
		System.out.println("To signup for Wedinna, we will need your email adress and a password");
		System.out.println("");

		System.out.println("Please write down your email:");
		System.out.println("");
		String email = scanner.nextLine();
		System.out.println("");

		System.out.println("Nice. Please write down your password now:");
		System.out.println("");
		String password = scanner.nextLine();
		System.out.println("");

		Login.signUpGuest(password,email);
	
		System.out.println("Perfect. You are registered");
		System.out.println("");
		System.out.println("You are now being redirected to the login page...");
		System.out.println("");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void existingBusiness (ArrayList <String> listNames,ArrayList <String> listDescriptions ,ArrayList <String> listPrices,ArrayList <String> listEmails,ArrayList <String> listPasswords) {

		Scanner scanner = new Scanner(System.in);

		boolean condition2 = true;
		boolean condition3 = true;

		while (condition3) {

			System.out.println("To login, please write down your email:");
			System.out.println("");
			String email = scanner.nextLine();
			System.out.println("");

			System.out.println("Nice. Please write down your password now:");
			System.out.println("");
			String password = scanner.nextLine();
			System.out.println("");

			User user = new User(email, password);

			if (Login.signInGuest(user.getPassword(), user.getEmail(),guestEmails, guestPasswords) == false) {

				System.out.println("Login unsuccesfull ...");
				System.out.println("");

			}

			else if (Login.signInGuest(user.getPassword(), user.getEmail(),guestEmails,guestPasswords) == true) {

				System.out.print("Login succesfull ...");
				System.out.println("");

				condition3 = false;

				while (condition2) {

					choiceMessagesGuest();

					char input = scanner.next().charAt(0); 
					scanner.nextLine();

					if (input == 'p') {

						System.out.println("Please input your new password");
						System.out.println("");

						String newPassword = scanner.nextLine();

						user.changePasswordGuest(newPassword,guestPasswords,guestEmails);
						System.out.println("Password changed ...");
						System.out.println("");

					}

					else if (input == 'r') {

						System.out.println("");
						System.out.println (user.remindPasswordGuest(guestEmails));
						System.out.println("");

					}

					else if (input == 'f') {

						System.out.println("");
						foodRequirements(user.getEmail());
						System.out.println("");

					}

					else if (input == 'i') {

						System.out.println("");
						respondToInvitation(user.getEmail());
						System.out.println("");

					}

					else if (input == 's') {

						System.out.println("");
						seatNumber(user.getEmail());
						System.out.println("");

					}

					else if (input == 'd') {

						System.out.println("");
						coupleContactDetails();
						System.out.println("");

					}

					else if (input == 'q') {

						System.out.println("Quitting...");
						condition2 = false;

					}

					else {

						System.out.println("");
						System.out.println("Wrong input...");
						System.out.println("");

					}

				}

			}

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void choiceMessagesBusinesses () {

		System.out.println("What would you like to do?");
		System.out.println("");
		System.out.println("Press p for changing password, r for remind password, a to add the details of your business, d for the couple contact details and q to quit: ");
		System.out.println("");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void welcomeMessageBusinesses () {

		System.out.println("Are you an existing user? ");
		System.out.println("");
		System.out.println("Press y for yes or n for no:");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}