class Ride {
    Location startLocation;
    Location endLocation;
    double cost;
    String dateAndTime;

    public Ride(Location startLocation, Location endLocation, double cost, String dateAndTime) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.cost = cost;
        this.dateAndTime = dateAndTime;
    }
    //Получает стоимость поездки
    public double getCost() {
        return cost;
    }
}