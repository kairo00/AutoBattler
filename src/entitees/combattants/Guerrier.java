package src.entitees.combattants;

import src.entitees.Combattant;

public class Guerrier extends Combattant{
    
    /**
     * Création du guerrier
     */
    public Guerrier() {
        super(220, 30, 25, 20, 110);
    }  
    
    /**
     * Le Guerrier à une chance de lancer une contre-attaque lorsqu'il est touché
     * @param cible la personne qui à attaqué le guerrier en dernier
     */
    @Override
    public void prendreDegat(Combattant cible) {
        //Tirage au sort pour savoir si le guerrier contre-attaque
        int r = (int)(Math.random()*10);
        super.prendreDegat(cible);
        //Si le tirage est inferieur à 6 le guerrier effectue une contre-attaque
        if(r < 6) {
            cible.prendreDegat(this);
            //Affichage de la contre-attaque et des dégâts infligés
            System.out.println("Le Guerrier ["+getId()+"] contre-attaque et inflige "+Math.max(0, getAttaque()-cible.getDefense())+" de dégats à "+cible.getNom()+" || pv : "+cible.getPV()+"/"+getPvMax());
        }
    }

    @Override
    public String toString() {
        return "G["+getPV()+"/"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "Guerrier";
    }
}
