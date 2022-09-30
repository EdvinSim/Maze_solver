
import java.util.Scanner;

public class Oblig6 {
    
    public static void main(String[] args) {

        //TODO evt put i try/catch hvis man ikke skriver filnavn.
        try {
            Labyrint lab = new Labyrint(args[0]);
            System.out.println(lab);

            int valg = 0;
            Scanner sc = new Scanner(System.in);
            
            while(valg != -1) {
                System.out.println("\nSkriv inn startkoordinater. rad mellomrom kolonne: (-1 for avslutt)");
                
                try {
                    String input = sc.nextLine();
                    String[] oppdelt = input.strip().split(" ");

                    int rad = Integer.parseInt(oppdelt[0]);
                    if (rad == -1) return; //Avslutte program.
                    int kolonne = Integer.parseInt(oppdelt[1]);
                    valg = rad;
                    lab.finnUtveiFra(rad, kolonne);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ugyldig input!");
                }
            }

            sc.close();
        
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Skriv filnavn!");
        } 
    }
}
