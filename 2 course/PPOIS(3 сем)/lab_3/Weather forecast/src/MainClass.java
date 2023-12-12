public class MainClass {
    public static void main(String[] args) {
        UserInput userInputHandler = new UserInput();
        WeatherService weatherService = new WeatherService();
        WeatherDisplay weatherDisplay = new WeatherDisplay();
        DateFormat dateFormat = new DateFormat();
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        WeatherApp weatherApp = new WeatherApp(userInputHandler, weatherService, weatherDisplay, dateFormat, exceptionHandler);
        weatherApp.run();
    }
}