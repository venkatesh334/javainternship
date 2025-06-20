import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simple Calculator");

        while (true) {
            double num1 = getNumber(scanner, "Enter the first number: ");
            double num2 = getNumber(scanner, "Enter the second number: ");
            char operator = getOperator(scanner);

            double result = calculate(num1, num2, operator);
            if (result == Double.NaN) {
                System.out.println("Error: Invalid operation or division by zero.");
            } else {
                System.out.println("Result: " + result);
            }

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String continueInput = scanner.next().trim().toLowerCase();
            if (!continueInput.equals("yes")) {
                break;
            }
        }

        scanner.close();
    }

    private static double getNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }

    private static char getOperator(Scanner scanner) {
        while (true) {
            System.out.print("Enter an operator (+, -, *, /): ");
            String input = scanner.next().trim();
            if (input.length() == 1 && "+-*/".indexOf(input.charAt(0)) != -1) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid operator. Please choose from +, -, *, /.");
            }
        }
    }

    private static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    return Double.NaN;
                }
                return num1 / num2;
            default:
                System.out.println("Error: Invalid operator.");
                return Double.NaN;
        }
    }
}