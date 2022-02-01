package question4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //this code block allows the user to enter an integer
        System.out.println("Please enter and integer");
        int integer = in.nextInt();

        //this code block determines whether the entered integer is positive, negative or zero
        if (integer>0) System.out.println("positive");
        else if (integer<0) System.out.println("negative");
        else System.out.println("Zero");

    }
}
