package question4;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();

        int arrayNumbers[] = new int[20];

        int largestNumber=0;
        int smallestNumber=1001;
        double sum=0;

        for(int i=0; i<arrayNumbers.length; i++) {
            int generatedNumbers = rnd.nextInt(1000)+1;
            arrayNumbers[i]=generatedNumbers;

            sum+=generatedNumbers;

            if(arrayNumbers[i]>largestNumber) {
                largestNumber = arrayNumbers[i];
            }
            if(arrayNumbers[i]<smallestNumber) {
                smallestNumber = arrayNumbers[i];
            }

            System.out.println(arrayNumbers[i]);
        }

        double averageNumber = (sum)/arrayNumbers.length;

        System.out.println("The smallest number is " + smallestNumber );
        System.out.println("The largest number is " + largestNumber );
        System.out.println("The average number is " + averageNumber);
    }
}
