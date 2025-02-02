package bmi;

import java.util.Scanner;
import java.lang.Math;

public class BMI {
	static int userInputStart = 0;
	static String tempContainer = "";
	static String userName;
	static String userAge;
	static String userGender;
	static String userWeight;
	static String userHeight;
	static double bmiResult;


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sign(4, "*", 50));
		System.out.println("\n\tWelcome To The BMI Calculator!\n");
		System.out.println(sign(4, "*", 50));
		System.out.println(
				"Your health is your wealth, and we're here to help you track it.\nThis tool calculates your Body Mass Index (BMI) to give you an idea of where you stand.");
		System.out.println("\nInstructions:");
		System.out.println("1. Enter your name.");
		System.out.println("2. Enter your age.");
		System.out
				.println("3. Enter your file name (For store the result and will useful for track the previous BMI).");
		System.out.println("4. Enter your weight in kilograms (kg).");
		System.out.println("5. Enter your height in meters (m).");
		System.out
				.println("\nLet’s get started on your health journey! Enter '1' to start or '2' for end the session\n");
		System.out.println(sign(4, "*", 50));
		Scanner input = new Scanner(System.in);

		while (userInputStart == 0 || userInputStart == 2) {
			tempContainer = input.nextLine();
			System.out.println(filter(tempContainer, "1 2".split(" "), 1, "", ""));
		}
		userInputStart = 0;

		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Name: ");
			tempContainer = input.nextLine();
			userName = filter(tempContainer, "".split(" "), 3, "name", "[a-zA-Z ]+");
			System.out.println(
					userInputStart == 1 ? "Succesfully stored in memory ! " + "\nHello " + userName : userName);
		}
		System.out.println(progressBar(6,0));
		userInputStart = 0;

		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Age: ");
			tempContainer = input.nextLine();
			userAge = filter(tempContainer, "".split(" "), 1, "age", "^(?:[1-7][0-9]|80)$");
			System.out.println(userInputStart == 1 ? "Succesfully stored in memory ! " : userAge);
		}
		System.out.println(progressBar(8,0));
		userInputStart = 0;

		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Gender (Male or Female): ");
			tempContainer = input.nextLine();
			userGender = filter(tempContainer, "male female".split(" "), 3, "", "");
			System.out.println(userInputStart == 1 ? "Succesfully stored in memory ! " : userGender);
		}
		System.out.println(progressBar(10,0));
		userInputStart = 0;

		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Weight (in KG / Kilogram) Ex. 40, 65, 100: ");
			tempContainer = input.nextLine();
			userWeight = filter(tempContainer, "".split(" "), 2, "weight", "^(?:1[0-9]|[2-9][0-9]|1[0-4][0-9]|150)(\\.\\d+)?$");
			System.out.println(userInputStart == 1 ? "Succesfully stored in memory ! " : userWeight);
		}
		System.out.println(progressBar(12,0));
		userInputStart = 0;

		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Height (in centimeter) Ex. 120, 145.45, 165: ");
			tempContainer = input.nextLine();
			userHeight = filter(tempContainer, "".split(" "), 3, "height", "^(?:1[2-9][0-9]|2[0-2][0-9]|230)(\\.\\d+)?$");
			System.out.println(userInputStart == 1 ? "Succesfully stored in memory ! " : userHeight);
		}
		System.out.println(progressBar(14,0));
		userInputStart = 0;
		
		System.out.println("Starting Calculation Process");
		
		
		
		byte num = 14;
		try {
			for(int i = 0; i < 4; i++) {
				num+=7;
		    Thread.sleep(2500);
		    System.out.println(progressBar(num,0));
			}
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		
		
		}
		
		bmiResult = BMI_calculation();
		
		System.out.println("Your BMI is " + String.format("%.2f", bmiResult) + "** " + BMI_category());
		System.out.println(progressBar(70,1));
		// For age do a other way session to user exit, if below age
		/*
		 * Scanner userWeight = new Scanner (System.in); System.out.println("Hello");
		 * int weight = userWeight.nextInt(); System.out.println(weight);
		 */

	}

	public static String sign(int i, String word, int end) {

		String combinedString = "";

		for (; i < end; i++) {

			combinedString += word;
		}
		return combinedString;

	}

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

							userInputStart = 1;

							return updatedLetter;

						} else {

							if (category.equals("height")) {
								return "Our system only supports weight within this range only : 125 to 230 but your height is "
										+ letter;
							}

							// return "Please enter a name without numbers or other special characters !";
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

					// String[] letter_array = updatedLetter.split(",");
					// for(int i = 0; i < 1; i++) {
					// boolean isUpperCse = Character.isUpperCase(letter_array[i]);
					// }

				}

			}

			updatedLetter = updatedLetter.toLowerCase();

			// System.out.println(updatedLetter.length());
			// char tempStartLetter = 0;
			// tempStartLetter;

			String tempCondition;

			String boldText = "\u001B[1m'" + updatedLetter.charAt(0) + "'";

			tempCondition = String.join(" or ", condition);

			if (updatedLetter.length() >= minLength) {

				if (true) {

					for (int i = 0; i < condition.length; i++) {

						if (updatedLetter.startsWith(Character.toString(condition[i].charAt(0)))) {

							if (i == (condition.length - 1)) {

								if (updatedLetter.equals(condition[i])) {

									finalOutput = progressBar(4,0);
									userInputStart = 1;
									break;

								} else {

									finalOutput = "Input not valid. Please Key in " + tempCondition;
									userInputStart = 2;
									break;
								}

							} else {

								if (updatedLetter.equals(condition[i])) {

									finalOutput = progressBar(4,0);
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

	public static String progressBar(int iteration, int final_iteration) {

		String openBar = "[";
		String progress = sign(0, "=", iteration);
		String closeBar = final_iteration == 1 ? "]" : "\t\t\t]";

		return openBar + progress + closeBar;

	}

	public static String switchStatement(String statement, String[] replacementWord, String category) {
		String updatedStatement = statement;
		int fieldCount = (int) statement.chars().filter(c -> c == '_').count();

		// Define the starting index based on the category
		int startIndex = 0;

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
		// array
		for (int i = 0; i < fieldCount; i++) {
			if (startIndex + i < replacementWord.length) {
				updatedStatement = updatedStatement.replaceFirst("_", replacementWord[startIndex + i]);
			}
		}

		return updatedStatement;
	}

	public static double BMI_calculation() {
		
		float weight = Float.parseFloat(userWeight);
		float height = (Float.parseFloat(userHeight) / 100);

		return (weight / (Math.pow(height, 2)));
		
		}
	
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
