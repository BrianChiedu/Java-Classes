package com.assignment3;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String  compare ;


    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

//        An array of 6 different strings
        String[] story = {"Brian Chiedu looked at the bendy sandwich","He walked over to the window and reflected on his crowded surroundings.\n","He had always loved magical Berlin with its smooth swamps.\n",
                        "It was a place that encouraged his tendency to feel confident.\n","Then he saw something in the distance, or rather someone.\n","It was the figure of Tom Jobs."};

        int gameMode;
        boolean invalidInput = false;
        int testModeInput;
        String sentence = "";

        do{
//            Below we ask the user to choose a mode
            System.out.println("Welcome choose a mode \n 1 : Normal mode \n 2 : Test mode");
            gameMode = in.nextInt();

//            A random string is chosen for game mode one
            if(gameMode == 1){
                sentence = story[rnd.nextInt(story.length)];
                System.out.println(sentence);
            }
//            For game mode two below we display a truncated version of the original strings and ask the user to choose one
            else if(gameMode ==2){
                for (int i = 0; i< story.length; i++){
                    if(story[i].length() > 50){
                        System.out.println( "No "+ i + ": " + story[i].substring(0, 50));
                    }
                    else{
                        System.out.println("No "+ i + ": " + story[i]);
                    }
                }
                System.out.println();
                System.out.println("Above are shortened versions of sentences in the story please enter their number to choose one");
                testModeInput = in.nextInt();
                sentence = story[testModeInput];
            }
//            Code below is for if user inputs invalid number for gameMode
            else{
                System.out.println("You have entered an invalid output try again");
                invalidInput = true;
            }
        }while(invalidInput);

        char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] letterReplacements = new char[] {'z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'};

        //Encrypted Sentence
        String  encryption = substitionMethod(sentence.toLowerCase(), alphabet, letterReplacements);
        System.out.println(encryption);
        String decryption = encryption;
//        This string stores the letter pairs the user enters
      compare = "";
//        Until the decryption is fully equal to the sentence, this while loop is going to keep going
        while(! sentence.equals((decryption.toLowerCase())))
        {
            //Decrypted Sentence
            System.out.println("The following sentence is encrypted: " + decryption + ". Attempt to decrypt it by entering two letters at a time until the whole sentence has meaning");
            decryption = decryptionMethod(decryption, in, alphabet, letterReplacements );
            System.out.println(decryption);
        }


    }

    // IN THIS METHOD WE ENCRYPT THE CHOSEN SENTENCE
    public static String substitionMethod(String paragraph, char[] alphabet, char[] letterReplacements){

        // below we convert our chosen sentence to a char array to enable encryption, and print it
        char[] letters = paragraph.toCharArray();
        for (char c : letters) {
            System.out.print(c);
        }
        System.out.println();

        //In the nested for loops below we try to encrypt our chosen sentence by replacing the letters in the char array
        for (int i = 0; i< letters.length; i++){
            for (int j = 0; j<alphabet.length; j++) {
                if( letters[i] == alphabet[j]) {
                      letters[i] = letterReplacements[j];
                      break;
               }
            }
            }
        return new String(letters);
        }
    //IN THIS METHOD THE USER DECRYPTS THE ENCRYPTED SENTENCE
    public static String decryptionMethod(String encodedString, Scanner in, char[] alphabet, char[] letterReplacements){

//            HERE WE COLLECT THE USERS TWO LETTER CHOICES
            String input = in.next();
            if(input.length() > 1) {
                char encrytpedLetter = input.toCharArray()[0];
                char decryptedLetter = input.toCharArray()[1];
                boolean same = false;

//            This ensures the letters entered are a correct match if not, no replacement can be done
                for (int i = 0; i < alphabet.length; i++) {
                    if (encrytpedLetter == alphabet[i] && decryptedLetter == letterReplacements[i]) {
                        same = true;
                    }
                }

                if (same) {
                    int length = encodedString.length();
                    System.out.println(length);
                    for (int i = 0; i < length; i++) {
                        //            HERE WE REPLACE THE USERS ENTERED LETTER WITH THE LETTER THE USER WISHES TO REPLACE IT WITH
                        if (encrytpedLetter == encodedString.charAt(i)) {
                            char[] encodedStringArray = encodedString.toCharArray();
                            encodedStringArray[i] = Character.toUpperCase(decryptedLetter);
                            encodedString = new String(encodedStringArray);
                        }
                    }
//            we are storing each of the letter pairs in compare
                    compare = compare + encrytpedLetter + " > " + decryptedLetter + "  ";
                    System.out.println(compare);

                }

                return encodedString;
            }
            else if(input.length() == 1) {
                return undoMethod(encodedString, input, alphabet, letterReplacements);
            }
            return encodedString;
    }

    public static String undoMethod(String encodedString, String input, char[] alphabet, char[] letterReplacements){
        char removeLetter = input.toCharArray()[0];
        int index = getIndex(alphabet,Character.toLowerCase(removeLetter));
        removeLetter = Character.toUpperCase(removeLetter);

        int length = encodedString.length();
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            //            HERE WE REPLACE THE USERS ENTERED LETTER WITH THE LETTER THE USER WISHES TO REPLACE IT WITH
            if (removeLetter == encodedString.charAt(i)) {
                char[] encodedStringArray = encodedString.toCharArray();
                encodedStringArray[i] = Character.toLowerCase(letterReplacements[index]);
                encodedString = new String(encodedStringArray);
            }
        }
        return encodedString;
    }
    
    
    public static int getIndex(char[] array, char value)
    {
        
        for(int i = 0 ; i < array.length; i++)
        {
            if(array[i] == value)
            return i;
        }
        return 0;
    }
    
    

}


