package com.github.calebrw.simpleCalc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            // Instantiate Console object
            final Scanner s = new Scanner(System.in);

            // Collect input as strings
            System.out.print("Please enter a number: ");
            final String input1 = s.nextLine();
            System.out.print("Please enter a number: ");
            final String input2 = s.nextLine();
            final String operators = "(+ - * / !)";
            System.out.print("Please input one of the following " + operators + ": ");
            final String input3 = s.nextLine();
            // For the operator, it is imperative that only the first character is used
            final char operator = input3.trim().charAt(0);

            // Convert Stings to Integers
            final Double i1 = Double.parseDouble(input1.trim());
            final Double i2 = Double.parseDouble(input2.trim());

            // Perform Operation
            Double result = null;
            switch (operator) {
                case '+':
                    result = i1 + i2;
                    break;
                case '-':
                    result = i1 - i2;
                    break;
                case '*':
                    result = i1 * i2;
                    break;
                case '/':
                    result = i1 / i2;
                    break;
                case '!':
                    result = factorial(i1);
                    break;
            }

            if (result == null) {
                // Display Invalid Operator message.
                System.out.println("You did not input a valid operator.");
            } else {
                // Display Result
                System.out.println("The result is: " + result);
            }

        } catch (NumberFormatException nfe) {

            System.out.println("One of the inputs was not a number.");
            System.out.println(nfe.getMessage());

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    /**
     * This static function returns the factorial value of an {@code Integer}
     *
     * @param d The initial integer as a {@code Double}, later rounded to nearest Integer
     * @return The returned value as n * n-1 * ... * 1
     */
    static private Double factorial(Double d) {

        int i = (int)Math.round(d);

        if (i > 1) {
            int result = i;
            for (int j = i; j > 1; j--) {
                result *= (j - 1);
            }
            return (double)result;
        } else if (i == 1) {
            return 1.0d;
        } else {
            throw new NumberFormatException("You cannot perform a factorial on a number less than 1");
        }

    }

}
