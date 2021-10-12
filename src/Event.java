public class Event {
    //Jens
    private final String eventName;
    private final int ticketAmount;
    private final Venue venue;
    private final Act[] act;
    private final double ticketPrice;

    public Event(String eventName, int ticketAmount, Venue venue, Act[] act, double ticketPrice) {
        this.eventName = eventName;
        this.ticketAmount = ticketAmount;
        this.venue = venue;
        this.act = act;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Event name: "+this.eventName+"\n"+
                "Venue name: "+this.venue.getVenueName()+"\n"+
                "Venue address: "+this.venue.getVenueAddress()+"\n"+
                "Tickets available: "+this.ticketAmount+"\n"+
                "Price per ticket: "+this.ticketPrice+"$\n"+
                "\nSchedule for the event is as follows:\n"+printSchedule();
    }
    public String printSchedule(){
        String scheduleFormatted ="";
        for (int i = 0; i < this.act.length; i++) {
            scheduleFormatted += "Act name: "+this.act[i].getActName()+"\n"+
                    "Act start time: "+this.act[i].getActStartTime()+"\n\n";

        }
        return scheduleFormatted;
    }
}
