package ticketing.repositories.impl;

import ticketing.data.DatabaseConnection;
import ticketing.entities.Event;
import ticketing.repositories.interfaces.EventRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImpl implements EventRepository {

    @Override
    public void create(Event event) {
        // JDBC logic will be added later
    }

    @Override
    public Event findById(int id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>();
    }
}

