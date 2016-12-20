 /**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Die abstrakte Klasse stellt eine Zahl in englischer Sprache dar
 */
public class ZahlwortEnglisch extends Zahlwort {
    private static final String[] N_0_20 = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"
    };

    private static final String[] T = {
            "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };


     /**
      * Konstruiert ein neues englisches Zahlwort
      * @param x die Zahl (muss zwischen 1 und 9999 liegen.
      */
    public ZahlwortEnglisch(int x) {
        super(x);
    }

     /**
      * Gibt die Zahl als Wort in englglischer Sprache zurueck
      * @return ein String mit der Zahl in englischer Sprache
      */
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

     /**
      * Gibt die Sprache dieses Zahlwortes zurueck
      * @return die Sprache
      */
    @Override
    public String getSprache() {
        return "englisch";
    }
}
