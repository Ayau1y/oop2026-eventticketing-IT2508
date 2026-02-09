package oop.project.TicketSalesComponent;

public abstract class Ticket {

    private int id;
    private String code;
    private int eventId;
    private int seatId;
    private Customer customer;
    private double price;
    private boolean booked;

    public Ticket() {}

    protected Ticket( String code, int eventId, int seatId, Customer customer, double price, boolean booked) {
        setCode( code );
        setEventId( eventId );
        setSeatId( seatId );
        setCustomer(customer);
        setPrice( price );
        setBooked( booked );
    }

    public Ticket(int id, String code, int eventId, int seatId, Customer customer, double price, boolean booked) {
        this.id = id;
        this.code = code;
        this.eventId = eventId;
        this.seatId = seatId;
        this.customer = customer;
        this.price = price;
        this.booked = booked;
        setId(id);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public int getEventId() {
        return eventId;
    }
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    public int getSeatId() {
        return seatId;
    }
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isBooked() {
        return booked;
    }
    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
