import java.util.Date;

public class Act {
    private String actName;
    private int actPrice;
    private Date actStartTime;

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
