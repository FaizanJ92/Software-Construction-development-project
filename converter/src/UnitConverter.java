import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UnitConverter {
    private double inputValue;
    private String inputUnit;
    private String outputUnit;

    public UnitConverter(double inputValue, String inputUnit, String outputUnit) {
        this.inputValue = inputValue;
        this.inputUnit = inputUnit;
        this.outputUnit = outputUnit;
    }

    public double convertLength() {
        if (inputUnit.equals("meters") && outputUnit.equals("kilometers")) {
            return inputValue / 1000;
        } else if (inputUnit.equals("kilometers") && outputUnit.equals("meters")) {
            return inputValue * 1000;
        } else if (inputUnit.equals("miles") && outputUnit.equals("feet")) {
            return inputValue * 5280;
        }
        return 0; // Placeholder for unsupported conversions
    }

    public double convertWeight() {
        if (inputUnit.equals("kilograms") && outputUnit.equals("grams")) {
            return inputValue * 1000;
        } else if (inputUnit.equals("grams") && outputUnit.equals("kilograms")) {
            return inputValue / 1000;
        }
        return 0; // Placeholder for unsupported conversions
    }

    public double convertTemperature() {
        if (inputUnit.equals("Celsius") && outputUnit.equals("Fahrenheit")) {
            return (inputValue * 9/5) + 32;
        } else if (inputUnit.equals("Fahrenheit") && outputUnit.equals("Celsius")) {
            return (inputValue - 32) * 5/9;
        }
        return 0; // Placeholder for unsupported conversions
    }

    public double convertTime() {
        if (inputUnit.equals("seconds") && outputUnit.equals("minutes")) {
            return inputValue / 60;
        } else if (inputUnit.equals("minutes") && outputUnit.equals("seconds")) {
            return inputValue * 60;
        }
        return 0; // Placeholder for unsupported conversions
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(" Unit Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Enter value:");
        label.setBounds(20, 20, 100, 30);
        frame.add(label);

        JTextField valueField = new JTextField();
        valueField.setBounds(120, 20, 150, 30);
        frame.add(valueField);

        String[] units = {"meters", "kilometers", "miles", "feet", "kilograms", "grams", "Celsius", "Fahrenheit", "seconds", "minutes"};
        JComboBox<String> inputUnitBox = new JComboBox<>(units);
        inputUnitBox.setBounds(20, 70, 150, 30);
        frame.add(inputUnitBox);

        JComboBox<String> outputUnitBox = new JComboBox<>(units);
        outputUnitBox.setBounds(200, 70, 150, 30);
        frame.add(outputUnitBox);
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(20, 120, 150, 30);
        frame.add(convertButton);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(20, 170, 300, 30);
        frame.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(valueField.getText());
                String inputUnit = (String) inputUnitBox.getSelectedItem();
                String outputUnit = (String) outputUnitBox.getSelectedItem();

                UnitConverter converter = new UnitConverter(value, inputUnit, outputUnit);
                double result = 0;

                if (inputUnit.equals("meters") || inputUnit.equals("kilometers") || inputUnit.equals("miles") || inputUnit.equals("feet")) {
                    result = converter.convertLength();
                } else if (inputUnit.equals("kilograms") || inputUnit.equals("grams")) {
                    result = converter.convertWeight();
                } else if (inputUnit.equals("Celsius") || inputUnit.equals("Fahrenheit")) {
                    result = converter.convertTemperature();
                } else if (inputUnit.equals("seconds") || inputUnit.equals("minutes")) {
                    result = converter.convertTime();
                }

                resultLabel.setText("Result: " + result);
            }
        });

        frame.setVisible(true);
    }
}
