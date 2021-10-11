import java.util.Date;

public class BandKunstner {
    private String navn;
    private int pris;
    private Date spilletidspunkt;

    public BandKunstner(String navn, int pris, Date spilletidspunkt) {
        this.navn = navn;
        this.pris = pris;
        this.spilletidspunkt = spilletidspunkt;
    }

    @Override
    public String toString() {
        return "BandKunstner{" +
                "navn='" + navn + '\'' +
                ", pris=" + pris +
                ", spilletidspunkt=" + spilletidspunkt +
                '}';
    }
}
