/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 */
public class PositiveNumber {
    private final static String DIGITS = "0123456789ABCDEF";
    private int value;

    /**
<<<<<<< HEAD
     * @param s
     * @throws NumberFormatException
=======
     * Die als String uebergebene Dezimalzahl wird gesetzt
     * @param s eine Dezimalzahl als String
     * @throws NumberFormatException falls der String keine gueltige Dezimalzahl repraesentiert
>>>>>>> branch 'master' of https://github.com/mdbug/javaha
     */
    public void setDecimal(String s) throws NumberFormatException {
        setValue(s, 10);
    }

    /**
<<<<<<< HEAD
     * @param s
     * @throws NumberFormatException
=======
     * Die als String uebergebene Hexadezimalzahl wird gesetzt
     * @param s eine Hexadezimalzahl als String
     * @throws NumberFormatException falls der String keine gueltige Hexadezimalzahl repraesentiert
>>>>>>> branch 'master' of https://github.com/mdbug/javaha
     */
    public void setHexadecimal(String s) throws NumberFormatException {
        setValue(s, 16);
    }

    /**
<<<<<<< HEAD
     * @param s
     * @throws NumberFormatException
=======
     * Die als String uebergebene Binaerzahl wird gesetzt
     * @param s eine Binaerzahl als String
     * @throws NumberFormatException falls der String keine gueltige Binaerzahl repraesentiert
>>>>>>> branch 'master' of https://github.com/mdbug/javaha
     */
    public void setBinary(String s) throws NumberFormatException {
        setValue(s, 2);
    }

    /**
<<<<<<< HEAD
     * @return
=======
     * Gibt die Zahl im Dezimalsystem als String zurueck
     * @return die Zahl im Dezimalsystem als String 
>>>>>>> branch 'master' of https://github.com/mdbug/javaha
     */
    public String getDecimal() {
        return getValue(10);
    }

    /**
<<<<<<< HEAD
     * @return
=======
     * Gibt die Zahl im Hexadezimalsystem als String zurueck
     * @return die Zahl im Hexadezimalsystem als String 
>>>>>>> branch 'master' of https://github.com/mdbug/javaha
     */
    public String getHexadecimal() {
        return getValue(16);
    }

    /**
<<<<<<< HEAD
     * @return
=======
     * Gibt die Zahl im Binaersystem als String zurueck
     * @return die Zahl im Binaersystem als String 
>>>>>>> branch 'master' of https://github.com/mdbug/javaha
     */
    public String getBinary() {
        return getValue(2);
    }

    /**
     * @param s
     * @param radix
     * @throws NumberFormatException
     * @throws ArithmeticException
     */
    private void setValue(String s, int radix) throws NumberFormatException, ArithmeticException {
        s = s.toUpperCase();
        int value = 0;
        for (int i = s.length()-1, factor = 1; i >= 0; i--, factor*=radix) {
            char c = s.charAt(i);
            int digit = DIGITS.indexOf(c);
            if (digit == -1 || digit >= radix) {
                throw new NumberFormatException("Bad Character: " + c);
            }
            value = Math.addExact(value, DIGITS.indexOf(c) * factor);
        }
        this.value = value;
    }
    
    /**
     * @param radix
     * @return
     */
    private String getValue(int radix) {
       StringBuilder builder = new StringBuilder();
       int number = value;
       do {
          builder.insert(0, DIGITS.charAt(number % radix));
          number /= radix;
       } while (number > 0);
       return builder.toString();
    }
}
