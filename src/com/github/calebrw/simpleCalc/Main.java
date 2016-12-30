package com.github.calebrw.simpleCalc;

import com.github.calebrw.simpleCalc.utils.MathHelper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String errorMessage = "There was a problem with the calculation you attempted. "
                + "Please rerun the program for a new calculation.";
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

            // Convert Stings to Integers
            final Double i1 = Double.parseDouble(input1.trim());
            final Double i2 = Double.parseDouble(input2.trim());

            // For the operator, it is imperative that only the first character is used
            final char operator = input3.trim().charAt(0);

            // Perform Operation
            Double result = null;
            switch (operator) {
                case '+':
                    result = MathHelper.add(i1, i2);
                    break;
                case '-':
                    result = MathHelper.subtract(i1, i2);
                    break;
                case '*':
                    result = MathHelper.multiply(i1, i2);
                    break;
                case '/':
                    result = MathHelper.divide(i1, i2);
                    break;
                case '!':
                    result = MathHelper.factorial(i1);
                    break;
            }

            // Display Invalid Operator message if there is a failure, or display the result if it's valid.
            System.out.println(result == null ? "You did not input a valid operator." : "The result is: " + result);

        } catch (NullPointerException | NumberFormatException npe) {

            System.out.println(errorMessage);
            System.out.println(npe.getMessage());

        } catch (Exception e) {

            System.out.println(errorMessage);
            e.printStackTrace();

        }

    }

}
