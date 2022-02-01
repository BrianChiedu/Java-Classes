package question3;

public class Main {

    public static void main(String[] args) {
        long totalMilli = System.currentTimeMillis();

        System.out.println(totalMilli);

        long totalSeconds = totalMilli/1000;

        long totalMinutes = totalSeconds/60;

        long totalHours = totalMinutes/60;

        long currentSeconds = totalSeconds%60;

        long currentMinutes = totalMinutes%60;

        long currentHours = totalHours%24;

        //currentHours++;



        System.out.println("The current time is " + currentHours + " : " + currentMinutes + " : " + currentSeconds);
    }
}
