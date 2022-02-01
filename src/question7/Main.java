package question7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        System.out.println("If you are single, enter 1. If you are single with a child, enter 2. If you are married, enter 3");
        int status = in.nextInt();

        System.out.println("Please enter your salary");
        double salary = in.nextDouble();

        double myTaxBand = 0;

        if (status == 1) myTaxBand = 351300/12;
        if (status == 2) myTaxBand = 39300/12;
        if (status == 3) myTaxBand = 44300/12;

        System.out.println("Your tax band is " + myTaxBand);


        double tax = 0;
        if (salary<=myTaxBand) {
            tax = 0.2*salary;

        }
        else {
            tax = 0.2*myTaxBand + 0.4*(salary-myTaxBand);

        }

        System.out.println("Your tax would be " + tax );
    }
}
