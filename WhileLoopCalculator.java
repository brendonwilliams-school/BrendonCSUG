import java.util.Scanner;

public class WhileLoopCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        double total = 0.0;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;

        while (counter < 5) {
            System.out.print("Enter a floating-point value: ");

            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();

                total += number;

                if (number > max) {
                    max = number;
                }

                if (number < min) {
                    min = number;
                }

                counter++;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        double average = total / 5;
        double interest = total * 0.20;

        System.out.println("\nResults:");
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
        System.out.println("Interest on total at 20%: " + interest);

        scanner.close();
    }
}
