import java.util.ArrayList;
import java.util.List;

/**
 * Created by micha on 01.12.2016.
 */
public class Schiebepuzzle {
    private final int WIDTH = 4;
    private final int HEIGHT = 4;
    private final int SIZE = WIDTH * HEIGHT;
    private final int EMPTY = 0;

    private int[][] feld;
    private int[] plaettchenX;
    private int[] plaettchenY;

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

    public boolean istVerschiebbar(int i) {
        if (i < 1 || i >= SIZE)
            throw new WrongNumberException();

        return (Math.abs(plaettchenX[i] - plaettchenX[EMPTY]) + Math.abs(plaettchenY[i] - plaettchenY[EMPTY])) == 1;
    }

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

    public void mische() {
        final int ZUEGE = 100;
        for (int i = 0; i < ZUEGE; ++i) {
            List<Integer> verschiebarePlaettchen = getVerschiebbarePlaettchen();
            int rnd = (int)(Math.random() * verschiebarePlaettchen.size());
            schiebe(verschiebarePlaettchen.get(rnd));
        }
    }

    public int getPlaettchenX(int i) {
        return plaettchenX[i];
    }

    public int getPlaettchenY(int i) {
        return plaettchenX[i];
    }

    public int getPlaettchenPosition(int i) {
        return plaettchenY[i] * WIDTH + plaettchenX[i];
    }

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
