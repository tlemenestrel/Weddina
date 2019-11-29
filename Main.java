package weddina.week1;

import java.util.*;

import weddina.week1.User;
import weddina.week1.Login;
import weddina.week1.Checklist;
import weddina.week1.Choices;
import weddina.week1.CatererChoice;
import weddina.week1.BandChoice;
import weddina.week1.VenueChoice;

public class Main {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main (String[] args) {

		Login.passwords.add("ABC");
		Login.emails.add("tlm@");

		Scanner scanner = new Scanner(System.in);

		welcomeMessages();

		char input = scanner.next().charAt(0); 

		if (input == 'y') {

			existingUser();

		}

		else if (input == 'n') {

			nonExistingUser();

		}

		else {

			System.out.println("Wrong input");

		}

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
		boolean condition = true;

		System.out.println("Nice. Please write down your email:");
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

			while (condition) {

			System.out.println("What would you like to do?");
			System.out.println("");
			System.out.println("Press p for changing password, r for remind password, t for your list of tasks, c for choosing the caterer, b for choosing the band, v for choosing the venue and q to quit: ");
			System.out.println("");

			char input = scanner.next().charAt(0); 

			if (input == 'p') {

				System.out.println("Please input your new password");
				System.out.println("");

				String newPassword = scanner.nextLine();

				user.changePassword(newPassword);
				System.out.println("Password changed ...");

			}

			else if (input == 'r') {

				user.remindPassword();

			}

			else if (input == 't') {

				Checklist.handlingTasks();

			}

			else if (input == 'c') {




			}

			else if (input == 'b') {

			}

			else if (input== 'v') {

				

			}

			else if (input == 'q') {

				System.out.println("Quitting...");
				condition = false;

			}

		}
		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void nonExistingUser () {



}

}