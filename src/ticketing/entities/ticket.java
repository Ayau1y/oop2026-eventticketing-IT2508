package ticketing.entities;

public class ticket {
    private int id;
    private int eventid;
    private int seatid;
    private int customerid;
    private String code;
    public ticket(int id,int eventid,int seatid,int customerid,String code)
    {
        this.id=id;
        this.eventid=eventid;
        this.seatid=seatid;
        this.customerid=customerid;
        this.code=code;
    }
    public ticket(int eventid,int seatid,int customerid,String code)
    {
        this.eventid=eventid;
        this.seatid=seatid;
        this.customerid=customerid;
        this.code=code;
    }
    public int getid (){return id;}
    public int geteventid (){ return eventid;}
    public int getseatid() {return seatid;}
    public int getcustomerId() {return customerid;}
    public String getcode() {return code;}

}
