package com.calculator;

public class Calculator {

    // Square root √x
    public double sqrt(double x) {
        return Math.sqrt(x);
    }

    // Factorial x!
    public long factorial(int x) {
        long result = 1;
        for(int i = 1; i <= x; i++) {
            result = result * i;
        }
        return result;
    }

    // Natural logarithm ln(x)
    public double log(double x) {
        return Math.log(x);
    }

    // Power x^b
    public double power(double x, double b) {
        return Math.pow(x, b);
    }
}
