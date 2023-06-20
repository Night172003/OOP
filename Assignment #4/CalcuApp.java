import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;


public class CalcuApp extends JFrame implements ActionListener {
    private JTextField numField1;
    private JTextField numField2;
    private JTextField resultField;

    public CalcuApp() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 3, 10, 10));
        setResizable(true);



        JLabel numLabel1 = new JLabel("First Number:");
        numField1 = new JTextField(10);
        JLabel numLabel2 = new JLabel("Second Number:");
        numField2 = new JTextField(10);
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(10);
        resultField.setEditable(false);

        JButton addButton = new JButton("Add");
        JButton subButton = new JButton("Subtract");
        JButton multiButton = new JButton("Multiply");
        JButton divButton = new JButton("Divide");
        JButton clearButton = new JButton("Clear");

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        multiButton.addActionListener(this);
        divButton.addActionListener(this);
        clearButton.addActionListener(this);

        add(numLabel1);
        add(numField1);
        add(numLabel2);
        add(numField2);
        add(resultLabel);
        add(resultField);
        add(addButton);
        add(subButton);
        add(multiButton);
        add(divButton);
        add(clearButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            String operation = button.getText();
            double num1 = 0, num2 = 0;

            if (e.getActionCommand().equals("Clear")) {
                numField1.setText("");
                numField2.setText("");
                resultField.setText("");
                return;
            }

            try {
                if (!numField1.getText().isEmpty()) {
                    num1 = Double.parseDouble(numField1.getText());
                }
                if (!numField2.getText().isEmpty()) {
                    num2 = Double.parseDouble(numField2.getText());
                }

                double result;
                switch (operation) {
                    case "Add":
                        result = num1 + num2;
                        break;
                    case "Subtract":
                        result = num1 - num2;
                        break;
                    case "Multiply":
                        result = num1 * num2;
                        break;
                    case "Divide":
                        result = num1 / num2;
                        break;
                    default:
                        result = 0;
                        break;
                }

                resultField.setText(Double.toString(result));
            } catch (NumberFormatException ex) {
                if (numField1.getText().isEmpty() && numField2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No numbers entered!");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid numbers!");
                }
            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalcuApp();
            }
        });
    }
}
