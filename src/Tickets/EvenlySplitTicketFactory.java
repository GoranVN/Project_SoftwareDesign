package Tickets;

public class EvenlySplitTicketFactory extends TicketFactory{
    public EvenlySplitTicketFactory() {
        super();
    }

    public Ticket createTicket(String type, float price) {
        switch (type) {
            case "airplane":
                return new EvenlySplitAirplaneTicket(price);
            case "concert":
                return new EvenlySplitConcertTicket(price);
            case "restaurant":
                return new EvenlySplitRestaurantTicket(price);
            case "taxi":
                return new EvenlySplitTaxiTicket(price);
            default:
                return new EvenlySplitDefaultTicket(price);
        }
    }
}
