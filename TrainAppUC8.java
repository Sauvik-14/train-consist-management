import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

// Bogie class (needed for testing)
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainAppUC8Test {

    // Helper method (reuse filter logic)
    private List<Bogie> filter(List<Bogie> list, int threshold) {
        return list.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    // ✅ 1. Capacity > Threshold
    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC", 60)
        );

        List<Bogie> result = filter(list, 70);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    // ✅ 2. Capacity == Threshold (should NOT include)
    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70)
        );

        List<Bogie> result = filter(list, 70);

        assertEquals(0, result.size());
    }

    // ✅ 3. Capacity < Threshold
    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("AC", 50)
        );

        List<Bogie> result = filter(list, 70);

        assertTrue(result.isEmpty());
    }

    // ✅ 4. Multiple Matching Bogies
    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC", 75),
                new Bogie("FC", 40)
        );

        List<Bogie> result = filter(list, 70);

        assertEquals(2, result.size());
    }

    // ✅ 5. No Matching Bogies
    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("AC", 50),
                new Bogie("FC", 40)
        );

        List<Bogie> result = filter(list, 70);

        assertTrue(result.isEmpty());
    }

    // ✅ 6. All Bogies Matching
    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC", 90)
        );

        List<Bogie> result = filter(list, 70);

        assertEquals(list.size(), result.size());
    }

    // ✅ 7. Empty List
    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        List<Bogie> result = filter(list, 70);

        assertTrue(result.isEmpty());
    }

    // ✅ 8. Original List Unchanged
    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 80));
        list.add(new Bogie("AC", 50));

        int originalSize = list.size();

        filter(list, 70);

        assertEquals(originalSize, list.size()); // unchanged
    }
}