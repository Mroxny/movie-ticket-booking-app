public enum TicketType {
    ADULT(25),
    STUDENT(18),
    CHILD(12.50);

    private double price;

    TicketType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}