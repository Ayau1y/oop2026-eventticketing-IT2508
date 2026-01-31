package ticketing.services;

import ticketing.exceptions.SeatAlreadyBookedException;
import ticketing.repositories.interfaces.SeatRepository;
import ticketing.entities.Seat;


public class SeatAllocationService {

    private final SeatRepository seatRepository;

    public SeatAllocationService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public void reserveSeat(Seat seat) {

        if (seat.isBooked()) {
            throw new SeatAlreadyBookedException("Seat is already booked, choose another Seat");
        }

        seat.setBooked(true);

    }
}