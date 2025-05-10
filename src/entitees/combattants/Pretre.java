package src.entitees.combattants;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

public class Pretre extends Combattant{
    //Le prêtre peut ressuciter un allié 1 fois max
    private int res = 0;

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
        Combattant allié = cible.choisirCombattantAleatoire();
        int pv = allié.getPV();
        //valeur que le prêtre va régénerer
        int regeneration = 30;
        //Condition pour éviter que le prêtre soigne au dela de la vie max
        int seuil = allié.getPvMax()- regeneration;
        //Si les pv de l'allié sont inférieurs au seuil alors le prêtre restaure 30 pv
        if(pv <= seuil) {
            regenererPV(30);
        }
        //Sinon il le soigne jusqu'à atteindre ses pv max
        if(pv > seuil) {
            regenererPV(allié.getPvMax()-pv);
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
        Combattant mort = alliee.choisirCombattantAleatoire();
        //Si le tirage = 1 il attaque
        if(random == 1) {
            attaquer(ennemie);
        }
        //Si le tirage = 0 il ressucite l'allié ciblé si le compteur de resurrection < 1
        if(random == 0 && !mort.estEnVie() && res < 1) {
            System.out.println("Le pretre ressucite "+mort.toString());
            soin(alliee);
            //Augmentation du compteur de resurrection
            res++;
        }
        //Si le tirage = 0 et que l'allié est en vie alors il le soigne
        if(random == 0 && mort.estEnVie()) {
            soin(alliee);
            System.out.println("Le pretre soigne "+mort.toString()+" de 30 pv");
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