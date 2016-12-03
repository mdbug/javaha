/**
 * Created by micha on 01.12.2016.
 */
public class Schiebepuzzle {
    private int WIDTH = 4;
    private int HEIGHT = 4;

    private int[][] feld;

    public Schiebepuzzle() {
        feld = new int[WIDTH][HEIGHT];
        int n = 1;
        for (int i = 0; i < HEIGHT; ++i) {
            for (int j = 0; j < WIDTH; ++j) {
                feld[i][j] = n;
                n++;
            }
        }
        feld[WIDTH-1][HEIGHT-1] = -1;
    }

    public void schiebe (int i) {

    }


}
