package ticketing.repositories.impl;

import ticketing.entities.Seat;
import ticketing.repositories.interfaces.SeatRepository;

import java.util.ArrayList;
import java.util.List;

public class SeatRepositoryImpl implements SeatRepository {

    @Override
    public Seat findById(int id) {
        return null;
    }

    @Override
    public List<Seat> findByEventId(int eventId) {
        return new ArrayList<>();
    }
}
