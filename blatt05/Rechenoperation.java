/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Das Interface stellt eine Rechenoperation dar
 */
public interface Rechenoperation {
    /**
     * Fuehrt eine Berechnung mit dem Uebergebenen Wert aus
     * 
     * @param x der Wert auf den die Rechenoperation angewendet werden soll
     * @return das Ergebnis der Rechenoperation
     */
    public double berechne(double x);
}
