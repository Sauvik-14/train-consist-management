import java.util.regex.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrainAppUC11 {

    public static boolean validateTrainID(String id) {
        return Pattern.compile("TRN-\\d{4}").matcher(id).matches();
    }

    public static boolean validateCargoCode(String code) {
        return Pattern.compile("PET-[A-Z]{2}").matcher(code).matches();
    }

    public static void main(String[] args) {
        System.out.println("Train ID Valid:   " + validateTrainID("TRN-1234"));
        System.out.println("Cargo Code Valid: " + validateCargoCode("PET-AB"));
        System.out.println("Train ID Valid:   " + validateTrainID("TRAIN12"));
        System.out.println("Cargo Code Valid: " + validateCargoCode("PET-ab"));
    }
}

class TrainAppUC11Test {

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(TrainAppUC11.validateTrainID("TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainAppUC11.validateTrainID("TRAIN12"));
        assertFalse(TrainAppUC11.validateTrainID("TRN12A"));
        assertFalse(TrainAppUC11.validateTrainID("1234-TRN"));
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(TrainAppUC11.validateCargoCode("PET-AB"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainAppUC11.validateCargoCode("PET-ab"));
        assertFalse(TrainAppUC11.validateCargoCode("PET123"));
        assertFalse(TrainAppUC11.validateCargoCode("AB-PET"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainAppUC11.validateTrainID("TRN-123"));
        assertFalse(TrainAppUC11.validateTrainID("TRN-12345"));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainAppUC11.validateCargoCode("PET-ab"));
        assertFalse(TrainAppUC11.validateCargoCode("PET-Ab"));
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(TrainAppUC11.validateTrainID(""));
        assertFalse(TrainAppUC11.validateCargoCode(""));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(TrainAppUC11.validateTrainID("TRN-1234X"));
        assertFalse(TrainAppUC11.validateCargoCode("PET-ABC"));
    }
}