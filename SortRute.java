public class SortRute extends Rute {
    
    public SortRute(int r, int k, Labyrint l) {
        super(r, k, l);
    }

    @Override
    public void finn(Rute fra) {
        if (fra == null) { //Dette skjer bare hvis start er x.
            System.out.println("Dette er ikke en aapen rute.");
            return;
        }
        //Siden sort rute er en X skal den ikke kalle paa noe videre.
    }

    @Override
    public String toString() {
        return "#";
    }
}
