/*
 * Класс Payment представляет информацию об оплате заказа в системе такси.
 */
class Payment {
    String paymentMethod;
    double amount;
    boolean isPaid;
    /*
     * Конструктор для создания объекта Payment с заданными параметрами.
     * paymentMethod Используемый метод оплаты (например, "Credit Card").
     * Сумма оплаты.
     */
    public Payment(String paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.isPaid = false;// По умолчанию оплата не выполнена
    }
}