package question2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number between o and 9999");
        int number = in.nextInt();

        if (number<10) System.out.print("000");
        else if (number<100) System.out.print("00");
        else if (number<1000)System.out.print("0");

        System.out.println(number);

        if (number<10) System.out.println("Number originally had 1 digit");
        else if (number<100) System.out.println("Number orginally had 2 digits");
        else if (number<1000)System.out.println("Number originally had 3 digits");
        else System.out.println("Number originally had 4 digits");
    }
}
