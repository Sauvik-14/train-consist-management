import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrainAppUC19 {

    public static boolean binarySearch(String[] ids, String key) {
        if (ids.length == 0) return false;
        String[] sorted = Arrays.copyOf(ids, ids.length);
        Arrays.sort(sorted);

        int low = 0, high = sorted.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(sorted[mid]);
            if      (cmp == 0) return true;
            else if (cmp  < 0) high = mid - 1;
            else               low  = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] bogieIDs = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        System.out.println("Search BG309: " + binarySearch(bogieIDs, "BG309"));
        System.out.println("Search BG999: " + binarySearch(bogieIDs, "BG999"));
    }
}

class TrainAppUC19Test {

    private final String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};

    @Test
    public void testBinarySearch_BogieFound() {
        assertTrue(TrainAppUC19.binarySearch(ids, "BG309"));
    }

    @Test
    public void testBinarySearch_BogieNotFound() {
        assertFalse(TrainAppUC19.binarySearch(ids, "BG999"));
    }

    @Test
    public void testBinarySearch_FirstElementMatch() {
        assertTrue(TrainAppUC19.binarySearch(ids, "BG101"));
    }

    @Test
    public void testBinarySearch_LastElementMatch() {
        assertTrue(TrainAppUC19.binarySearch(ids, "BG550"));
    }

    @Test
    public void testBinarySearch_SingleElementArray() {
        assertTrue(TrainAppUC19.binarySearch(new String[]{"BG101"}, "BG101"));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        assertFalse(TrainAppUC19.binarySearch(new String[]{}, "BG101"));
    }

    @Test
    public void testBinarySearch_UnsortedInputHandled() {
        assertTrue(TrainAppUC19.binarySearch(
            new String[]{"BG309", "BG101", "BG550", "BG205", "BG412"}, "BG205"));
    }
}