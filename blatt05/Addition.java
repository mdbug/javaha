/**
 * Die Klasse stellt die Rechenoperation Addition dar
 */
public class Addition implements Rechenoperation {
    private double d;

    /**
     * Konstruiert ein neues Additions-Objekt
     * @param d die Zahl die addiert werden soll
     */
    public Addition(double d) {
        this.d = d;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double berechne(double x) {
        return x + d;
    }

}
