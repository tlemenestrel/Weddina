package weddina.week1;

import java.util.*;

public class Login {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static ArrayList <String> passwords = new ArrayList <String>();
	public static ArrayList <String> emails = new ArrayList <String>();
	public static ArrayList <String> firstNames = new ArrayList <String>();
	public static ArrayList <String> lastNames = new ArrayList <String>();

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean checkIfUserExists (String password, String email) {

		if (emails.contains(email)) {

			return true;

		}

		else {

			return false;

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean signUp (String password, String email, String firstName, String lastName) {

		if (checkIfUserExists(password,email) == false) {

			passwords.add(password);
			emails.add(email);
			firstNames.add(firstName);
			lastNames.add(lastName);
			return (true);

		}

		else {

			return false;

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean signIn (String password, String email) {

		if (checkIfUserExists(password,email) == true) {

			if (passwords.contains(password)) {

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
