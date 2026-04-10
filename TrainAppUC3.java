import java.util.*;

public class TrainAppUC3 {
    public static void main(String[] args) {

        Set<String> bogieIDs = new HashSet<>();

        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG101"); // duplicate

        System.out.println("Unique Bogie IDs: " + bogieIDs);
    }
}