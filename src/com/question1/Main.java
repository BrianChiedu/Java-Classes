package com.question1;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //char[][] charArray = new char [3][6];
        char[][] charArray = {  {'G','B','A','C','A','B'},
                                {'K','D','X','F','O','B'},
                                {'Z','H','S','A','D','C'} };

        display(charArray);


        char character1 = 'B'; //first char
        char character2 = 'H'; //second char

        System.out.println();
        int replacements = replacementmethod(charArray,character1, character2 );
        System.out.println("Number of replaced letters are " + replacements);
        System.out.println();

        display(charArray);

    }

    //		Function that replaces the letter
    public static int replacementmethod(char[][] charArray, char character1,  char character2) {

        int replacedAmount = 0;

        for(int i = 0; i<charArray.length; i++) {
            for(int j =0; j<charArray[i].length; j++) {
                if(charArray[i][j] == character1) {
                    charArray[i][j] = character2;
                    replacedAmount++;
                }
            }
        }



        return replacedAmount;
    }


    // Function that prints the method
    public static void display(char[][] charArray) {

        for(int i = 0; i<charArray.length; i++) {
            System.out.println(charArray[i]);

        }
    }

}
