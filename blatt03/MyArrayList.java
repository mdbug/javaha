/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 */
public class MyArrayList {
    private int[] arr = new int[10];
    private int size = 0;

    /**
     *  Haengt ein Element hinten an die Liste an
     */ 
    public void add(int i) {
        //TODO
    }

    // Gibt das Element an der angegebenen Stelle zurueck. Wirft
    // eine ArrayIndexOutOfBoundsException, falls pos nicht zwischen
    // 0 und size liegt.
    public int get(int pos) {
        //TODO
    }

    // Gibt eine Stringdarstellung in der Form [1,2,3,4,7,9]
    // zurueck.
    public String toString() {

        //TODO

    }

    // Loescht das Feld.
    public void clear() {

        //TODO
    }

    // Gibt die Anzahl der aufgenommenen Elemente zurueck.
    public int size() {

        //TODO
    }

    // Gibt die Groesse des Feldes (einschliesslich freier Elemente)
    // zurueck.
    public int capacity() {

        //TODO
    }

    // Erzeugt einen Klon der this-Liste.
    public MyArrayList clone() {

        //TODO
    }

    // Fuegt ein Element an der Position pos ein. Verschiebt alle
    // folgenden Elemente eine Position nach hinten. Wirft eine
    // ArrayIndexOutOfBoundsException, falls pos nicht zwischen 0
    // und size liegt.
    public void add(int i, int pos) {

        //TODO
    }

    // Loescht das Element an der Position pos. Verschiebt alle
    // folgenden Elemente eine Position nach vorne. Wirft eine
    // ArrayIndexOutOfBoundsException, falls pos nicht zwischen 0
    // und size liegt.
    public void delete(int pos) {

        //TODO
    }
}
