public class Aapning extends HvitRute {
    
    public Aapning(int r, int k, Labyrint l) {
        super(r, k, l);
    }

    @Override
    public void finn(Rute fra) {
        if (fra != null) {
            System.out.println("Aapning: (" + hentRad() + "," + hentKolonne() +")"); //Dette er basecaset.
        }

        for (Rute nabo: naboer) {
            if(nabo != null && nabo != fra) {
                nabo.finn(this);
            }
        }
    }

    @Override
    public String toString() {
        return ".";
    }
}
