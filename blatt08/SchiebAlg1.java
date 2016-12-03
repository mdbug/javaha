import java.util.List;

/**
 * Created by michael on 03.12.2016.
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
