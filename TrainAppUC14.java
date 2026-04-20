import org.junit.Test;
import static org.junit.Assert.*;

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) { super(message); }
}

class PassengerBogieUC14 {
    String type;
    int capacity;
    PassengerBogieUC14(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0)
            throw new InvalidCapacityException("Capacity must be greater than zero");
        this.type     = type;
        this.capacity = capacity;
    }
}

public class TrainAppUC14 {
    public static void main(String[] args) {
        try {
            PassengerBogieUC14 b1 = new PassengerBogieUC14("Sleeper", 72);
            System.out.println("Created: " + b1.type + " | Capacity: " + b1.capacity);

            PassengerBogieUC14 b2 = new PassengerBogieUC14("AC Chair", -5);
            System.out.println("Created: " + b2.type);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class TrainAppUC14Test {

    @Test
    public void testException_ValidCapacityCreation() throws InvalidCapacityException {
        assertNotNull(new PassengerBogieUC14("Sleeper", 72));
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_NegativeCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogieUC14("Sleeper", -10);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_ZeroCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogieUC14("Sleeper", 0);
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        try {
            new PassengerBogieUC14("Sleeper", -5);
            fail("Expected InvalidCapacityException");
        } catch (InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogieUC14 b = new PassengerBogieUC14("First Class", 24);
        assertEquals("First Class", b.type);
        assertEquals(24, b.capacity);
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        assertNotNull(new PassengerBogieUC14("Sleeper",     72));
        assertNotNull(new PassengerBogieUC14("AC Chair",    56));
        assertNotNull(new PassengerBogieUC14("First Class", 24));
    }
}