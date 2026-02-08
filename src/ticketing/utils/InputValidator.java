package ticketing.utils;

public class InputValidator {
    public static boolean isValidCode(String code) {return code != null && code.length() >= 5;}
    public static boolean isValidPrice(double price) {return price > 0;}
    public static boolean isValidId(int id) {return id > 0;}
}

