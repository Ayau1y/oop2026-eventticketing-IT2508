package ticketing.repositories.impl;

import ticketing.entities.Customer;
import ticketing.data.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ticketing.repositories.interfaces.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class  CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void create(Customer customer) {
        String sql = "INSERT INTO customers (name, email) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());

            stmt.executeUpdate();
            System.out.println("Customer created successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>();
    }
}