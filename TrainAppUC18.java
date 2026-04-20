import org.junit.Test;
import static org.junit.Assert.*;

public class TrainAppUC18 {

    public static boolean linearSearch(String[] ids, String key) {

        for (String id : ids) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] bogieIDs = {
                "BG101",
                "BG205",
                "BG309",
                "BG412",
                "BG550"
        };

        System.out.println(
                "Search BG309: " +
                linearSearch(bogieIDs, "BG309")
        );

        System.out.println(
                "Search BG999: " +
                linearSearch(bogieIDs, "BG999")
        );
    }
}

class TrainAppUC18Test {

    private final String[] ids = {
            "BG101",
            "BG205",
            "BG309",
            "BG412",
            "BG550"
    };

    @Test
    public void testSearch_BogieFound() {
        assertTrue(
                TrainAppUC18.linearSearch(ids, "BG309")
        );
    }

    @Test
    public void testSearch_BogieNotFound() {
        assertFalse(
                TrainAppUC18.linearSearch(ids, "BG999")
        );
    }

    @Test
    public void testSearch_FirstElementMatch() {
        assertTrue(
                TrainAppUC18.linearSearch(ids, "BG101")
        );
    }

    @Test
    public void testSearch_LastElementMatch() {
        assertTrue(
                TrainAppUC18.linearSearch(ids, "BG550")
        );
    }

    @Test
    public void testSearch_SingleElementArray() {
        assertTrue(
                TrainAppUC18.linearSearch(
                        new String[]{"BG101"},
                        "BG101"
                )
        );
    }
}