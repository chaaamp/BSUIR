// Класс Booking представляет информацию о заказе в системе такси.
class Booking {
    //Поля, хранящие информацию о заказе
    RideRequest rideRequest;
    Driver assignedDriver;
    Ride ride;
    Payment payment;
    /*Конструктор для создания объекта Booking с заданными параметрами
     * Запрос на поездку
     * Назначенный водитель
     * Информация о поездке
     * Информация об оплате*/
    public Booking(RideRequest rideRequest, Driver assignedDriver, Ride ride, Payment payment) {
        this.rideRequest = rideRequest;
        this.assignedDriver = assignedDriver;
        this.ride = ride;
        this.payment = payment;
    }
    /*
     * Получает объект RideRequest, связанный с заказом.
     * возвращает запрос на поездку.
     */
    public RideRequest getRideRequest() {
        return rideRequest;
    }
    //как и в RideRequest
    public Driver getAssignedDriver() {
        return assignedDriver;
    }
    //как и в RideRequest
    public Ride getRide() {
        return ride;
    }
    //как и в RideRequest
    public Payment getPayment() {
        return payment;
    }
}
