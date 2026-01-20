package ticketing.entities;

public class Ticket {
    private int id;
    private int eventid;
    private int seatid;
    private int customerid;
    private String code;
    public Ticket(int id, int eventid, int seatid, int customerid, String code)
    {
        this.id=id;
        this.eventid=eventid;
        this.seatid=seatid;
        this.customerid=customerid;
        this.code=code;
    }
    public Ticket(int eventid, int seatid, int customerid, String code)
    {
        this.eventid=eventid;
        this.seatid=seatid;
        this.customerid=customerid;
        this.code=code;
    }
    public int getId (){return id;}
    public int getEventid (){ return eventid;}
    public int getSeatid() {return seatid;}
    public int getCustomerId() {return customerid;}
    public String getCode() {return code;}

}
