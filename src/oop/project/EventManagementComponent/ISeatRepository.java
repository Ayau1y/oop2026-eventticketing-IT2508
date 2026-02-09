package oop.project.EventManagementComponent;

public interface ISeatRepository extends oop.project.repositories.interfaces.IRepository<Seat> {
    boolean isSeatAvailable(int eventId, String seatNumber);
    void update(Seat seat);
}