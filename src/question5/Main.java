package question5;

public class Main {

    public static void main(String[] args) {

        int[] arr1 = new int[] {8, 12, 4, 87, 45};

        int[] arr2 = new int[] {2, 65, 34, 6, 18};

        arr1 = arr2;

        arr2 = arr1;

        System.out.println(arr1[4]);


    }
}
