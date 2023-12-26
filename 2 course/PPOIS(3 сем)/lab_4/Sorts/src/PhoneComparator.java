import java.util.Comparator;

public class PhoneComparator implements Comparator<Phone> {
    @Override
    public int compare(Phone phone1, Phone phone2) {
        // Проверяем на null
        if (phone1 == null && phone2 == null) {
            return 0; // объекты равны
        } else if (phone1 == null) {
            return -1; // null меньше, чем любой объект
        } else if (phone2 == null) {
            return 1; // любой объект больше, чем null
        }

        // Сравниваем по модели
        return phone1.getModel().compareTo(phone2.getModel());
    }
}