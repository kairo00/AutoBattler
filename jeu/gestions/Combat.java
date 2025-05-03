package jeu.gestions;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

import jeu.Jeu;
import jeu.combattants.Combattant;
import jeu.comparateurs.ComparatorVitesse;
/**
 * Représente un combat entre deux équipes.
 * La classe Combat gère le lancement du combat, des manches, ainsi que l'affichage inter manches et à la fin des combats.
 * @author Hugo Marion
 * @author Johan Geyer
 * @version 1.0
 */
public class Combat {
    private Equipe equipe_1;
    private Equipe equipe_2;
    Scanner scanner;

    private int cpt_manche=1;
    /**
     * Crée un combat entre deux équipes.
     * @param equipe_1 la première équipe
     * @param equipe_2 la deuxieme équipe
     * @param scanner permettant la saisie utilisateur
     */
    public Combat(Equipe equipe_1, Equipe equipe_2, Scanner scanner) {
        this.equipe_1 = equipe_1;
        this.equipe_2 = equipe_2;
        this.scanner = scanner;
    }

    /**
     * Lance un combat entre les deux équipes sous forme de manches.
     * Tant que les deux équipes ont des combattants vivants le combat continue.
     * L'écran de victoire est affiché à la fin du combat.
     */
    public void lancerCombat() {
        boolean continuer=true;
        while(equipe_1.aDesVivants() && equipe_2.aDesVivants() && continuer) {
            lancerManche();
            continuer = Jeu.demanderQuitter(scanner);
        }
        if (continuer) { 
            System.out.println(ecranVictoire()+"\n Appuyer sur n'importe quelles touches pour quitter.");
            scanner.nextLine();
        }
        cpt_manche=1;
    }

    /**
     * Lance une manche entre les deux équipes triées par ordre de vitesse décroissante.
     * Les combattants jouent tour a tour tant qu'ils sont en vie, la manche s'arête lorsque tout les combattants ont joué ou qu'une des deux équipes n'a plus de combattants vivants.
     */
    private void lancerManche() {
        System.out.println("Manche "+cpt_manche);

            ArrayList<Combattant> attaquantTri = new ArrayList<>();
            for (Combattant c : equipe_1.getEquipe()) {
                if (c.estEnVie()) attaquantTri.add(c);
            }
            for (Combattant c : equipe_2.getEquipe()) {
                if (c.estEnVie()) attaquantTri.add(c);
            }
            
            Collections.sort(attaquantTri, new ComparatorVitesse());

            for (Combattant attaquant : attaquantTri) {
                if (equipe_1.getEquipe().contains(attaquant)) {
                    attaquant.attaquer(equipe_2);
                    if (!equipe_1.aDesVivants() || !equipe_2.aDesVivants()) break;
                } else if(equipe_2.getEquipe().contains(attaquant)) {
                    attaquant.attaquer(equipe_1);
                    if (!equipe_1.aDesVivants() || !equipe_2.aDesVivants()) break;
                } else {
                    break;
                }
        }
        System.out.println(resultatManche());
        cpt_manche++;
    }

    /**
     * Les combattants des deux équipes sont triés par vitesse décroissante.
     * Récupere les pv actuels des combattants dans une chaine de caractère. 
     * @return une chaine de caractère contenant les pv des combattants des deux équipes
     */
    public String resultatManche() {
        Collections.sort(equipe_1.getEquipe(), new ComparatorVitesse());
        Collections.sort(equipe_2.getEquipe(), new ComparatorVitesse());
        
        String str = "";
        str += "======[Resulat de la manche "+ (cpt_manche) + "]======\nEquipe 1:\n";
        for(Combattant c : equipe_1.getEquipe()) {
            str += c.toString()+" "+c.estEnVie()+"\n";
        }
        str += "\nEquipe 2:\n";
        for(Combattant c : equipe_2.getEquipe()) {
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
        if(equipe_1.aDesVivants()) {
            str += "======[Victoire de l'equipe 1]======\nSurvivant(s):\n";
            for(Combattant c : equipe_1.getEquipe()) {
                if(c.estEnVie()) str += c.toString()+"\n";
            }
        } else if(equipe_2.aDesVivants()) {
            for(Combattant c : equipe_2.getEquipe()) {
                if(c.estEnVie()) str += c.toString()+"\n";
            }
        } else {
            str = "Egalité";
        }
        return str;
    }
    
}