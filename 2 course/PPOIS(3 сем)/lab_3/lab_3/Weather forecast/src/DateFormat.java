import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    private static final String DATE_FORMAT_PATTERN = "dd.MM.yyyy HH:mm:ss";

    /**
     * Форматирует объект Date в удобночитаемую строку даты и времени.
     *
     * @param date Объект Date, который нужно отформатировать.
     * @return Строка с отформатированной датой и временем в указанном шаблоне.
     */
    public String formatToReadableDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        return dateFormat.format(date);
    }
}

