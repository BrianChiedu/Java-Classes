package part2;

import java.util.Locale;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        String[] regularSports = {"Tennis", "Football", "Skating", "Jogging", "Basketball", "Baseball", "Curling", "Volleyball", "Cricket", "Badminton", "Squash", "Rugby"};

        String[] prefixes = {"Cyber", "Mega", "Hyper", "Neo"};

        Random rnd = new Random();

        for (int i = 0; i< regularSports.length; i++){
            if (regularSports[i].endsWith("ball")){
                regularSports[i] = regularSports[i].replace("ball", "orb");
            }
            else if (regularSports[i].startsWith("C")){
                regularSports[i] = regularSports[i].replace("C", "K");
            }
            else{
                int select = rnd.nextInt(prefixes.length);
                String newSport = prefixes[select] + regularSports[i].toLowerCase();
                regularSports[i]=newSport;
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
