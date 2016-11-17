/**
 * Created by abraining on 16.11.2016.
 */
public class Random implements GefStrategie {
    /**
     * oopponentsLastDecision speichert letzten Zug des Gegners
     */

    private boolean opponentsLastDecision;
    @Override
    public boolean getNextDecision() {
        if(Math.random()<0.5) return true;
        else return false;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {
        opponentsLastDecision=decision;
    }
}
