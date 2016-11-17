/**
 * Created by abraining on 16.11.2016.
 */
public interface GefStrategie {
    /**
     * gibt die nächste eigene Spielentscheidung zurück
     * @return eigene Entschediung
     */
    public boolean getNextDecision();


    /**
     * dem Spieler wird der letzte Zug des Gegners mitgeteilt
     * @param decision letzter Zug des Gegners
     */
    public void setOpponentsLastDecision(boolean decision); //true => Verrat
}
