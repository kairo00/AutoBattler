package src.entitees.combattants;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

/**
 * Classe représentant le paladin.
 * Capacité spéciale: Regénération de 10 PV lorsque c'est son tour
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 * @see Combattant
 */
public class Paladin extends Combattant {
    /**
     * Création du paladin
     */
    public Paladin() {
        super(200, 45, 25, 10, 110);
    }

    /**
     * Le paladin se soigne pendant son tour (donc lorsqu'il attaque)
     * @param ennemie cible aléatoire choisie parmi les combattants adverses
     */
    @Override
    public void attaquer(Equipe ennemie, Equipe alliee) {
        Combattant adversaire = ennemie.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);

//Si les pv sont en dessous ou égaux à 190 le paladin se soigne de 10
        if(getPV() <= 190) {
            regenererPV(10);
            System.out.println("🔮 [Capacité spécial] Le paladin[Equipe " + alliee.getID() + "] se soigne de 10 PV ! || PV paladin : " + getPV() + "/" + getPvMax());
        }
        //Sinon il se soigne jusqu'à atteindre la valeur des ses pv max
        if(getPV() > 190) {
            regenererPV(200-getPV());
        }
        //Affichage des dégâts infligés ainsi que les pv de l'adversaire
        System.out.println("🗡️  " + getNom() + "[Equipe " + alliee.getID() + "] attaque " + adversaire.getNom() + "[Equipe " + ennemie.getID() + "] et lui inflige " + Math.max(0, getAttaque() - adversaire.getDefense()) + " dégât(s) || PV cible : " + adversaire.getPV() + "/" + adversaire.getPvMax());
    }


    /**
     * 
     */
    @Override
    public String toString() {
        return "P["+getPV()+"/"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "Paladin";
    }
}
