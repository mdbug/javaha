/**
 * Created by abraining on 16.11.2016.
 */
public class PerKind implements GefStrategie {
    /**
     * oopponentsLastDecision speichert letzten Zug des Gegners
     */

    private boolean opponentsLastDecision;
    private int zug=1;
    @Override
    public boolean getNextDecision() {
        zug++;
        if(zug%3==0) return true;
        else return false;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {
        opponentsLastDecision=decision;
    }
}
