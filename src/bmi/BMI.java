package bmi;

import java.util.Scanner;
import java.lang.Math;

public class BMI {
	
	// Global variables for user input and processing
	static int userInputStart = 0;          // Used for controlling input validation loops
    static String tempContainer = "";       // Temporary container for input values
    static String userName;                 // Stores the user's name
    static String userAge;                  // Stores the user's age as a String
    static String userGender;               // Stores the user's gender
    static String userWeight;               // Stores the user's weight in kg as a String
    static String userHeight;               // Stores the user's height in centimeters as a String
    static double bmiResult;                // Holds the calculated BMI


	public static void main(String[] args) {

		String initial;
		
		// Display a decorative header using the sign method	
		System.out.println(sign(4, "*", 50));
		System.out.println("\n\tWelcome To The BMI Calculator!\n");
		System.out.println(sign(4, "*", 50));
		System.out.println(
				"Your health is your wealth, and we're here to help you track it.\nThis tool calculates your Body Mass Index (BMI) to give you an idea of where you stand.");
		System.out.println("\nInstructions:");
		System.out.println("1. Enter your name.");
		System.out.println("2. Enter your age.");
		System.out.println("3. Enter your weight in kilograms (kg).");
		System.out.println("4. Enter your height in meters (m).");
		System.out
				.println("\nLet’s get started on your health journey! Enter '1' to start or '2' for end the session\n");
		System.out.println(sign(4, "*", 50));
		
		// Create a Scanner object to capture user input from the console
		Scanner input = new Scanner(System.in);

		// Loop to validate the start session input (expects "1" to start, "2" to end)
		while (userInputStart == 0 || userInputStart == 2) {
			tempContainer = input.nextLine();
			// Call filter method to validate the input against allowed options "1" and "2"
			initial = filter(tempContainer, "1 2".split(" "), 1, "", "");
			if(initial.equals("2")) {
		        System.out.println("Exiting the BMI Calculator. Have a great day!");
		        System.exit(0);  // This will stop the program immediately
			}else {
				System.out.println(initial);
			}
		}
		System.out.println(progressBar(4,0));
		userInputStart = 0; // Reset the flag for next input section

		// Loop to capture and validate the user's name
		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Name: ");
			tempContainer = input.nextLine();
			// Filter method validates the name (expects at least 3 letters, and only alphabet characters)
			userName = filter(tempContainer, "".split(" "), 3, "name", "[a-zA-Z ]+"); 
			// Print success message if the input is valid, else print the error message returned by filter
			System.out.println(
					userInputStart == 1 ? "Succesfully stored in memory ! " + "\nHello " + userName : userName);
		}
		System.out.println(progressBar(6,0));
		userInputStart = 0;

		// Loop to capture and validate the user's age
		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Age: ");
			tempContainer = input.nextLine();
			 // Validate age with regex (supports ages from 10 to 80)
			userAge = filter(tempContainer, "".split(" "), 1, "age", "^(?:[1-7][0-9]|80)$");
			System.out.println(userInputStart == 1 ? "Succesfully stored in memory ! " : userAge);
		}
		System.out.println(progressBar(8,0));
		userInputStart = 0;

		// Loop to capture and validate the user's gender (expects "male" or "female")
		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Gender (Male or Female): ");
			tempContainer = input.nextLine();
			// Validate gender input by checking against allowed options
			userGender = filter(tempContainer, "male female".split(" "), 3, "", "");
			System.out.println(userInputStart == 1 ? "Succesfully stored in memory ! " : userGender);
		}
		System.out.println(progressBar(10,0));
		userInputStart = 0;

		// Loop to capture and validate the user's weight (in kg)
		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Weight (in KG / Kilogram) Ex. 40, 65, 100: ");
			tempContainer = input.nextLine();
			// Regex ensures weight is between 10 and 150 kg (with optional decimal values)
			userWeight = filter(tempContainer, "".split(" "), 2, "weight", "^(?:1[0-9]|[2-9][0-9]|1[0-4][0-9]|150)(\\.\\d+)?$");
			System.out.println(userInputStart == 1 ? "Succesfully stored in memory ! " : userWeight);
		}
		System.out.println(progressBar(12,0));
		userInputStart = 0;

		// Loop to capture and validate the user's height (in centimeters)
		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Height (in centimeter) Ex. 120, 145.45, 165: ");
			tempContainer = input.nextLine();
			// Regex ensures height is between 125 and 230 cm (with optional decimal values)
			userHeight = filter(tempContainer, "".split(" "), 3, "height", "^(?:1[2-9][0-9]|2[0-2][0-9]|230)(\\.\\d+)?$");
			System.out.println(userInputStart == 1 ? "Succesfully stored in memory ! " : userHeight);
		}
		System.out.println(progressBar(14,0));
		userInputStart = 0;
		
		System.out.println("Starting Calculation Process");
		
		
		// Simulate a progress bar using a loop that increments a counter and sleeps for 2.5 seconds per step.
		byte num = 14;
		try {
			for(int i = 0; i < 4; i++) {
				num+=7;
		    Thread.sleep(2500); // Pause execution to simulate processing.
		    System.out.println(progressBar(num,0));
			}
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		
		bmiResult = BMI_calculation(); // Calculate the BMI using the BMI_calculation() method.
		
		 // Display the calculated BMI (formatted to 2 decimal places) along with the corresponding category.
		System.out.println("Your BMI is " + String.format("%.2f", bmiResult) + "** " + BMI_category());
		System.out.println(progressBar(70,1));
	}

	
	//This method for generates a string composed of a repeated word (or character) from the start index 'i' to 'end'.
	public static String sign(int i, String word, int end) {

		String combinedString = "";

		for (; i < end; i++) {

			combinedString += word;
		}
		return combinedString;

	}

	//This method is for validates and processes the user's input based on several parameters.
	public static String filter(String letter, String[] condition, int minLength, String category, String regex) {
		String updatedLetter = letter;
		String finalOutput = "";
		String[] replacementLetters = {};
		if (letter.isEmpty()) {
			return "Please enter a valid number";
		} else {

			updatedLetter = updatedLetter.trim();

			if (!(category == null)) {

				if (category.equals("name") || category.equals("age") || category.equals("weight")
						|| category.equals("height")) {

					if (updatedLetter.length() >= minLength) {

						if (updatedLetter.matches(regex)) {
							
							switch (category) {

							case "name":
								// If the category is "name", ensure the first letter is uppercase.
								char firstLetter = updatedLetter.charAt(0);

								if (!Character.isUpperCase(firstLetter)) {

									String firstLetterUpdated = Character.toString(firstLetter);
									firstLetterUpdated = firstLetterUpdated.toUpperCase();
									updatedLetter = updatedLetter.replaceFirst(Character.toString(firstLetter),
											firstLetterUpdated);
								}

								break;

							case "age":

								break;

							case "weight":

								break;

							default:

								break;

							}

							userInputStart = 1; // Flag input as valid

							return updatedLetter;

						} else {
							// Provide custom error messages based on category.
							
							if (category.equals("height")) {
								return "Our system only supports weight within this range only : 125 to 230 but your height is "
										+ letter;
							}

							replacementLetters = new String[] { "Please enter a name",
									"without number or other special character !",
									"Our system only supports ages within this range only :",
									"10 to 80 but your age is " + letter,
									"Our system only supports weight within this range only :",
									"10 to 150 but your weight is " + letter,

							};

							return switchStatement("_ _", replacementLetters, category);
						}

					} else {

						replacementLetters = new String[] { "name", "3", "letters", "your age", "2", "digits", "number",
								"2", "digits", };

						return category == "age"
								? "Sorry, our system only supports ages within the range of 10 to 80. However, your age is "
										+ letter
								: (category == "height"
										? "Sorry, our system only supports heights within the range of 125 to 230. However, your height is "
												+ letter
										: switchStatement("Please type _ with a minimum length _ _", replacementLetters,
												category));

					}

				}

			}

			updatedLetter = updatedLetter.toLowerCase(); // Lowercase the input for further processing (useful for validating gender, etc.)

			String tempCondition;

			String boldText = "\u001B[1m'" + updatedLetter.charAt(0) + "'";

			tempCondition = String.join(" or ", condition);

			if (updatedLetter.length() >= minLength) {
				// Loop through the allowed conditions to check if the input is valid.
				
				if (true) {
					for (int i = 0; i < condition.length; i++) {

						if (updatedLetter.startsWith(Character.toString(condition[i].charAt(0)))) {

							if (i == (condition.length - 1)) {

								if (updatedLetter.equals(condition[i])) {

									finalOutput = updatedLetter;
									userInputStart = 1;
									break;

								} else {

									finalOutput = "Input not valid. Please Key in " + tempCondition;
									userInputStart = 2;
									break;
								}

							} else {

								if (updatedLetter.equals(condition[i])) {

									finalOutput = updatedLetter;
									userInputStart = 1;
									break;

								} else {

									finalOutput = "Input not valid. Please Key in " + tempCondition;
									break;

								}
							}
						} else {

							finalOutput = "***Please Enter a valid input with a correct starting letter or number. Starting letter from user is "
									+ boldText + "\033[0;0m \n" + "***but expected starting letter or number is: "
									+ tempCondition + "***";

						}

					}

				}

			} else {

				return "Please enter a valid number with a minimum length";

			}

		}

		return finalOutput;
	}

	//This method is for creates a visual representation of progress using a string of "=" characters.
	public static String progressBar(int iteration, int final_iteration) {

		String openBar = "[";
		String progress = sign(0, "=", iteration);
		String closeBar = final_iteration == 1 ? "]" : "\t\t\t]";

		return openBar + progress + closeBar;

	}

	//This method is for dynamically creates an error message by replacing underscores in the statement with words from replacementWord.
	public static String switchStatement(String statement, String[] replacementWord, String category) {
		String updatedStatement = statement;
		int fieldCount = (int) statement.chars().filter(c -> c == '_').count();

		int startIndex = 0;

		 // Determine starting index based on the category.
		switch (category) {
		case "name":
			startIndex = 0;
			break;
		case "age":
			startIndex = fieldCount;
			break;
		case "weight":
			startIndex = fieldCount * 2;
			break;
		default:
			break;
		}

		// Replace the underscores with the appropriate words from the replacementWord
		for (int i = 0; i < fieldCount; i++) {
			if (startIndex + i < replacementWord.length) {
				updatedStatement = updatedStatement.replaceFirst("_", replacementWord[startIndex + i]);
			}
		}

		return updatedStatement;
	}

	//This method is for computes the BMI using the standard formula: BMI = weight (kg) / (height (m))^2.
	//Note that userHeight is entered in centimeters, so it is divided by 100 to convert to meters.
	public static double BMI_calculation() {
		
		float weight = Float.parseFloat(userWeight);
		float height = (Float.parseFloat(userHeight) / 100);

		return (weight / (Math.pow(height, 2)));
		
		}
	
	//This method is for determines the BMI category based on the calculated BMI value.
    //Uses several if-else conditions to provide a message that includes both advice and the category.
	public static String BMI_category(){
	
			if(bmiResult < 18.5) {
				tempContainer = "You’re too skinny! Let’s bulk up a bit—time for some healthy snacks!" + "\u001B[1m" + " Category - Underweight\u001B[0m";
			} else if(bmiResult < 24.9) {
				tempContainer = "You’re just right! Keep rocking that healthy balance!" + "\u001B[1m" + " Category - Normal Weight\u001B[0m";
			} else if(bmiResult < 29.9) {
				tempContainer = "Carrying a little extra love! Let’s find ways to move and groove more!" + "\u001B[1m" + " Category - Overweight\u001B[0m";
			} else if(bmiResult < 34.9) {
				tempContainer = "It’s time for a health reboot. Small steps can lead to big changes!" + "\u001B[1m" + " Category - Obese Class I\u001B[0m";
			} else if(bmiResult < 39.9) {
				tempContainer = "Health matters! Prioritizing fitness and nutrition can make a difference!" + "\u001B[1m" + " Category - Obese Class II\u001B[0m";
			} else {
				tempContainer = "Serious health risks ahead. Seeking guidance from a healthcare professional is crucial!" + "\u001B[1m" + " Category - Severe Obese Class III\u001B[0m";
			}
		
		
		return tempContainer;
	}
}
