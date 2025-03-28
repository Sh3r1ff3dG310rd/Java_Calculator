//CLAY NOTTINGHAM CALCULATOR

//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator implements ActionListener{

    //Variables
    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[9];
    JButton add, subtract, multiply, divide;
    JButton decimal, equals, delete, clear, negative;
    JPanel panel;

    //Font
    Font calcFont = new Font("Monospaced", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    //Constructor
    Calculator(){
        //Calculator frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        //Dimensions for Text Field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(calcFont);
        textField.setEditable(false);

        //Buttons
        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        decimal = new JButton(".");
        equals = new JButton("=");
        delete = new JButton("Del");
        clear = new JButton("Clr");
        negative = new JButton("(-)");
        functions[0] = add;
        functions[1] = subtract;
        functions[2] = multiply;
        functions[3] = divide;
        functions[4] = decimal;
        functions[5] = equals;
        functions[6] = delete;
        functions[7] = clear;
        functions[8] = negative;

        //For loop for Function Buttons
        for(int x = 0; x < 9; x++) {
            functions[x].addActionListener(this);
            functions[x].setFont(calcFont);
            functions[x].setFocusable(false);
        }

        //For loop for Number Buttons
        for(int y = 0; y < 10; y++) {
            numbers[y] = new JButton(String.valueOf(y));
            numbers[y].addActionListener(this);
            numbers[y].setFont(calcFont);
            numbers[y].setFocusable(false);
        }

        //Function button dimensions
        negative.setBounds(50, 430, 100, 50);
        delete.setBounds(150, 430, 100, 50);
        clear.setBounds(250, 430, 100, 50);

        //Layout for panel
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subtract);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(multiply);
        panel.add(decimal);
        panel.add(numbers[0]);
        panel.add(equals);
        panel.add(divide);

        //Frame for panel
        frame.add(panel);
        frame.add(negative);
        frame.add(delete);
        frame.add(clear);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //For loops for button functions
        for(int x = 0; x < 10; x++) {
            if(e.getSource() == numbers[x]) {
                textField.setText(textField.getText().concat(String.valueOf(x)));
            }
        }

        if(e.getSource() == decimal) {
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == add) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource() == subtract) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if(e.getSource() == multiply) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if(e.getSource() == divide) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if(e.getSource() == equals) {
            num2 = Double.parseDouble(textField.getText());

            switch(operator) {
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == clear) {
            textField.setText("");
        }

        if(e.getSource() == delete) {
            String string = textField.getText();
            textField.setText("");
            for(int y = 0; y < string.length() -1; y++) {
                textField.setText(textField.getText()+string.charAt(y));
            }
        }

        if(e.getSource() == negative) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
