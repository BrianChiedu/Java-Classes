package com.assignment3;

import java.util.Random;
import java.util.Scanner;

public class Main {

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

            if(gameMode == 1){
                System.out.println(story[rnd.nextInt(story.length)]);
                sentence = story[rnd.nextInt(story.length)];
            }
//            Below for test mode we display a truncated version of the original strings and ask the user to choose ne
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
            else{
                System.out.println("You have entered an invalid output try again");
                invalidInput = true;
            }
        }while(invalidInput);



    }
}
