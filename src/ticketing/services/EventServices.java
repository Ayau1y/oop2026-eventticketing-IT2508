package ticketing.services;

import ticketing.entities.Event;
import ticketing.repositories.interfaces.EventRepository;
import ticketing.exceptions.EventCancelledException;

public class EventServices {

    private final EventRepository eventRepository;

    public EventServices(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent(Event event) {
        eventRepository.create(event);
    }

    public Event getEventByeId(int id) {
        Event event = eventRepository.findById(id);

        if (event != null && event.isCancelled()) {
            throw new EventCancelledException("Event is cancelled");
        }

        return event;
    }
}