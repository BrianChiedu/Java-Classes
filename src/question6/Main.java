package question6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //this code block allows the users to input their weight and height
        System.out.println("Please enter your weight");
        double weight = in.nextDouble(); //kg

        System.out.println("Please enter your height");
        double height = in.nextDouble(); //cm

        //this code block calculates and prints the users' bmi
        double metreHeight = height/100;
        double bmi = weight/Math.pow(metreHeight, 2);

        System.out.println("Your BMI is " + bmi);

        //this code block allocates the users to the weight class they belong
        if (bmi<18.5) System.out.println("You are underweight");
        else if (bmi<=24.9) System.out.println("You are normal weight");
        else if (bmi<=29.9) System.out.println("You are overweight");
        else System.out.println("You are obese");
    }
}
