import java.util.*;
import java.util.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;

class BogieUC13 {
    String name;
    int capacity;
    BogieUC13(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainAppUC13 {

    public static List<BogieUC13> filterWithLoop(List<BogieUC13> bogies, int threshold) {
        List<BogieUC13> result = new ArrayList<>();
        for (BogieUC13 b : bogies) {
            if (b.capacity > threshold) result.add(b);
        }
        return result;
    }

    public static List<BogieUC13> filterWithStream(List<BogieUC13> bogies, int threshold) {
        return bogies.stream()
            .filter(b -> b.capacity > threshold)
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<BogieUC13> bogies = Arrays.asList(
            new BogieUC13("Sleeper",     72),
            new BogieUC13("AC Chair",    56),
            new BogieUC13("First Class", 24),
            new BogieUC13("General",     90)
        );

        long loopStart = System.nanoTime();
        List<BogieUC13> loopResult = filterWithLoop(bogies, 60);
        System.out.println("Loop   Time (ns): " + (System.nanoTime() - loopStart));

        long streamStart = System.nanoTime();
        List<BogieUC13> streamResult = filterWithStream(bogies, 60);
        System.out.println("Stream Time (ns): " + (System.nanoTime() - streamStart));

        System.out.println("Loop   Result Count: " + loopResult.size());
        System.out.println("Stream Result Count: " + streamResult.size());
    }
}

class TrainAppUC13Test {

    private List<BogieUC13> buildList() {
        return Arrays.asList(
            new BogieUC13("Sleeper",     72),
            new BogieUC13("AC Chair",    56),
            new BogieUC13("First Class", 24),
            new BogieUC13("General",     90)
        );
    }

    @Test
    public void testLoopFilteringLogic() {
        assertTrue(TrainAppUC13.filterWithLoop(buildList(), 60)
            .stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    public void testStreamFilteringLogic() {
        assertTrue(TrainAppUC13.filterWithStream(buildList(), 60)
            .stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    public void testLoopAndStreamResultsMatch() {
        assertEquals(
            TrainAppUC13.filterWithLoop(buildList(), 60).size(),
            TrainAppUC13.filterWithStream(buildList(), 60).size());
    }

    @Test
    public void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        TrainAppUC13.filterWithLoop(buildList(), 60);
        assertTrue(System.nanoTime() - start > 0);
    }

    @Test
    public void testLargeDatasetProcessing() {
        List<BogieUC13> large = new ArrayList<>();
        for (int i = 0; i < 10000; i++) large.add(new BogieUC13("T" + i, i % 100));
        assertEquals(
            TrainAppUC13.filterWithLoop(large, 60).size(),
            TrainAppUC13.filterWithStream(large, 60).size());
    }
}