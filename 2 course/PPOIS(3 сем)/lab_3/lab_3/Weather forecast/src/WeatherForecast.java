import java.util.ArrayList;
import java.util.List;
/**
 * Класс WeatherForecast представляет прогноз погоды на несколько дней.
 */
public class WeatherForecast {
    private List<WeatherData> dailyForecast;
    /**
     * Конструктор класса WeatherForecast.
     * Инициализирует список для хранения ежедневного прогноза.
     */
    public WeatherForecast() {
        this.dailyForecast = new ArrayList<>();
    }
    /**
     * Метод getDailyForecast возвращает список с данными о погоде на несколько дней.
     *
     * @return Список с данными о погоде.
     */
    public List<WeatherData> getDailyForecast() {
        return dailyForecast;
    }
    /**
     * Метод addWeatherData добавляет данные о погоде в ежедневный прогноз.
     *
     * @param weatherData Данные о погоде для добавления.
     */
    public void addWeatherData(WeatherData weatherData) {
        dailyForecast.add(weatherData);
    }

}
