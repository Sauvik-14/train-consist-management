import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class GoodsBogieUC12 {
    String shape;
    String cargo;
    GoodsBogieUC12(String shape, String cargo) {
        this.shape = shape;
        this.cargo = cargo;
    }
}

public class TrainAppUC12 {

    public static boolean isSafeFormation(List<GoodsBogieUC12> bogies) {
        return bogies.stream()
            .allMatch(b -> !b.shape.equals("Cylindrical") || b.cargo.equals("Petroleum"));
    }

    public static void main(String[] args) {
        List<GoodsBogieUC12> bogies = new ArrayList<>();
        bogies.add(new GoodsBogieUC12("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogieUC12("Rectangular", "Coal"));

        System.out.println("Train Safety Compliant: " + isSafeFormation(bogies));
    }
}

class TrainAppUC12Test {

    @Test
    public void testSafety_AllBogiesValid() {
        List<GoodsBogieUC12> bogies = Arrays.asList(
            new GoodsBogieUC12("Cylindrical", "Petroleum"),
            new GoodsBogieUC12("Rectangular", "Coal"));
        assertTrue(TrainAppUC12.isSafeFormation(bogies));
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        assertFalse(TrainAppUC12.isSafeFormation(
            Collections.singletonList(new GoodsBogieUC12("Cylindrical", "Coal"))));
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogieUC12> bogies = Arrays.asList(
            new GoodsBogieUC12("Rectangular", "Coal"),
            new GoodsBogieUC12("Open",        "Grain"));
        assertTrue(TrainAppUC12.isSafeFormation(bogies));
    }

    @Test
    public void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogieUC12> bogies = Arrays.asList(
            new GoodsBogieUC12("Cylindrical", "Petroleum"),
            new GoodsBogieUC12("Cylindrical", "Coal"));
        assertFalse(TrainAppUC12.isSafeFormation(bogies));
    }

    @Test
    public void testSafety_EmptyBogieList() {
        assertTrue(TrainAppUC12.isSafeFormation(new ArrayList<>()));
    }
}