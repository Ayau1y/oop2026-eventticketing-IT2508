package ticketing.repositories.interfaces;

public interface SeatRepository {
    boolean isSeatAvailable(int eventId, String seatNumber);
}
