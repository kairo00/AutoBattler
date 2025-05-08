package jeu.combattants;
import jeu.gestions.Equipe;

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
    public void action(Equipe ennemie, Equipe alliée) {
        
        int random = (int)(2*Math.random());
        Combattant mort = alliée.choisirCombattantAleatoire();

        if(random == 1) {
            attaquer(ennemie);
        }
        if(random == 0 && !mort.estEnVie() && res < 1) {
            System.out.println("Le pretre ressucite "+mort.toString());
            soin(alliée);
            res++;
        }else {
            soin(alliée);
            System.out.println("Le pretre soigne "+mort.toString()+" de 30 pv");
        }
       
    }

    @Override
    public String getNom() {
        return "Pretre";
    }

    @Override
    public String toString() {
        return "Pr["+getPV()+"/160]";
    }
}