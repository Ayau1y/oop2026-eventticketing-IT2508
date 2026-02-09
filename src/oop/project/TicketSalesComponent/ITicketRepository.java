package oop.project.TicketSalesComponent;

import oop.project.generalInteface.IRepository;

public interface ITicketRepository extends IRepository<Ticket> {
    Ticket findByCode(String code);
}
