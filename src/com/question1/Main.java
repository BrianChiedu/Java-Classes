package com.question1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        //This code block asks the user to enter a rarity they expect to get
        System.out.println("Enter one of the following letters for the rarity you expect to get: N for Normal, M for Magical, R for Rare and L for Legendary");
        char user = in.next().charAt(0);

        //This code block decides what number the user gets according to probabilities
        Random rnd = new Random();

        int num1 = rnd.nextInt(100);

        System.out.println(num1);
        char actual;
        if (num1<60) {
            actual = 'N';
        }
        else if (num1<85) {
            actual = 'M';
        }
        else if (num1<97) {
            actual = 'R';
        }
        else {
            actual = 'L';
        }

        System.out.println("Here is the item you got " + actual);

        if ( user == actual) {
            System.out.println("You got it correct!");
        }
    }
}
