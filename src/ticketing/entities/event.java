package ticketing.entities;

import java.time.LocalDateTime;
public class event {
    private int id;
    private String title;
    private String venue;
    private LocalDateTime eventdate;
    private boolean cancelled;
    public event (int id, String title, String venue, LocalDateTime eventdate, boolean cancelled) {
        this.id = id;
        this.title = title;
        this.venue = venue;
        this.eventdate = eventdate;
        this.cancelled = cancelled;
    }
    public event (String title, String venue, LocalDateTime eventdate) {
        this.title = title;
        this.venue = venue;
        this.eventdate = eventdate;
        this.cancelled = false;
    }
    public int getid() {return id;}
    public String gettitle() {return title;}
    public String getvenue() {return venue;}
    public LocalDateTime geteventdate() {return eventdate;}
    public boolean iscancelled() {return cancelled;}
    public void setcancelled(boolean cancelled) {this.cancelled = cancelled;}
}