/**
 * Die Klasse stellt die Rechenoperation Quadratwurzel dar
 */
public class Quadratwurzel implements Rechenoperation {

    /**
     * {@inheritDoc}
     */
    @Override
    public double berechne(double x) {
        if (x < 0)
            throw new ArithmeticException();
        return Math.sqrt(x);
    }

}
