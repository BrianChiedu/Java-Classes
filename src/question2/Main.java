package question2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //this code block allows the user to enter coordinates for point A,B and C.
        System.out.println("Please enter x coordinate for A");
        double xA = in.nextDouble();

        System.out.println("Please enter y coordinate for A");
        double yA = in.nextDouble();

        System.out.println("Please enter x coordinate for B");
        double xB = in.nextDouble();

        System.out.println("Please enter y coordinate for B");
        double yB = in.nextDouble();

        System.out.println("Please enter x coordinate for C");
        double xC = in.nextDouble();

        System.out.println("Please enter y coordinate for C");
        double yC = in.nextDouble();

        System.out.println("ok");


        ////in this code block we use law of cosines to find the needed angle
        double lineC = Math.sqrt(Math.pow(xB-xA, 2) + Math.pow(yB-yA, 2));

        double lineB = Math.sqrt(Math.pow(xC-xA, 2) + Math.pow(yC-yA, 2));

        double lineA = Math.sqrt(Math.pow(xC-xB, 2) + Math.pow(yC-yB, 2));

        double cosB = (Math.pow(lineB, 2)-Math.pow(lineA, 2)-Math.pow(lineC, 2))/(-2*lineA*lineC);

        double angleB = Math.acos(cosB);
        angleB = Math.toDegrees(angleB);

        System.out.println("Angle B is " + angleB);
    }
}
