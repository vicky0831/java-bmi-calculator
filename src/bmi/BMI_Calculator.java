package bmi;

import javax.swing.SwingUtilities;
import java.util.Scanner;

public class BMI_Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Choose Interface Mode:");
        System.out.println("1: Command Line Interface (CLI)");
        System.out.println("2: Graphical User Interface (GUI)");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        
        if (choice.equals("1")) {
            // Launch the CLI version
        	String[] args1 = {};
    		BMI.main(args1);
            
        } else if (choice.equals("2")) {
            // Launch the GUI version on the Event Dispatch Thread (EDT)
            SwingUtilities.invokeLater(() -> new BMICalculatorGUI());
        } else {
            System.out.println("Invalid option. Please run the program again and choose 1 or 2.");
        }
        
	}

}
