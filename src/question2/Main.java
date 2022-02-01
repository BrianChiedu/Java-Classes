package question2;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //this code block generates 2 random single digit numbers
        Random rnd = new Random();

        int singleDigitNumber = rnd.nextInt(10);
        int singleDigitNumber2 = rnd.nextInt(10);

        System.out.println(singleDigitNumber + "  " + singleDigitNumber2);
        //this code block asks the user to input to enter 2 digits separately
        System.out.println("Please enter a number between 2 digits separately");
        int user1 = in.nextInt();
        int user2 = in.nextInt();

        //this code block determines whether the player wins by taking their input and judging it
        if ( user1 == singleDigitNumber && user2 == singleDigitNumber2) {
            System.out.println("Congratulations you've won $10,000!");
        }
        else if ( user1 == singleDigitNumber2 && user2 == singleDigitNumber ) {
            System.out.println("Congratulations you've won $3000!");
        }
        else if (user1 == singleDigitNumber || user2 == singleDigitNumber2 || user1 == singleDigitNumber2 || user2 == singleDigitNumber) {
            System.out.println("Congratulations you've won $1000");
        }
        else {
            System.out.println("Sorry try again next time");
        }
    }
}
