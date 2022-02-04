package question3;

public class Main {
    public static void main(String[] args) {

    }
    public static int maxMethod(int numberx, int numbery, int numberz){
        int greaterValue;
        int greatestValue;
        greaterValue=Math.max(numberx, numbery);

        greatestValue = Math.max(greaterValue, numberz);

        return greatestValue;
    }

    public static double maxMethod(double numberA, double numberB, double numberC){
        double greaterValue;
        double greatestValue;
        greaterValue=Math.max(numberA, numberB);

        greatestValue = Math.max(greaterValue, numberC);

        return greatestValue;

    }

    public static char maxMethod(char x, char y, char z){
        int asciiValueA = (int) x;
        int asciiValueB = (int) y;
        int asciiValueC = (int) z;

        int greaterValue;
        int greatestValue;
        greaterValue=Math.max(asciiValueA, asciiValueB);

        greatestValue = Math.max(greaterValue, asciiValueC);

        char finalAnswer = (char) greatestValue;

        return finalAnswer;

    }
//                                 MINIMUM METHODS
    public static int minMethod(int numberx, int numbery, int numberz){
        int lesserValue;
        int leastValue;
        lesserValue=Math.min(numberx, numbery);

        leastValue = Math.min(lesserValue, numberz);

        return leastValue;
    }

    public static double minMethod(double numberA, double numberB, double numberC){
        double lesserValue;
        double leastValue;
        lesserValue=Math.min(numberA, numberB);

        leastValue = Math.min(lesserValue, numberC);

        return leastValue;

    }

    public static char minMethod(char x, char y, char z){
        int asciiValueA = (int) x;
        int asciiValueB = (int) y;
        int asciiValueC = (int) z;

        int lesserValue;
        int leastValue;
        lesserValue=Math.min(asciiValueA, asciiValueB);

        leastValue = Math.min(lesserValue, asciiValueC);

        char finalAnswer = (char) leastValue;

        return finalAnswer;

    }
}
