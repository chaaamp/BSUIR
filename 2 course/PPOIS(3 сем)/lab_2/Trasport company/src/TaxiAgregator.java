import java.util.ArrayList;
import java.util.List;

/*
 * Класс TaxiAggregator представляет собой агрегатор такси с основными функциональностями.
 */
class TaxiAggregator {
    // Список доступных водителей
    private List<Driver> availableDrivers;

    // Список забронированных поездок
    private List<Booking> bookings;

    /*
     * Конструктор для создания объекта TaxiAggregator с пустыми списками водителей и поездок.
     */
    public TaxiAggregator() {
        this.availableDrivers = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    /*
     * Метод для добавления нового водителя в список доступных.
       Водитель для добавления.
     */
    public void addDriver(Driver driver) {
        availableDrivers.add(driver);
    }

    /**
     * Метод для получения списка доступных водителей
     * Список доступных водителей.
     */
    public List<Driver> getAvailableDrivers() {
        return availableDrivers;
    }

    /*
     * Метод для поиска доступного водителя.
     * Первый доступный водитель или null, если нет доступных водителей.
     */
    public Driver findAvailableDriver() {
        for (Driver driver : availableDrivers) {
            if (driver.isAvailable) {
                return driver;
            }
        }
        return null;
    }

    /**
     * Метод для создания новой поездки
     * Пользователь, заказавший поездку.
     * Начальное местоположение поездки.
     * Конечное местоположение поездки.
     * Объект Booking, представляющий созданную поездку, или null, если нет доступных водителей.
     */
    public Booking createBooking(User user, Location startLocation, Location endLocation) {
        Driver driver = findAvailableDriver();
        if (driver != null) {
            RideRequest rideRequest = new RideRequest(user, startLocation, endLocation);
            Ride ride = new Ride(startLocation, endLocation, calculateCost(startLocation, endLocation), "Now");
            Payment payment = new Payment("Credit Card", ride.getCost());
            Booking booking = new Booking(rideRequest, driver, ride, payment);

            // Обновляем статус водителя
            driver.isAvailable = false;

            // Добавляем заказ в список
            bookings.add(booking);

            return booking;
        } else {
            System.out.println("Извините, в данный момент нет доступных водителей.");
            return null;
        }
    }

    /**
     * Метод для расчета стоимости поездки на основе расстояния.
     * <p>
     * Начальное местоположение поездки.
     * Конечное местоположение поездки.
     * Стоимость поездки.
     */
    protected double calculateCost(Location startLocation, Location endLocation) {
        // Пример: расчет стоимости на основе расстояния (просто для иллюстрации)
        double distance = calculateDistance(startLocation, endLocation);

        // Предположим, что стоимость составляет 0.5р за километр
        double costPerKilometer = 0.5;

        return distance * costPerKilometer;
    }

    /*
     * Метод для расчета расстояния между двумя точками.
     * Начальное местоположение.
     * Конечное местоположение.
     * Расстояние между точками.
     */
    protected double calculateDistance(Location startLocation, Location endLocation) {
        // Пример: расчет расстояния между двумя точками (просто для иллюстрации)
        // Здесь вы можете использовать различные алгоритмы для расчета реального расстояния

        // В данном случае, просто считаем Евклидово расстояние
        double deltaX = endLocation.latitude - startLocation.latitude;
        double deltaY = endLocation.longitude - startLocation.longitude;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /*
     * Метод для завершения поездки
     * Завершаемая поездка.
     */
    public void completeBooking(Booking booking) {
        // Завершаем заказ
        booking.getPayment().isPaid = true;
        booking.getAssignedDriver().isAvailable = true;
        System.out.println("Поездка завершена. Спасибо за использование нашего сервиса!");
    }

}
