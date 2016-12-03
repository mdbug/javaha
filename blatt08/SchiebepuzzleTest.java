/**
 * Created by michael on 03.12.2016.
 */
public class SchiebepuzzleTest {
    public static void main(String[] args) {
        Schiebepuzzle puzzle = new Schiebepuzzle();
        System.out.println(puzzle);
        puzzle.mische();
        System.out.println(puzzle);
        Loesungsalgorithmus alg = new SchiebAlg1();
        alg.loese(puzzle);
        System.out.println(puzzle);
    }
}
