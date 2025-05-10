package src.entitees.miniboss;

import src.entitees.*;
import src.jeu.gestions.*;

public class Herald extends Combattant{
    
    //mini-boss pour le mode alternatif
    public Herald() {
        super(800, 45, 20, 30, 3000);
    }

    /**
     * Les mini-boss attaquent 2 fois
     * @param ennemis que le mini-boss va attaquer
     */
    @Override
    public String toString() {
        return "Herald ["+getPV()+" /"+getPvMax()+"]";
    }

    //Les mini-boss attaquent 2 fois
    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        for(int i = 0; i < 2; i++) {
            adversaire.prendreDegat(this);
            //Affichage de l'attaque effectuée
            System.out.println(getNom() + "["+getId() + "] attaque " + adversaire.getNom()+"["+adversaire.getId()+"]" + " lui infligeant " + Math.max(0, getAttaque()-adversaire.getDefense()) + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax());
        }
    }

    @Override
    public String getNom() {
        return "Herald";
    } 
}
