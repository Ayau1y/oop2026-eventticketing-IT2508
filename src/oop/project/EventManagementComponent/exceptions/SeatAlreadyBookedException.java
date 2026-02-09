package oop.project.EventManagementComponent.exceptions;

public class SeatAlreadyBookedException extends RuntimeException {
    public SeatAlreadyBookedException() {
        super("This seat has already been booked");
    }
}
