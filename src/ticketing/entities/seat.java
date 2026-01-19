package ticketing.entities;

public class seat {
    private int id;
    private int eventid;
    private String seatnumber;
    private boolean booked;
    public seat(int id, int eventid, String seatnumber, boolean booked) {
        this.id = id;
        this.eventid = eventid;
        this.seatnumber = seatnumber;
        this.booked = booked;
    }
    public int getid() {return id;}
    public int geteventid() {return eventid;}
    public String getseatnumber() {return seatnumber;}
    public boolean isbooked() {return booked;}
    public void setbooked(boolean booked) {this.booked = booked;}
}