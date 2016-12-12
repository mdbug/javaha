/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Die Klasse stellt eine Positon auf einem Schachfeld dar
 */
public class Position {
    final private int MAX_VALID = 8;
    final private int x;
    final private int y;

    /**
     * Setzt die Position auf den Wert x/y.
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Gibt die x-Koordinate der Position zurück
    public int getX() {
        return x;
    }

    /**
     * Gibt die y-Koordinate der Position zurueck.
     *
     * @return die y-Koordinate der Position
     */
    public int getY() {
        return y;
    }

    /**
     * Gibt zurueck, ob die Positionen this und p gleich sind.
     *
     * @param p Position
     * @return true, falls die Positionen gleich sind. false, sonst.
     */
    public boolean equals(Position p) {
        return (this.getX() == p.getX() && this.getY() == p.getY());
    }

    //Gibt zurück, ob die Position gültig (d.h. innerhalb des Schachbretts) ist.
    public boolean isValid() {
        return (x >= 1 && x <= MAX_VALID && y >= 1 && y <= MAX_VALID);
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return "(" + getX() + "/" + getY() + ")";
    }

}
