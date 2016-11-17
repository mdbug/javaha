/**
 * Created by abraining on 16.11.2016.
 */
public class Spite implements GefStrategie {
    /**
     * oopponentsLastDecision speichert letzten Zug des Gegners
     * salty bestimmt, wann er verrate wurde
     */

    private boolean opponentsLastDecision;
    private boolean salty;
    @Override
    public boolean getNextDecision() {
        if(salty) return true;
        return false;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {
        opponentsLastDecision=decision;
        salty = decision;
    }
}
