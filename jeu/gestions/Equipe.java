package jeu.gestions;
import java.util.List;

import jeu.combattants.Combattant;
import jeu.comparateurs.ComparatorVie;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Cette classe représente les équipes de combattants.
 * La classe Equipe gère la séléction de combattants selon certains critère et permet d'obtenir des informations sur les combattants d'une équipe.
 * @author Hugo Marion
 * @author Johan Geyer
 * @version 1.0
 */
public class Equipe {
    private List<Combattant> equipe;
    
    /*Compteur statique comptant le nombre d'équipes crées */
    private static int nbEquipe=1;
    private int id;

    /**
     * Créé une équipe de combattant(s)
     */
    public Equipe() {
        this.equipe = new ArrayList<Combattant>();
        this.id = nbEquipe++;
    }

    /**
     * Choisi aléatoirement un combattant parmis les combattants de l'équipe encore en vie.
     * @return un combattant
     */
    public Combattant choisirCombattantAleatoire() {
        int indexHasard;
        do {
            indexHasard = (int) (Math.random()*equipe.size());
        } while(!equipe.get(indexHasard).estEnVie());
        
        return equipe.get(indexHasard);
    }

    /**
     * Choisi le combattant de l'equipe avec le plus faible niveau de PV.
     * @return un combattant de l'équipe courante
     */
    public Combattant choisirCombattantFaible() {
        Collections.sort(equipe, new ComparatorVie());
        return equipe.get(equipe.size()-1);
    }

    /**
     * Permet de savoir si une équipe à encore des combattants vivants.
     * @return un booléen, true s'il y a des vivant, false sinon
     */
    public boolean aDesVivants() {
        for(int i = 0;i<equipe.size();i++) {
            if(equipe.get(i).estEnVie()) return true;
        }
        return false;
    }

    /* Getteurs */
    public List<Combattant> getEquipe() {
        return equipe;
    }

    public int getID() {
        return id;
    }
}