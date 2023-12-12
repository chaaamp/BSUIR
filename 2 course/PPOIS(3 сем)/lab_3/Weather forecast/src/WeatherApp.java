/**
 * Класс WeatherApp представляет приложение для отображения погоды.
 */
public class WeatherApp {
    private UserInput userInputHandler;
    private WeatherService weatherService;
    private WeatherDisplay weatherDisplay;
    private DateFormat dateFormat;
    private ExceptionHandler exceptionHandler;
    /**
     * Конструктор класса WeatherApp.
     * Инициализирует объекты, необходимые для работы приложения.
     *
     * @param userInputHandler Обработчик ввода пользователя.
     * @param weatherService   Сервис получения данных о погоде.
     * @param weatherDisplay   Отображение данных о погоде.
     * @param dateFormat       Форматирование даты.
     * @param exceptionHandler Обработчик исключений.
     */
    public WeatherApp(
            UserInput userInputHandler,
            WeatherService weatherService,
            WeatherDisplay weatherDisplay,
            DateFormat dateFormat,
            ExceptionHandler exceptionHandler
    ) {
        this.userInputHandler = userInputHandler;
        this.weatherService = weatherService;
        this.weatherDisplay = weatherDisplay;
        this.dateFormat = dateFormat;
        this.exceptionHandler = exceptionHandler;
    }
    /**
     * Метод run запускает приложение для отображения данных о погоде.
     * Пользователю предлагается ввести название города, после чего отображаются соответствующие данные о погоде.
     * В случае ошибок выводится сообщение об ошибке.
     */
    public void run() {
        try {
            String city = userInputHandler.getUserCityInput();
            WeatherData weatherData = weatherService.getWeatherData(city);

            if (weatherData != null) {
                weatherDisplay.displayWeather(weatherData);
                System.out.println("Получено " + dateFormat.formatToReadableDate(weatherData.getDate()));
            } else {
                System.out.println("Не удалось получить данные о погоде.");
            }

        } catch (Exception e) {
            exceptionHandler.handleException(e);
        }
    }
}
