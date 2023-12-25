import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class CocktailSortTest {

    @Test
    public void testCocktailSort_IntegerArray() {
        // Arrange
        Integer[] array = {4, 2, 7, 1, 9, 5, 3};
        Integer[] expected = {1, 2, 3, 4, 5, 7, 9};

        // Act
        CocktailSort.cocktailSort(array);

        // Assert
        assertArrayEquals(expected, array);
    }
    @Test
    public void testCocktailSort_IntegerVector() {
        // Arrange
        List<Integer> vector = Arrays.asList(4, 2, 7, 1, 9, 5, 3);
        Integer[] expected = {1, 2, 3, 4, 5, 7, 9};

        // Act
        List<Integer> result = CocktailSort.cocktailSort(vector);

        // Assert
        assertArrayEquals(expected, result.toArray());
    }
    @Test
    public void testCocktailSort_StringArray() {
        // Arrange
        String[] array = {"apple", "orange", "banana", "grape"};
        String[] expected = {"apple", "banana", "grape", "orange"};

        // Act
        CocktailSort.cocktailSort(array);

        // Assert
        assertArrayEquals(expected, array);
    }

}
