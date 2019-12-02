package weddina.week1;

import java.util.*;

import weddina.week1.Login;

public class Guests {

		public static void handlingGuests () {

		boolean condition1 = true;

		Scanner scanner = new Scanner(System.in);

		welcomeMessageGuest();

		while (condition1) {

			char input = scanner.next().charAt(0); 
			scanner.nextLine();

			if (input == 'y') {

				existingGuest();
				condition1 = false;

			}

			else if (input == 'n') {

				nonExistingGuest();
				existingGuest();
				condition1 = false;

			}

			else {

				System.out.println("Wrong input");

			}

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void nonExistingGuest () {

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

		Login.signUp(password,email,Login.guestPasswords,Login.guestEmails);
	
		System.out.println("Perfect. You are registered");
		System.out.println("");
		System.out.println("You are now being redirected to the login page...");
		System.out.println("");

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void existingGuest () {

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

		if (Login.signIn(user.getPassword(), user.getEmail(),Login.guestEmails, Login.guestPasswords) == false) {

			System.out.print("Login unsuccesfull ...");

		}

		else if (Login.signIn(user.getPassword(), user.getEmail(),Login.guestEmails,Login.guestPasswords) == true) {

			System.out.print("Login succesfull ...");
			System.out.println("");

			while (condition2) {

			choiceMessagesGuest();

			char input = scanner.next().charAt(0); 
			scanner.nextLine();

			if (input == 'p') {

				System.out.println("Please input your new password");
				System.out.println("");

				String newPassword = scanner.nextLine();

				user.changePassword(newPassword, Login.guestPasswords,Login.guestEmails);
				System.out.println("Password changed ...");
				System.out.println("");

			}

			else if (input == 'r') {

				System.out.println("");
				System.out.println (user.remindPassword(Login.guestEmails));
				System.out.println("");


			}

			else if (input == 'f') {

				System.out.println("");
				Checklist.handlingTasks();
				System.out.println("");

			}

			else if (input == 'i') {


			}

			else if (input == 's') {


			}

			else if (input == 'd') {


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

	public static void choiceMessagesGuest () {

		System.out.println("What would you like to do?");
		System.out.println("");
		System.out.println("Press p for changing password, r for remind password, f for choosing your food requirements, i to respond to the invitation, s to see your seat number, d for the couple contact details and q to quit: ");
		System.out.println("");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void welcomeMessageGuest () {

		System.out.println("Are you an existing user? ");
		System.out.println("");
		System.out.println("Press y for yes or n for no:");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}