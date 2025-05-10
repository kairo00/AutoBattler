package src.entitees.combattants;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

/**
 * Classe représentant le mage.
 * Capacité spéciale: Ignore l'armure de la cible.
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 * @see Combattant
 */
public class Mage extends Combattant {

    /**
     * Creation d'un mage
     */
    public Mage() {
        super(160, 70, 0, 30, 80);
    }

    /**
     * Le mage ignore l'armure
     * @param cible la personne que le mage va attaquer
     */
    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        System.out.println(adversaire.getPV());
        adversaire.prendreDegat(this);
        System.out.println(adversaire.getNom()+" degat subit: "+getAttaque()+" pv: "+adversaire.getPV()+"/200");
    }

    @Override
    public int calculerDegat(Combattant cible) {
        return getAttaque();
    }

    @Override
    public String toString() {
        return "M["+getPV()+"/"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "Mage";
    }
}