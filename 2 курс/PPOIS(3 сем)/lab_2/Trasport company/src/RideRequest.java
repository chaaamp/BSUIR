// RideRequest class
class RideRequest {
    User user;
    Location startLocation;
    Location endLocation;
    /*
     * Конструктор для создания объекта RideRequest с заданными параметрами.
     * Пользователь, отправивший запрос.
     * Начальное местоположение поездки.
     * Конечное местоположение поездки.
     */
    public RideRequest(User user, Location startLocation, Location endLocation) {
        this.user = user;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public User getUser() {
        return user;//Пользователь, отправивший запрос.
    }
}
