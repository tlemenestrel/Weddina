package weddina.week1;

import java.util.*;

public class Choices {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static ArrayList <String> catererNames = new ArrayList <String>();
	public static ArrayList <String> catererPrices = new ArrayList <String>();
	public static ArrayList <String> catererDescriptions = new ArrayList <String>();

	public static ArrayList <String>bandNames = new ArrayList <String>();
	public static ArrayList <String> bandPrices = new ArrayList <String>();
	public static ArrayList <String> bandDescriptions = new ArrayList <String>();

	public static ArrayList <String> venueNames = new ArrayList <String>();
	public static ArrayList <String> venuePrices = new ArrayList <String>();
	public static ArrayList <String> venueDescriptions = new ArrayList <String>();

	public static String catererChoice;
	public static String bandChoice;
	public static String venueChoice;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void handlingChoices (ArrayList<String> listNames,ArrayList<String> listDescriptions, ArrayList<String> listPrices, String destination) {

		Scanner scanner = new Scanner(System.in);
		boolean conditionChoices = true;

		while (conditionChoices == true) {

			System.out.println("");
			System.out.println("What would you like to do?");
			System.out.println("");
			System.out.println("Press s to consult your choices, c to make a choice and q to go back to the main menu");
			System.out.println("");

			char input = scanner.next().charAt(0);
			scanner.nextLine(); 			

			if (input == 's') {

				consultChoices(listNames, listDescriptions, listPrices);
				
			}

			else if (input == 'c') {

				makeChoice(listNames, destination);

			}

			else if (input == 'q') {

				System.out.println("");
				System.out.println("Back to the main menu...");
				conditionChoices = false;

			}

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void consultChoices (ArrayList<String> listNames, ArrayList<String> listPrices, ArrayList<String> listDescriptions) {

		System.out.println("");
		System.out.println("Your choices are:");
		System.out.println("");
		System.out.println("Names:");
		System.out.println("");

		int counter = 1;

		for (String name : listNames) {

			System.out.println("");
			System.out.println(counter+ "-" + name);

			counter ++;

			}

		counter = 0;

		System.out.println("Their respective descriptions are:");
		System.out.println("");

		for (String description : listDescriptions) {

			System.out.println("");
			System.out.println(counter + "-" + description);

			counter ++;

		}

		counter = 0;

		System.out.println("Their respective prices are:");
		System.out.println("");

		for (String price : listPrices) {

			System.out.println("");
			System.out.println(counter + "-" + price);

			counter ++;

		}

		System.out.println("");

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void makeChoice (ArrayList<String> listNames, String destination) {

		Scanner scanner = new Scanner (System.in);

		System.out.println("");
		System.out.println("Which one would you like to choose?");

		String choice = scanner.nextLine();

		if ((listNames.contains(choice)) == true){

			destination = choice;
			System.out.println("Your choice has been recorded");

		}

		else if ((listNames.contains(choice)) == false){

			System.out.println("Your choice does not exist...");

		}

	} 

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
