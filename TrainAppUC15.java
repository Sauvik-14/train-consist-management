import org.junit.Test;
import static org.junit.Assert.*;

class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) { super(message); }
}

public class TrainAppUC15 {

    static String lastLog = "";

    public static String assignedCargo = null;

    public static void assignCargo(String shape, String cargo) {
        assignedCargo = null;
        try {
            if (shape.equals("Rectangular") && cargo.equals("Petroleum"))
                throw new CargoSafetyException("Petroleum cannot be assigned to Rectangular bogie");
            assignedCargo = cargo;
            System.out.println("Cargo assigned: " + cargo + " -> " + shape);
        } catch (CargoSafetyException e) {
            System.out.println("Safety Error: " + e.getMessage());
        } finally {
            lastLog = "Cargo assignment validation complete.";
            System.out.println(lastLog);
        }
    }

    public static void main(String[] args) {
        assignCargo("Cylindrical", "Petroleum");
        assignCargo("Rectangular", "Petroleum");
    }
}

class TrainAppUC15Test {

    @Test
    public void testCargo_SafeAssignment() {
        TrainAppUC15.assignCargo("Cylindrical", "Petroleum");
        assertEquals("Petroleum", TrainAppUC15.assignedCargo);
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        try {
            TrainAppUC15.assignCargo("Rectangular", "Petroleum");
        } catch (Exception e) {
            fail("Exception should be handled inside assignCargo");
        }
    }

    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        TrainAppUC15.assignCargo("Rectangular", "Petroleum");
        assertNull(TrainAppUC15.assignedCargo);
    }

    @Test
    public void testCargo_ProgramContinuesAfterException() {
        TrainAppUC15.assignCargo("Rectangular", "Petroleum");
        TrainAppUC15.assignCargo("Cylindrical", "Petroleum");
        assertEquals("Petroleum", TrainAppUC15.assignedCargo);
    }

    @Test
    public void testCargo_FinallyBlockExecution() {
        TrainAppUC15.assignCargo("Rectangular", "Petroleum");
        assertEquals("Cargo assignment validation complete.", TrainAppUC15.lastLog);
    }
}