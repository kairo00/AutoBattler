package jeu.combattants;

import jeu.gestions.Equipe;
/**
 * Classe Berserker qui hérite de Combattant
 * Elle gère les capacités spéciales du combattant Berserker.
 * Capacité spéciale: À son tour, si les PV du berserker sont inférieurs ou égaux à 80 il attaque sa cible une seconde fois
 * @author Hugo Marion
 * @author Johan Geyer
 * @version 1.0
 * @see Combattant
 */
public class Berserker extends Combattant{
   
    /**
     * 
     */
    public Berserker() {
        super(220, 55, 10, 50);
    }

    /**
     * 
     */
    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);

        if(getPV() <= 80 && estEnVie()) {
            adversaire = ennemis.choisirCombattantAleatoire();
            adversaire.prendreDegat(this);
        }
        System.out.println(adversaire.getNom()+"[Equipe "+ennemis.getID()+"] "+" a subit une attaque de "+getNom()+"lui infligeant "+getAttaque()+"de dégats || pv: "+adversaire.getPV()+"/"+adversaire.getPvMax());
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "B["+getPV()+"/"+getPvMax()+"]";
    }

    /**
     * 
     */
    @Override
    public String getNom() {
        return "Berserker";
    }
}