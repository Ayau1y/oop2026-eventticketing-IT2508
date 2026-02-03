package ticketing.services;

import ticketing.entities.Event;
import ticketing.repositories.interfaces.EventRepository;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EventServices {
    private final EventRepository repo;

    public EventServices(EventRepository repo) {
        this.repo = repo;
    }
    public List<Event> getActiveEvents() {
        return repo.findAll().stream()
                .filter(e -> !e.isCancelled())
                .collect(Collectors.toList());
    }
    public List<Event> getEventsSortedByDate() {
        return repo.findAll().stream()
                .sorted(Comparator.comparing(Event::getEventDate))
                .collect(Collectors.toList());
    }
    public Event getEventById(int id) {
        return repo.findAll().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }
}
