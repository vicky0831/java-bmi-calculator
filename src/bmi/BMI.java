package bmi;

import java.util.Scanner;

public class BMI {
	static int userInputStart = 0;
	static String tempContainer = "";

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
			String userStart = input.nextLine();
			System.out.println(filter(userStart, "1 2".split(" "), 1, ""));
		}
		userInputStart = 0;

		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Name: ");
			String userName = input.nextLine();
			System.out.println(filter(userName, "".split(" "), 3, "name"));
		}
		userInputStart = 0;
		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Age: ");
			String userAge = input.nextLine();
		}

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

	public static String filter(String letter, String[] condition, int minLength, String category) {
		String updatedLetter = letter;
		String updatedCondition = "";
		String finalOutput = "";
		if (letter.isEmpty()) {
			return "Please enter a valid number";
		} else {

			updatedLetter = updatedLetter.trim();

			if (!(category == null)) {

				if (category.equals("name")) {

					if (updatedLetter.length() >= minLength) {

						char firstLetter = updatedLetter.charAt(0);

						if (!Character.isUpperCase(firstLetter)) {

							String firstLetterUpdated = Character.toString(firstLetter);
							firstLetterUpdated = firstLetterUpdated.toUpperCase();
							updatedLetter = updatedLetter.replaceFirst(Character.toString(firstLetter),
									firstLetterUpdated);

						}
						userInputStart = 1;
						return tempContainer = updatedLetter;

					} else {
						return "Please type a name with minimum length 3 letters";
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

						if (updatedLetter.startsWith(condition[i])) {

							if (i == (condition.length - 1)) {

								if (updatedLetter.equals(condition[i])) {

									finalOutput = progressBar(4);
									userInputStart = 1;
									break;

								} else {

									finalOutput = "Input not valid. Please Key in " + tempCondition;
									userInputStart = 2;
									break;
								}

							} else {

								if (updatedLetter.equals(condition[i])) {

									finalOutput = progressBar(4);
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
									+ tempCondition + ". Don't Play with Me !!***";

						}

					}

				}

			} else {

				return "Please enter a valid number with a minimum length";

			}

		}

		return finalOutput;
	}

	public static String progressBar(int iteration) {

		String openBar = "[";
		String progress = sign(0, "=", iteration);
		String closeBar = "\t\t\t]";

		return openBar + progress + closeBar;

	}
}
