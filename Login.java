package weddina.week1;

import java.util.*;

public class Login {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean checkIfCoupleExists (String email) {

		if (Couple.coupleEmail.equals(email)) {

			return true;

		}

		else {

			return false;

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean checkIfGuestExists (String email) {

		if (Guests.guestEmails.contains(email)) {

			return true;

		}

		else {

			return false;

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean checkIfBusinessExists (String email, ArrayList<String> listEmails) {

		if (listEmails.contains(email)) {

			return true;

		}

		else {

			return false;

		}

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void signUpCouple (String password, String email) {

		if (checkIfCoupleExists(email) == false) {

			Couple.couplePassword = password;
			Couple.coupleEmail = email;

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void signUpGuest (String password, String email) {

		if (checkIfGuestExists(email) == false) {

			Guests.guestPasswords.add(password);
			Guests.guestEmails.add(email);
			Guests.guestsResponses.add(new String("Not coming"));
			Guests.seatNumber.add(Guests.seatCounter);
			Guests.seatCounter++;

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void signUpBusiness (String password, String email, ArrayList<String> listEmails, ArrayList<String> listPasswords) {

		if (checkIfBusinessExists(email,listPasswords) == false) {

			listPasswords.add(password);
			listEmails.add(email);


		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean signInCouple (String password, String email) {

		if (checkIfCoupleExists(email) == true) {

			if (Couple.couplePassword.equals(password)) {

				return true;

			}

			else {

				return false;

			}

		}

		else {

			return false;

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean signInGuest (String password, String email,ArrayList<String> listEmails, ArrayList<String> listPasswords) {

		if (checkIfGuestExists(email) == true) {

			if (listPasswords.contains(password)) {

				return true;

			}

			else {

				return false;

			}

		}

		else {

			return false;

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean signInBusiness (String password, String email,ArrayList<String> listEmails, ArrayList<String> listPasswords) {

		if (checkIfBusinessExists(email, listEmails) == true) {

			if (listPasswords.contains(password)) {

				return true;

			}

			else {

				return false;

			}

		}

		else {

			return false;

		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
