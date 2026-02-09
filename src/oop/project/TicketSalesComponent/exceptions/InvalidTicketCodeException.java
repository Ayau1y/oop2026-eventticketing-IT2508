package oop.project.TicketSalesComponent.exceptions;

public class InvalidTicketCodeException extends RuntimeException {
    public InvalidTicketCodeException() {
        super("The ticket code is invalid");
    }
}
