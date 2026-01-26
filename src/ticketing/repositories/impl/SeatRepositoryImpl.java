package ticketing.repositories.impl;

import ticketing.data.DatabaseConnection;
import ticketing.repositories.interfaces.SeatRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SeatRepositoryImpl implements SeatRepository {

    @Override
    public boolean isSeatAvailable(int eventId, String seatNumber) {
        String sql = "SELECT booked FROM seats WHERE event_id = ? AND seat_number = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, eventId);
            stmt.setString(2, seatNumber);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                boolean booked = rs.getBoolean("booked")
                return !booked;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
//
