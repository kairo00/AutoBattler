public class Potion extends Item {

    private final int ajoutePv = 40;
    Potion() {
        super("Potion", "Consummable", 50);
    }

    @Override
    public void effet(Equipe equipe) {
        for(Combattant i: equipe.getTeam()) {
            i.regenererPV(ajoutePv);
            System.out.println("Vous avez utilisé une potion, vos unités régénere "+ajoutePv+" pv !");
        }
    }

    @Override
    public String toString() {
        return "Potion";
    }
}