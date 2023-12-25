import java.util.ArrayList;
import java.util.List;

public class StrandSort {

    // Strand Sort для списков
    public static <T extends Comparable<T>> List<T> strandSort(List<T> list) {
        // Создаем список цепочек, в каждой цепочке будут элементы с определенным порядком
        List<List<T>> strands = new ArrayList<>();

        // Проходим по исходному списку
        for (T current : list) {
            boolean placed = false;

            // Проходим по существующим цепочкам
            for (List<T> strand : strands) {
                T lastElement = strand.get(strand.size() - 1);

                // Если текущий элемент больше или равен последнему элементу в цепочке
                if (current.compareTo(lastElement) >= 0) {
                    strand.add(current);
                    placed = true;
                    break;
                }
            }

            // Если текущий элемент не может быть размещен в существующей цепочке, создаем новую цепочку
            if (!placed) {
                strands.add(new ArrayList<>(List.of(current)));
            }
        }

        // Объединяем цепочки до тех пор, пока не останется только одна цепочка
        while (strands.size() > 1) {
            List<T> mergedStrand = mergeTwoStrands(strands.remove(0), strands.remove(0));
            strands.add(mergedStrand);
        }

        return strands.get(0);  // Возвращаем упорядоченный список
    }

    // Вспомогательный метод для объединения двух цепочек
    private static <T extends Comparable<T>> List<T> mergeTwoStrands(List<T> strand1, List<T> strand2) {
        List<T> mergedStrand = new ArrayList<>();
        int i = 0, j = 0;

        // Объединяем две упорядоченные цепочки
        while (i < strand1.size() && j < strand2.size()) {
            if (strand1.get(i).compareTo(strand2.get(j)) < 0) {
                mergedStrand.add(strand1.get(i));
                i++;
            } else {
                mergedStrand.add(strand2.get(j));
                j++;
            }
        }

        // Добавляем оставшиеся элементы
        while (i < strand1.size()) {
            mergedStrand.add(strand1.get(i));
            i++;
        }
        while (j < strand2.size()) {
            mergedStrand.add(strand2.get(j));
            j++;
        }

        return mergedStrand;  // Возвращаем объединенную цепочку
    }
}
