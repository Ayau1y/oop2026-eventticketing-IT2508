package ticketing.repositories.interfaces;

import ticketing.entities.Event;
import java.util.List;

public interface EventRepository extends Repository<Event> {
    List<Event> findByTitle(String title);
}
