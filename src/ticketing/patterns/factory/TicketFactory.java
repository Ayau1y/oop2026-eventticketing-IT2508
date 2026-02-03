package ticketing.patterns.factory;

import ticketing.entities.*;

public class TicketFactory {

    public static Ticket createTicket(String type, int id, String code, int eventId, int seatId, Customer customer, double price) {
        return switch (type.toUpperCase()) {
            case "VIP" -> new VIPTicket(id, code, eventId, seatId, customer, price);
            case "STUDENT" -> new StudentTicket(id, code, eventId, seatId, customer, price);
            default -> new StandardTicket(id, code, eventId, seatId, customer, price);
        };
    }
}
