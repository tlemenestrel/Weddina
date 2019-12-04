package weddina.week1;

import java.util.*;

import weddina.week1.User;
import weddina.week1.Login;
import weddina.week1.Checklist;
import weddina.week1.Choices;
import weddina.week1.Guests;
import weddina.week1.Couple;
import weddina.week1.Businesses;

public class Main {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main (String[] args) {

		insertDataForTesting();
		choosingTypeOfUser();

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void insertDataForTesting () {

		Couple.couplePassword = "ABC";
		Couple.coupleEmail = "tlm@";

		Guests.guestEmails.add("tlm@");
		Guests.guestPasswords.add("ABC");
		Guests.guestsResponses.add("Coming");
		Guests.seatNumber.add(1);

		Businesses.venueEmails.add("tlm@");
		Businesses.venuePasswords.add("ABC");

		Businesses.bandEmails.add("@tlm@");
		Businesses.bandPasswords.add("ACB");

		Businesses.catererEmails.add("@tlm");
		Businesses.catererPasswords.add("BAC");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void choosingTypeOfUser() {

		boolean condition1 = true;

		Scanner scanner = new Scanner(System.in);

		while (condition1) {

			messageForChoosingTypeOfUser();

			char input = scanner.next().charAt(0); 
			scanner.nextLine();
			
			if (input == 'c') {

				Couple.handlingCouple();
				condition1 = false;
			}

			else if (input == 'g') {

				Guests.handlingGuests();
				condition1 = false;

			}

			else if (input == 'b') {

				boolean condition2 = true;

				while (condition2) {

					System.out.println("");
					System.out.println("Press c for caterer, v for venue or b for band:");

					char input2 = scanner.next().charAt(0); 
					scanner.nextLine();

					if (input2 == 'c') {

						Businesses.handlingBusinesses(Businesses.catererNames,Businesses.catererDescriptions,Businesses.catererPrices,Businesses.catererEmails,Businesses.catererPasswords);
						condition2 = false;
						condition1 = false;

					}

					else if (input2 == 'v') {

						Businesses.handlingBusinesses(Businesses.venueNames,Businesses.venueDescriptions,Businesses.venuePrices,Businesses.venueEmails,Businesses.venuePasswords);
						condition2 = false;
						condition1 = false;
						
					}

					else if (input2 == 'b') {

						Businesses.handlingBusinesses(Businesses.bandNames,Businesses.bandDescriptions,Businesses.bandPrices,Businesses.bandEmails,Businesses.bandPasswords);
						condition2 = false;
						condition1 = false;
						
					}

					else {

						System.out.println("Wrong input");

					}

				}
			}

			else {

				System.out.println("Wrong input");

			}

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void messageForChoosingTypeOfUser() {

		System.out.println("Hello. Welcome to Wedinna");
		System.out.println("");
		System.out.println("Are you the couple, a guest or a business? ");
		System.out.println("");
		System.out.println("Press c for couple, g for guest or b for business:");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
