public class WeatherDisplay {
    public void displayWeather(WeatherData weatherData) {
        System.out.println("Погода в городе " + weatherData.getCity() + ":");
        System.out.println("Температура: " + weatherData.getTemperature() + " °C");
        System.out.println("Условия: " + weatherData.getConditions());
        System.out.println("Дата получения данных: " + weatherData.getDate());
    }
}