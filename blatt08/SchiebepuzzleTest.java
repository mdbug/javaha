/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Klasse zum Testen des Schiebepuzzels und des Loesungsalgorithmus
 */
public class SchiebepuzzleTest {
    public static void main(String[] args) {
        Schiebepuzzle puzzle = new Schiebepuzzle();
        System.out.println("Ungemischt:");
        System.out.println(puzzle);
        puzzle.mische();
        System.out.println("Gemischt:");
        System.out.println(puzzle);
        Loesungsalgorithmus alg = new SchiebAlg1();
        alg.loese(puzzle);
        System.out.println("\"Geloest\"");
        System.out.println(puzzle);
    }
}
