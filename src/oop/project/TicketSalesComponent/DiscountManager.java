package oop.project.TicketSalesComponent;

public class DiscountManager {

    private static DiscountManager instance;

    private DiscountManager() {}

    public static synchronized DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    public double applyStudentDiscount(double price) {
        return price * 0.8;
    }

    public double applyVIPMarkup(double price) {
        return price * 1.5;
    }

    public double applyCustomDiscount(double price, double discountPercentage) {
        return price * (1 - (discountPercentage / 100));
    }
}