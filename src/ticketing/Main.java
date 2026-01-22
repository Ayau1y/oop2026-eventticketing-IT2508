package ticketing;

import ticketing.data.DatabaseConnection;
import ticketing.repositories.interfaces.EventRepository;
import ticketing.repositories.impl.EventRepositoryImpl;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Event Ticketing System");

        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Database connection successful");
        } catch (Exception e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }

        EventRepository eventRepository = new EventRepositoryImpl();
        System.out.println("EventRepository initialized");

        System.out.println("System is ready");
    }
}