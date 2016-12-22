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

            // Convert Stings to Integers
            final Double i1 = Double.parseDouble(input1);
            final Double i2 = Double.parseDouble(input2);

            // Perform Addition
            final Double result = i1 + i2;

            // Display Result
            System.out.println("The result is: " + result);

        } catch (NumberFormatException nfe) {

            System.out.println("One of the inputs was not a number.");
            System.out.println(nfe.getMessage());

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
