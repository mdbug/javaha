/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 */
public class DasSpiel {
    public static void main(String[] args) {
        GefDilemma gd = new GefDilemma(new Random(), new Random());
        gd.spiele(100);
    }
}
