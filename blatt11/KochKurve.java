/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Die Klasse bietet eine rekursive Funktion zur Berechnung einer Kochkurve
 */
public class KochKurve {
    /**
     * Abstand des dritten Punktes von der Geraden
     * Berechnet mit Satz des Pythagoras
     * (1/6)^2 + DISTANCE^2 = (1/3)^2
     */
    private static final double DISTANCE = Math.sqrt(1.0/12);

    /**
     * Die Funktion gibt fuer eine gegebene Rekursionstiefe alle Eckpunkte der Koch-Kurve auf dem Bildschirmpunkt aus
     *
     * @param ax x-Koordinate des Anfangspunktes
     * @param ay y-Koordinate des Anfangspunktes
     * @param bx x-Koordinate des Endpunktes
     * @param by y-Koordinate des Endpunktes
     * @param rek Rekursionstiefe
     */
    public static void kochKurve(double ax, double ay, double bx, double by, double rek) {
        if (rek == 0) {
            System.out.printf("(%.1f/%.1f) ", ax, ay);
        } else {
            //Richtungsvektor
            double rx = bx - ax;
            double ry = by - ay;

            //Zwischenpunkte
            double x1 = ax + (rx / 3);
            double y1 = ay + (ry / 3);
            double x2 = ax + (rx / 2) + (ry * DISTANCE);
            double y2 = ay + (ry / 2) - (rx * DISTANCE);
            double x3 = ax + (rx * 2 / 3);
            double y3 = ay + (ry * 2 / 3);

            kochKurve(ax, ay, x1, y1, rek-1);
            kochKurve(x1, y1, x2, y2, rek-1);
            kochKurve(x2, y2, x3, y3, rek-1);
            kochKurve(x3, y3, bx, by, rek-1);
        }
    }

    public static void main (String[] args) {
        double ax = 0, ay = 500, bx = 500, by = 500;
        kochKurve(0, 500, 500, 500,2);
        System.out.printf("(%.1f/%.1f)", bx, by);
    }
}
