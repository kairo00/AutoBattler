package src.entitees.boss;

import src.entitees.Combattant;
import src.jeu.gestions.*;

public class Monika extends Combattant {

    //Boss pour le mode alternatif
    public Monika() {
        super(1600, 45, 20, 30, 3000);
    }

    /**
     * Les boss attaquent 4 fois
     * @param ennemis que le mini-boss va attaquer
     */
    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        for(int i = 0; i < 4; i++) {
            adversaire.prendreDegat(this);
            //Affichage de l'attaque effectuée
            System.out.println(getNom() + "["+getId() + "] attaque " + adversaire.getNom()+"["+adversaire.getId()+"]" + " lui infligeant " + Math.max(0, getAttaque()-adversaire.getDefense()) + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax());
        }
    }

    @Override
    public String toString() {
        return "Monika["+getPV()+"/"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "Monika";
    } 
    
    
}
