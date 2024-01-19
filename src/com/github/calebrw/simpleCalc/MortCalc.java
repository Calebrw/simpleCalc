package com.github.calebrw.simpleCalc;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortCalc {

    // Define constants
    private static final int MONTHS_IN_YEAR = 12;

    // Define variables
    /**
     * The principal is the total amount of the loan
     */
    double principal;
    /**
     * The Annual Interest Rate
     */
    float annualInterest;
    /**
     * The number of years in the mortgage's term.
     * Many mortgages are in 10, 15, 20, and 30 year terms
     */
    int termYears;

    public static void main(String[] args) {

        try {
            MortCalc mc = new MortCalc();
            mc.setup();
            mc.calculate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Configure, verify and load variables.
     */
    private void setup() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter the principal amount:");
            while ( !scanner.hasNextDouble()) {
                System.out.println("That is not a number.");
                scanner.next();
            }
            this.principal = scanner.nextDouble();
        } while (this.principal <= 0);

        do {
            System.out.println("Enter the annual interest rate:");
            while ( !scanner.hasNextFloat()) {
                System.out.println("That is not a number.");
                scanner.next();
            }
            this.annualInterest = scanner.nextFloat();
        } while (this.annualInterest <= 0);

        // If the interest rate is larger than .5 (aka 50%)
        // then divide by 100 to get the actual percentage.
        // For example .61 is more likely ot be .61% that 61%
        if (this.annualInterest > .5) {
            System.out.println("Interest Rate too high.");
            System.out.println("Dividing by 100.");
            this.annualInterest /= 100;
        }

        do {
            System.out.println("Enter the term in years:");
            while ( !scanner.hasNextInt()) {
                System.out.println("That is not a number.");
                scanner.next();
            }
            this.termYears = scanner.nextInt();
        } while (this.termYears <= 0);

        scanner.close();
    }

    /**
     * Calculates the mortgage's monthly payment
     *
     * @see     <a href="https://en.wikipedia.org/wiki/Mortgage_calculator">Mortgage calculator on Wikipedia</a>
     */
    private void calculate() {
        float monthlyInterest = this.annualInterest / MONTHS_IN_YEAR;
        int termMonths = this.termYears * MONTHS_IN_YEAR;

        double monthlyPayment = this.principal *
                ( ( monthlyInterest * Math.pow(1 + monthlyInterest, termMonths ) )
                / ( Math.pow(1 + monthlyInterest, termMonths) - 1 ) );
        double totalPayment = monthlyPayment * termMonths;

        System.out.println("Monthly payment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
        System.out.println("Total Payments: " + NumberFormat.getCurrencyInstance().format(totalPayment));
    }
}
