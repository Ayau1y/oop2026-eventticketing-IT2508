package oop.project.TicketSalesComponent;

import oop.project.TicketSalesComponent.factory.TicketFactory;
import oop.project.data.IDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl implements ITicketRepository {
    private final IDB db;

    public TicketRepositoryImpl(IDB db) {
        this.db = db;
    }

    @Override
    public Ticket findByCode(String code) {
        String sql = "SELECT * FROM tickets WHERE code = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, code);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) return mapResultSetToTicket(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ticket findById(int id) {
        String sql = "SELECT * FROM tickets WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) return mapResultSetToTicket(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets";
        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                tickets.add(mapResultSetToTicket(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public void create(Ticket ticket) {
        String sql = "INSERT INTO tickets (code, event_id, seat_id, price, booked, type) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ticket.getCode());
            stmt.setInt(2, ticket.getEventId());
            stmt.setInt(3, ticket.getSeatId());
            stmt.setDouble(4, ticket.getPrice());
            stmt.setBoolean(5, ticket.isBooked());

            String type = ticket.getClass().getSimpleName().replace("Ticket", "").toUpperCase();
            stmt.setString(6, type);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Ticket mapResultSetToTicket(ResultSet rs) throws SQLException {
        return TicketFactory.createTicket(
                rs.getString("type"),
                rs.getInt("id"),
                rs.getString("code"),
                rs.getInt("event_id"),
                rs.getInt("seat_id"),
                null, // Customer can be loaded via a CustomerService if needed
                rs.getDouble("price")
        );
    }
}