package oop.project.EventManagementComponent;

public class Seat {
    private int id;
    private int eventid;
    private String seatnumber;
    private boolean booked;
    public Seat(int id, int eventid, String seatnumber, boolean booked) {
        this.id = id;
        this.eventid = eventid;
        this.seatnumber = seatnumber;
        this.booked = booked;
    }
    public int getId() {return id;}
    public int getEventid() {return eventid;}
    public String getSeatnumber() {return seatnumber;}
    public boolean isBooked() {return booked;}
    public void setBooked(boolean booked) {this.booked = booked;}
}