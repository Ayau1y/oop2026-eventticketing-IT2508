package ticketing.entities;

public abstract class Ticket {

    protected int id;
    protected String code;
    protected int eventId;
    protected int seatId;
    protected Customer customer;
    protected double price;
    protected boolean booked;

    public Ticket(int id, String code, int eventId, int seatId, Customer customer, double price) {
        this.id = id;
        this.code = code;
        this.eventId = eventId;
        this.seatId = seatId;
        this.customer = customer;
        this.price = price;
        this.booked = false;
    }

    public int getId() { return id; }
    public String getCode() { return code; }
    public int getEventId() { return eventId; }
    public int getSeatId() { return seatId; }
    public Customer getCustomer() { return customer; }
    public double getPrice() { return price; }
    public boolean isBooked() { return booked; }

    public void book() {
        this.booked = true;
    }
    public abstract String getType();
}
