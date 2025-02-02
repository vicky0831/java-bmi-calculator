package bmi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;

public class BMICalculatorGUI extends JFrame {

    private JTextField nameField, ageField, weightField, heightField;
    private JLabel bmiResultLabel, bmiCategoryLabel;

    private double bmiResult;

    public BMICalculatorGUI() {
        setTitle("BMI Calculator");

        // Set up layout
        setLayout(new GridLayout(7, 2, 10, 10));

        // Create components
        JLabel nameLabel = new JLabel("Enter Your Name:");
        nameField = new JTextField();
        JLabel ageLabel = new JLabel("Enter Your Age:");
        ageField = new JTextField();
        JLabel weightLabel = new JLabel("Enter Your Weight (kg):");
        weightField = new JTextField();
        JLabel heightLabel = new JLabel("Enter Your Height (cm):");
        heightField = new JTextField();

        JButton calculateButton = new JButton("Calculate BMI");
        bmiResultLabel = new JLabel("Your BMI: ");
        bmiCategoryLabel = new JLabel("BMI Category: ");

        // Add components to frame
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(weightLabel);
        add(weightField);
        add(heightLabel);
        add(heightField);
        add(calculateButton);
        add(bmiResultLabel);
        add(bmiCategoryLabel);

        // Set default frame settings
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add button listener
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });

        setVisible(true);
    }

    private void calculateBMI() {
        try {
            String name = nameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            float weight = Float.parseFloat(weightField.getText().trim());
            float height = Float.parseFloat(heightField.getText().trim()) / 100; // Convert cm to meters

            if (age < 10 || age > 80) {
                showMessage("Age must be between 10 and 80!");
                return;
            }
            if (weight < 10 || weight > 150) {
                showMessage("Weight must be between 10 and 150 kg!");
                return;
            }
            if (height < 1.25 || height > 2.30) {
                showMessage("Height must be between 125 and 230 cm!");
                return;
            }

            bmiResult = weight / Math.pow(height, 2);
            bmiResultLabel.setText("Your BMI: " + String.format("%.2f", bmiResult));
            bmiCategoryLabel.setText("BMI Category: " + BMI_category());

        } catch (NumberFormatException ex) {
            showMessage("Please enter valid values for all fields!");
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    private String BMI_category() {
        if (bmiResult < 18.5) {
            return "Underweight";
        } else if (bmiResult < 24.9) {
            return "Normal Weight";
        } else if (bmiResult < 29.9) {
            return "Overweight";
        } else if (bmiResult < 34.9) {
            return "Obese Class I";
        } else if (bmiResult < 39.9) {
            return "Obese Class II";
        } else {
            return "Severe Obese Class III";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BMICalculatorGUI());
    }
}
