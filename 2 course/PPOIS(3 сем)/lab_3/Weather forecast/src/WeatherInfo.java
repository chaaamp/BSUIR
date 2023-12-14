/*класс с наследованием для weatherdata*/
    import java.util.Date;

    public class WeatherInfo {
        protected String city;
        protected double temperature;
        protected String conditions;
        protected Date date;

        // Конструктор
        public WeatherInfo(String city, double temperature, String conditions, Date date) {
            this.city = city;
            this.temperature = temperature;
            this.conditions = conditions;
            this.date = date;
        }

        // Геттеры и сеттеры
        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public String getConditions() {
            return conditions;
        }

        public void setConditions(String conditions) {
            this.conditions = conditions;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

