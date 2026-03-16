import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperature {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();

        // Add days of the week
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        // Get temperatures for each day
        for (String day : days) {
            System.out.print("Enter the average temperature for " + day + ": ");
            double temp = scanner.nextDouble();
            temperatures.add(temp);
        }

        scanner.nextLine(); // clear buffer

        String input;

        while (true) {

            System.out.println("\nEnter a day of the week to see the temperature.");
            System.out.println("Type 'week' to see the whole week.");
            System.out.println("Type 'exit' to quit.");
            System.out.print("Input: ");

            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.equalsIgnoreCase("week")) {

                double total = 0;

                System.out.println("\nWeekly Temperatures:");

                for (int i = 0; i < days.size(); i++) {
                    System.out.println(days.get(i) + ": " + temperatures.get(i));
                    total += temperatures.get(i);
                }

                double average = total / temperatures.size();

                System.out.println("Weekly Average Temperature: " + average);
            }

            else {

                boolean found = false;

                for (int i = 0; i < days.size(); i++) {

                    if (input.equalsIgnoreCase(days.get(i))) {
                        System.out.println(days.get(i) + " Temperature: " + temperatures.get(i));
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Invalid day entered.");
                }
            }
        }

        scanner.close();
        System.out.println("Program ended.");
    }
}