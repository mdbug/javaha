/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 */
public class PositiveNumber {
    private final static String DIGITS = "0123456789ABCDEF";
    private int value;

    /**
     * Die als String uebergebene Dezimalzahl wird gesetzt
     * @param s eine Dezimalzahl als String
     * @throws NumberFormatException falls der String keine gueltige Dezimalzahl repraesentiert
     */
    public void setDecimal(String s) throws NumberFormatException {
        setValue(s, 10);
    }

    /**
     * Die als String uebergebene Hexadezimalzahl wird gesetzt
     * @param s eine Hexadezimalzahl als String
     * @throws NumberFormatException falls der String keine gueltige Hexadezimalzahl repraesentiert
     */
    public void setHexadecimal(String s) throws NumberFormatException {
        setValue(s, 16);
    }

    /**
     * Die als String uebergebene Binaerzahl wird gesetzt
     * @param s eine Binaerzahl als String
     * @throws NumberFormatException falls der String keine gueltige Binaerzahl repraesentiert
     */
    public void setBinary(String s) throws NumberFormatException {
        setValue(s, 2);
    }

    /**
     * Gibt die Zahl im Dezimalsystem als String zurueck
     * @return die Zahl im Dezimalsystem als String 
     */
    public String getDecimal() {
        return getValue(10);
    }

    /**
     * Gibt die Zahl im Hexadezimalsystem als String zurueck
     * @return die Zahl im Hexadezimalsystem als String 
     */
    public String getHexadecimal() {
        return getValue(16);
    }

    /**
     * Gibt die Zahl im Binaersystem als String zurueck
     * @return die Zahl im Binaersystem als String 
     */
    public String getBinary() {
        return getValue(2);
    }

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
