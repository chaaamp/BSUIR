// Vehicle class
class Vehicle {
    String licensePlate;
    String model;

    public Vehicle(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
    }

    public String getLicensePlate() {

        return licensePlate;
    }

    public String getModel() {

        return model;
    }
}
