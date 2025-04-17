import java.util.*;

public class Jeu {

    public static void choixCombattant(Equipe equipe) {
        int nbCombattant;
        Combattant [] typeCombattant = {new Paladin(), new Berserker(), new Mage(), new Archer(), new Voleur(), new Guerrier()};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choix des combattants :");
        for(Combattant c : typeCombattant) {
            System.out.println("Nombre de "+c.toString()+":");
            nbCombattant = scanner.nextInt();
            for(int i = 0; i<nbCombattant;i++) {
                equipe.Add(c);
            }
        }
        

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();
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
                 * 
                 */
                choixCombattant(equipe1);
                choixCombattant(equipe2);
                jeuLance = false;
            }
        }
        scanner.close();
    }
}
