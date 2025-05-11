package src.entitees.combattants;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

/**
 * Classe représentant l'abomination.
 * capacité spéciale: attaque 
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
     * @param ennemie cible aléatoire choisie parmis les combattant
     */
    @Override
    public void attaquer(Equipe ennemie, Equipe alliee) {
        Combattant adversaire = ennemie.choisirCombattantAleatoire();
        //regeneration de pv a chaque coup
        regenererPV(5);
        if(getCourage() > 0) {
            adversaire.prendreDegat(this);
            System.out.println("🗡️  " + getNom() + "[Equipe " + alliee.getID() + "] attaque " + adversaire.getNom() + "[Equipe " + ennemie.getID() + "] et lui inflige " + Math.max(0, getAttaque() - adversaire.getDefense()) + " dégât(s) || PV cible : " + adversaire.getPV() + "/" + adversaire.getPvMax());
        }
        if(getCourage() > -10) {
            adversaire.prendreDegat(this);
            adversaire.prendreDegat(this);
            System.out.println("🗡️ [Attaque 2 fois] " + getNom() + "[Equipe " + alliee.getID() + "] attaque " + adversaire.getNom() + "[Equipe " + ennemie.getID() + "] et lui inflige " + Math.max(0, getAttaque() - adversaire.getDefense()) + " dégât(s) || PV cible : " + adversaire.getPV() + "/" + adversaire.getPvMax());
        }else{
            if(getCourage() > -20) {
                adversaire.prendreDegat(this);
                adversaire.prendreDegat(this);
                System.out.println("🗡️ [Attaque 2 fois] " + getNom() + "[Equipe " + alliee.getID() + "] attaque " + adversaire.getNom() + "[Equipe " + ennemie.getID() + "] et lui inflige " + Math.max(0, getAttaque() - adversaire.getDefense()) + " dégât(s) || PV cible : " + adversaire.getPV() + "/" + adversaire.getPvMax());
            }else{
                if(getCourage() > -30) {
                    adversaire.prendreDegat(this);
                    adversaire.prendreDegat(this);
                    adversaire.prendreDegat(this);
                    adversaire.prendreDegat(this);
                    System.out.println("🗡️ [Attaque 4 fois] " + getNom() + "[Equipe " + alliee.getID() + "] attaque " + adversaire.getNom() + "[Equipe " + ennemie.getID() + "] et lui inflige " + Math.max(0, getAttaque() - adversaire.getDefense()) + " dégât(s) || PV cible : " + adversaire.getPV() + "/" + adversaire.getPvMax());
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