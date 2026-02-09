package oop.project.EventManagementComponent;

import oop.project.data.IDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImpl implements IEventRepository {
    private final IDB db;

    public EventRepositoryImpl(IDB db) {
        this.db = db;
    }

    @Override
    public List<Event> findByTitle(String title) {
        List<Event> events = new ArrayList<>();
        // Using ILIKE for case-insensitive search
        String sql = "SELECT * FROM events WHERE title ILIKE ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + title + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    events.add(mapResultSetToEvent(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public Event findById(int id) {
        String sql = "SELECT * FROM events WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEvent(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events";
        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                events.add(mapResultSetToEvent(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public void create(Event event) {
        String sql = "INSERT INTO events (title, venue, event_date, cancelled) VALUES (?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, event.getTitle());
            stmt.setString(2, event.getVenue());

            if (event.getEventDate() != null) {
                stmt.setTimestamp(3, Timestamp.valueOf(event.getEventDate()));
            } else {
                stmt.setNull(3, Types.TIMESTAMP);
            }

            stmt.setBoolean(4, event.isCancelled());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Event mapResultSetToEvent(ResultSet rs) throws SQLException {
        Event.Builder builder = new Event.Builder()
                .setId(rs.getInt("id"))
                .setTitle(rs.getString("title"))
                .setVenue(rs.getString("venue"))
                .setCancelled(rs.getBoolean("cancelled"));

        Timestamp ts = rs.getTimestamp("event_date");
        if (ts != null) {
            builder.setDate(ts.toLocalDateTime());
        }

        return builder.build();
    }
}