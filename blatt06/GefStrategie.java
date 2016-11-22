/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Das Interface stellt eine Gefangenen-Dilemma-Strategie dar
 */
public interface GefStrategie {
    /**
     * gibt die nächste eigene Spielentscheidung zurück
     *
     * @return eigene Entschediung
     */
    public boolean getNextDecision();


    /**
     * dem Spieler wird der letzte Zug des Gegners mitgeteilt
     *
     * @param decision letzter Zug des Gegners (true = Betrug, false = Kooperation)
     */
    public void setOpponentsLastDecision(boolean decision);
}
