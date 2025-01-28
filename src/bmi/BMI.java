package bmi;

import java.util.Scanner;

public class BMI {
	static int userInputStart = 0;
	static String tempContainer = "";
	static String userName;
	static String userAge;

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
			System.out.println(userName);
		}
		System.out.println(progressBar(6));
		userInputStart = 0;

		while (userInputStart == 0 || userInputStart == 2) {
			System.out.print("Enter Your Age: ");
			tempContainer = input.nextLine();
			userAge = filter(tempContainer, "".split(" "), 1, "age", "^(?:[1-7][0-9]|80)$");
			System.out.println(userInputStart == 1 ? "Hi" + userAge : userAge);
		}
		System.out.println(progressBar(8));

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
		String updatedCondition = "";
		String finalOutput = "";
		String[] replacementLetters = {};
		if (letter.isEmpty()) {
			return "Please enter a valid number";
		} else {

			updatedLetter = updatedLetter.trim();

			if (!(category == null)) {

				if (category.equals("name") || category.equals("age")) {

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

							default:

							}

							userInputStart = 1;

							return updatedLetter;

						} else {

							// return "Please enter a name without numbers or other special characters !";
							replacementLetters = new String[] { "Please enter a name", "without number or other special character !", "Our system only supports ages within this range only :","10 to 80 but your age is " + letter };

							return switchStatement("_ _",replacementLetters, category);
						}

					} else {

						replacementLetters = new String[] { "name", "3", "letters", "your age", "2" ,"digits" };

						return category == "age" ? "Sorry, our system only supports ages within the range of 10 to 80. However, your age is " + letter : switchStatement("Please type _ with a minimum length _ _",replacementLetters, category);
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

	public static String switchStatement(String statement, String[] replacementWord, String category) {

		String updatedStatement = statement;
		int fieldCount = 0;
		byte tempNumber = 0;
		char[] statementInChar;

		statementInChar = statement.toCharArray();

		for (int i = 0; i < statementInChar.length; i++) {

			if (statementInChar[i] == '_') {

				fieldCount++;

			}

		}

		switch (category) {

		case "name":

			for (int i = 0; i < (fieldCount); i++) {

				updatedStatement = updatedStatement.replaceFirst("_", replacementWord[i]);

			}

			break;

		case "age":

			for (int i = fieldCount; i < (fieldCount + fieldCount); i++) {

				updatedStatement = updatedStatement.replaceFirst("_", replacementWord[i]);

			}

			break;

		case "test":

			for (int i = (fieldCount + fieldCount); i < (fieldCount + fieldCount + fieldCount); i++) {

				updatedStatement = updatedStatement.replaceFirst("_", replacementWord[i]);

			}

			break;

		default:

			break;

		}

		return updatedStatement;

	}

}
