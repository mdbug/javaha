import java.util.ArrayList;

/**
 * Created by michael on 10.12.2016.
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
