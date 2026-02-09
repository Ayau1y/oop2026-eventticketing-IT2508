package oop.project.TicketSalesComponent;

import oop.project.EventManagementComponent.Event;
import oop.project.EventManagementComponent.IEventRepository;
import oop.project.EventManagementComponent.ISeatRepository;
import oop.project.EventManagementComponent.exceptions.EventCancelledException;
import oop.project.EventManagementComponent.exceptions.SeatAlreadyBookedException;
import oop.project.TicketSalesComponent.exceptions.InvalidTicketCodeException;
import oop.project.TicketSalesComponent.factory.TicketFactory;
import oop.project.ReportingComponent.SearchResult;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TicketService {
    private final ITicketRepository ticketRepo;
    private final ISeatRepository seatRepo;
    private final IEventRepository eventRepo;

    public TicketService(ITicketRepository ticketRepo, ISeatRepository seatRepo, IEventRepository eventRepo) {
        this.ticketRepo = ticketRepo;
        this.seatRepo = seatRepo;
        this.eventRepo = eventRepo;
    }

    public void buyTicket(String type, int eventId, int seatId, String seatNumber, Customer customer, double basePrice) {

        Event event = eventRepo.findById(eventId);
        if (event == null || event.isCancelled()) {
            throw new EventCancelledException();
        }

        if (!seatRepo.isSeatAvailable(eventId, seatNumber)) {
            throw new SeatAlreadyBookedException();
        }

        DiscountManager dm = DiscountManager.getInstance();
        double finalPrice = basePrice;
        if ("STUDENT".equalsIgnoreCase(type)) finalPrice = dm.applyStudentDiscount(basePrice);
        else if ("VIP".equalsIgnoreCase(type)) finalPrice = dm.applyVIPMarkup(basePrice);

        String uniqueCode = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Ticket newTicket = TicketFactory.createTicket(type, 0, uniqueCode, eventId, seatId, customer, finalPrice);

        ticketRepo.create(newTicket);

        System.out.println("Success! Ticket " + uniqueCode + " issued for $" + finalPrice);
    }

    public Ticket getTicketByCode(String code) {
        Ticket ticket = ticketRepo.findByCode(code);
        if (ticket == null) throw new InvalidTicketCodeException();
        return ticket;
    }
    public SearchResult<Ticket> searchTicketsByEvent(int eventId) {
        List<Ticket> allTickets = ticketRepo.findAll();
        List<Ticket> filteredByEvent = allTickets.stream()
                .filter(t -> t.getEventId() == eventId)
                .collect(Collectors.toList());

        return new SearchResult<>(filteredByEvent);
    }
}