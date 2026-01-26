package ticketing.exceptions;

public class EventCancelledException extends RuntimeException {
    public EventCancelledException(String message) {
        super(message);
    }
}
//