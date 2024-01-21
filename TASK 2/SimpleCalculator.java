// Task 2
// Simple Calculator
import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Simple Calculator");
        System.out.println("------------------");

        while (true) {
            try {
                System.out.println("Select operation:");
                System.out.println("1. Addition (+)");
                System.out.println("2. Subtraction (-)");
                System.out.println("3. Multiplication (*)");
                System.out.println("4. Division (/)");
                System.out.println("5. Exit");

                System.out.print("Enter your choice (1-5): ");
                int choice = scanner.nextInt();

                if (choice == 5) {
                    System.out.println("Exiting the calculator. Goodbye!");
                    break; 
                }

                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                switch (choice) {
                    case 1 -> System.out.println("Result: " + calculator.add(num1, num2));
                    case 2 -> System.out.println("Result: " + calculator.subtract(num1, num2));
                    case 3 -> System.out.println("Result: " + calculator.multiply(num1, num2));
                    case 4 -> System.out.println("Result: " + calculator.divide(num1, num2));
                    case 5 -> {
                        System.out.println("Exiting the calculator. Goodbye!");
                        break;
                    }
                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("------------------");
        }
    }
}

class Calculator {
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return num1 / num2;
    }
}
