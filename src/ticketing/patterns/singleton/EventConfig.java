package ticketing.patterns.singleton;

import ticketing.repositories.impl.EventRepositoryImpl;
import ticketing.repositories.impl.SeatRepositoryImpl;
import ticketing.repositories.interfaces.EventRepository;
import ticketing.repositories.interfaces.SeatRepository;
import ticketing.services.EventServices;

public class EventConfig {

    private static final EventRepository eventRepository = new EventRepositoryImpl();
    private static final SeatRepository seatRepository = new SeatRepositoryImpl();
    private static final EventServices eventService = new EventServices(eventRepository);

    private EventConfig() {}
    public static EventRepository getEventRepository() {return eventRepository;}
    public static SeatRepository getSeatRepository() {return seatRepository;}
    public static EventServices getEventService() {return eventService;}
}