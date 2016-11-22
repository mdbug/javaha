/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Das Interface stellt die Gefangenendilemma-Strategie Tit for Tat dar.
 *
 * Kooperiert in der ersten Runde und kopiert in den naechsten Runden den vorherigen Spielzug des
 * Spielpartners. Diese Strategie ist prinzipiell kooperationswillig, uebt aber bei Verrat
 * Vergeltung. Bei erneuter Kooperation des Mitspielers ist sie nicht nachtragend,
 * sondern reagiert ihrerseits mit Kooperation.
 */
public class TitForTat implements GefStrategie {
    private boolean opponentsLastDecision;
    private boolean firstRound = true;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getNextDecision() {
        if (firstRound) {
            firstRound = false;
            return false;
        }
        return opponentsLastDecision;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOpponentsLastDecision(boolean decision) {
        opponentsLastDecision = decision;
    }
}
