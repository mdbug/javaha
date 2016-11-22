/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Das Interface stellt die Gefangenendilemma-Strategie spite dar.
 *
 * Kooperiert solange, bis der Mitspieler zum ersten Mal verraet. Veraet danach immer.
 * Kooperiert bis zum ersten Vertrauensmissbrauch. Sehr nachtragend.
 */
public class Spite implements GefStrategie {
    private boolean opponentsLastDecision;
    private boolean salty = false;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getNextDecision() {
        if (salty)
            return true;
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOpponentsLastDecision(boolean decision) {
        opponentsLastDecision = decision;
        if (decision == true)
            salty = true;
    }
}
