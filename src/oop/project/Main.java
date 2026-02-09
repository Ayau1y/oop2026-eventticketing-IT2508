package oop.project;

import oop.project.EventManagementComponent.*;
import oop.project.EventManagementComponent.exceptions.EventCancelledException;
import oop.project.EventManagementComponent.exceptions.SeatAlreadyBookedException;
import oop.project.TicketSalesComponent.*;
import oop.project.TicketSalesComponent.exceptions.InvalidTicketCodeException;
import oop.project.data.DatabaseConnection;
import oop.project.data.IDB;
import oop.project.ReportingComponent.SearchResult;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IDB db = DatabaseConnection.getInstance();

        IEventRepository eventRepo = new EventRepositoryImpl(db);
        ISeatRepository seatRepo = new SeatRepositoryImpl(db);
        ICustomerRepository customerRepo = new CustomerRepositoryImpl(db);
        ITicketRepository ticketRepo = new TicketRepositoryImpl(db);

        EventServices eventService = new EventServices(eventRepo);
        SeatAllocationService seatService = new SeatAllocationService(seatRepo);
        TicketService ticketService = new TicketService(ticketRepo, seatRepo, eventRepo);

        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Ticketing System Initialized ---");

        while (true) {
            System.out.println("\n--- EVENT MANAGEMENT SYSTEM ---");
            System.out.println("1. View Active Events");
            System.out.println("2. Search Events by Title");
            System.out.println("3. Buy Ticket ");
            System.out.println("4. Check Seat Availability");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            try {
                switch (choice) {
                    case 1:
                        System.out.println("\n--- Current Active Events ---");
                        List<Event> activeEvents = eventService.getActiveEvents();
                        if (activeEvents.isEmpty()) System.out.println("No active events found.");
                        activeEvents.forEach(e -> System.out.println(e.getId() + ": " + e.getTitle() + " @ " + e.getVenue()));
                        break;

                    case 2:
                        System.out.print("Enter search keyword: ");
                        String keyword = scanner.nextLine();
                        SearchResult<Event> searchResults = eventService.searchEventsByTitle(keyword);

                        System.out.println("\n--- Search Results (" + searchResults.getCount() + ") ---");
                        searchResults.getAll().forEach(e -> System.out.println("- " + e.getTitle() + " [" + e.getVenue() + "]"));
                        break;

                    case 3:
                        System.out.println("\n--- Purchase Ticket ---");
                        System.out.print("Customer Name: "); String name = scanner.nextLine();
                        System.out.print("Customer Email: "); String email = scanner.nextLine();
                        Customer customer = new Customer(name, email);

                        System.out.print("Event ID: "); int eid = scanner.nextInt();
                        System.out.print("Seat ID: "); int sid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Seat Number (e.g. A12): "); String sNum = scanner.nextLine();
                        System.out.print("Ticket Type (STUDENT/VIP/STANDARD): "); String type = scanner.nextLine();

                        double basePrice = 5000.0;

                        ticketService.buyTicket(type, eid, sid, sNum, customer, basePrice);
                        break;
                    case 4:
                        System.out.print("Event ID: ");
                        int checkEid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Seat Number (e.g., A1): ");
                        String checkSNum = scanner.nextLine();


                        boolean isFree = seatRepo.isSeatAvailable(checkEid, checkSNum);

                        if (isFree) {
                            System.out.println("✅ Seat " + checkSNum + " is AVAILABLE");
                        } else {
                            System.out.println("❌ Seat " + checkSNum + " is NOT available or doesn't exist.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (EventCancelledException | SeatAlreadyBookedException | InvalidTicketCodeException e) {
                System.out.println("\n[!] BOOKING DENIED: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\n[X] SYSTEM ERROR: " + e.getMessage());
            }
        }
        System.out.println("Exiting. Goodbye!");
    }
}