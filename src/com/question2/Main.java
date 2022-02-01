package com.question2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5,6,6};

        //int[] arrayA = new int[] {5,1,2,2,4,5,7};
        int[] arrayA = new int[] {4,4,4,4,4,4,4};
        int answer;

        answer = method1(arrayA);
        System.out.println(answer);

    }

    public static int method1(int[] array1 ) {

        int smallestInteger = 1;


        Arrays.sort(array1);

        // if the first number in the array is greater than 1 or less than 0 the smallest positive integer not in array1 is One
        int smallest = array1[0];

        for(int i=0; i<array1.length; i++) {
            //for() {
                if(array1[i] != array1[i+1]) {

                    if(array1[i]+1 != array1[i+1]) {
                        smallestInteger = array1[i]+1;
                        break;
                    }
                }
            }
        //}
        return smallestInteger;

    }

}
