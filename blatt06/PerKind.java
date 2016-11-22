/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Das Interface stellt die Gefangenendilemma-Strategie per kind dar. Spielt periodisch die
 * Folge kooperieren/kooperieren/verraten. Diese Strategie versucht, den Mitspieler durch
 * zweimaliges Kooperieren in Sicherheit zu wiegen, um ihn dann einmal auszunehmen.
 */
public class PerKind implements GefStrategie {
    private boolean opponentsLastDecision;
    private int zug = 1;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getNextDecision() {
        zug++;
        if (zug % 3 == 0)
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
