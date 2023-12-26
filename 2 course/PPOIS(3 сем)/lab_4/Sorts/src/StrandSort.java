import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StrandSort {

    // Strand Sort для списков
    public static <T extends Comparable<T>> List<T> strandSort(List<T> list) {
        // Инициализация списка цепочек
        List<List<T>> strands = new ArrayList<>();

        // Проходим по элементам входного списка
        for (T current : list) {
            boolean placed = false;

            // Проходим по существующим цепочкам
            for (List<T> strand : strands) {
                T lastElement = strand.get(strand.size() - 1);

                // Если текущий элемент больше или равен последнему элементу цепочки, добавляем его в цепочку
                if (current.compareTo(lastElement) >= 0) {
                    strand.add(current);
                    placed = true;
                    break;
                }
            }

            // Если не удалось разместить элемент в существующих цепочках, создаем новую цепочку
            if (!placed) {
                strands.add(new ArrayList<>(List.of(current)));
            }
        }

        // Объединяем цепочки, пока не останется одна
        while (strands.size() > 1) {
            List<T> mergedStrand = mergeTwoStrands(strands.remove(0), strands.remove(0));
            strands.add(mergedStrand);
        }

        // Возвращаем упорядоченную цепочку (результат сортировки)
        return strands.get(0);
    }

    // Вспомогательный метод для объединения двух цепочек (для списков)
    private static <T extends Comparable<T>> List<T> mergeTwoStrands(List<T> strand1, List<T> strand2) {
        List<T> mergedStrand = new ArrayList<>();
        int i = 0, j = 0;

        // Объединяем две цепочки, упорядочивая элементы
        while (i < strand1.size() && j < strand2.size()) {
            if (strand1.get(i).compareTo(strand2.get(j)) < 0) {
                mergedStrand.add(strand1.get(i));
                i++;
            } else {
                mergedStrand.add(strand2.get(j));
                j++;
            }
        }

        // Добавляем оставшиеся элементы первой цепочки (если есть)
        while (i < strand1.size()) {
            mergedStrand.add(strand1.get(i));
            i++;
        }

        // Добавляем оставшиеся элементы второй цепочки (если есть)
        while (j < strand2.size()) {
            mergedStrand.add(strand2.get(j));
            j++;
        }

        // Возвращаем объединенную цепочку
        return mergedStrand;
    }

    // Strand Sort для массивов
    public static <T extends Comparable<T>> void strandSort(T[] array) {
        // Инициализация списка цепочек
        List<List<T>> strands = new ArrayList<>();

        // Проходим по элементам массива
        for (T current : array) {
            boolean placed = false;

            // Проходим по существующим цепочкам
            for (List<T> strand : strands) {
                T lastElement = strand.get(strand.size() - 1);

                // Если текущий элемент больше или равен последнему элементу цепочки, добавляем его в цепочку
                if (current.compareTo(lastElement) >= 0) {
                    strand.add(current);
                    placed = true;
                    break;
                }
            }

            // Если не удалось разместить элемент в существующих цепочках, создаем новую цепочку
            if (!placed) {
                strands.add(new ArrayList<>(List.of(current)));
            }
        }

        // Объединяем цепочки, пока не останется одна
        while (strands.size() > 1) {
            List<T> mergedStrand = mergeTwoStrands(strands.remove(0), strands.remove(0));
            strands.add(mergedStrand);
        }

        // Копируем упорядоченные элементы обратно в массив
        List<T> finalStrand = strands.get(0);
        for (int i = 0; i < array.length; i++) {
            array[i] = finalStrand.get(i);
        }
    }

    // Strand Sort для массивов с использованием Comparator
    public static <T> void strandSort(T[] array, Comparator<T> comparator) {
        // Инициализация списка цепочек
        List<List<T>> strands = new ArrayList<>();

        // Проходим по элементам массива
        for (T current : array) {
            boolean placed = false;

            // Проходим по существующим цепочкам
            for (List<T> strand : strands) {
                T lastElement = strand.get(strand.size() - 1);

                // Если текущий элемент больше или равен последнему элементу цепочки, добавляем его в цепочку
                if (comparator.compare(current, lastElement) >= 0) {
                    strand.add(current);
                    placed = true;
                    break;
                }
            }

            // Если не удалось разместить элемент в существующих цепочках, создаем новую цепочку
            if (!placed) {
                strands.add(new ArrayList<>(List.of(current)));
            }
        }

        // Объединяем цепочки, пока не останется одна
        while (strands.size() > 1) {
            List<T> mergedStrand = mergeTwoStrands(strands.remove(0), strands.remove(0), comparator);
            strands.add(mergedStrand);
        }

        // Копируем упорядоченные элементы обратно в массив
        List<T> finalStrand = strands.get(0);
        for (int i = 0; i < array.length; i++) {
            array[i] = finalStrand.get(i);
        }
    }

    // Вспомогательный метод для объединения двух цепочек (для массивов с использованием Comparator)
    private static <T> List<T> mergeTwoStrands(List<T> strand1, List<T> strand2, Comparator<T> comparator) {
        List<T> mergedStrand = new ArrayList<>();
        int i = 0, j = 0;

        // Объединяем две цепочки, упорядочивая элементы с использованием Comparator
        while (i < strand1.size() && j < strand2.size()) {
            if (comparator.compare(strand1.get(i), strand2.get(j)) < 0) {
                mergedStrand.add(strand1.get(i));
                i++;
            } else {
                mergedStrand.add(strand2.get(j));
                j++;
            }
        }

        // Добавляем оставшиеся элементы первой цепочки (если есть)
        while (i < strand1.size()) {
            mergedStrand.add(strand1.get(i));
            i++;
        }

        // Добавляем оставшиеся элементы второй цепочки (если есть)
        while (j < strand2.size()) {
            mergedStrand.add(strand2.get(j));
            j++;
        }

        // Возвращаем объединенную цепочку
        return mergedStrand;
    }

    // Strand Sort для списков с использованием Comparator
    public static <T> List<T> strandSort(List<T> list, Comparator<T> comparator) {
        // Инициализация списка цепочек
        List<List<T>> strands = new ArrayList<>();

        // Проходим по элементам входного списка
        for (T current : list) {
            boolean placed = false;

            // Проходим по существующим цепочкам
            for (List<T> strand : strands) {
                T lastElement = strand.get(strand.size() - 1);

                // Если текущий элемент больше или равен последнему элементу цепочки, добавляем его в цепочку
                if (comparator.compare(current, lastElement) >= 0) {
                    strand.add(current);
                    placed = true;
                    break;
                }
            }

            // Если не удалось разместить элемент в существующих цепочках, создаем новую цепочку
            if (!placed) {
                strands.add(new ArrayList<>(List.of(current)));
            }
        }

        // Объединяем цепочки, пока не останется одна
        while (strands.size() > 1) {
            List<T> mergedStrand = mergeTwoStrands(strands.remove(0), strands.remove(0), comparator);
            strands.add(mergedStrand);
        }

        // Возвращаем упорядоченную цепочку (результат сортировки)
        return strands.get(0);
    }
}
