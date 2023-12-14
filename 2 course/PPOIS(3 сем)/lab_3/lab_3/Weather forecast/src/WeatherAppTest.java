import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс WeatherAppTest содержит юнит-тесты для проверки функциональности приложения WeatherApp.
 */
public class WeatherAppTest {

    @Test
    void testWeatherServiceWithValidCity() {
        // Создание объекта WeatherService
        WeatherService weatherService = new WeatherService();

        // Запрос данных о погоде для города "London"
        WeatherData weatherData = weatherService.getWeatherData("London");

        // Проверка, что получены корректные данные
        assertNotNull(weatherData);
        assertNotNull(weatherData.getCity());
        assertNotNull(weatherData.getConditions());
        assertNotNull(weatherData.getDate());
        assertNotNull(weatherData.getTemperature());
    }

    @Test
    void testWeatherServiceWithInvalidCity() {
        // Создание объекта WeatherService
        WeatherService weatherService = new WeatherService();

        // Запрос данных о погоде для некорректного города
        WeatherData weatherData = weatherService.getWeatherData("InvalidCityName");

        // Проверка, что возвращается null при ошибке
        assertNull(weatherData);
    }

    @Test
    void testWeatherParserWithValidData() {
        // Создание объекта WeatherParser
        WeatherParser weatherParser = new WeatherParser();

        // JSON-данные с корректной информацией о погоде
        String jsonData = "{\"name\":\"TestCity\",\"main\":{\"temp\":273},\"weather\":[{\"description\":\"Clear Sky\"}]}";

        // Парсинг данных и создание объекта WeatherData
        WeatherData weatherData = weatherParser.parseWeatherData(jsonData);

        // Проверка, что получены корректные данные
        assertNotNull(weatherData);
        assertEquals("TestCity", weatherData.getCity());
        assertEquals(-0.14, weatherData.getTemperature(), 0.01);
        assertEquals("Clear Sky", weatherData.getConditions());
        assertNotNull(weatherData.getDate());
    }

    @Test
    void testWeatherParserWithInvalidData() {
        // Создание объекта WeatherParser
        WeatherParser weatherParser = new WeatherParser();

        // Некорректные JSON-данные
        String jsonData = "Invalid JSON Data";

        // Парсинг данных с ошибкой
        WeatherData weatherData = weatherParser.parseWeatherData(jsonData);

        // Проверка, что возвращается null при ошибке
        assertNull(weatherData);
    }

    @Test
    void testUserInput() {
        // Подготовка данных для ввода пользователя
        String input = "TestCity\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // Создание объекта UserInput
        UserInput userInput = new UserInput();

        // Тестирование метода getUserCityInput
        String userCity = userInput.getUserCityInput();

        // Восстановление стандартного потока ввода
        System.setIn(System.in);

        // Проверка, что введенные данные соответствуют ожидаемым
        assertEquals("TestCity", userCity.trim());
    }

    @Test
    void testWeatherForecast() {
        // Создание объектов WeatherData
        WeatherData weatherData1 = new WeatherData("City1", 25.0, "Clear Sky", new Date());
        WeatherData weatherData2 = new WeatherData("City2", 30.0, "Partly Cloudy", new Date());

        // Создание объекта WeatherForecast
        WeatherForecast weatherForecast = new WeatherForecast();

        // Добавление WeatherData в прогноз
        weatherForecast.addWeatherData(weatherData1);
        weatherForecast.addWeatherData(weatherData2);

        // Получение ежедневного прогноза
        List<WeatherData> dailyForecast = weatherForecast.getDailyForecast();

        // Проверка, что прогноз содержит ожидаемые объекты WeatherData
        assertNotNull(dailyForecast);
        assertEquals(2, dailyForecast.size());
        assertEquals(weatherData1, dailyForecast.get(0));
        assertEquals(weatherData2, dailyForecast.get(1));
    }

    @Test
    void weatherDataConstructorShouldSetValuesCorrectly() {
        // Подготовка данных для создания объекта WeatherData
        String city = "Moscow";
        double temperature = 20.5;
        String conditions = "clear sky";
        Date date = new Date();

        // Создание объекта WeatherData
        WeatherData weatherData = new WeatherData(city, temperature, conditions, date);

        // Проверка, что значения установлены корректно
        assertEquals(city, weatherData.getCity());
        assertEquals(temperature, weatherData.getTemperature());
        assertEquals(conditions, weatherData.getConditions());
        assertEquals(date, weatherData.getDate());
    }

    @Test
    void settersShouldModifyFieldsCorrectly() {
        // Создание объекта WeatherData
        WeatherData weatherData = new WeatherData("City", 25.0, "sunny", new Date());

        // Изменение значений с использованием сеттеров
        weatherData.setCity("NewCity");
        weatherData.setTemperature(30.0);
        weatherData.setConditions("cloudy");

        // Проверка, что значения были изменены корректно
        assertEquals("NewCity", weatherData.getCity());
        assertEquals(30.0, weatherData.getTemperature());
        assertEquals("cloudy", weatherData.getConditions());
    }

    @Test
    void settersAndGettersShouldHandleNullValues() {
        // Создание объекта WeatherData с null значениями
        WeatherData weatherData = new WeatherData(null, 0.0, null, null);

        // Проверка, что геттеры возвращают корректные значения по умолчанию
        assertNull(weatherData.getCity());
        assertEquals(0.0, weatherData.getTemperature());
        assertNull(weatherData.getConditions());
        assertNull(weatherData.getDate());

        // Установка новых значений с использованием сеттеров
        weatherData.setCity("City");
        weatherData.setTemperature(25.0);
        weatherData.setConditions("sunny");
        weatherData.setDate(new Date());

        // Проверка, что геттеры возвращают обновленные значения
        assertEquals("City", weatherData.getCity());
        assertEquals(25.0, weatherData.getTemperature());
        assertEquals("sunny", weatherData.getConditions());
        assertNotNull(weatherData.getDate());
    }
}
