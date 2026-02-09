package oop.project.TicketSalesComponent.factory;
import oop.project.TicketSalesComponent.Customer;
import oop.project.TicketSalesComponent.Ticket;
import oop.project.TicketSalesComponent.subtickets.StandardTicket;
import oop.project.TicketSalesComponent.subtickets.StudentTicket;
import oop.project.TicketSalesComponent.subtickets.VIPTicket;

public class TicketFactory {
    public static Ticket createTicket(
            String type, int id, String code, int eventId, int seatId, Customer customer, double price) {
        if (type == null) {
            return null;
        }
        return switch (type.toUpperCase()) {
            case "VIP" -> new VIPTicket(id, code, eventId, seatId, customer, price);
            case "STUDENT" -> new StudentTicket(id, code, eventId, seatId, customer, price);
            default -> new StandardTicket(id, code, eventId, seatId, customer, price);
        };
    }
}