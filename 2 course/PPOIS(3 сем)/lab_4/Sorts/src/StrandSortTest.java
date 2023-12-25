import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrandSortTest {

    @Test
    void testStrandSortWithIntegers() {
        List<Integer> unsortedList = Arrays.asList(5, 3, 8, 2, 1, 4);
        List<Integer> expectedSorted = Arrays.asList(1, 2, 3, 4, 5, 8);

        List<Integer> sortedList = StrandSort.strandSort(new ArrayList<>(unsortedList));

        assertEquals(expectedSorted, sortedList);
    }

    @Test
    void testStrandSortWithStrings() {
        List<String> unsortedList = Arrays.asList("banana", "apple", "orange", "kiwi");
        List<String> expectedSorted = Arrays.asList("apple", "banana", "kiwi", "orange");

        List<String> sortedList = StrandSort.strandSort(new ArrayList<>(unsortedList));

        assertEquals(expectedSorted, sortedList);
    }

    @Test
    void testStrandSortWithDuplicates() {
        List<Integer> unsortedList = Arrays.asList(5, 3, 8, 2, 1, 4, 5, 3, 8, 2, 1, 4);
        List<Integer> expectedSorted = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5 , 8, 8);

        List<Integer> sortedList = StrandSort.strandSort(new ArrayList<>(unsortedList));

        assertEquals(expectedSorted, sortedList);
    }

    @Test
    void testStrandSortWithNegativeNumbers() {
        List<Integer> unsortedList = Arrays.asList(-5, -3, -8, -2, -1, -4);
        List<Integer> expectedSorted = Arrays.asList(-8, -5, -4, -3, -2, -1);

        List<Integer> sortedList = StrandSort.strandSort(new ArrayList<>(unsortedList));

        assertEquals(expectedSorted, sortedList);
    }
}
