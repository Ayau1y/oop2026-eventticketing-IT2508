package ticketing.repositories.interfaces;

import ticketing.entities.Seat;

public interface SeatRepository extends Repository<Seat> {
    boolean isSeatAvailable(int eventId, String seatNumber);
}