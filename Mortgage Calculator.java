package com.practice;

import java.text.NumberFormat;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        
        //CONSTANTS
        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENT = 100;

        //Create scanner object
        Scanner scanner = new Scanner(System.in);
        //Declare variables
        float principal = 0;
        float monthlyRate = 0;
        byte years = 0;
        int numberOfPayments = 0;

        //While loop for user input for principal payment
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextFloat();
            if (principal >= 1000 && principal <= 1000000) {
                break;
            }
            System.out.print("Enter a value between 1000 and 1000000: ");
        }

        //While loop for user input for annual interest rate
        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualRate = scanner.nextFloat();
            if (annualRate >= 1 && annualRate <= 30) {
                monthlyRate = annualRate / PERCENT / MONTHS_IN_YEARS;
                break;
            }
            System.out.print("Enter a value between 1 and 30: ");
        }

        //While loop for user input for period of years
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEARS;
                break;
            }
            System.out.print("Enter a value between 1 and 30: ");
        }
        
        //Calculate mortgage
        double mortgage = principal * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments)) / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
        //Print out mortgage in a currency format
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));


    }
}
