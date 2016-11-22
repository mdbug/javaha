/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Das Interface stellt die Gefangenendilemma-Strategie pavlov dar.
 *
 * Kooperiert in der ersten Runde und verrät, falls der vorherige Zug des Mitspielers anders
 * als der eigene war. Kooperiert, wenn in der Vorrunde beide Spieler kooperierten oder
 * beide verrieten. Dies führt zu einem Wechsel des Verhaltens, wenn der Gewinn der Vorrunde
 * klein war, aber zum Beibehalten des Verhaltens, wenn der Gewinn groß war.
 */
public class Pavlov implements GefStrategie {
    private boolean opponentsLastDecision;
    private boolean ownLastDecision;
    private boolean firstRound = true;

    /**
     *  {@inheritDoc}
     */
    @Override
    public boolean getNextDecision() {
        if (firstRound) {
            firstRound = false;
            ownLastDecision = false;
            return false;
        } else if (ownLastDecision != opponentsLastDecision) {
            ownLastDecision = true;
            return true;
        } else {
            ownLastDecision = false;
            return false;
        }
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void setOpponentsLastDecision(boolean decision) {
        opponentsLastDecision = decision;
    }
}
