import java.util.*;

public class TrainAppUC5 {
    public static void main(String[] args) {

        Set<String> train = new LinkedHashSet<>();

        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add("Guard");
        train.add("Sleeper"); // duplicate

        System.out.println("Train Formation: " + train);
    }
}