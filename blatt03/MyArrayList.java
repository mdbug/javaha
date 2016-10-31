
/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 */
public class MyArrayList {
    final int INITIAL_SIZE = 10;
    final int INCREASE_FACTOR = 2;
    final double DECREASE_FACTOR = 1 / 2.0;
    final double DECREASE_THRESHOLD = 1 / 3.0;

    private int[] arr = new int[INITIAL_SIZE];
    private int size = 0;

    private void adjustSize() {
        if (size >= arr.length) {
            int[] tmp = new int[arr.length * INCREASE_FACTOR];
            System.arraycopy(arr, 0, tmp, 0, arr.length);
            arr = tmp;
        } else if ((arr.length > INITIAL_SIZE)
                && ((double) size / arr.length <= DECREASE_THRESHOLD)) {
            int[] tmp = new int[(int) (arr.length * DECREASE_FACTOR)];
            System.arraycopy(arr, 0, tmp, 0, tmp.length);
            arr = tmp;
        }
    }

    /**
     * Haengt ein Element hinten an die Liste an
     */
    public void add(int i) {
        adjustSize();
        arr[size] = i;
        size++;
    }

    /**
     * Gibt das Element an der angegebenen Stelle zurueck.
     * 
     * @param pos
     *            der Index des Elements
     * @return das Element an der angegebenen Stelle
     * @throws Wirft
     *             eine ArrayIndexOutOfBoundsException, falls pos nicht zwischen
     *             0 und size liegt.
     */
    public int get(int pos) throws ArrayIndexOutOfBoundsException {
        return arr[pos];
    }

    /**
     * Gibt eine Stringdarstellung in der Form [1,2,3,4,7,9] zurueck.
     * 
     * @return eine Stringdarstellung in der Form [1,2,3,4,7,9]
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i=0; i<size; i++) {
            sb.append(arr[i]);
            if (i<size-1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Loescht das Feld.
     */
    public void clear() {
        arr = new int[INITIAL_SIZE];
        size = 0;
    }

    /**
     * Gibt die Anzahl der aufgenommenen Elemente zurueck.
     * 
     * @return die Anzahl der aufgenommenen Elemente
     */
    public int size() {
        return size;
    }

    /**
     * Gibt die Groesse des Feldes (einschliesslich freier Elemente) zurueck.
     * 
     * @return die Groesse des Feldes (einschliesslich freier Elemente)
     */
    public int capacity() {
        return arr.length;
    }

    /**
     * Erzeugt einen Klon der this-Liste.
     * 
     * @return den Klon
     */
    public MyArrayList clone() {
        MyArrayList clone = new MyArrayList();
        clone.arr = arr.clone();
        clone.size = size;
        return clone;
    }

    /**
     * Fuegt ein Element an der Position pos ein. Verschiebt alle folgenden
     * Elemente eine Position nach hinten. Wirft eine
     * 
     * @param i
     *            das Element das eingefuegt werden soll
     * @param pos
     *            die Position, an die das Element eingefuegt werden soll
     * @throws ArrayIndexOutOfBoundsException,
     *             falls pos nicht zwischen 0 und size liegt.
     */
    public void add(int i, int pos) throws ArrayIndexOutOfBoundsException {
        if (pos < 0 || pos > size) {
            throw new ArrayIndexOutOfBoundsException(pos);
        }
        adjustSize();

        if (pos == size) {
            add(i);
        } else {
            System.arraycopy(arr, pos, arr, pos + 1, arr.length - pos - 1);
            arr[pos] = i;
            size++;
        }
    }

    /**
     * Loescht das Element an der Position pos. Verschiebt alle folgenden
     * Elemente eine Position nach vorne.
     * 
     * @param pos
     *            die Position des Elements das geloescht werden soll
     * @throws ArrayIndexOutOfBoundsException,
     *             falls pos nicht zwischen 0 und size liegt.
     */
    public void delete(int pos) {
        if (pos < 0 || pos > size) {
            throw new ArrayIndexOutOfBoundsException(pos);
        }
        System.arraycopy(arr, pos + 1, arr, pos, arr.length - pos - 1);
        size--;
        adjustSize();
    }
}
