
public class Paladin extends Combattant {
    Paladin() {
        super(200, 45, 25, 10);
    }

    @Override
    public void passive(Combattant cible) {
        int pv = getPV();
        if(pv <= 190) {
            regenererPV(10);
        }
        if(pv > 190) {
            regenererPV(200-pv);
        }
    }
}
