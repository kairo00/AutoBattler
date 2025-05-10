package src.entitees.combattants;

import src.entitees.Combattant;

public class Voleur extends Combattant{
    
    /**
     * Création du voleur
     */
    public Voleur() {
        super(145, 45, 20, 40,100);
    }

    /**
     * Le voleur à 50% de chance d'esquiver
     * @return true si le voleur esquive sinon false
     */
    @Override
    public boolean activerEsquive() {
        //Tirage au sort pour l'esquive
        int r = (int)(2*Math.random());
        return r == 1;
    }

    @Override
    public String toString() {
        return "V["+getPV()+"/"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "Voleur";
    }
}
