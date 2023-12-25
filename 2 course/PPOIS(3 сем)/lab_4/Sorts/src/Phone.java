class Phone implements Comparable<Phone> {
    private String model;
    private String brand;
    private int year;

    public Phone(String model, String brand, int year) {
        this.model = model;
        this.brand = brand;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Phone anotherPhone) {
        return year - anotherPhone.getYear();
    }

    @Override
    public String toString() {
        return "Phone: " +
                "Model=" + model +
                ", Brand=" + brand +
                ", Year=" + year;
    }
}