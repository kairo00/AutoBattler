import java.util.*;

public class Jeu {

    public static void choixCombattant(Equipe equipe, Scanner scanner) {
        int nbCombattant;
        String choix;
        String[] combattants = {"Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier"};

        do {
        equipe.getTeam().clear();
        System.out.println("\n\nChoix pour l'équipe "+equipe.getID());
        for (int i = 0; i < combattants.length; i++) {
            System.out.println("Nombre de " + combattants[i] + " :");
            nbCombattant = scanner.nextInt();
            scanner.nextLine();
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
        if(equipe.getTeam().isEmpty()) {
             System.out.println("Impossible de lancer le combat.\n\t Touche [Entrer] : Refaire son équipe.\n\t Autres touches : quitter la partie.\nChoix :");
            choix = scanner.nextLine();
        } else {
            choix = "quitter boucle";
        }
        }while(choix.isEmpty());
    }   

    public static void choixCombattantPvp(Equipe equipe, Scanner scanner) {
        int choix;
        ArrayList<String> combattants = new ArrayList<>(Arrays.asList("Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier"));
        Collections.shuffle(combattants);

        String [] combattantHasard = {combattants.get(0), combattants.get(1), combattants.get(2)};

        System.out.println("\n\nChoix pour l'équipe "+equipe.getID());
        System.out.println("Choisi parmis les combattants suivant:");
        for(int i = 0; i<3;i++) {
            System.out.println((i+1)+". "+combattantHasard[i]);
        }

        choix = saisieMenu(scanner, 1, 3);
        scanner.nextLine();
        switch (combattantHasard[choix-1]) {
            case "Paladin": equipe.getTeam().add(new Paladin()); break;
            case "Berserker": equipe.getTeam().add(new Berserker()); break;
            case "Mage": equipe.getTeam().add(new Mage()); break;
            case "Archer": equipe.getTeam().add(new Archer()); break;
            case "Voleur": equipe.getTeam().add(new Voleur()); break;
            case "Guerrier": equipe.getTeam().add(new Guerrier());
        }
    }

    public static void choixCombattantOrdi(Equipe equipe) {
        String[] combattants = {"Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier"};
        int r = (int) (Math.random()*combattants.length);
        switch (combattants[r]) {
            case "Paladin": equipe.getTeam().add(new Paladin()); break;
            case "Berserker": equipe.getTeam().add(new Berserker()); break;
            case "Mage": equipe.getTeam().add(new Mage()); break;
            case "Archer": equipe.getTeam().add(new Archer()); break;
            case "Voleur": equipe.getTeam().add(new Voleur()); break;
            case "Guerrier": equipe.getTeam().add(new Guerrier());
        }
        System.out.println("[🤖] À choisi "+combattants[r]);
    }

    public static void afficherMenu() {
        return;
    }

    public static int saisieMenu(Scanner scanner, int min, int max) {
        int choix;
        do {
            System.out.println("Choix ?");
            choix = scanner.nextInt();
        }while(choix < min || choix > max);
        return choix;
    }

    public static boolean demanderQuitter(Scanner scanner) {
        char choix;
        do {
            System.out.println("Voulez-vous quitter la partie ? [y/n]");
            choix = scanner.nextLine().charAt(0);
        }while (choix != 'y' && choix != 'n' && choix != 'Y' && choix != 'N');
        return (choix == 'n' || choix == 'N');
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Equipe equipe1 = new Equipe();
        Equipe equipe2 = new Equipe();
        Combat arene = new Combat(equipe1, equipe2, scanner);
        final int TEST=1, PVP=2, PVE=3, QUITTER = 4, TEAM_SIZE=5;

        /*
         *  Temporaire
         *  Espace de test pour nos méthodes.
         */

        boolean partieLance;
        int choix = 0;
        while(true) {

            //Affichage fct
            System.out.println("1. Mode Test 🧪");
            System.out.println("2. Mode PVP ( 🚧 En construction...)");
            System.out.println("3. Mode PVE 🤖");
            System.out.println("4. Quitter 🚪");
            
            //Saisie utilisateur fct
            choix = saisieMenu(scanner, 1, 4);


            if (choix == TEST) {
                partieLance=true;
                choixCombattant(equipe1, scanner);
                if(equipe1.getTeam().isEmpty()) continue;
                choixCombattant(equipe2, scanner);
                if(equipe2.getTeam().isEmpty()) continue;
                arene.lancerCombat();
            } else if(choix == PVP) {
                equipe1.getTeam().clear();
                equipe2.getTeam().clear();
                for(int i = 0;i<(TEAM_SIZE*2);i++) {
                    if(i%2==0) choixCombattantPvp(equipe1, scanner);
                    else choixCombattantPvp(equipe2, scanner);
                }
                partieLance=true;
                while(partieLance) {
                    arene.lancerCombat();
                    partieLance=false;
                }
            } else if(choix == PVE) {
                equipe1.getTeam().clear();
                equipe2.getTeam().clear();
                for(int i = 0;i<(TEAM_SIZE*2);i++) {
                    if(i%2==0) choixCombattantPvp(equipe1, scanner);
                    else choixCombattantOrdi(equipe2);
                }
                partieLance=true;
                while(partieLance) {
                    arene.lancerCombat();
                    partieLance=false;
                }
            } else if (choix == QUITTER) break;
        }
        scanner.close();
    }
}
