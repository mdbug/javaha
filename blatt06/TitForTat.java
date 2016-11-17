/**
 * Created by abraining on 16.11.2016.
 */
public class TitForTat implements GefStrategie {
    /**
     * oopponentsLastDecision speichert letzten Zug des Gegners
     * firstRound wird benutzt, um die Entscheidung in der ersten Runde zu realisieren
     */

    private boolean opponentsLastDecision;
    private boolean firstRound=true;
    @Override
    public boolean getNextDecision() {
        if(firstRound) {
            firstRound=false;
            return false;
        }
        return opponentsLastDecision;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {
        opponentsLastDecision=decision;
    }
}
