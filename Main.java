package weddina.week1;

import java.util.*;

import weddina.week1.User;
import weddina.week1.Login;
import weddina.week1.Checklist;
import weddina.week1.Choices;

public class Main {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main (String[] args) {

		Login.passwords.add("ABC");
		Login.emails.add("tlm@");

		boolean condition1 = true;

		Scanner scanner = new Scanner(System.in);

		welcomeMessages();

		char input = scanner.next().charAt(0); 

		while (condition1) {

		if (input == 'y') {

			existingUser();
			condition1 = false;

		}

		else if (input == 'n') {

			nonExistingUser();
			existingUser();
			condition1 = false;

		}

		else {

			System.out.println("Wrong input");

		}

	}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void choiceMessages () {

		System.out.println("What would you like to do?");
		System.out.println("");
		System.out.println("Press p for changing password, r for remind password, t for your list of tasks, c for choosing the caterer, b for choosing the band, v for choosing the venue and q to quit: ");
		System.out.println("");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void welcomeMessages () {

		System.out.println("Hello. Welcome to Wedinna");
		System.out.println("");
		System.out.println("Are you an existing user? ");
		System.out.println("");
		System.out.println("Press y for yes or n for no:");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void existingUser () {

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

		if ((Login.signIn(user.getPassword(), user.getEmail())) == false) {

			System.out.print("Login unsuccesfull ...");

		}

		else if ((Login.signIn(user.getPassword(), user.getEmail())) == true) {

			System.out.print("Login succesfull ...");
			System.out.println("");

			while (condition2) {

			choiceMessages();

			char input = scanner.next().charAt(0); 
			scanner.nextLine();

			if (input == 'p') {

				System.out.println("Please input your new password");
				System.out.println("");

				String newPassword = scanner.nextLine();

				user.changePassword(newPassword);
				System.out.println("Password changed ...");
				System.out.println("");

			}

			else if (input == 'r') {

				System.out.println("");
				System.out.println (user.remindPassword());
				System.out.println("");


			}

			else if (input == 't') {

				System.out.println("");
				Checklist.handlingTasks();
				System.out.println("");

			}

			else if (input == 'c') {

				Choices.handlingChoices(Choices.catererNames, Choices.catererDescriptions, Choices.catererPrices, Choices.catererChoice);

			}

			else if (input == 'b') {

				Choices.handlingChoices(Choices.bandNames, Choices.bandDescriptions, Choices.bandPrices, Choices.bandChoice);

			}

			else if (input== 'v') {

				Choices.handlingChoices(Choices.venueNames, Choices.venueDescriptions, Choices.venuePrices, Choices.venueChoice);	

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

	public static void nonExistingUser () {

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

		Login.passwords.add(password);
		Login.emails.add(email);

		System.out.println("Perfect. You are registered");
		System.out.println("");
		System.out.println("You are now being redirected to the login page...");
		System.out.println("");

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}