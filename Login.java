package weddina.week1;

import java.util.*;

public class Login {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public List <String> passwords = new ArrayList <String>;
	public List <String> emails = new ArrayList <String>;
	public List <String> firstNames = new ArrayList <String>;
	public List <String> lastNames = new ArrayList <String>;

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

		if (checkIfUserExists == false) {

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

		if (checkIfUserExists == true) {

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
