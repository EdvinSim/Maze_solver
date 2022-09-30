public class HvitRute extends Rute {

    public HvitRute(int r, int k, Labyrint l) {
        super(r, k, l);
    }

    @Override
    public void finn(Rute fra) {
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
