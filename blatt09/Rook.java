import java.util.ArrayList;

/**
 * Created by michael on 10.12.2016.
 */
public class Rook extends Chessman {
    final private int MAX_VALID = 8;

    /**
     * {@inheritDoc}
     */
    public Rook(Position pos) {
        super(pos);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> moveList = new ArrayList<>();
        int x0 = getPosition().getX();
        int y0 = getPosition().getY();

        for (int x = 1; x <= MAX_VALID; ++x) {
            if (x != x0) {
                moveList.add(new Position(x, y0));
            }
        }
        for (int y = 1; y <= MAX_VALID; ++y) {
            if (y != y0) {
                moveList.add(new Position(x0, y));
            }
        }

        return moveList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Turm: " + getPosition();
    }
}
