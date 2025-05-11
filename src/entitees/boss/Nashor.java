package src.entitees.boss;

import src.entitees.Combattant;
import src.jeu.gestions.*;

/**
 * Classe représentant le boss Nashor
 * Capacité spéciale: Attaque 4 fois
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 * @see Combattant
 */
public class Nashor extends Combattant{
    //Boss pour le mode alternatif
    public Nashor() {
        super(1600, 45, 20, 30, 3000);
    }
    
    /**
     * Les boss attaquent 4 fois
     * @param ennemie que le mini-boss va attaquer
     */
    @Override
    public void attaquer(Equipe ennemie, Equipe alliee) {
        Combattant adversaire = ennemie.choisirCombattantAleatoire();
        for(int i = 0; i < 4; i++) {
            adversaire.prendreDegat(this);
        }
         //Affichage de l'attaque effectuée
        System.out.println("🧌 [Boss]  " + getNom() + "[Equipe " + alliee.getID() + "] attaque 4 fois " + adversaire.getNom() + "[Equipe " + ennemie.getID() + "] et lui inflige " + Math.max(0, getAttaque() - adversaire.getDefense()) + " dégât(s) || PV cible : " + adversaire.getPV() + "/" + adversaire.getPvMax());
    }

    @Override
    public String toString() {
        return "Nashor["+getPV()+"/"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "Nashor";
    } 
    
}
