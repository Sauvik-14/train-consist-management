import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrainAppUC17 {

    public static String[] sortBogieNames(String[] names) {
        String[] copy = Arrays.copyOf(names, names.length);
        Arrays.sort(copy);
        return copy;
    }

    public static void main(String[] args) {
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        System.out.println("Sorted: " + Arrays.toString(sortBogieNames(bogieNames)));
    }
}

class TrainAppUC17Test {

    @Test
    public void testSort_BasicAlphabeticalSorting() {
        assertArrayEquals(
            new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"},
            TrainAppUC17.sortBogieNames(
                new String[]{"Sleeper", "AC Chair", "First Class", "General", "Luxury"}));
    }

    @Test
    public void testSort_UnsortedInput() {
        assertArrayEquals(
            new String[]{"AC Chair", "General", "Luxury", "Sleeper"},
            TrainAppUC17.sortBogieNames(
                new String[]{"Luxury", "General", "Sleeper", "AC Chair"}));
    }

    @Test
    public void testSort_AlreadySortedArray() {
        assertArrayEquals(
            new String[]{"AC Chair", "First Class", "General"},
            TrainAppUC17.sortBogieNames(
                new String[]{"AC Chair", "First Class", "General"}));
    }

    @Test
    public void testSort_DuplicateBogieNames() {
        assertArrayEquals(
            new String[]{"AC Chair", "General", "Sleeper", "Sleeper"},
            TrainAppUC17.sortBogieNames(
                new String[]{"Sleeper", "AC Chair", "Sleeper", "General"}));
    }

    @Test
    public void testSort_SingleElementArray() {
        assertArrayEquals(
            new String[]{"Sleeper"},
            TrainAppUC17.sortBogieNames(new String[]{"Sleeper"}));
    }
}