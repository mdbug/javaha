import java.util.ArrayList;

/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Die abstrakte Klasse stellt eine Schachfigur dar
 */
public abstract class Chessman {
    private Position position;

    /**
     * Setzt die Figur auf den angegebenen Punkt. Loest eine RuntimeException aus, falls das Feld nicht existiert.
     *
     * @param pos Position
     */
    public Chessman(Position pos) {
        if (!pos.isValid())
            throw new RuntimeException("Feld existiert nicht");
        position = pos;
    }

    /**
     * Gibt die aktuelle Position zurueck
     *
     * @return die aktuelle Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Setzt die Figur auf den angegebenen Punkt. Loest eine RuntimeException aus, falls das Feld
     * nicht in einem Zug erreicht werden kann. Andere Figuren auf dem Brett werden nicht
     * beruecksichtigt.
     *
     * @param pos Positon
     */
    public void moveTo(Position pos) {
        if(!canMoveTo(pos))
            throw new RuntimeException("Feld kann nicht in einem Zug erreicht werden");
        position = pos;
    }

    /**
     * Gibt die Liste der Positionen zurueck, die mit der Figur in einem Zug erreicht werden koennen.
     *
     * @return Liste der Positionen, die mit der Figur in einem Zug erreicht werden koennen.
     */
    public abstract ArrayList<Position> getMoveList();

    /**
     * Gibt zurueck, ob die Figur die angegebene Position in einem Zug erreichen kann.
     *
     * @param pos Position
     * @return true, falls die Figur die angegebene Position in einem Zug erreichen kann. false, sonst.
     */
    public boolean canMoveTo(Position pos) {
        ArrayList<Position> moveList = getMoveList();
        for (Position move : moveList) {
            if (pos.equals(move)) {
                return true;
            }
        }
        return false;
    }
}
