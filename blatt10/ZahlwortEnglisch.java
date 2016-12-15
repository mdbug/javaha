/**
 * Created by micha on 15.12.2016.
 */
public class ZahlwortEnglisch extends Zahlwort {
    private static final String[] N_0_20 = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"
    };

    private static final String[] T = {
            "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public ZahlwortEnglisch(int x) {
        super(x);
    }

    @Override
    public String getWortString() {
        if (x < 0 || x > 9999)
            throw new NumberFormatException();

        StringBuilder sb = new


        if (x <= 20) {
            return N_0_20[x];
        } else {
            if (x % 10 == 0) {
                return T[(x / 10) - 2];
            } else {
                return T[(x / 10) - 2] + "-" + N_0_20[x % 10];
            }
        }
    }

    @Override
    public String getSprache() {
        return "englisch";
    }

    public static void main(String[] args) {
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
