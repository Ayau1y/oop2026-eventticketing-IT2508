package ticketing.repositories.impl;

import ticketing.entities.Ticket;
import ticketing.repositories.interfaces.TicketRepository;

    public class TicketRepositoryImpl implements TicketRepository {

    @Override
    public Ticket findByCode(String code) {
        return null;
    }

    @Override
    public void creat(Ticket ticket) {
        // TODO: JDCB
    }
}