import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Labyrint {

    Rute[][] labyrint;

    //Del B
    public Labyrint(String filnavn) {

    //Leser fra fil og kontruerer labyrinten
        try {
            File fil = new File(filnavn);
            Scanner sc = new Scanner(fil);

            int antRader = sc.nextInt(); //Horisontalt
            int antKolonner = sc.nextInt(); //Vertikalt
            sc.nextLine();//Hopper til neste linje.
            labyrint = new Rute[antRader][antKolonner];
            int radIndex = 0;

            while(sc.hasNextLine()) {

                String[] radStreng = sc.nextLine().strip().split("");
                int kolonneIndex = 0;

                for (String rute: radStreng) {
                    if (rute.equals(".")) {
                        //Hvis det er en Aapning.
                        if (radIndex == 0 || radIndex == antRader-1 || kolonneIndex == 0 || kolonneIndex == antKolonner-1) {
                            labyrint[radIndex][kolonneIndex] = new Aapning(radIndex, kolonneIndex, this);
                        }
                        else {
                            labyrint[radIndex][kolonneIndex] = new HvitRute(radIndex, kolonneIndex, this);
                        }
                    }
                    else if (rute.equals("#")){
                        labyrint[radIndex][kolonneIndex] = new SortRute(radIndex, kolonneIndex, this);
                    }
                    else {
                        System.out.println("Ugyldig symbol i filen!");
                        System.exit(1);
                    }
                    kolonneIndex++;
                }
                radIndex++;
            }

            sc.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen :( Husk aa skrive filnavn som parameter.");
            System.exit(1);
        }

        //Setter naboer
        for (Rute[] linje: labyrint) {
            for (Rute rute: linje) {
                int rad = rute.hentRad();
                int kolonne = rute.hentKolonne();

                Rute nord, syd, vest, oest;

                if (0 <= rad-1 && rad-1 < labyrint.length) { //Hvis naboindex er gyldig.
                    nord = labyrint[rad-1][kolonne];
                } else {
                    nord = null; //TODO er dette nodvendig eller peker den paa null fra foer? I saa fall maa jeg gjorde det paa alle if sjekkene.
                }
                if (0 <= rad+1 && rad+1 < labyrint.length) {
                    syd = labyrint[rad+1][kolonne];
                } else {
                    syd = null;
                }
                if (0 <= kolonne-1 && kolonne-1 < linje.length) {
                    vest = labyrint[rad][kolonne-1];
                } else {
                    vest = null;
                }
                if (0 <= kolonne+1 && kolonne+1 < linje.length) {
                    oest = labyrint[rad][kolonne+1];
                } else {
                    oest = null;
                }
                
                rute.settNaboer(nord, syd, vest, oest);
            }
        }
    }

    public void finnUtveiFra(int rad, int kol) {
        try {
            System.out.println("Start: " + "("+ rad + "," + kol + ")");
            labyrint[rad][kol].finn(null);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Koordinat finnes ikke!");
        }
    }

    public String toString() {

        System.out.print("\t");
        for (int kolNr = 0 ; kolNr < labyrint[0].length; kolNr++) {
            if (kolNr < 10) {
                System.out.print(kolNr + " ");
            } else {
            System.out.print(kolNr);
            }
        }

        String streng = "\n";
        int radNr = 0;

        for (Rute[] rad: labyrint) {
            streng += "\n" + radNr + "\t";
            for (Rute rute: rad) {
                streng += rute + " ";
            }
            radNr++;
        }
        return streng;
    }

}