package oop.project.EventManagementComponent.exceptions;

public class EventCancelledException extends RuntimeException {
    public EventCancelledException() {
        super("Event is not available");
    }
}