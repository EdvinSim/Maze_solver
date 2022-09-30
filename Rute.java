abstract class Rute {
    
    int rad; //Horisontalt
    int kolonne; //Vertikalt
    Labyrint labyrint;
    Rute[] naboer = new Rute[4]; //En array med 4 plasser: nord, syd, vest, oest.

    public Rute(int r, int k, Labyrint l) {
        rad = r;
        kolonne = k;
        labyrint = l;
    }

    public void settNaboer(Rute nord, Rute syd, Rute vest, Rute oest) {
        naboer[0] = nord;
        naboer[1] = syd;
        naboer[2] = vest;
        naboer[3] = oest;
    }
    
    public int hentRad() {
        return rad;
    }

    public int hentKolonne() {
        return kolonne;
    }

    abstract void finn(Rute fra);

}
