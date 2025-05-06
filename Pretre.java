public class Pretre extends Combattant{
    private int res = 0;
    Pretre() {
        super(160, 35, 20, 20, 80);
    }
    
    @Override
    public void soin(Equipe cible) {
        Combattant allié = cible.choisirCombattantAleatoire();
        int pv = allié.getPV();
        if(pv <= allié.getPVMax()) {
            regenererPV(30);
        }
        if(pv > allié.getPVMax()-30) {
            regenererPV(allié.getPVMax()-pv);
        }
    }

    @Override
    public void action(Equipe ennemie, Equipe alliée) {
        
        int random = (int)(2*Math.random());
        Combattant mort = alliée.choisirCombattantAleatoire();

        if(random == 1) {
            attack(ennemie);
        }
        if(random == 0 && !mort.isAlive() && res < 1) {
            soin(alliée);
            res++;
        }else {
            soin(alliée);
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