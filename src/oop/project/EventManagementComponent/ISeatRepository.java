package oop.project.EventManagementComponent;

import oop.project.generalInteface.IRepository;

public interface ISeatRepository extends IRepository<Seat> {
    boolean isSeatAvailable(int eventId, String seatNumber);
    void update(Seat seat);
}