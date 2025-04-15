public class Berserker extends Combattant{
    Berserker() {
        super(220, 55, 10, 50);
    }

    @Override
    void attack() {
        int pv = getPV();
        if(pv <= 80) {
            attack();
        }
    }
}