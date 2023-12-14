import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Класс WeatherService предоставляет метод для получения данных о погоде из внешнего API.
 */
public class WeatherService {
    private static final String API_KEY = "a5dbeb0f950abb78931640c4f44a0f70";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    /**
     * Метод getWeatherData осуществляет запрос к OpenWeatherMap API и возвращает данные о погоде.
     *
     * @param city Название города, для которого запрашиваются данные о погоде.
     * @return Объект WeatherData с информацией о погоде.
     */
    public WeatherData getWeatherData(String city) {
        try {
            // Формирование URL с запросом к OpenWeatherMap API
            String apiUrl = String.format(API_URL, city, API_KEY);
            URL url = new URL(apiUrl);

            // Открытие соединения
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Получение ответа от сервера
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Чтение данных из ответа
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Парсинг JSON и создание объекта WeatherData
                WeatherParser weatherParser = new WeatherParser();
                return weatherParser.parseWeatherData(response.toString());
            } else {
                System.err.println("Ошибка при получении данных. Код ответа: " + responseCode);
            }

        } catch (Exception e) {
            System.err.println("Произошла ошибка при запросе данных о погоде: " + e.getMessage());
        }

        // В случае ошибки возвращаем пустой объект WeatherData
        return null;
    }
}
