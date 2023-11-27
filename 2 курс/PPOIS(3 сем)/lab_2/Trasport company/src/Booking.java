class Booking {
    RideRequest rideRequest;
    Driver assignedDriver;
    Ride ride;
    Payment payment;

    public Booking(RideRequest rideRequest, Driver assignedDriver, Ride ride, Payment payment) {
        this.rideRequest = rideRequest;
        this.assignedDriver = assignedDriver;
        this.ride = ride;
        this.payment = payment;
    }
}
