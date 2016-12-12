import java.util.ArrayList;

/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Die Klasse stellt die Schachfigur Springer dar.
 */
public class Knight extends Chessman {
    final static private int[][] MOVES = {
            {-2, -1}, {-2, 1},
            {-1, -2}, {-1, 2},
            { 1, -2}, { 1, 2},
            { 2, -1}, { 2, 1}
    };

    /**
     * {@inheritDoc}
     */
    public Knight(Position pos) {
        super(pos);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> moveList = new ArrayList<>();
        int x = getPosition().getX();
        int y = getPosition().getY();
        for (int[] m : MOVES) {
            Position pos = new Position(x + m[0], y + m[1]);
            if (pos.isValid()) {
                moveList.add(pos);
            }
        }
        return moveList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Springer: " + getPosition();
    }
}
