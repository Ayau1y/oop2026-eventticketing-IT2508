package oop.project.EventManagementComponent;
import java.time.LocalDateTime;

public class Event {
    private int id;
    private String title;
    private String venue;
    private LocalDateTime eventDate;
    private boolean cancelled;

    private Event(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.venue = builder.venue;
        this.eventDate = builder.eventDate;
        this.cancelled = builder.cancelled;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getVenue() { return venue; }
    public LocalDateTime getEventDate() { return eventDate; }
    public boolean isCancelled() { return cancelled; }
    public static class Builder {
        private int id;
        private String title;
        private String venue;
        private LocalDateTime eventDate;
        private boolean cancelled;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setTitle(String title) { this.title = title; return this; }
        public Builder setVenue(String venue) { this.venue = venue; return this; }
        public Builder setDate(LocalDateTime date) { this.eventDate = date; return this; }
        public Builder setCancelled(boolean cancelled) { this.cancelled = cancelled; return this; }

        public Event build() { return new Event(this); }
    }
}