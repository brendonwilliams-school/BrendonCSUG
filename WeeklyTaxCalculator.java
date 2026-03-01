package taxcalculator;

import java.util.Scanner;

public class WeeklyTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for weekly income
        System.out.print("Enter your weekly income: $");
        double weeklyIncome = scanner.nextDouble();

        double taxRate;

        // Determine tax rate
        if (weeklyIncome < 500) {
            taxRate = 0.10;
        } else if (weeklyIncome >= 500 && weeklyIncome < 1500) {
            taxRate = 0.15;
        } else if (weeklyIncome >= 1500 && weeklyIncome < 2500) {
            taxRate = 0.20;
        } else {
            taxRate = 0.30;
        }

        // Calculate weekly tax
        double weeklyTax = weeklyIncome * taxRate;

        // Display results
        System.out.println("\n--- Weekly Tax Summary ---");
        System.out.printf("Weekly Income: $%.2f\n", weeklyIncome);
        System.out.printf("Tax Rate: %.0f%%\n", taxRate * 100);
        System.out.printf("Weekly Tax Withholding: $%.2f\n", weeklyTax);

        scanner.close();
    }
}