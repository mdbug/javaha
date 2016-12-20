/**
 * Created by micha on 15.12.2016.
 */
public class ZahlwortEnglisch extends Zahlwort {
    private static final String[] N_0_20 = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"
    };

    private static final String[] T = {
            "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public ZahlwortEnglisch(int x) {
        super(x);
    }

    @Override
    public String getWortString() {
        int n = x;
        if (n < 1 || n > 9999)
            throw new NumberFormatException();

        StringBuilder sb = new StringBuilder();

        if (n >= 1000) {
            sb.append(N_0_20[n / 1000]).append(" thousand");
            n %= 1000;
            if (n > 0) {
                sb.append(" ");
            }
        }

        if (n >= 100 && n < 1000) {
            sb.append(N_0_20[n / 100]).append(" hundred");
            n %= 100;
            if (n > 0) {
                sb.append(" and ");
            }
        }

        if (n <= 20) {
            sb.append(N_0_20[n]);
        } else if (n < 100) {
            sb.append(T[n / 10]);
            if (n % 10 != 0) {
                 sb.append("-").append(N_0_20[n % 10]);
            }
        }

        return sb.toString();
    }

    @Override
    public String getSprache() {
        return "englisch";
    }

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
