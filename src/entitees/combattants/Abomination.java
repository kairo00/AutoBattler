package src.entitees.combattants;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

/**
 * Classe représentant l'abomination.
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 * @see Combattant
 */
public class Abomination extends Combattant {
    /**
     * Création de l'abomination
     */
    public Abomination() {
        super(200, 30, 20, 20, 80);
    }

    /**
     * Le nombre d'attaques évolue en fonction du courage plus la ressource est basse plus il attaque
     * @param ennemis cible aléatoire choisie parmis les combattant
     */
    @Override
    public void attaquer(Equipe ennemis) {
        Combattant adversaire = ennemis.choisirCombattantAleatoire();
        //regeneration de pv a chaque coup
        regenererPV(5);
        if(getCourage() > 0) {
            adversaire.prendreDegat(this);
        }
        if(getCourage() > -10) {
            adversaire.prendreDegat(this);
            adversaire.prendreDegat(this);
        }else{
            if(getCourage() > -20) {
                adversaire.prendreDegat(this);
                adversaire.prendreDegat(this);
            }else{
                if(getCourage() > -30) {
                    adversaire.prendreDegat(this);
                    adversaire.prendreDegat(this);
                    adversaire.prendreDegat(this);
                    adversaire.prendreDegat(this);
                }
            
            }
        }
    }   

    @Override
    public String getNom() {
        return "Abomination";
    }

    @Override
    public String toString() {
        return "Ab["+getPV()+"/"+getPvMax()+"]";
    }
}