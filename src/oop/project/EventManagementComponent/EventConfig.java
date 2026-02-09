package oop.project.EventManagementComponent;

import oop.project.data.DatabaseConnection;
import oop.project.data.IDB;

public class EventConfig {
    private static final IDB db = DatabaseConnection.getInstance();

    private static final IEventRepository eventRepository = new EventRepositoryImpl(db);
    private static final ISeatRepository seatRepository = new SeatRepositoryImpl(db);
    private static final EventServices eventService = new EventServices(eventRepository);

    private EventConfig() {}

    public static IEventRepository getEventRepository() { return eventRepository; }
    public static ISeatRepository getSeatRepository() { return seatRepository; }
    public static EventServices getEventService() { return eventService; }
}