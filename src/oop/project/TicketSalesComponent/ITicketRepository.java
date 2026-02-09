package oop.project.TicketSalesComponent;

public interface ITicketRepository extends oop.project.repositories.interfaces.IRepository<Ticket> {
    Ticket findByCode(String code);
}
