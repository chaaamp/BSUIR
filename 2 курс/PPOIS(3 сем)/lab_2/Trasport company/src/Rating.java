//Рейтинг, присвоенный водителю
class Rating {
    double ratingValue;
    //создание нового объекта с указанным значением рейтинга
    public Rating(double ratingValue) {
        this.ratingValue = ratingValue;
    }
    //Возврат значения рейтинга
    public double getRatingValue() {
        return ratingValue;
    }
}