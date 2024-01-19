package com.github.calebrw.simpleCalc;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortCalc {

    private static final int MONTHS_IN_YEAR = 12;

    public static void main(String[] args) {

        double principal = 0;
        float annualInterest = 0;
        int termYears = 0;
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the principal amount:");
            principal = scanner.nextDouble();

            System.out.println("Enter the annual interest rate:");
            annualInterest = scanner.nextFloat();

            if (annualInterest > .5) {
                System.out.println("Interest Rate too high.");
                System.out.println("Dividing by 100.");
                annualInterest /= 100;
            }

            System.out.println("Enter the term in years:");
            termYears = scanner.nextInt();

            scanner.close();

            Calculation(principal, annualInterest, termYears);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

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
