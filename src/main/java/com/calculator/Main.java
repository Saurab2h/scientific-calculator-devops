package com.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Scientific Calculator");
        System.out.println("----------------------");
        System.out.println("1. Square Root (√x)");
        System.out.println("2. Factorial (x!)");
        System.out.println("3. Natural Log ln(x)");
        System.out.println("4. Power (x^b)");

        System.out.print("Choose operation: ");
        int choice = sc.nextInt();

        switch(choice) {

            case 1:
                System.out.print("Enter number: ");
                double x = sc.nextDouble();
                System.out.println("Result: " + calc.sqrt(x));
                break;

            case 2:
                System.out.print("Enter integer: ");
                int n = sc.nextInt();
                System.out.println("Result: " + calc.factorial(n));
                break;

            case 3:
                System.out.print("Enter number: ");
                x = sc.nextDouble();
                System.out.println("Result: " + calc.log(x));
                break;

            case 4:
                System.out.print("Enter base: ");
                double a = sc.nextDouble();
                System.out.print("Enter exponent: ");
                double b = sc.nextDouble();
                System.out.println("Result: " + calc.power(a, b));
                break;

            default:
                System.out.println("Invalid option");
        }

        sc.close();
    }
}
