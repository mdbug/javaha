//TODO JavaDoc
public class PositiveNumber {
    private int value;
    private final static String DIGITS = "0123456789ABCDEF";

    public void setDecimal(String s) throws NumberFormatException {
        setValue(s, 10);
    }

    public void setHexadecimal(String s) throws NumberFormatException {
        setValue(s, 16);
    }

    public void setBinary(String s) throws NumberFormatException {
        setValue(s, 2);
    }

    public String getDecimal() {
        return getValue(10);
    }

    public String getHexadecimal() {
        return getValue(16);
    }

    public String getBinary() {
        return getValue(2);
    }

    private void setValue(String s, int radix) throws NumberFormatException, ArithmeticException {
        s = s.toUpperCase();
        int value = 0;
        for (int i = 0, factor = 1; i < s.length(); i++, factor*=radix) {
            char c = s.charAt(s.length()-1-i);
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
