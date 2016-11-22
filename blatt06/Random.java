/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Das Interface stellt die Gefangenendilemma-Strategie random dar.
 *
 * Verraet oder kooperiert aufgrund eines 50:50 Zufallsentscheid
 */
public class Random implements GefStrategie {
    /**
     * oopponentsLastDecision speichert letzten Zug des Gegners
     */

    private boolean opponentsLastDecision;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getNextDecision() {
        if (Math.random() < 0.5)
            return true;
        else
            return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOpponentsLastDecision(boolean decision) {
        opponentsLastDecision = decision;
    }
}
