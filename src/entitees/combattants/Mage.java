package src.entitees.combattants;
import src.entitees.Combattant;

public class Mage extends Combattant {

    /**
     * Création du mage
     */
    public Mage() {
        super(160, 70, 0, 30, 80);
    }

    /**
     * Le mage ignore l'armure
     * @param cible la personne que le mage va attaquer
     */
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