public class Arrangement {
    private String navn;
    private int billetAntal;
    private Spillested spillested;
    private BandKunstner bandKunstner[];
    private int billetpris;

    public Arrangement(String navn, int billetAntal, Spillested spillested, BandKunstner[] bandKunstner, int billetpris) {
        this.navn = navn;
        this.billetAntal = billetAntal;
        this.spillested = spillested;
        this.bandKunstner = bandKunstner;
        this.billetpris = billetpris;
    }
    public double billetpris(int kapacitet, BandKunstner[] bandKunstnerArray){
        return 0.0;
    }
}
