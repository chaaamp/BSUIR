class RideRequest {
    User user;
    Location startLocation;
    Location endLocation;

    public RideRequest(User user, Location startLocation, Location endLocation) {
        this.user = user;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }
}
