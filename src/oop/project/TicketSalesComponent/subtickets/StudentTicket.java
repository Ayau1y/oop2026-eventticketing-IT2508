package oop.project.TicketSalesComponent.subtickets;

import oop.project.TicketSalesComponent.Customer;
import oop.project.TicketSalesComponent.Ticket;

public class StudentTicket extends Ticket {
    public StudentTicket(int id, String code, int eventId, int seatId, Customer customer, double price) {
        super(id, code, eventId, seatId, customer, price, true);
    }
}