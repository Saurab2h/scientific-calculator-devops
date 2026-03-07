package com.calculator;

import java.util.Scanner;
import java.math.BigInteger;
public class Calculator {

    // Square root √x
    public double sqrt(double x) {
        return Math.sqrt(x);
    }

    // Factorial x!
    public static BigInteger factorial(int n) {
    
    if (n < 0) {
        System.out.println("Error: Factorial is not defined for negative numbers");
        return BigInteger.ZERO;
    }

     BigInteger result = BigInteger.ONE;

    for (int i = 2; i <= n; i++) {
        result = result.multiply(BigInteger.valueOf(i));
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
