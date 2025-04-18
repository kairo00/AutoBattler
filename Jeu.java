import java.util.*;

public class Jeu {

    public static void choixCombattant(Equipe equipe, Scanner scanner) {
        int nbCombattant;
        Combattant [] typeCombattant = {new Paladin(), new Berserker(), new Mage(), new Archer(), new Voleur(), new Guerrier()};

        System.out.println("\nChoix des combattants pour l'équipe "+equipe.getID()+" :");
        for(Combattant c : typeCombattant) {
            System.out.println("Nombre de "+c.getNom()+":");
            nbCombattant = scanner.nextInt();
            for(int i = 0; i<nbCombattant;i++) {
                equipe.getTeam().add(c);
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
