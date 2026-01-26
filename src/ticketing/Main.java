package ticketing;

import ticketing.entities.Event;
import ticketing.repositories.impl.SeatRepositoryImpl;
import ticketing.repositories.interfaces.SeatRepository;
import ticketing.repositories.interfaces.EventRepository;
import ticketing.repositories.impl.EventRepositoryImpl;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EventRepository eventRepository = new EventRepositoryImpl();
        SeatRepository seatRepository = new SeatRepositoryImpl();
        Scanner scanner = new Scanner(System.in);

        List<Event> events = eventRepository.findAll();
        System.out.println("List of events");
        for (Event event : events) {
            System.out.println(event.getId() + event.getTitle() +
                    " | " + event.getVenue() +
                    " | " + event.getEventDate());
        }

        System.out.print("Enter the event ID to check availability");
        int eventId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter seat number");
        String seatNumber = scanner.nextLine();

        boolean available = seatRepository.isSeatAvailable(eventId, seatNumber);
        if (available) {
            System.out.println(seatNumber +" "+ "available!");
        } else {
            System.out.println(seatNumber + "already taken!");
        }
    }
}
