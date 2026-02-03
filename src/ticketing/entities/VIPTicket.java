package ticketing.entities;

public class VIPTicket extends Ticket {
    private double vipfee=2000;
    public VIPTicket(int id, String code, int eventId, int seatId, Customer customer, double price) {
        super(id, code, eventId, seatId, customer, price);
    }
    @Override
    public double getPrice() {return price + vipfee ;}
    @Override
    public String getType() {return "VIP";}
}
