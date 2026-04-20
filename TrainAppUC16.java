import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrainAppUC16 {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - 1 - i; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp   = arr[j];
                    arr[j]     = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void main(String[] args) {
        int[] capacities = {72, 56, 24, 70, 60};
        bubbleSort(capacities);
        System.out.println("Sorted Capacities: " + Arrays.toString(capacities));
    }
}

class TrainAppUC16Test {

    @Test
    public void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 60};
        TrainAppUC16.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    @Test
    public void testSort_AlreadySortedArray() {
        int[] arr = {24, 56, 60, 70, 72};
        TrainAppUC16.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    @Test
    public void testSort_DuplicateValues() {
        int[] arr = {72, 56, 56, 24};
        TrainAppUC16.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 56, 72}, arr);
    }

    @Test
    public void testSort_SingleElementArray() {
        int[] arr = {50};
        TrainAppUC16.bubbleSort(arr);
        assertArrayEquals(new int[]{50}, arr);
    }

    @Test
    public void testSort_AllEqualValues() {
        int[] arr = {40, 40, 40};
        TrainAppUC16.bubbleSort(arr);
        assertArrayEquals(new int[]{40, 40, 40}, arr);
    }
}