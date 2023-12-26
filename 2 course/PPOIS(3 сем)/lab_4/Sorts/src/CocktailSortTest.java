import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class CocktailSortTest {

    @Test
    public void testStrandSortForPhoneArray() {
        // Создаем тестовые объекты Phone
        Phone phone1 = new Phone("Apple", "Iphone", 2020);
        Phone phone2 = new Phone("Xiaomi", "Mate", 2021);
        Phone phone3 = new Phone("Samsung", "Lite", 2019);

        Phone[] inputArray = {phone1, phone2, phone3};
        Phone[] expectedArray = {phone1, phone3, phone2}; // Ожидаемый порядок сортировки по модели

        // Копируем массив для сохранения оригинальных данных
        Phone[] originalArray = Arrays.copyOf(inputArray, inputArray.length);

        // Создаем PhoneComparator
        Comparator<Phone> phoneComparator = new PhoneComparator();

        // Вызываем метод strandSort для списка и сохраняем результат в новом массиве
        Phone[] sortedArray = StrandSort.strandSort(Arrays.asList(originalArray), phoneComparator)
                .toArray(new Phone[0]);

        // Проверяем, что оригинальный массив не изменился
        assertArrayEquals(originalArray, inputArray);

        // Проверяем, что отсортированный массив соответствует ожидаемому результату
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test
    public void testStrandSortForPhoneList() {
        Phone phone1 = new Phone("Apple", "Iphone", 2020);
        Phone phone2 = new Phone("Xiaomi", "Mate", 2021);
        Phone phone3 = new Phone("Samsung", "Lite", 2019);

        List<Phone> inputList = Arrays.asList(phone1, phone2, phone3);
        List<Phone> expectedList = Arrays.asList(phone1, phone3, phone2);

        Comparator<Phone> phoneComparator = new PhoneComparator();

        List<Phone> sortedList = StrandSort.strandSort(inputList, phoneComparator);

        assertArrayEquals(expectedList.toArray(), sortedList.toArray());
    }

    @Test
    public void testCocktailSortForPhoneList() {
        Phone phone1 = new Phone("Apple", "Iphone", 2020);
        Phone phone2 = new Phone("Xiaomi", "Mate", 2021);
        Phone phone3 = new Phone("Samsung", "Lite", 2019);

        List<Phone> inputList = Arrays.asList(phone1, phone2, phone3);
        List<Phone> expectedList = Arrays.asList(phone1, phone3, phone2);

        Comparator<Phone> phoneComparator = new PhoneComparator();

        List<Phone> sortedList = CocktailSort.cocktailSort(inputList, phoneComparator);

        assertArrayEquals(expectedList.toArray(), sortedList.toArray());
    }

    @Test
    public void testCocktailSortForPhoneArray() {
        Phone phone1 = new Phone("Apple", "Iphone", 2020);
        Phone phone2 = new Phone("Xiaomi", "Mate", 2021);
        Phone phone3 = new Phone("Samsung", "Lite", 2019);
        Phone[] inputArray = {phone1, phone2, phone3};
        Phone[] expectedArray = {phone1, phone3, phone2};

        Comparator<Phone> phoneComparator = new PhoneComparator();

        CocktailSort.cocktailSort(inputArray, phoneComparator);

        assertArrayEquals(expectedArray, inputArray);
    }
    @Test
    public void testCocktailSortForIntegerArray() {
        Integer[] inputArray = {4, 2, 7, 1, 5, 3};
        Integer[] expectedArray = {1, 2, 3, 4, 5, 7};

        CocktailSort.cocktailSort(inputArray);

        assertArrayEquals(expectedArray, inputArray);
    }
    @Test
    public void testStrandSortWithIntegers() {
        Integer[] unsortedArray = {5, 3, 8, 2, 1, 4};
        Integer[] expectedSortedArray = {1, 2, 3, 4, 5, 8};

        List<Integer> sortedList = StrandSort.strandSort(Arrays.asList(unsortedArray));

        assertEquals(Arrays.asList(expectedSortedArray), sortedList);
    }
    @Test
    public void testStrandSortWithPhones() {
        Phone phone1 = new Phone("Apple", "Iphone", 2020);
        Phone phone2 = new Phone("Xiaomi", "Mate", 2021);
        Phone phone3 = new Phone("Samsung", "Lite", 2019);
        Phone[] unsortedArray = {phone2, phone1, phone3};
        Phone[] expectedSortedArray = {phone1, phone3, phone2};

        Comparator<Phone> phoneComparator = new PhoneComparator();

        StrandSort.strandSort(unsortedArray, phoneComparator);

        assertArrayEquals(expectedSortedArray, unsortedArray);
    }
    @Test
    void testStrandSortWithInt() {
        Integer[] inputArray = {4, 2, 7, 1, 5, 3};
        Integer[] expectedArray = {1, 2, 3, 4, 5, 7};

        StrandSort.strandSort(inputArray);

        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void testCocktailSortWithPhones() {
        Phone phone1 = new Phone("ModelA", "BrandA", 2020);
        Phone phone2 = new Phone("ModelC", "BrandB", 2021);
        Phone phone3 = new Phone("ModelB", "BrandC", 2019);

        List<Phone> unsortedList = new ArrayList<>(Arrays.asList(phone2, phone1, phone3));
        List<Phone> expectedSorted = Arrays.asList(phone1, phone3, phone2);

        Comparator<Phone> phoneComparator = new PhoneComparator();

        CocktailSort.cocktailSort(unsortedList, phoneComparator);

        assertEquals(expectedSorted, unsortedList);

        // Проверим, что элементы в списке действительно упорядочены
        for (int i = 0; i < unsortedList.size() - 1; i++) {
            Phone current = unsortedList.get(i);
            Phone next = unsortedList.get(i + 1);
            assertTrue(phoneComparator.compare(current, next) <= 0);
        }
    }
}