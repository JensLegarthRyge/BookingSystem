import java.util.Date;

public class Act {
    private final String actName;
    private final int actPrice;
    private final Date actStartTime;

    public Act(String actName, int actPrice, Date actStartTime) {
        this.actName = actName;
        this.actPrice = actPrice;
        this.actStartTime = actStartTime;
    }

    public int getPrice() {
        return actPrice;
    }

    public String getActName() {
        return actName;
    }

    public Date getActStartTime() {
        return actStartTime;
    }
}