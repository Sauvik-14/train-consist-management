import java.util.*;
import java.util.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;

class BogieUC10 {
    String name;
    int capacity;
    BogieUC10(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainAppUC10 {

    public static int totalSeats(List<BogieUC10> bogies) {
        return bogies.stream()
            .map(b -> b.capacity)
            .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        List<BogieUC10> bogies = new ArrayList<>();
        bogies.add(new BogieUC10("Sleeper",     72));
        bogies.add(new BogieUC10("AC Chair",    56));
        bogies.add(new BogieUC10("First Class", 24));

        System.out.println("Total Seating Capacity: " + totalSeats(bogies));
    }
}

class TrainAppUC10Test {

    private List<BogieUC10> buildList() {
        return Arrays.asList(
            new BogieUC10("Sleeper",     72),
            new BogieUC10("AC Chair",    56),
            new BogieUC10("First Class", 24)
        );
    }

    @Test
    public void testReduce_TotalSeatCalculation() {
        assertEquals(152, TrainAppUC10.totalSeats(buildList()));
    }

    @Test
    public void testReduce_MultipleBogiesAggregation() {
        assertTrue(TrainAppUC10.totalSeats(buildList()) > 0);
    }

    @Test
    public void testReduce_SingleBogieCapacity() {
        assertEquals(72, TrainAppUC10.totalSeats(
            Collections.singletonList(new BogieUC10("Sleeper", 72))));
    }

    @Test
    public void testReduce_EmptyBogieList() {
        assertEquals(0, TrainAppUC10.totalSeats(new ArrayList<>()));
    }

    @Test
    public void testReduce_CorrectCapacityExtraction() {
        List<Integer> caps = buildList().stream()
            .map(b -> b.capacity).collect(Collectors.toList());
        assertTrue(caps.containsAll(Arrays.asList(72, 56, 24)));
    }

    @Test
    public void testReduce_AllBogiesIncluded() {
        assertEquals(72 + 56 + 24, TrainAppUC10.totalSeats(buildList()));
    }

    @Test
    public void testReduce_OriginalListUnchanged() {
        List<BogieUC10> original = new ArrayList<>(buildList());
        TrainAppUC10.totalSeats(original);
        assertEquals(3, original.size());
    }
}