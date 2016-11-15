/**
 * Die Klasse stellt die Rechenoperation ^2 dar
 */
public class Quadrat implements Rechenoperation {

    /**
     * {@inheritDoc}
     */
    @Override
    public double berechne(double x) {
        return x * x;
    }

}
