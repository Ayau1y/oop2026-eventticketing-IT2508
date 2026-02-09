package oop.project.EventManagementComponent;

import oop.project.EventManagementComponent.exceptions.EventCancelledException;
import oop.project.ReportingComponent.SearchResult;

import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EventServices {
    private final IEventRepository repo;

    public EventServices(IEventRepository repo) {
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
        Event event = repo.findById(id);
        if (event == null) {
            throw new RuntimeException("Event not found with id: " + id);
        }

        if (event.isCancelled()) {
            throw new EventCancelledException();
        }

        return event;
    }

    public SearchResult<Event> searchEventsByTitle(String title) {
        List<Event> found = repo.findByTitle(title);
        return new SearchResult<>(found);
    }
}