/**
 * Created by abraining on 16.11.2016.
 */
public class Pavlov implements GefStrategie {
    /**
     * oopponentsLastDecision speichert letzten Zug des Gegners
     * ownLastDecision speichert den letzten Zug von sich selber
     * firstRound wird benutzt, um die Entscheidung in der ersten Runde zu realisieren
     */

    private boolean opponentsLastDecision;
    private boolean ownLastDecision;
    private boolean firstRound=true;
    @Override
    public boolean getNextDecision() {
        if(firstRound) {
            firstRound=false;
            ownLastDecision=false;
            return false;
        } else if(ownLastDecision != opponentsLastDecision) {
            ownLastDecision = true;
            return true;
        } else {
            ownLastDecision = false;
            return false;
        }
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {
        opponentsLastDecision=decision;
    }
}
