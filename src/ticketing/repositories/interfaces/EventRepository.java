package ticketing.repositories.interfaces;

import ticketing.entities.Event;
import java.util.List;

public interface EventRepository {
    List<Event> findAll();

    void create(Event event);
    Event findById(int id);
}

