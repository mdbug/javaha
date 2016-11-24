import java.util.Arrays;

/**
 * Created by abraining on 23.11.2016.
 */
public class Blatt {
    /**
     * karten verwaltet das eigene Blatt
     */
    private int[] blatt = new int[3];

    /**
     * erzeugt ein Blatt-Objekt mit einem gueltigen Blatt als Attribut
     * @param blatt
     */
    public Blatt(int[] blatt){
        boolean werteOk = true;
        for(int a : blatt) werteOk = ((2 <= a) && (a <= 14));
        if(!werteOk && blatt.length != 3) throw new ArithmeticException("Kartenwerte falsch oder zu viele, bzw. nicht genug Karten");

        this.blatt = blatt;
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
     * getBlatt() gibt das eigene Blatt
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
     * toString() gibt das eigene Blatt im String-Format aus
     * @return eigenes Blatt als String zurück
     */
    public String toString(){
        String temp = Arrays.toString(blatt);
        return temp.substring(1,temp.length()-1);
    }
}
