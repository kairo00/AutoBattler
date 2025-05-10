package src.jeu.gestions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import src.entitees.Combattant;
import src.jeu.comparateurs.ComparatorVitesse;
/**
 * Représente un combat entre deux équipes.
 * La classe Combat gère le lancement du combat, des manches, ainsi que l'affichage inter manches et à la fin des combats.
 * @author Hugo Marion
 * @author Johan Geyer
 * @version 1.0
 */
public class Combat {
    private Equipe equipe1;
    private Equipe equipe2;

    private int compteurManche=1;
    /**
     * Crée un combat entre deux équipes.
     * @param equipe1 la première équipe
     * @param equipe2 la deuxieme équipe
     */
    public Combat(Equipe equipe1, Equipe equipe2) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;

    }

    /**
     * Lance un combat entre les deux équipes sous forme de manches.
     * Tant que les deux équipes ont des combattants vivants le combat continue.
     * L'écran de victoire est affiché à la fin du combat.
     */
    public void lancerCombat() {
        boolean continuer=true;
        while(equipe1.aDesVivants() && equipe2.aDesVivants() && continuer) {
            lancerManche();
        }
        System.out.println(ecranVictoire()+"\n Appuyer sur n'importe quelles touches pour quitter.");
        
        compteurManche=1;
    }

    /**
     * Lance une manche entre les deux équipes triées par ordre de vitesse décroissante.
     * Les combattants jouent tour a tour tant qu'ils sont en vie, la manche s'arête lorsque tout les combattants ont joué ou qu'une des deux équipes n'a plus de combattants vivants.
     */
    private void lancerManche() {
        System.out.println("Manche "+compteurManche);

            ArrayList<Combattant> attaquantTri = new ArrayList<>();
            for (Combattant c : equipe1.getEquipe()) {
                if (c.estEnVie()) attaquantTri.add(c);
            }
            for (Combattant c : equipe2.getEquipe()) {
                if (c.estEnVie()) attaquantTri.add(c);
            }
            
            Collections.sort(attaquantTri, new ComparatorVitesse());

            for (Combattant attaquant : attaquantTri) {
                if (!attaquant.estEnVie()) continue;
                if (equipe1.aDesVivants() && equipe2.aDesVivants()) {
                    if (equipe1.getEquipe().contains(attaquant)) {
                        attaquant.action(equipe2, equipe1);
                    } else if (equipe2.getEquipe().contains(attaquant)) {
                        attaquant.action(equipe1, equipe2);
                    }
                } else {
                    break;
                }
            }
        System.out.println(resultatManche());
        System.out.println("[Entrer] pour continuer le combat.");
        new Scanner(System.in).nextLine();
        compteurManche++;
    }

    /**
     * Les combattants des deux équipes sont triés par vitesse décroissante.
     * Récupere les pv actuels des combattants dans une chaine de caractère. 
     * @return une chaine de caractère contenant les pv des combattants des deux équipes
     */
    public String resultatManche() {
        Collections.sort(equipe1.getEquipe(), new ComparatorVitesse());
        Collections.sort(equipe2.getEquipe(), new ComparatorVitesse());
        
        String str = "";
        str += "======[Resulat de la manche "+ (compteurManche) + "]======\nEquipe 1:\n";
        for(Combattant c : equipe1.getEquipe()) {
            str += c.toString()+" "+c.estEnVie()+"\n";
        }
        str += "\nEquipe 2:\n";
        for(Combattant c : equipe2.getEquipe()) {
            str += c.toString()+" "+c.estEnVie()+c.getVitesse()+"\n";
        }
        return str;
    }

    /**
     * Gère la victoire de l'équipe 1, de l'équipe 2 et le cas où les deux équipes sont à égalités.
     * @return une chaine de cractère contenant les informations sur les survivants de l'équipe victorieuse.
     */
    public String ecranVictoire() {
        String str = "";
        if(equipe1.aDesVivants()) {
            str += "======[Victoire de l'equipe 1]======\nSurvivant(s):\n";
            for(Combattant c : equipe1.getEquipe()) {
                if(c.estEnVie()) str += c.toString()+"\n";
            }
        } else if(equipe2.aDesVivants()) {
            str += "======[Victoire de l'equipe 2]======\nSurvivant(s):\n";
            for(Combattant c : equipe2.getEquipe()) {
                if(c.estEnVie()) str += c.toString()+"\n";
            }
        } else {
            str = "Egalité";
        }
        return str;
    }
    
}