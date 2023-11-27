class Payment {
    String paymentMethod;
    double amount;
    boolean isPaid;

    public Payment(String paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.isPaid = false;
    }
}