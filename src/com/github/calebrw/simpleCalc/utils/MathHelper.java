package com.github.calebrw.simpleCalc.utils;

public class MathHelper {

    /**
     * This function performs addition
     *
     * @param d1 The first input value as a {@code Double}.
     * @param d2 The second input value as a {@code Double}.
     * @return The sum of the two inputs
     */
    public static Double add(Double d1, Double d2) {
        return d1 + d2;
    }

    /**
     * This function performs subtraction
     *
     * @param d1 The first input value as a {@code Double}.
     * @param d2 The second input value as a {@code Double}.
     * @return The result of the two inputs
     */
    public static Double subtract(Double d1, Double d2) {
        return d1 - d2;
    }

    /**
     * This function performs multiplication
     *
     * @param d1 The first input value as a {@code Double}.
     * @param d2 The second input value as a {@code Double}.
     * @return The product of the two inputs
     */
    public static Double multiply(Double d1, Double d2) {
        return d1 * d2;
    }

    /**
     * This function performs division
     *
     * @param d1 The first input value as a {@code Double}.
     * @param d2 The second input value as a {@code Double}.
     * @return The quotient of the two inputs
     */
    public static Double divide(Double d1, Double d2) {
        if (d2 == 0d) throw new NumberFormatException("Cannot divide by zero.");
        return d1 / d2;
    }

    /**
     * This static function returns the factorial value of an {@code Integer}
     *
     * @param d The initial integer as a {@code Double}, later rounded to nearest Integer
     * @return The returned value as n * n-1 * ... * 1
     */
    public static Double factorial(Double d) {

        int i = (int)Math.round(d);

        if (i > 1) {
            int result = i;
                result *= factorial((double)i - 1d);
            return (double)result;
        } else if (i == 1) {
            return 1.0d;
        } else {
            throw new NumberFormatException("You cannot perform a factorial on a number less than 1");
        }

    }
}
