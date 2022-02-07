package part2;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        String[] regularSports = {"Tennis", "Football", "Skating", "Jogging", "Basketball", "Baseball", "Curling", "Volleyball", "Cricket", "Badminton", "Squash", "Rugby"};

        System.out.println(regularSports.length);
        System.out.println();

        for (int i = 0; i< regularSports.length; i++){
            if (regularSports[i].endsWith("ball")){
                regularSports[i] = regularSports[i].replace("ball", "orb");
            }
            else if (regularSports[i].startsWith("C")){
                regularSports[i] = regularSports[i].replace("C", "K");
            }
            else{
                regularSports[i] = regularSports[i].toLowerCase(Locale.ROOT);
                regularSports[i] = regularSports[i].replaceFirst("", "Cyber");
            }
            System.out.println(regularSports[i]);
        }

//        String x = "my oh my chicken pot pie";
//
//        System.out.println(x.indexOf("pot"));
//        System.out.println(x.charAt(17));
//        System.out.println(x.indexOf('o'));
//        System.out.println(x.indexOf("oh"));

    }
}
