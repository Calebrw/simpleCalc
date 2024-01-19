package com.github.calebrw.simpleCalc;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortCalc {

    // Define constants
    private static final int MONTHS_IN_YEAR = 12;

    public static void main(String[] args) {

        // Declare variables
        double principal;
        float annualInterest;
        int termYears;

        try {
            Scanner scanner = new Scanner(System.in);

            // The principal is the total amount of the loan
            do {
                System.out.println("Enter the principal amount:");
                while ( !scanner.hasNextDouble()) {
                    System.out.println("That is not a number.");
                    scanner.next();
                }
                principal = scanner.nextDouble();
            } while (principal <= 0);

            // The Annual Interest Rate
            do {
                System.out.println("Enter the annual interest rate:");
                while ( !scanner.hasNextFloat()) {
                    System.out.println("That is not a number.");
                    scanner.next();
                }
                annualInterest = scanner.nextFloat();
            } while (annualInterest <= 0);

            // If the interest rate is larger than .5 (aka 50%)
            // then divide by 100 to get the actual percentage.
            // For example .61 is more likely ot be .61% that 61%
            if (annualInterest > .5) {
                System.out.println("Interest Rate too high.");
                System.out.println("Dividing by 100.");
                annualInterest /= 100;
            }

            // Many mortgages are in 10, 15, 20, and 30 year terms
            do {
                System.out.println("Enter the term in years:");
                while ( !scanner.hasNextInt()) {
                    System.out.println("That is not a number.");
                    scanner.next();
                }
                termYears = scanner.nextInt();
            } while (termYears <= 0);

            scanner.close();

            Calculation(principal, annualInterest, termYears);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Calculates the mortgage's monthly payment
     * @param principal         The principal is the total amount of the loan
     * @param annualInterest    The Annual Interest Rate
     * @param termYears         The number of years the mortgage is for
     *
     * @see     <a href="https://en.wikipedia.org/wiki/Mortgage_calculator">Mortgage calculator on Wikipedia</a>
     */
    private static void Calculation(double principal, float annualInterest, int termYears) {
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR;
        int termMonths = termYears * MONTHS_IN_YEAR;

        double monthlyPayment = principal *
                ( ( monthlyInterest * Math.pow(1 + monthlyInterest, termMonths ) )
                / ( Math.pow(1 + monthlyInterest, termMonths) - 1 ) );
        double totalPayment = monthlyPayment * termMonths;

        System.out.println("Monthly payment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
        System.out.println("Total Payments: " + NumberFormat.getCurrencyInstance().format(totalPayment));
    }
}
