package src.entitees.combattants;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

/**
 * Classe représentant le prêtre.
 * Capacité spéciale: peut soigner un allié ou ressucite un allié mort.
 * @author Johan Geyer
 * @author Hugo Marion
 * @version 1.0
 * @see Combattant
 */
public class Pretre extends Combattant{

    /**
     * Création du prêtre
     */
    public Pretre() {
        super(160, 35, 20, 20, 80);
    }
    
    /**
     * Le prêtre peut soigner pendant son tour
     * @param cible cible aléatoire choisie parmi les combattants alliés
     */
    public void soin(Equipe cible) {
        //Le prêtre choisit un allié aléatoire à soigner
        Combattant allie = cible.choisirCombattantAleatoire();
        int pv = allie.getPV();
        //valeur que le prêtre va régénerer
        int regeneration = 30;
        //Condition pour éviter que le prêtre soigne au dela de la vie max
        int seuil = allie.getPvMax()- regeneration;
        //Si les pv de l'allié sont inférieurs au seuil alors le prêtre restaure 30 pv
        if(pv <= seuil) {
            regenererPV(30);
            System.out.println("💞 Le pretre soigne "+allie.getNom()+" de 30 pv");
        }
        //Sinon il le soigne jusqu'à atteindre ses pv max
        if(pv > seuil) {
            regenererPV(allie.getPvMax()-pv);
            System.out.println("💞 Le pretre soigne "+allie.getNom()+" de 30 pv");
        }
    }

    /**
     * Le prêtre doit choisir entre deux actions soigner ou attaquer
     * @param ennemie que le prêtre va attaquer
     * @param alliee que le prêtre va soigner ou ressuciter
     */
    @Override
    public void action(Equipe ennemie, Equipe alliee) {
        //Tirage pour savoir quelle action le prêtre va effectuer
        int random = (int)(2*Math.random());
        //Si le tirage = 1 il attaque
        if(random == 1) {
            attaquer(ennemie, alliee);
        }
        //Si le tirage = 0 et que l'allié est en vie alors il le soigne
        if(random == 0) {
            soin(alliee);
        }
    }


    @Override
    public String getNom() {
        return "Pretre";
    }

    @Override
    public String toString() {
        return "Pr["+getPV()+"/"+getPvMax()+"]";
    }
}