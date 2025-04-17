import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Equipe {
    private List<Combattant> team;

    public Equipe() {
        this.team = new ArrayList<Combattant>();
    }

    public void Add(Combattant combattant){
        team.add(combattant);
    }

    public String show(int i) {
        return team.get(i).toString();
    }

    /*
     *  🚧 A voir avec attack() si de retourner un combattant c'est ce qu'il y a de mieux
     *  Choisi un combattant au hasard de SON équipe, ce combattant est retourné.
     */
    public Combattant choisirCombattantVivant() {
        int randomIndex;
        do {
            randomIndex = (int) (Math.random()*team.size());
        } while(!team.get(randomIndex).isAlive());
        
        return team.get(randomIndex);
    }

    /*
     * 🚧 A voir avec attack() si de retourner un combattant c'est ce qu'il y a de mieux
     * 🚧 Tri (temporairement) => à avoir si ce ne serait pas mieux de le faire a un autre moment au lieu de rappeler Collections.sort a chaque fois
     *    Retourne le combattant le plus faible de la liste (index 0 -> tri croissant (voir classe Comparator))
     */
    public Combattant choisirCombattantFaible() {
        Collections.sort(team, new ComparatorVie());
        return team.get(0);
    }
}