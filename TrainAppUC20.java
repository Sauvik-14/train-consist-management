import org.junit.Test;
import static org.junit.Assert.*;

public class TrainAppUC20 {

    public static boolean searchBogie(String[] ids, String key) {
        if (ids == null || ids.length == 0)
            throw new IllegalStateException("No bogies available. Cannot perform search.");
        for (String id : ids)
            if (id.equals(key)) return true;
        return false;
    }

    public static void main(String[] args) {
        try {
            searchBogie(new String[]{}, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        String[] ids = {"BG101", "BG205", "BG309"};
        System.out.println("Search BG205: " + searchBogie(ids, "BG205"));
        System.out.println("Search BG999: " + searchBogie(ids, "BG999"));
    }
}

class TrainAppUC20Test {

    @Test(expected = IllegalStateException.class)
    public void testSearch_ThrowsExceptionWhenEmpty() {
        TrainAppUC20.searchBogie(new String[]{}, "BG101");
    }

    @Test
    public void testSearch_AllowsSearchWhenDataExists() {
        TrainAppUC20.searchBogie(new String[]{"BG101", "BG205"}, "BG101");
    }

    @Test
    public void testSearch_BogieFoundAfterValidation() {
        assertTrue(TrainAppUC20.searchBogie(
            new String[]{"BG101", "BG205", "BG309"}, "BG205"));
    }

    @Test
    public void testSearch_BogieNotFoundAfterValidation() {
        assertFalse(TrainAppUC20.searchBogie(
            new String[]{"BG101", "BG205", "BG309"}, "BG999"));
    }

    @Test
    public void testSearch_SingleElementValidCase() {
        assertTrue(TrainAppUC20.searchBogie(new String[]{"BG101"}, "BG101"));
    }
}