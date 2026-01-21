package ticketing.repositories.interfaces;

import ticketing.entities.Seat;
import java.util.List;

public interface SeatRepository {
    Seat findById(int id);

    List<Seat> findByEventId(int eventId);
}
