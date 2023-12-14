import java.util.Scanner;
/**
 * Класс UserInput предоставляет функционал для ввода данных пользователя.
 */
public class UserInput {
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }
    /**
     * Запрашивает у пользователя ввод названия города.
     *
     * @return Строка с названием города, введенным пользователем.
     */
    public String getUserCityInput() {
        System.out.println("Введите название города:");
        return scanner.nextLine();
    }


}
