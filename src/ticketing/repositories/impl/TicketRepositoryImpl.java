package ticketing.repositories.impl;

import ticketing.entities.Ticket;
import ticketing.repositories.interfaces.TicketRepository;
import ticketing.data.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

    public class TicketRepositoryImpl implements TicketRepository {

    @Override
    public Ticket findByCode(String code) {
        return null;
    }

    @Override
    public void create(Ticket ticket) {
        String sql = "INSERT INTO tickets (ticket_code, event_id, customer_id, seat_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ticket.getCode());
            stmt.setInt(2, ticket.getEventId());
            stmt.setInt(3, ticket.getCustomerId());
            stmt.setInt(4, ticket.getSeatId());

            stmt.executeUpdate();
            System.out.println("Ticket created successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}