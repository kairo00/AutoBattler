package src.entitees.combattants;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

public class Paladin extends Combattant {

    /**
     * Création du paladin
     */
    public Paladin() {
        super(200, 45, 25, 10, 110);
    }

    /**
     * Le paladin se soigne pendant son tour (donc lorsqu'il attaque)
     * @param ennemis cible aléatoire choisie parmi les combattants adverses
     */
    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        adversaire.prendreDegat(this);

        //Si les pv sont en dessous ou égaux à 190 le paladin se soigne de 10
        if(getPV() <= 190) {
            regenererPV(10);
        }
        //Sinon il se soigne jusqu'à atteindre la valeur des ses pv max
        if(getPV() > 190) {
            regenererPV(200-getPV());
        }
        //Affichage des dégâts infligés ainsi que les pv de l'adversaire
        System.out.println(getNom() + "["+getId() + "] attaque " + adversaire.getNom()+"["+adversaire.getId()+"]" + " lui infligeant " + Math.max(0, getAttaque()-adversaire.getDefense()) + " de dégats || pv: " + adversaire.getPV() + "/" + adversaire.getPvMax());
    }

    @Override
    public String toString() {
        return "P["+getPV()+"/"+getPvMax()+"]";
    }

    @Override
    public String getNom() {
        return "Paladin";
    }
}
