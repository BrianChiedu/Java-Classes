package com.question1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //this code block allows the user to enter three different decimals
        System.out.println("Enter a floating-point number");
        double number1 = in.nextDouble();

        System.out.println("Enter a floating-point number");
        double number2 = in.nextDouble();

        System.out.println("Enter a floating-point number");
        double number3 = in.nextDouble();

        //this first method find the greatest number by using the math class
        double greaterNo= Math.max(number1, number2);
        double greatestNo= Math.max(greaterNo, number3);

        System.out.println("The greatest number is " + greatestNo);

        //this is the second method that uses conditional statements to find the greatest number
        if (number1>number2) greaterNo = number1;
        else greaterNo = number2;

        if (greaterNo>number3) greatestNo = greaterNo;
        else greatestNo = number3;

        System.out.println("The greatest number is " + greatestNo);
    }
}
