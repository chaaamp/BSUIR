import java.util.ArrayList;
import java.util.List;

class TaxiAggregator {
    private List<Driver> availableDrivers;
    private List<Booking> bookings;

    public TaxiAggregator() {
        this.availableDrivers = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    // Регистрация нового водителя в системе
    public void registerDriver(Driver driver) {
        availableDrivers.add(driver);
    }

    // Поиск доступного водителя для заказа
    public Driver findAvailableDriver(Location userLocation) {
        for (Driver driver : availableDrivers) {
            if (driver.isAvailable) {
                // Просто для примера: простейшая логика поиска ближайшего водителя
                double distance = calculateDistance(driverLocation, userLocation);
                if (distance < MAX_DISTANCE) {
                    return driver;
                }
            }
        }
        return null; // Нет доступных водителей
    }

    // Создание нового заказа
    public Booking createBooking(User user, Location startLocation, Location endLocation) {
        // Поиск доступного водителя
        Driver availableDriver = findAvailableDriver(startLocation);

        if (availableDriver != null) {
            // Создание заказа
            RideRequest rideRequest = new RideRequest(user, startLocation, endLocation);
            Ride ride = new Ride(startLocation, endLocation, calculateRideCost(startLocation, endLocation), getCurrentDateTime());
            Payment payment = new Payment("Credit Card", ride.getCost());

            // Обновление статуса водителя
            availableDriver.isAvailable = false;

            // Создание бронирования
            Booking booking = new Booking(rideRequest, availableDriver, ride, payment);

            // Добавление заказа в список бронирований
            bookings.add(booking);

            return booking;
        } else {
            return null; // Нет доступных водителей
        }
    }

    // Завершение поездки и освобождение водителя
    public void completeRide(Booking booking) {
        booking.getAssignedDriver().isAvailable = true;
        booking.getPayment().setPaid(true);
    }

    // Пример метода для расчета расстояния между двумя местоположениями
    private double calculateDistance(Location location1, Location location2) {
        // Реализация расчета расстояния (может потребоваться использование сторонней библиотеки)
        return 0.0;
    }

    // Пример метода для расчета стоимости поездки
    private double calculateRideCost(Location startLocation, Location endLocation) {
        // Реализация расчета стоимости (может зависеть от различных факторов)
        return 20.0; // Пример стоимости
    }

    // Пример метода для получения текущей даты и времени
    private String getCurrentDateTime() {
        // Реализация получения текущей даты и времени
        return "2023-11-20 12:00:00"; // Пример
    }
}
