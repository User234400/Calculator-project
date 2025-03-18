package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {

    public static double add(double x, double y) {
        return x + y;
    }

    public static double subtract(double x, double y) {
        return x - y;
    }

    public static double multiply(double x, double y) {
        return x * y;
    }

    public static String divide(double x, double y) {
        if (y == 0) {
            return "Error! Division by zero.";
        }
        return String.valueOf(x / y);
    }

    public static String modulus(double x, double y) {
        if (y == 0) {
            return "Error! Modulus by zero.";
        }
        return String.valueOf(x % y);
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static String sqrt(double number) {
        if (number < 0) {
            return "Error! Cannot compute square root of a negative number.";
        }
        return String.valueOf(Math.sqrt(number));
    }

    public static double absolute(double number) {
        return Math.abs(number);
    }

    public static long roundNumber(double number) {
        return Math.round(number);
    }

    public static void displayHistory(ArrayList<String> history) {
        System.out.println("\nCalculation History:");
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
    }

    public static void performOperation() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> history = new ArrayList<>();

        while (true) {
            System.out.println("\nConsole Calculator");
            System.out.println("Choose operation:");
            System.out.println("1. Add (+)");
            System.out.println("2. Subtract (-)");
            System.out.println("3. Multiply (*)");
            System.out.println("4. Divide (/)");
            System.out.println("5. Modulus (%)");
            System.out.println("6. Power (base^exponent)");
            System.out.println("7. Square Root (sqrt)");
            System.out.println("8. Absolute Value (abs)");
            System.out.println("9. Round (round)");
            System.out.println("10. View History");
            System.out.println("11. Exit");

            System.out.print("Enter choice (1-11): ");
            String choice = scanner.nextLine();

            if (choice.equals("11")) {
                System.out.println("Exiting Calculator. Goodbye!");
                break;
            } else if (choice.equals("10")) {
                displayHistory(history);
                continue;
            }

            double x = 0, y = 0;
            String result = "";

            try {
                if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5") || choice.equals("6")) {
                    System.out.print("Enter first number: ");
                    x = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter second number: ");
                    y = Double.parseDouble(scanner.nextLine());
                } else if (choice.equals("7") || choice.equals("8") || choice.equals("9")) {
                    System.out.print("Enter number: ");
                    x = Double.parseDouble(scanner.nextLine());
                } else {
                    System.out.println("Invalid input.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case "1":
                    result = String.valueOf(add(x, y));
                    break;
                case "2":
                    result = String.valueOf(subtract(x, y));
                    break;
                case "3":
                    result = String.valueOf(multiply(x, y));
                    break;
                case "4":
                    result = divide(x, y);
                    break;
                case "5":
                    result = modulus(x, y);
                    break;
                case "6":
                    result = String.valueOf(power(x, y));
                    break;
                case "7":
                    result = sqrt(x);
                    break;
                case "8":
                    result = String.valueOf(absolute(x));
                    break;
                case "9":
                    result = String.valueOf(roundNumber(x));
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    continue;
            }

            System.out.println("Result: " + result);

            String historyEntry = (choice.equals("7") || choice.equals("8") || choice.equals("9")) ?
                    (x + " = " + result) : (x + " " + getOperator(choice) + " " + y + " = " + result);
            history.add(historyEntry);

            System.out.print("\nDo you want to perform another operation? (yes/no): ");
            String cont = scanner.nextLine().toLowerCase();
            if (!cont.equals("yes")) {
                System.out.println("Exiting Calculator. Goodbye!");
                break;
            }
        }
        scanner.close();
    }

    private static String getOperator(String choice) {
        switch (choice) {
            case "1": return "+";
            case "2": return "-";
            case "3": return "*";
            case "4": return "/";
            case "5": return "%";
            case "6": return "^";
            default: return "";
        }
    }

    public static void main(String[] args) {
        performOperation();
    }
}
