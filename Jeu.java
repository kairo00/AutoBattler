import java.util.Scanner;

public class Jeu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         *  Temporaire
         *  Espace de test pour nos méthodes.
         */

        boolean jeuLance=true, modePvp=false, modeTest=false;
        int choix = 0;
        while(jeuLance) {
            while(jeuLance && (!modePvp) && (!modeTest)) {
                
                //Affichage
                System.out.println("1. Mode Test 🧪");
                System.out.println("2. Mode PVP ( 🚧 En construction...)");
                System.out.println("3. Quitter 🚪");
                
                //Saisie utilisateur
                do {
                System.out.println("Choix ?");
                choix = scanner.nextInt();
                }while(choix < 1 || choix > 3);
                
                switch(choix) {
                    case 1: modeTest = true; break;
                    case 2: modePvp = true; break;
                    default: jeuLance = false;
                }
            }

            while(jeuLance && modeTest) {
                /*
                 * Voir avec johan comment faire
                 */
            }
        }
        scanner.close();
    }
}
