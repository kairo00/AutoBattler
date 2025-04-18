import java.util.*;

public class Jeu {

    public static void choixCombattant(Equipe equipe, Scanner scanner) {
        int nbCombattant;
        String[] combattants = {"Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier"};
        for (int i = 0; i < combattants.length; i++) {
            System.out.println("Nombre de " + combattants[i] + " :");
            nbCombattant = scanner.nextInt();
            for (int j = 0; j < nbCombattant; j++) {
                switch (i) {
                    case 0: equipe.getTeam().add(new Paladin()); break;
                    case 1: equipe.getTeam().add(new Berserker()); break;
                    case 2: equipe.getTeam().add(new Mage()); break;
                    case 3: equipe.getTeam().add(new Archer()); break;
                    case 4: equipe.getTeam().add(new Voleur()); break;
                    case 5: equipe.getTeam().add(new Guerrier());
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();
        Combat arene = new Combat(equipe1, equipe2);
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
                choixCombattant(equipe1, scanner);
                choixCombattant(equipe2, scanner);
                arene.lancerCombat();
                jeuLance = false;
            }
        }
        scanner.close();
    }
}
