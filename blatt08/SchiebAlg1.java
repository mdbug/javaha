import java.util.List;

/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 */
public class SchiebAlg1 implements Loesungsalgorithmus {
    @Override
    public void loese(Schiebepuzzle puzzle) {
        do {
            List<Integer> verschiebarePlaettchen = puzzle.getVerschiebbarePlaettchen();
            int rnd = (int)(Math.random() * verschiebarePlaettchen.size());
            puzzle.schiebe(verschiebarePlaettchen.get(rnd));
        } while (puzzle.getPlaettchenPosition(1) != 0);
    }
}
