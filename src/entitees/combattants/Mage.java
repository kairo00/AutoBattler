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
    public void attaquer(Equipe ennemie, Equipe alliee) {
        Combattant adversaire = ennemie.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);
        System.out.println("🧙‍♂️ [Capacité spécial]"+getNom() +"[Equipe "+alliee.getID()+"] Jette un sort... "+ adversaire.getNom()+ "[Equipe "+ennemie.getID()+"] se retrouve sans défense durant l'attaque du "+getNom());
        System.out.println("🗡️ " + getNom() + "[Equipe " + alliee.getID() + "] attaque " + adversaire.getNom() + "[Equipe " + ennemie.getID() + "] et lui inflige " + Math.max(0, getAttaque() - adversaire.getDefense()) + " dégât(s) || PV cible : " + adversaire.getPV() + "/" + adversaire.getPvMax());
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