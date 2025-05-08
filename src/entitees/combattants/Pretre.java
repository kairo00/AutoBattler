package src.entitees.combattants;
import src.entitees.Combattant;
import src.jeu.gestions.Equipe;

public class Pretre extends Combattant{
    private int res = 0;
    public Pretre() {
        super(160, 35, 20, 20, 80);
    }
    
    @Override
    public void soin(Equipe cible) {
        Combattant allié = cible.choisirCombattantAleatoire();
        int pv = allié.getPV();
        if(pv <= allié.getPvMax()) {
            regenererPV(30);
        }
        if(pv > allié.getPvMax()-30) {
            regenererPV(allié.getPvMax()-pv);
        }
    }

    @Override
    public void action(Equipe ennemie, Equipe alliee) {
        
        int random = (int)(2*Math.random());
        Combattant mort = alliee.choisirCombattantAleatoire();

        if(random == 1) {
            attaquer(ennemie);
        }
        if(random == 0 && !mort.estEnVie() && res < 1) {
            System.out.println("Le pretre ressucite "+alliee.toString());
            soin(alliee);
            res++;
        }else {
            soin(alliee);
            System.out.println("Le pretre soigne "+alliee.toString()+" de 30 pv");
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