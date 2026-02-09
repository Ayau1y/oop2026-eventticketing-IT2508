package oop.project.EventManagementComponent;

import oop.project.EventManagementComponent.exceptions.SeatAlreadyBookedException;

public class SeatAllocationService {
    private final ISeatRepository seatRepository;

    public SeatAllocationService(ISeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public void reserveSeat(int seatId) {
        Seat seat = seatRepository.findById(seatId);

        if (seat == null) {
            throw new RuntimeException("Seat not found!");
        }

        if (seat.isBooked()) {
            throw new SeatAlreadyBookedException();
        }

        seat.setBooked(true);
        seatRepository.update(seat);

        System.out.println("Seat " + seat.getSeatnumber() + " successfully reserved.");
    }
}