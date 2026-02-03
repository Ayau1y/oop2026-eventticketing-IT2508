package ticketing.patterns.singleton;

public class DiscountManager {
    private static DiscountManager instance;
    private DiscountManager() {}

    public static DiscountManager getInstance() {
        if (instance == null) {instance = new DiscountManager();}
        return instance;}
    public double applyStudentDiscount(double price) {return price * 0.8;}
}
