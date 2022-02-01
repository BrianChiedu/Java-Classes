package question5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //this code block allows the user to enter a number representing a month
        System.out.println("Please enter the number of the month");
        int month = in.nextInt();

        //this code block takes the entered number  and outputs the month the entered number represents
        if (month>12) System.out.println("Month number is between 1 and 12");
        else if (month == 12) System.out.println("December");
        else if (month == 11) System.out.println("November");
        else if (month == 10) System.out.println("October");
        else if (month == 9) System.out.println("September");
        else if (month == 8) System.out.println("August");
        else if (month == 7) System.out.println("July");
        else if (month == 6) System.out.println("June");
        else if (month == 5) System.out.println("May");
        else if (month == 4) System.out.println("April");
        else if (month == 3) System.out.println("March");
        else if (month == 2) System.out.println("February");
        else if (month == 1) System.out.println("January");
        else System.out.println("Month number is between 1 and 12");
    }
}
