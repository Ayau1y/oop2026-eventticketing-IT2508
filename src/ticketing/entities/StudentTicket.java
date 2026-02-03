package ticketing.entities;

public class StudentTicket extends Ticket {

    private double discount = 0.2;
    public StudentTicket(int id, String code, int eventId, int seatId,
                         Customer customer, double price) {
        super(id, code, eventId, seatId, customer, price);
    }
    @Override
    public double getPrice() {return price * (1 - discount);}
    @Override
    public String getType() {return "STUDENT";}
}
