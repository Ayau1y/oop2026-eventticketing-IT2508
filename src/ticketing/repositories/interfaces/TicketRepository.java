package ticketing.repositories.interfaces;

import ticketing.entities.Ticket;

public interface
TicketRepository {
    Ticket findByCode(String code);
    void create(Ticket ticket);
}
