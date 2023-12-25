import java.util.List;

public class CocktailSort {

    // Cocktail Sort для массивов
    public static <T extends Comparable<T>> void cocktailSort(T[] array) {
        boolean swapped = true;
        int start = 0;
        int end = array.length;

        // Продолжаем сортировку, пока есть обмены элементов
        while (swapped) {
            swapped = false;

            // Проходим по массиву слева направо
            for (int i = start; i < end - 1; ++i) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    // Обмен элементов
                    T temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            // Если обменов не произошло, массив отсортирован
            if (!swapped)
                break;

            // Обновляем конечный индекс
            end--;

            // Проходим по массиву справа налево
            for (int i = end - 1; i >= start; --i) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    // Обмен элементов
                    T temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            // Обновляем начальный индекс
            start++;
        }
    }

    // Cocktail Sort для списков
    public static <T extends Comparable<T>> List<T> cocktailSort(List<T> list) {
        // Преобразуем список в массив для сортировки
        T[] array = list.toArray((T[]) new Comparable[list.size()]);
        cocktailSort(array);

        // Копируем отсортированный массив обратно в список
        for (int i = 0; i < list.size(); i++) {
            list.set(i, array[i]);
        }

        return list;
    }
}