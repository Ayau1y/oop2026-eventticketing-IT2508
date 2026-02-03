package ticketing.entities;

public class StandardTicket extends Ticket {

    public StandardTicket(int id, String code, int eventId, int seatId,
                          Customer customer, double price) {
        super(id, code, eventId, seatId, customer, price);
    }
    @Override
    public String getType() {return "STANDARD";}
}

