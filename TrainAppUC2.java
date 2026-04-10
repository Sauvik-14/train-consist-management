import java.util.*;

public class TrainAppUC2 {
    public static void main(String[] args) {

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After Adding: " + passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("After Removal: " + passengerBogies);

        System.out.println("Contains Sleeper? " + passengerBogies.contains("Sleeper"));
    }
}