import java.lang.*;
import  java.util.Scanner;
public class GMT {
    public static void main(String[] args) {
        //User enters GMT
        Scanner input = new Scanner(System.in);  
        System.out.println("Enter the timezone offset to GMT:");
        int timeZO = input.nextInt();

        //Number of milliseconds in a day
        long ms_inDay = 86400000;

        //Grabbing the time
        double currentT = System.currentTimeMillis();

        //Adding the offset to the time (in milliseconds)
        currentT = currentT + (timeZO * 3600000);

        //Using modulus returns time passed just for this day
        double time_remain = currentT % ms_inDay;

        //Dividing the remaining by a hour in milliseconds to get leftover from hours
        double time_remain_hrs = time_remain % 3600000;

        //Grabbing actual hour of the day
        double hours = time_remain / 3600000;

        //Repeating same process for minutes
        double time_remain_mins = time_remain_hrs % 60000;
        double minutes = time_remain_hrs / 60000;

        //and again for seconds
        double seconds = time_remain_mins / 1000;

        //Removing decimal values
        int hours_ = (int) hours;
        int minutes_ = (int) minutes;
        int seconds_ = (int) seconds;

        //Printing current timeblahvlahyah
        System.out.printf("The current time at %d GMT is %d:%d:%d.%n",timeZO, hours_, minutes_, seconds_);
    }
}