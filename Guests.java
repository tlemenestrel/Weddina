package weddina.week1;

import java.util.*;

import weddina.week1.Login;

public class Guests {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static ArrayList <String> guestPasswords = new ArrayList <String>();
	public static ArrayList <String> guestEmails = new ArrayList <String>();

	public static ArrayList <String> foodRequirements = new ArrayList <String>();

	public static ArrayList <String> guestsResponses = new ArrayList <String>(); // For future iterations, should be a ArrayList <Boolean>

	public static ArrayList <Integer> seatNumber = new ArrayList <Integer>();

	public static int seatCounter = 1;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

		Login.signUpGuest(password,email);
	
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

	public static void foodRequirements (String email) {

		Scanner scanner = new Scanner(System.in);

		if (Login.checkIfGuestExists(email) == true) {

			if ((foodRequirements.size()) < (guestEmails.size())) {

				System.out.println("Please input your food requirements");
				System.out.println("");

				String foodReq = scanner.nextLine();

				foodRequirements.add(foodReq);

				System.out.println("Food requirements added ...");
				System.out.println("");

			}

			else {	

				System.out.println("Please input your food requirements");
				System.out.println("");

				String foodReq = scanner.nextLine();

				foodRequirements.add(foodReq);

				System.out.println("Food requirements added ...");
				System.out.println("");

				if (foodRequirements.contains(foodReq)) {

					int index = guestEmails.indexOf(email);

					foodRequirements.set(index, foodReq);

				}

			}

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void respondToInvitation (String email) {

		Scanner scanner = new Scanner(System.in);
		boolean condition = true;

		while (condition) {

			System.out.println("Press y if you are coming, n if you are not coming or q to go back to the main menu:");
			System.out.println("");

			char input = scanner.next().charAt(0);
			scanner.nextLine();

			if (input == 'y') {

				int index = guestEmails.indexOf(email);
				System.out.println(index);
				guestsResponses.set(index, "Coming");

			}

			else if (input == 'n') {

				int index = guestEmails.indexOf(email);
				guestsResponses.set(index, "Not coming");

			}

			else if (input == 'q') {

				System.out.println("");
				System.out.println("Back to the main menu...");
				System.out.println("");
				condition = false;

			}

			else {

				System.out.println("");
				System.out.println("Wrong input...");
				System.out.println("");

			}
		
		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void seatNumber (String email) {

		int index = guestEmails.indexOf(email);

		System.out.println("");
		System.out.println("Your seat number is " + seatNumber.get(index));
		System.out.println("");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void coupleContactDetails () {

		System.out.println("The couple's email address is: " + Couple.coupleEmail);

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
