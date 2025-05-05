import java.util.Scanner;

public class JeuAlternatif {

    public static void choixCombattant(Equipe equipe, Scanner scanner) {
        int nbCombattant;
        String[] combattants = {"Paladin", "Berserker", "Mage", "Archer", "Voleur", "Guerrier", "Pretre", "Abomination"};
        System.out.println("Veuillez choisir vos combattants (Max 4)");
        for (int i = 0; i < combattants.length; i++) {
            System.out.println(i+". "+combattants[i]);
        }
        for(int i = 0; i < 4; i++) {
            nbCombattant = scanner.nextInt();
            System.out.println("Vous avez selectionné "+combattants[nbCombattant]+"il vous reste "+i+"choix");
            switch (nbCombattant) {
                case 0: equipe.getTeam().add(new Paladin()); break;
                case 1: equipe.getTeam().add(new Berserker()); break;
                case 2: equipe.getTeam().add(new Mage()); break;
                case 3: equipe.getTeam().add(new Archer()); break;
                case 4: equipe.getTeam().add(new Voleur()); break;
                case 5: equipe.getTeam().add(new Guerrier());break;
                case 6: equipe.getTeam().add(new Pretre());break;
                case 7: equipe.getTeam().add(new Abomination());
                
            }
        }
    }

    public void Mobs(Equipe groupe) {
        int nombre = (int)(6*Math.random());
        int type = (int)(3*Math.random());

        for(int i = 0; i < nombre; i++) {
            switch(type) {
                case 0 : groupe.getTeam().add(new Diablotin()); break;
                case 1 : groupe.getTeam().add(new Cultist()); break;
                case 2 : groupe.getTeam().add(new Demon()); break;
            }
        }
    }

    public void prochainEvent(Equipe equipe) {
        
        int seed = (int)(2*Math.random());
        switch(seed) {
            case 0 :
                Equipe mobs = new Equipe();
                Mobs(mobs);
                Combat arene = new Combat(equipe, mobs);
                arene.lancerCombat();
                break;
            case 1: 
                repos(equipe);
        }
    }

    public void repos(Equipe equipe) {
        for(Combattant i : equipe.getTeam()) {
            i.regenererPV(50);
        }
    }

    public void boucleDeJeu(Scanner scanner, Equipe equipe, Inventaire inventaire) {
        while (true) { 
            
            System.out.println("1. Prochain event");
            System.out.println("2. Inventaire");
            System.out.println("3. Status de l'equipe");
            int choix = scanner.nextInt();
                switch(choix) {
                    case 1 : prochainEvent(equipe); break;
                    case 2 : inventaire.ouvrirInventaire(); break;
                    case 3 : equipe.toString();
                }
            System.out.println("");
        }
        
    }

    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        Equipe equipe = new Equipe();
        Equipe mobs = new Equipe();

        choixCombattant(equipe, scanner);

    }
}