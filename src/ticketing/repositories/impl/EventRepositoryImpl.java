package ticketing.repositories.impl;

import ticketing.data.DatabaseConnection;
import ticketing.entities.Event;
import ticketing.repositories.interfaces.EventRepository;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImpl implements EventRepository {

    @Override
    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT id, title, venue, event_date, cancelled FROM events";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Event event = new Event(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("venue"),
                        rs.getTimestamp("event_date").toLocalDateTime(),
                        rs.getBoolean("cancelled")
                );
                events.add(event);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public Event findById(int id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT id, title, venue, event_date, cancelled FROM events WHERE id=?"
             )) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Event(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("venue"),
                        rs.getTimestamp("event_date").toLocalDateTime(),
                        rs.getBoolean("cancelled")
                );
            }

        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public void create(Event event) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO events (title, venue, event_date, cancelled) VALUES (?, ?, ?, ?)"
             )) {

            stmt.setString(1, event.getTitle());
            stmt.setString(2, event.getVenue());
            stmt.setTimestamp(3, Timestamp.valueOf(event.getEventDate()));
            stmt.setBoolean(4, event.isCancelled());
            stmt.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }
    }
}