package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        //this variable is the total prize money the user wins from the various methods and games below
        int prizeMoney = 0;

        int bonusPrizeMoney = 0;
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// part number (1)
// status (finished)

        //our winning numbers array
        int[] winningNumbers = new int[10];

        boolean isDuplicate = false;

        int randomNumber = 0;

        int sumOfWinningNumbers = 0;

        for(int i=0; i<winningNumbers.length; i++) {

            //in this loop we generate 10 random winning numbers
            do {
                randomNumber = rnd.nextInt(99)+1;

                //in this loop we make sure there are no duplicates
                for(int j=0; j<=i; j++) {
                    if(randomNumber == winningNumbers[j]) {
                        isDuplicate = true;
                        break;
                    }
                    else {
                        isDuplicate = false;
                    }
                }

            }while(isDuplicate);

            // to put in the number into the winning numbers array
            winningNumbers[i] = randomNumber;

            //as the random numbers are generated they are added together here to give us the sum of winning numbers
            sumOfWinningNumbers = sumOfWinningNumbers + randomNumber;

            //here we make sure that single digit numbers generated are displayed as two digits with a zero at the front
            if(winningNumbers[i]<10) {
                System.out.print("0" + winningNumbers[i] + " ");
            }
            else {
                System.out.print(winningNumbers[i] + " ");
            }

        }
        System.out.println(" ");
        System.out.println("The sum of winning numbers is " + sumOfWinningNumbers);
        System.out.println("");

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// part number (2)
// status (finished)

        int[] prizeSums = new int[4];

        int bonusGame = 0;

        //in the counters array each element corresponds to the number of times a certain sum has appeared in prize sums array
        int[] counters = new int[5];

        //to calculate the probability of winning each prizeSums
        for (int i=0; i<prizeSums.length; i++) {

            bonusGame = rnd.nextInt(101);
            //if the random number generated is within the probability range the sum gets added to the array
            if(bonusGame<50) {
                prizeSums[i] = 10;
            }
            else if(bonusGame<77) {
                prizeSums[i] = 20;
            }
            else if(bonusGame<92) {
                prizeSums[i] = 50;
            }
            else if(bonusGame<98) {
                prizeSums[i] = 200;
            }
            else{
                prizeSums[i] = 1000;
            }
        }

        for(int j = 0; j<prizeSums.length; j++) {
            System.out.println(prizeSums[j]);
        }

        //to check if prizeSum appears more than once
        for(int j=0; j<prizeSums.length; j++) {
            //if the prize sums are equal to these numbers we add 1 to the respective indexes of the counter array
            //if there is a 10 in the prize sums array we add 1 to the first element of the counters array
            //each of the index in the counters array corresponds to each of the prize sums
            if(prizeSums[j] == 10) {
                counters[0] += 1;
            }
            else if(prizeSums[j] == 20) {
                counters[1] += 1;
            }
            else if(prizeSums[j] == 50) {
                counters[2] += 1;
            }
            else if(prizeSums[j] == 200) {
                counters[3] += 1;
            }
            else {
                counters[4] += 1;
            }
        }

        System.out.println("In the bonus game here, if a sum appears more than once you win that sum");
        System.out.println("");

        //to print out the number.this loop goes through the counters array to check if any of the elements are greater than 1
        for(int k=0; k<counters.length; k++) {
            if(counters[k]>1) {
                //if the elements are greater than one, that means the sum has appeared more than once in the prize sum array and the user is entitled to that sum. so below we check what index that has a value greater than one and based on the index we add the prize sum it corresponds to
                if(k==0) {
                    System.out.println("Congratulations you won 10");
                    bonusPrizeMoney += 10;
                }
                else if(k==1) {
                    System.out.println("Congratulations you won 20");
                    bonusPrizeMoney += 20;
                }
                else if(k==2) {
                    System.out.println("Congratulations you won 50");
                    bonusPrizeMoney += 50;
                }
                else if(k==3) {
                    System.out.println("Congratulations you won 200");
                    bonusPrizeMoney += 200;
                }
                else {
                    System.out.println("Congratulations you won 1000");
                    bonusPrizeMoney += 1000;
                }

            }
        }
        System.out.println("");
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// part number (3)
// status (finished)


        int[] guessedNumbers = new int[5];

        boolean isRepeat = false;

        int guessedNumber;

        for(int i=0; i<5; i++) {

            //in this loop we allow the user to input a guess
            do {
                System.out.println("Please enter guess number " + (i + 1) + " below");
                guessedNumber = in.nextInt();

                isRepeat = false;
                //in this loop we make sure the user doesn't enter the same guess twice, if the user does we ask again for the number.
                for(int j=0; j<=i; j++) {
                    if(guessedNumber == guessedNumbers[j]) {
                        isRepeat = true;
                        break;
                    }
                }

            }while(isRepeat);

            guessedNumbers[i] = guessedNumber;
        }

        System.out.println("Please guess what the sum of all ten winning numbers will be");
        int sumGuess = in.nextInt();
        System.out.println("");

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// part number (4)
// status (unfinished)

        int counter = 0;

        //in this for loop we  check if the users guessed numbers is equal to any of the 10 winning numbers then if it is, counter is incremented
        for(int i=0; i<guessedNumbers.length; i++) {

            for(int j=0; j<winningNumbers.length; j++) {
                if(guessedNumbers[i] == winningNumbers[j]) {
                    counter++;
                }
            }
        }

        //here the number of times counter was incremented would determine how many numbers the user guessed correctly and the prize the user wins
        if(counter == 5) {
            System.out.println("Congratulations, you have won €800000 ");
            prizeMoney += 800000;
        }
        else if(counter == 4) {
            System.out.println("Congratulations, you have won €100000 ");
            prizeMoney += 100000;
        }
        else if(counter == 3) {
            System.out.println("Congratulations, you have won €25000 ");
            prizeMoney += 25000;
        }
        else if(counter == 2) {
            System.out.println("Congratulations, you have won €6000 ");
            prizeMoney += 6000;
        }
        else if(counter == 1) {
            System.out.println("Congratulations, you have won €1000 ");
            prizeMoney += 1000;
        }

        System.out.println("");

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// part number (5)
// status (finished)


        //if the users guess for some of winning numbers is equal to the actual sum of winning numbers, the user wins a prize.
        if(sumGuess == sumOfWinningNumbers) {
            System.out.println("Congratulations, you have won €300,000");
        }
        System.out.println("");

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// part number (6)
// status (finished)

        //below I explain to the user how the total prize money won is calculated
        System.out.println("If you guessed the number correctly you win a prize sum and if you guessed the sum of the ten numbers correnctly you also another prize sum." +"\r\n"+ "The higher prize sum of these two would be added to your "
                + "bonus game prize sum and this is how your total prize money is calculated.");
        System.out.println("");

        //below we only print out the highest prize sum the user won
        if(prizeMoney<300000 && sumGuess == sumOfWinningNumbers) {
            System.out.println("Congratulations the prize money you won is a total of " + (300000 + bonusPrizeMoney));
        }
        else {
            System.out.println("Congratulations the prize money you won is a total of " + (prizeMoney + bonusPrizeMoney));
        }



    }
}

