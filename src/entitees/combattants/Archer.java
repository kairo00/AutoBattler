package src.entitees.combattants;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

public class Archer extends Combattant {

    /**
     * Création de l'archer
     */
    public Archer() {
        super(170, 55, 5, 60, 100);
    }

    /**
     * L'archer choisit le combattant le plus faible
     * @param ennemis cible avec le moins de pv choisie parmis les combattant
     */
    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantFaible();
        adversaire.prendreDegat(this);
    }

    @Override
    public String toString() {
        return "A["+getPV()+"/"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "Archer";
    }
}
