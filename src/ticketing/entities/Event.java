package ticketing.entities;

import java.time.LocalDateTime;
public class Event {
    private int id;
    private String title;
    private String venue;
    private LocalDateTime eventdate;
    private boolean cancelled;
    public Event(int id, String title, String venue, LocalDateTime eventdaSte, boolean cancelled) {
        this.id = id;
        this.title = title;
        this.venue = venue;
        this.eventdate = eventdate;
        this.cancelled = cancelled;
    }
    public Event(String title, String venue, LocalDateTime eventdate) {
        this.title = title;
        this.venue = venue;
        this.eventdate = eventdate;
        this.cancelled = false;
    }
    public int getId() {return id;}
    public String getTitle() {return title;}
    public String getVenue() {return venue;}
    public LocalDateTime getEventdate() {return eventdate;}
    public boolean isCancelled() {return cancelled;}
    public void setCancelled(boolean cancelled) {this.cancelled = cancelled;}
}