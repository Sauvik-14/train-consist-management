import java.util.*;
import java.util.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;

class BogieUC9 {
    String name;
    int capacity;

    BogieUC9(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainAppUC9 {

    public static Map<String, List<BogieUC9>> groupByType(List<BogieUC9> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    public static void main(String[] args) {

        List<BogieUC9> bogies = new ArrayList<>();

        bogies.add(new BogieUC9("Sleeper", 72));
        bogies.add(new BogieUC9("AC Chair", 56));
        bogies.add(new BogieUC9("Sleeper", 72));
        bogies.add(new BogieUC9("First Class", 24));

        Map<String, List<BogieUC9>> grouped = groupByType(bogies);

        grouped.forEach((type, list) ->
                System.out.println(type + " -> " + list.size() + " bogie(s)")
        );
    }
}

class TrainAppUC9Test {

    private List<BogieUC9> buildList() {
        List<BogieUC9> bogies = new ArrayList<>();

        bogies.add(new BogieUC9("Sleeper", 72));
        bogies.add(new BogieUC9("AC Chair", 56));
        bogies.add(new BogieUC9("Sleeper", 72));
        bogies.add(new BogieUC9("First Class", 24));

        return bogies;
    }

    @Test
    public void testGrouping_BogiesGroupedByType() {
        assertTrue(TrainAppUC9.groupByType(buildList()).containsKey("Sleeper"));
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        assertEquals(2,
                TrainAppUC9.groupByType(buildList()).get("Sleeper").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        assertEquals(3,
                TrainAppUC9.groupByType(buildList()).size());
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        assertTrue(
                TrainAppUC9.groupByType(new ArrayList<>()).isEmpty()
        );
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<BogieUC9> bogies = Arrays.asList(
                new BogieUC9("Sleeper", 72),
                new BogieUC9("Sleeper", 72)
        );

        assertEquals(1,
                TrainAppUC9.groupByType(bogies).size());
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<BogieUC9>> grouped =
                TrainAppUC9.groupByType(buildList());

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {
        Map<String, List<BogieUC9>> grouped =
                TrainAppUC9.groupByType(buildList());

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(1, grouped.get("AC Chair").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<BogieUC9> original = buildList();

        TrainAppUC9.groupByType(original);

        assertEquals(4, original.size());
    }
}