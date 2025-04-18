public class Combat {

    Equipe equipe1;
    Equipe equipe2;

    Combat(Equipe equipe1, Equipe equipe2) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
    }

    public Equipe Versus(){
        while(!equipe1.loose() && !equipe2.loose()) {
            

        }
    }
    
}