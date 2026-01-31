package ticketing.services;

import ticketing.entities.Ticket;
import ticketing.exceptions.InvalidTicketCodeException;
import ticketing.repositories.interfaces.TicketRepository;

public class
TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket getTicketByCode(String code) {

        Ticket ticket = ticketRepository.findByCode(code);

        if (ticket == null) {
            throw new InvalidTicketCodeException("Invalid ticket code");
        }

        return ticket;
    }

    public void buyTicket(Ticket ticket) {
        ticketRepository.create(ticket);
    }
}