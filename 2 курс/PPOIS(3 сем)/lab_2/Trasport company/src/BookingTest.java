import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    void testGetRideRequest() {
        User user = new User("Egor", "111-222-8888");
        Location startLocation = new Location(37.7749, -122.4194);
        Location endLocation = new Location(34.0522, -118.2437);
        RideRequest rideRequest = new RideRequest(user, startLocation, endLocation);

        Driver driver = new Driver("Alice", "111-222-3333");
        Ride ride = new Ride(startLocation, endLocation, 25.0, "Now");
        Payment payment = new Payment("Credit Card", 25.0);

        Booking booking = new Booking(rideRequest, driver, ride, payment);

        assertEquals(rideRequest, booking.getRideRequest());
    }

    @Test
    void testGetAssignedDriver() {
        User user = new User("Maksim", "123-456-7890");
        Location startLocation = new Location(37.7749, -122.4194);
        Location endLocation = new Location(34.0522, -118.2437);
        RideRequest rideRequest = new RideRequest(user, startLocation, endLocation);

        Driver driver = new Driver("Danik", "111-222-3333");
        Ride ride = new Ride(startLocation, endLocation, 25.0, "Now");
        Payment payment = new Payment("Credit Card", 25.0);

        Booking booking = new Booking(rideRequest, driver, ride, payment);

        assertEquals(driver, booking.getAssignedDriver());
    }

    @Test
    void testGetRide() {
        User user = new User("Slava", "123-456-7890");
        Location startLocation = new Location(37.7749, -122.4194);
        Location endLocation = new Location(34.0522, -118.2437);
        RideRequest rideRequest = new RideRequest(user, startLocation, endLocation);

        Driver driver = new Driver("Petr", "111-222-3333");
        Ride ride = new Ride(startLocation, endLocation, 25.0, "Now");
        Payment payment = new Payment("Credit Card", 25.0);

        Booking booking = new Booking(rideRequest, driver, ride, payment);

        assertEquals(ride, booking.getRide());
    }

    @Test
    void testGetPayment() {
        User user = new User("John", "123-456-7890");
        Location startLocation = new Location(37.7749, -122.4194);
        Location endLocation = new Location(34.0522, -118.2437);
        RideRequest rideRequest = new RideRequest(user, startLocation, endLocation);

        Driver driver = new Driver("Alice", "111-222-3333");
        Ride ride = new Ride(startLocation, endLocation, 25.0, "Now");
        Payment payment = new Payment("Credit Card", 25.0);

        Booking booking = new Booking(rideRequest, driver, ride, payment);

        assertEquals(payment, booking.getPayment());
    }

//
@Test
void testRatingCreation() {
    Rating rating = new Rating(4.5);
    assertEquals(4.5, rating.getRatingValue());
}

    @Test
    void testDriverRating() {
        Driver driver = new Driver("Bob", "111-222-3333");
        Rating rating = new Rating(4.5);
        driver.setRating(rating);

        assertEquals(4.5, driver.getRating().getRatingValue());
    }

    @Test
    void testVehicleCreation() {
        Vehicle vehicle = new Vehicle("ABC123", "Toyota");
        assertEquals("ABC123", vehicle.getLicensePlate());
        assertEquals("Toyota", vehicle.getModel());
    }

    @Test
    void testAssignVehicleToDriver() {
        Driver driver = new Driver("Alice", "111-222-3333");
        Vehicle vehicle = new Vehicle("XYZ987", "Honda");
        driver.assignVehicle(vehicle);

        assertEquals(vehicle, driver.getAssignedVehicle());
    }

    @Test
    void testAddDriverToAggregator() {
        TaxiAggregator taxiAggregator = new TaxiAggregator();
        Driver driver = new Driver("Eve", "444-555-6666");
        taxiAggregator.addDriver(driver);

        assertTrue(taxiAggregator.getAvailableDrivers().contains(driver));
    }

    @Test
    void testCreateBookingWithRating() {
        TaxiAggregator taxiAggregator = new TaxiAggregator();
        User user = new User("John", "123-456-7890");
        Location startLocation = new Location(37.7749, -122.4194);
        Location endLocation = new Location(34.0522, -118.2437);
        Driver driver = new Driver("Bob", "111-222-3333");
        Rating driverRating = new Rating(4.5);
        driver.setRating(driverRating);
        taxiAggregator.addDriver(driver);

        Booking booking = taxiAggregator.createBooking(user, startLocation, endLocation);

        assertNotNull(booking);
        assertNotNull(booking.getAssignedDriver());
        assertEquals(driver, booking.getAssignedDriver());
        assertNotNull(booking.getAssignedDriver().getRating());
        assertEquals(driverRating, booking.getAssignedDriver().getRating());
    }
}
