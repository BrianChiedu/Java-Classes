package com.question3;

public class Main {
    public static void main(String[] args) {


    }
    public static int maxMethod(int numberx, int numbery, int numberz){
        int greaterValue;
        int greatestValue;
        greaterValue=Math.max(numberx, numbery);

        greatestValue = Math.max(greaterValue, numberz);

        return greatestValue;
    }

    public static double maxMethod(double numberA, double numberB, double numberC){
        double greaterValue;
        double greatestValue;
        greaterValue=Math.max(numberA, numberB);

        greatestValue = Math.max(greaterValue, numberC);

        return greatestValue;

    }

//    public static char maxMethod(char a, char b, char c){
//
//    }
}
