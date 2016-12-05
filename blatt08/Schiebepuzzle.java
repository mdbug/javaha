import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Die Klasse stellt ein Schiebepuzzle dar
 */
public class Schiebepuzzle {
    private final int WIDTH = 4;
    private final int HEIGHT = 4;
    private final int SIZE = WIDTH * HEIGHT;
    private final int EMPTY = 0;

    private int[][] feld;
    private int[] plaettchenX;
    private int[] plaettchenY;

    /**
     * Konstruiert ein Schiebepuzzle, in dem die Zahlen richtig angeordnet sind
     */
    public Schiebepuzzle() {
        feld = new int[HEIGHT][WIDTH];
        plaettchenX = new int[SIZE];
        plaettchenY = new int[SIZE];
        int n = 1;
        for (int i = 0; i < HEIGHT; ++i) {
            for (int j = 0; j < WIDTH && n < 16; ++j) {
                plaettchenX[n] = j;
                plaettchenY[n] = i;
                feld[i][j] = n;
                n++;
            }
        }
        plaettchenX[EMPTY] = WIDTH - 1;
        plaettchenY[EMPTY] = HEIGHT - 1;
        feld[HEIGHT-1][WIDTH-1] = 0;
    }

    /**
     * Die Methode schiebt das Plaettchen mit der Nummer i auf den freien Platz.
     * @param i das Plaettchen, welches verschoben werden soll
     * @throws WrongNumberException falls das Plaettchen nicht existiert
     * @throws WrongMoveException falls der Zug nicht moeglich ist
     */
    public void schiebe(int i) {
        if (i < 1 || i >= SIZE)
            throw new WrongNumberException();
        if (!istVerschiebbar(i))
            throw new WrongMoveException();

        int tmpX = plaettchenX[i];
        int tmpY = plaettchenY[i];
        plaettchenX[i] = plaettchenX[EMPTY];
        plaettchenY[i] = plaettchenY[EMPTY];
        plaettchenX[EMPTY] = tmpX;
        plaettchenY[EMPTY] = tmpY;
        feld[plaettchenY[i]][plaettchenX[i]] = i;
        feld[plaettchenY[EMPTY]][plaettchenX[EMPTY]] = 0;
    }

    /**
     * Prueft ob das Plaettchen verschiebbar ist
     * @param i die Nummer des Plaettchens
     * @return true, falls das Plaettchen verschiebar ist. false, sonst.
     */
    public boolean istVerschiebbar(int i) {
        if (i < 1 || i >= SIZE)
            throw new WrongNumberException();

        return (Math.abs(plaettchenX[i] - plaettchenX[EMPTY]) + Math.abs(plaettchenY[i] - plaettchenY[EMPTY])) == 1;
    }

    /**
     * Gibt eine Liste aller Plaettchen zurueck, die verschiebbar sind
     * @return eine Liste aller verschiebarer Plaettchen
     */
    public List<Integer> getVerschiebbarePlaettchen() {
        List<Integer> list = new ArrayList<>();
        if (plaettchenX[EMPTY] > 0)
            list.add(feld[plaettchenY[EMPTY]][plaettchenX[EMPTY]-1]);
        if (plaettchenX[EMPTY] < WIDTH-1)
            list.add(feld[plaettchenY[EMPTY]][plaettchenX[EMPTY]+1]);
        if (plaettchenY[EMPTY] > 0)
            list.add(feld[plaettchenY[EMPTY]-1][plaettchenX[EMPTY]]);
        if (plaettchenY[EMPTY] < HEIGHT-1)
            list.add(feld[plaettchenY[EMPTY]+1][plaettchenX[EMPTY]]);

        return list;
    }

    /**
     * Die Methode mischt das Spiel, indem 100 zufaellige (gueltige) Zuege durchgefuehrt werden.
     */
    public void mische() {
        final int ZUEGE = 100;
        for (int i = 0; i < ZUEGE; ++i) {
            List<Integer> verschiebarePlaettchen = getVerschiebbarePlaettchen();
            int rnd = (int)(Math.random() * verschiebarePlaettchen.size());
            schiebe(verschiebarePlaettchen.get(rnd));
        }
    }

    /**
     * Gibt die x-Position des Plaettchens zurueck
     * @param i die Nummer des Plaettchens
     * @return die x-Koordinate des Plaettchens
     */
    public int getPlaettchenX(int i) {
        return plaettchenX[i];
    }

    /**
     * Gibt die y-Position des Plaettchens zurueck
     * @param i die Nummer des Plaettchens
     * @return die y-Koordinate des Plaettchens
     */
    public int getPlaettchenY(int i) {
        return plaettchenX[i];
    }

    /**
     * Gibt die Positon des Plaettchens zurueck. Von oben links (=0) bis unten rechts.
     * @param i das Plaettchen
     * @return die Position des Plaettchens
     */
    public int getPlaettchenPosition(int i) {
        return plaettchenY[i] * WIDTH + plaettchenX[i];
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int y = 0; y < HEIGHT; ++y) {
            for (int x = 0; x < WIDTH; ++x) {
                if (feld[y][x] != 0) {
                    s.append(String.format("|%2d", feld[y][x]));
                } else {
                    s.append("|  ");
                }
            }
            s.append("|\n");
            for (int i = 0; i < WIDTH; ++i) {
                s.append("---");
            }
            s.append("-\n");
        }
        return s.toString();
    }
}
