package question5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of the day");
        int day = in.nextInt();

        System.out.println("Enter the number of the month");
        int month = in.nextInt();

        System.out.println("Enter the number of the year");
        int year = in.nextInt();

        if (month>0 && month<=12) {

            int maxDays = 31;

            if (month == 2) {
                if((year%4 == 0 && year%100 !=0) || (year%400 == 0)) {
                    maxDays = 29;
                }
                else {
                    maxDays = 28;
                }
            }

            else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                maxDays = 31;
            }
            else {
                maxDays = 30;
            }


            if (day <= maxDays) {
                System.out.println("Date is legitimate");
            }
            else {
                System.out.println("Date is not legitimate");
            }
            System.out.println(maxDays);

        }
        else {
            System.out.println("Date is not legitimate");
        }
    }
}
