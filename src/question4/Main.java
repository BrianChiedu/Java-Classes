package question4;

public class Main {

    public static void main(String[] args) {

//        TEST CASE FOR CHAR METHOD
        char[] arrayX = new char[] {'g', 'E', 'x', 'r', 'k', 'A'};

        char answer =maxMethod(arrayX);

        System.out.println(answer);

//      TEST CASE FOR INT METHOD
//        int[] arrayX = new int[] {54, 7, 46, 3, 86, 23};
//
//        int answer = minMethod(arrayX);
//
//        System.out.println(answer);
//
//    }

//        TEST CASE FOR DOUBLE METHOD
//        double[] arrayX = new double[]{54.76, 7.4, 46.2, 3.77, 86.13, 23.7};
//
//        double answer = minMethod(arrayX);
//
//        System.out.println(answer);

    }

    //    MAXIMUM METHODS
    public static int maxMethod(int[] arr1) {
        int largestNumber = 0;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > largestNumber) {
                largestNumber = arr1[i];
            }
        }
        return largestNumber;

    }

    public static double maxMethod(double[] arr2) {
        double largestNumber = 0;

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > largestNumber) {
                largestNumber = arr2[i];
            }
        }
        return largestNumber;

    }

    public static char maxMethod(char[] arr3) {
        int[] castedArray = new int[arr3.length];
        int largestNumber = 0;

        for (int i = 0; i < arr3.length; i++) {
            int castedChar = (int) arr3[i];
            castedArray[i] = castedChar;
        }

        for (int i = 0; i < castedArray.length; i++) {
            if (castedArray[i] > largestNumber) {
                largestNumber = castedArray[i];
            }
        }
        return (char) largestNumber;

    }

    // MINIMUM METHODS

    public static int minMethod(int[] arr1) {
        int smallestNumber = arr1[0];

        for (int i = 0; i < arr1.length; i++) {

            if (arr1[i] < smallestNumber) {
                smallestNumber = arr1[i];
            }
        }
        return smallestNumber;

    }

    public static double minMethod(double[] arr2) {
        double smallestNumber = arr2[0];

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < smallestNumber) {
                smallestNumber = arr2[i];
            }
        }
        return smallestNumber;

    }

    public static char minMethod(char[] arr3) {
        int[] castedArray = new int[arr3.length];

        for (int i = 0; i < arr3.length; i++) {
            int castedChar = (int) arr3[i];
            castedArray[i] = castedChar;
        }

        int smallestNumber = castedArray[0];

        for (int i = 0; i < castedArray.length; i++) {
            if (castedArray[i] < smallestNumber) {
                smallestNumber = castedArray[i];
            }
        }
        return (char) smallestNumber;
    }
}
