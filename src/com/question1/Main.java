package com.question1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //this code block allows the user to enter the diameter and height of the cone
        System.out.println(" Please enter diameter ");
        double diameter = in.nextDouble();

        System.out.println(" Please enter height ");
        double height = in.nextDouble();

        //this code block calculates the volume of the cone
        double radius = diameter/2.0;
        double volume = Math.PI*Math.pow(radius, 2)*height/3.0;

        System.out.println("Volume of cone is " + volume);

        //this code block calculates and prints the total surface area of the cone
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));

        double tsa = Math.PI*radius*slantHeight + Math.PI*Math.pow(radius, 2);

        System.out.println("Total surface area of cone is " + tsa);
    }
}
