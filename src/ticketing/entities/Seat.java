package ticketing.entities;

public class Seat {
    private int id;
    private int eventid;
    private String seatnumber;
    private boolean booked;
    public Seat(int id, int eventId, String seatNumber, boolean booked) {
        this.id = id;
        this.eventid = eventid;
        this.seatnumber = seatnumber;
        this.booked = booked;
    }
    public int getId() {return id;}
    public int getEventId() {return eventid;}
    public String getSeatNumber() {return seatnumber;}
    public boolean isBooked() {return booked;}
    public void setBooked(boolean booked) {this.booked = booked;}
}