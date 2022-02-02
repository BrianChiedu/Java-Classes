package com.question2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//       CASES FOR INDEX OUT OF BOUNDS
        //int[] arrayA = {1,2,3,4,5,6,6};
        //int[] arrayA = new int[] {1,1,1,1,1,1,1};

        //int[] arrayA = new int[] {5,1,2,2,4,5,7};
        int[] arrayA = new int[] {4,4,4,4,4,4,4};

        int answer = method1(arrayA);
        System.out.println(answer);

    }

    public static int method1(int[] array ) {

        int smallestInteger = 1;


        Arrays.sort(array);

        // if the first number in the array is greater than 1 the smallest positive integer not in array1 is One
        int smallest = array[0];
        if(smallest>1){
            return smallestInteger;
        }

        for(int i=0; i<=array.length; i++)
            if (array[i] != array[i + 1]) {
                if (array[i] + 1 != array[i + 1]) {
                    smallestInteger = array[i] + 1;
                    break;
                }
            }
//        I feel like we need an exit statement to tell us if we run the whole integers and all of them are equal to each other we should stop and exit
        return smallestInteger;
    }

}
