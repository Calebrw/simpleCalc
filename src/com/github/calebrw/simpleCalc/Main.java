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
            final String operators = "(+ - * /)";
            System.out.print("Please input of of the following " + operators + ": ");
            final String input3 = s.nextLine();
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

}
