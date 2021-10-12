public class Venue {
    private final String venueName;
    private final String venueAddress;

    public Venue(String venueName, String venueAddress, int venueCapacity) {
        this.venueName = venueName;
        this.venueAddress = venueAddress;
    }

    public String getVenueName() {
        return venueName;
    }
    public String getVenueAddress() {
        return venueAddress;
    }
}
