public class Event {
    private String eventName;
    private int ticketAmount;
    private Venue venue;
    private Act act[];
    private double ticketPrice;

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
                "Tickets available: "+this.ticketAmount+"\n"+
                "Price per ticket: "+this.ticketPrice+"$\n"+
                "Schedule:\n"+printSchedule();
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
