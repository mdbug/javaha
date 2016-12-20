/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 */
public class TestEnglisch {
    public static void main(String[] args) {
        //int[] testtabelle = new int[9999];
        //for (int i=0; i < testtabelle.length; ++i)
        //    testtabelle[i] = i+1;

        int[] testtabelle = { 10, 11, 12, 13, 15, 18, 20, 35, 51, 80, 103, 1067};
        for (int zahl: testtabelle) {
            try {
                ZahlwortEnglisch zahlwort = new ZahlwortEnglisch(zahl);
                System.out.println(zahlwort);
            }
            catch (NumberFormatException ex) {
                System.out.println(ex);
            }
        }
    }
}
