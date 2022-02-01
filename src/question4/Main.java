package question4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a letter of the alphabet");
        char letter = in.next().charAt(0);




        if((letter>='a' && letter<='z') || (letter>='A' && letter<='Z')) {
            System.out.println("Is a letter of the alphabet");

            letter = Character.toLowerCase(letter);

            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                System.out.println("Letter is a vowel");
            }
            else {
                System.out.println("Letter is a consonant");
            }
        }
        else {
            System.out.println("Is not a letter of the alphabet");
        }
    }
}
