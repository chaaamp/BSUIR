/*
 * Класс ExceptionHandler предназначен для обработки и вывода информации о исключениях.
 */
public class ExceptionHandler {
    public void handleException(Exception e) {
        System.err.println("Произошла ошибка: " + e.getMessage());
        e.printStackTrace();  // Вывести стек вызовов для более детальной информации
    }
}
