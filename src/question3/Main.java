package question3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("hi");

        Scanner in = new Scanner(System.in);

        Random rnd = new Random();


        boolean isPlus = rnd.nextBoolean();
        boolean hideFirst = rnd.nextBoolean();


        int num1 = rnd.nextInt(45)+5;
        int num2 = rnd.nextInt(45)+5;

        int answer=0;

        if(isPlus)
        {
            answer = num1 + num2;

            if(hideFirst)
            {
                System.out.println("? + " + num2 + " = " + answer);
            }
            else
            {
                System.out.println(num1 + " + ? = " + answer);
            }


        }
        else
        {
            answer = num1 - num2;

            if(hideFirst)
            {
                System.out.println("? - " + num2 + " = " + answer);
            }
            else
            {
                System.out.println(num1 + " - ? = " + answer);
            }
        }

        System.out.println("What is ?:");
        int userAnswer = in.nextInt();

        if(hideFirst)
        {
            if(userAnswer==num1)
            {
                System.out.println("Correct!");
            }
            else
            {
                System.out.println("Wrong!");
            }
        }
        else
        {
            if(userAnswer==num2)
            {
                System.out.println("Correct!");
            }
            else
            {
                System.out.println("Wrong!");
            }
        }


//		if((hideFirst==true & userAnswer==num1) || (hideFirst==false & userAnswer==num2))
//		{
//			System.out.println("Correct!");
//		}
//		else
//		{
//			System.out.println("Wrong!");
//		}
    }
}
