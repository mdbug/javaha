/**
 * Created by abraining on 16.11.2016.
 */
public class GefDilemma {
    /**
     * Spieler 1 und 2 repräsentiert als Strategien
     */
    private GefStrategie spieler1;
    private GefStrategie spieler2;

    /**
     * Erzeugt ein Objekt der Klasse GefDilemma
     * @param spieler1 Strategie des 1. Spielers
     * @param spieler2 Strategie des 2. Spielers
     */
    public GefDilemma(GefStrategie spieler1, GefStrategie spieler2){
        this.spieler1=spieler1;
        this.spieler2=spieler2;
    }

    /**
     * Simulation des Spiels
     * @param n Anzahl der Runden
     */
    public void spiele(int n){
        int punkte1=0;
        int punkte2=0;

        for(int i=0; i<n;i++){
            boolean sp1=spieler1.getNextDecision();
            boolean sp2=spieler2.getNextDecision();
            if(!sp1 && !sp2) {
                punkte1+=2;
                punkte2+=2;
            } else if(sp1 && sp2){
                punkte1+=4;
                punkte2+=4;
            } else if(sp1 == true && sp2 == false){
                punkte2+=5;
            } else punkte1+=5;
            spieler1.setOpponentsLastDecision(sp2);
            spieler2.setOpponentsLastDecision(sp1);
        }

        if(punkte1<punkte2) System.out.println("Spieler 1 hat mit "+punkte1+" Punkten gewonnen.");
        else if(punkte2<punkte1) System.out.println("Spieler 2 hat mit "+punkte2+" Punkten gewonnen.");
        else System.out.println("Unentschieden: " +punkte1);
    }
}
