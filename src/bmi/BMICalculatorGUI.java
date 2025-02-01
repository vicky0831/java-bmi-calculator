package bmi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class BMICalculatorGUI extends JFrame {

    private JTextField weightField;
    private JTextField heightField;
    private JLabel resultLabel;

    public BMICalculatorGUI() {
        super("BMI Calculator (GUI)");

        // Set up the layout
        setLayout(new GridLayout(4, 2, 15, 10)); // 4 rows, 2 columns, with spacing

        // Create GUI components
        JLabel weightLabel = new JLabel("Weight (kg):");
        weightField = new JTextField();
        JLabel heightLabel = new JLabel("Height (m):");
        heightField = new JTextField();
        JButton calculateButton = new JButton("Calculate BMI");
        resultLabel = new JLabel("Your BMI will appear here.");

        weightLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        heightLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
  
        // Add components to the frame
        add(weightLabel);
        add(weightField);
        add(heightLabel);
        add(heightField);
        add(calculateButton);
        add(resultLabel);

        // Set up action for button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  calculateBMI();
            }
        });

        // Set default frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200); // Set size of the window
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }


    public static void main(String[] args) {
        // Launch the GUI
        SwingUtilities.invokeLater(() -> new BMICalculatorGUI());
    }
}
