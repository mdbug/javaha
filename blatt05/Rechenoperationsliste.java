import java.util.ArrayList;

public class Rechenoperationsliste {
    private ArrayList<Rechenoperation> liste;
    
    /**
     * Ini
     */
    public Rechenoperationsliste() {
        liste = new ArrayList<>();
    }
    
    /**
     * @param operation
     */
    public void add(Rechenoperation operation) {
        liste.add(operation);
    }
    
    /**
     * @param feld
     * @return
     */
    public double[] transform(double[] feld) {
        double[] ergebnisse = new double[feld.length];
        for (Rechenoperation o : liste) {
            for (int i = 0; i < feld.length; i++) {
                ergebnisse[i] = o.berechne(feld[i]);
            }
        }
        return ergebnisse;
    }
}
