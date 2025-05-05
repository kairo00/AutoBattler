import java.util.Collections;

public class Combat {
    private Equipe equipe_1;
    private Equipe equipe_2;
    private int cpt_manche=1;

    public Combat(Equipe equipe_1, Equipe equipe_2) {
        this.equipe_1 = equipe_1;
        this.equipe_2 = equipe_2;
    }

    public void lancerCombat() {
        //tri les combattants par ordre croissant selon leur vitesse
        while(equipe_1.aDesVivants() && equipe_2.aDesVivants()) {
            lancerManche();
        }
        System.out.println(ecranVictoire());

    }

    private void lancerManche() {
        Collections.sort(equipe_1.getTeam(), new ComparatorVitesse());
        Collections.sort(equipe_2.getTeam(), new ComparatorVitesse());

        int i = 0;
        int j = 0;
        int cpt_tour = (int) (Math.random()*2); // Equipe 1 ou 2 qui commence

        System.out.println("Manche "+cpt_manche);

        while (equipe_1.aDesVivants() && equipe_2.aDesVivants()) {  // Arrêt si une équipe est morte
            boolean attaqueOK = false;
            
            // ekip 1
            while (i < equipe_1.getTeam().size() && !equipe_1.getTeam().get(i).isAlive()) i++;
            if (i < equipe_1.getTeam().size() && (cpt_tour % 2 == 0 || !attaqueOK)) {
                equipe_1.getTeam().get(i).action(equipe_2, equipe_1);
                i++;
                attaqueOK = true;
            }
            
            // ekip 2
            while (j < equipe_2.getTeam().size() && !equipe_2.getTeam().get(j).isAlive()) j++;

            if (j < equipe_2.getTeam().size() && (cpt_tour % 2 == 1 || !attaqueOK)) {
                equipe_2.getTeam().get(j).action(equipe_1, equipe_2);
                j++;
                attaqueOK = true;
            }

            if (!attaqueOK) break;
            cpt_tour++;
        }
        System.out.println(resultatManche());
        cpt_manche++;
    }

    public String resultatManche() {
        Collections.sort(equipe_1.getTeam(), new ComparatorVitesse());
        Collections.sort(equipe_2.getTeam(), new ComparatorVitesse());
        
        String str = "";
        str += "======[Resulat de la manche "+ cpt_manche + "]======\nEquipe 1:\n";
        for(Combattant c : equipe_1.getTeam()) {
            str += c.toString()+" "+c.isAlive()+c.getVit()+"\n";
        }
        str += "\n";
        for(Combattant c : equipe_2.getTeam()) {
            str += c.toString()+" "+c.isAlive()+c.getVit()+"\n";
        }
        return str;
    }

    public String ecranVictoire() {
        if(equipe_1.aDesVivants()) {
            return "Victoire de l'ekip 1";
        } else if(equipe_2.aDesVivants()) {
            return "Victoire de l'ekip 2";
        } else {
            return "Egalité";
        }
    }
    
}