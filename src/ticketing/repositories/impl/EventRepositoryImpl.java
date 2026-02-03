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
    public List<Event> findByTitle(String title) {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT id, title, venue, event_date, cancelled FROM events WHERE title ILIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                events.add(new Event.Builder()
                        .setId(rs.getInt("id"))
                        .setTitle(rs.getString("title"))
                        .setVenue(rs.getString("venue"))
                        .setDate(rs.getTimestamp("event_date").toLocalDateTime())
                        .setCancelled(rs.getBoolean("cancelled"))
                        .build()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return events;
    }
    @Override
    public Event findById(int id) {
        String sql = "SELECT id, title, venue, event_date, cancelled FROM events WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Event.Builder()
                        .setId(rs.getInt("id"))
                        .setTitle(rs.getString("title"))
                        .setVenue(rs.getString("venue"))
                        .setDate(rs.getTimestamp("event_date").toLocalDateTime())
                        .setCancelled(rs.getBoolean("cancelled"))
                        .build();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT id, title, venue, event_date, cancelled FROM events";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                events.add(new Event.Builder()
                        .setId(rs.getInt("id"))
                        .setTitle(rs.getString("title"))
                        .setVenue(rs.getString("venue"))
                        .setDate(rs.getTimestamp("event_date").toLocalDateTime())
                        .setCancelled(rs.getBoolean("cancelled"))
                        .build()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }
    @Override
    public void create(Event event) {
        String sql = "INSERT INTO events (title, venue, event_date, cancelled) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, event.getTitle());
            stmt.setString(2, event.getVenue());
            stmt.setTimestamp(3, Timestamp.valueOf(event.getEventDate()));
            stmt.setBoolean(4, event.isCancelled());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}