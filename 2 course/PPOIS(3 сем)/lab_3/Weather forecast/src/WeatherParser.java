import org.json.JSONObject;
import java.util.Date;

/**
 * Класс WeatherParser отвечает за парсинг данных о погоде из JSON-формата.
 */
public class WeatherParser {

    /**
     * Метод parseWeatherData выполняет парсинг данных о погоде из JSON-строки.
     *
     * @param jsonData JSON-строка с данными о погоде.
     * @return Объект WeatherData, содержащий распарсированные данные о погоде.
     */
    public WeatherData parseWeatherData(String jsonData) {
        try {
            // Создание объекта JSON на основе строки
            JSONObject json = new JSONObject(jsonData);

            // Извлечение данных из JSON
            String city = json.getString("name");
            double temperatureKelvin = json.getJSONObject("main").getDouble("temp");
            double temperatureCelsius = temperatureKelvin - 273; // Перевод температуры в градусы Цельсия
            String conditions = json.getJSONArray("weather").getJSONObject(0).getString("description");

            // Получение текущей даты
            Date date = new Date();

            // Создание объекта WeatherData с распарсированными данными
            WeatherData weatherData = new WeatherData(city, temperatureCelsius, conditions, date);

            return weatherData;
        } catch (Exception e) {
            // В случае ошибки выводим стек вызовов и возвращаем null
            e.printStackTrace();
            return null;
        }
    }
}


