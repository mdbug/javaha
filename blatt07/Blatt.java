import java.util.Arrays;

/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 */
public class Blatt {

    private int[] blatt = new int[3];

    /**
     * Erzeugt ein Blatt-Objekt mit einem gueltigen Blatt als Attribut
     * @param blatt
     */
    public Blatt(int[] blatt){
        if (blatt.length != 3)
            throw new ArithmeticException("Nicht genau drei Karten");
        for(int b : blatt) {
            if (b < 2 || b > 14) {
                throw new ArithmeticException("Ungueltige Karte");
            }
        }

        this.blatt = blatt.clone();
    }

    /**
     * IsDrilling() bestimmt, ob das eigene Blatt ein Drilling ist
     * @return Gibt zurück, ob das eigene Blatt ein Drilling ist
     */
    public boolean isDrilling(){
        return blatt[0] == blatt[1] && blatt[1] == blatt[2];
    }

    /**
     * IsPaar() bestimmt, ob das eigene Blatt ein Paar ist
     * @return Gibt zurück, ob das eigene Blatt ein Paar ist
     */
    public boolean isPaar(){
        return blatt[0] == blatt[1] || blatt[1] == blatt[2] || blatt[0] == blatt[2];
    }

    /**
     * getBlatt() gibt das eigene Blatt zurueck
     * @return eigenes Blatt
     */
    public int[] getBlatt(){
        return blatt;
    }

    /**
     * gibPaarStellen() gibt die Stellen zurück, an denen sich die Paare befinden
     * @return Stellen, an denen sich Paare befinden
     */
    public int[] gibPaarStellen(){
        if(isPaar()){
            if(blatt[0] == blatt[1]) return new int[]{0,1};
            else if(blatt[1] == blatt[2]) return new int[]{1,2};
            else return new int[]{0,2};
        } else throw new ArithmeticException("keine Paaren da");
    }

    /**
     * toString() gibt das eigene Blatt im String-Format zurueck
     * @return eigenes Blatt als String zurueck
     */
    public String toString(){
        String temp = Arrays.toString(blatt);
        return temp.substring(1, temp.length() - 1);
    }
}
