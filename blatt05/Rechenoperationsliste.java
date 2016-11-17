import java.util.ArrayList;

/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Die Klasse stellt eine Liste von Rechenoperationen dar
 */
public class Rechenoperationsliste {
    private ArrayList<Rechenoperation> liste;
    
    /**
     * Initialisiert die Liste von Rechenoperationen
     */
    public Rechenoperationsliste() {
        liste = new ArrayList<>();
    }
    
    /**
     * Fuegt zur Liste der Rechenoperationen die uebergebene Operation hinzu
     *
     * @param operation eine Rechenoperation die zur Liste hinzugefuegt werden soll
     */
    public void add(Rechenoperation operation) {
        liste.add(operation);
    }
    
    /**
     * Wendet alle Rechenoperationen der Reihe nach auf jedes Element des uebergebenen Feldes an
     *
     * @param feld ein double-Feld, auf das die Rechenoperationen angewendet werden sollen
     * @return ein double-Feld mit den Ergebnissen
     */
    public double[] transform(double[] feld) {
        double[] ergebnisse = feld.clone();
        for (Rechenoperation o : liste) {
            for (int i = 0; i < feld.length; i++) {
                ergebnisse[i] = o.berechne(ergebnisse[i]);
            }
        }
        return ergebnisse;
    }
}
