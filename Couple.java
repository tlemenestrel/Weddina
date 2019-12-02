package weddina.week1;

import java.util.*;

import weddina.week1.Businesses;

public class Couple  {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static String couplePassword;
	public static String coupleEmail;
	public static String coupleContactDetails;

	public static String catererChoice;
	public static String bandChoice;
	public static String venueChoice;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void handlingCouple () {

		boolean condition1 = true;

		Scanner scanner = new Scanner(System.in);

		welcomeMessagesCouple();

		while (condition1) {

			char input = scanner.next().charAt(0); 
			scanner.nextLine();

			if (input == 'y') {

				existingCouple();
				condition1 = false;

			}

			else if (input == 'n') {

				nonExistingCouple();
				existingCouple();
				condition1 = false;

			}

			else {

				System.out.println("Wrong input");

			}

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void nonExistingCouple () {

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

		Login.signUpCouple(password,email);
	
		System.out.println("Perfect. You are registered");
		System.out.println("");
		System.out.println("You are now being redirected to the login page...");
		System.out.println("");

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void existingCouple () {

		Scanner scanner = new Scanner(System.in);
		boolean condition2 = true;

		System.out.println("To login, please write down your email:");
		System.out.println("");
		String email = scanner.nextLine();
		System.out.println("");

		System.out.println("Nice. Please write down your password now:");
		System.out.println("");
		String password = scanner.nextLine();
		System.out.println("");

		User user = new User(email, password);

		if (Login.signInCouple(user.getPassword(), user.getEmail()) == false) {

			System.out.print("Login unsuccesfull ...");

		}

		else if (Login.signInCouple(user.getPassword(), user.getEmail()) == true) {

			System.out.print("Login succesfull ...");
			System.out.println("");

			while (condition2) {

			choiceMessagesCouple();

			char input = scanner.next().charAt(0); 
			scanner.nextLine();

			if (input == 'p') {

				System.out.println("Please input your new password");
				System.out.println("");

				String newPassword = scanner.nextLine();

				user.changePasswordCouple(newPassword);
				System.out.println("Password changed ...");
				System.out.println("");

			}

			else if (input == 'r') {

				System.out.println("");
				System.out.println (user.remindPasswordCouple());
				System.out.println("");


			}

			else if (input == 't') {

				System.out.println("");
				Checklist.handlingTasks();
				System.out.println("");

			}

			else if (input == 'c') {

				Choices.handlingChoices(Businesses.catererNames, Businesses.catererDescriptions, Businesses.catererPrices, catererChoice);

			}

			else if (input == 'b') {

				Choices.handlingChoices(Businesses.bandNames, Businesses.bandDescriptions, Businesses.bandPrices, bandChoice);

			}

			else if (input== 'v') {

				Choices.handlingChoices(Businesses.venueNames, Businesses.venueDescriptions, Businesses.venuePrices, venueChoice);	

			}

			else if (input == 'q') {

				System.out.println("Quitting...");
				condition2 = false;

			}

			else {

				System.out.println("Wrong input...");

			}

		}

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void choiceMessagesCouple () {

		System.out.println("What would you like to do?");
		System.out.println("");
		System.out.println("Press p for changing password, r for remind password, t for your list of tasks, c for choosing the caterer, b for choosing the band, v for choosing the venue and q to quit: ");
		System.out.println("");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void welcomeMessagesCouple () {

		System.out.println("Are you an existing user? ");
		System.out.println("");
		System.out.println("Press y for yes or n for no:");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
