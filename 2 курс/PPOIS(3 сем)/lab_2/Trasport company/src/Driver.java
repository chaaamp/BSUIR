class Driver {
    //Поля, хранящие информацию о водителе
    String name;
    String phoneNumber;
    boolean isAvailable;
    Rating rating;
    Vehicle assignedVehicle;
//Конструктор Driver
    public Driver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isAvailable = true;
        this.rating = new Rating(0.0); // Инициализация рейтинга при создании водителя
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.assignedVehicle = vehicle;
    }

    public Vehicle getAssignedVehicle() {
        return assignedVehicle;
    }
}