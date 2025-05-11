package src.entitees.combattants;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

/**
 * Classe représenantant un archer
 * Capacité speciale: Attaquer l'adversaire le plus faible faible
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 * @see Combattant
 */
public class Archer extends Combattant {

    /**
     * Création de l'archer
     */
    public Archer() {
        super(170, 55, 5, 60, 100);
    }

    /**
     * L'archer attaque le combattant le plus faible de l'équipe adverse
     * @param ennemie cible choisie parmis les combattant
     */
    @Override
    public void attaquer(Equipe ennemie, Equipe alliee) {
        Combattant adversaire = ennemie.choisirCombattantFaible();
        adversaire.prendreDegat(this);
        System.out.println("🗡️  " + getNom() + "[Equipe " + alliee.getID() + "] attaque " + adversaire.getNom() + "[Equipe " + ennemie.getID() + "] et lui inflige " + Math.max(0, getAttaque() - adversaire.getDefense()) + " dégât(s) || PV cible : " + adversaire.getPV() + "/" + adversaire.getPvMax());
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
