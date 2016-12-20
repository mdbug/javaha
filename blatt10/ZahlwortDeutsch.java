/**
 * Created by abraining on 14.12.2016.
 */
public class ZahlwortDeutsch extends Zahlwort{
    /**
     * eigenZahlen und zehner als Wörterbuch
     */
    private static final String[] eigenZahlen = {"null", "eins", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun", "zehn",
                                    "elf", "zwoelf", "dreizehn", "vierzehn", "fuenfzehn", "sechszehn", "siebzehn",
                                    "achtzehn", "neunzehn"};
    private static final String[] zehner = {"zwanzig", "dreissig", "vierzig", "fuenfzig", "sechzig", "siebzig", "achtzig", "neunzig"};

    public ZahlwortDeutsch(int x){
        super(x);
    }

    /**
     * getSprache() gibt die Sprache zurueck
     * @return die Sprache (deutsch)
     */
    @Override
    public String getSprache() {
        return "deutsch";
    }

    /**
     * getWortString() gibt die im Attribut x gespeicherte Zahl als Wort zurueck
     * @return  Attribut x als Wort
     */
    @Override
    public String getWortString() {
        if(x < 20) return eigenZahlen[x];
        String wort = "";

        StringBuilder builder = new StringBuilder(getZifferString());
        for(int i = 0 + builder.length(); i < 4; i++) builder.insert(0, "0");

        wort += getTausendHundert(builder.toString());
        wort += getZehner(builder.toString());
        return wort;
    }

    private static String getTausendHundert(String s){
        String wort = "";
        for(int i = 0; i < 2; i++){
            switch(s.charAt(i)){
                case '0':
                    continue;
                case '1':
                    wort += "ein";
                    break;
                case '2':
                    wort += eigenZahlen[2];
                    break;
                case '3':
                    wort += eigenZahlen[3];
                    break;
                case '4':
                    wort += eigenZahlen[4];
                    break;
                case '5':
                    wort += eigenZahlen[5];
                    break;
                case '6':
                    wort += eigenZahlen[6];
                    break;
                case '7':
                    wort += eigenZahlen[7];
                    break;
                case '8':
                    wort += eigenZahlen[8];
                    break;
                case '9':
                    wort += eigenZahlen[9];
                    break;
            }
            if(i == 0) wort += "tausend";
            else wort += "hundert";
        }
        return wort;
    }

    private static String getZehner(String s){
        String wort = "";
        if(s.charAt(3) != '0'){
            switch(s.charAt(3)){
                case '1':
                    wort += "ein";
                    break;
                case '2':
                    wort += eigenZahlen[2];
                    break;
                case '3':
                    wort += eigenZahlen[3];
                    break;
                case '4':
                    wort += eigenZahlen[4];
                    break;
                case '5':
                    wort += eigenZahlen[5];
                    break;
                case '6':
                    wort += eigenZahlen[6];
                    break;
                case '7':
                    wort += eigenZahlen[7];
                    break;
                case '8':
                    wort += eigenZahlen[8];
                    break;
                case '9':
                    wort += eigenZahlen[9];
                    break;
            }
            wort += "und";
        }
        switch(s.charAt(2)){
            case '0':
                break;
            case '1':
                wort += "ein";
                break;
            case '2':
                wort += zehner[0];
                break;
            case '3':
                wort += zehner[1];
                break;
            case '4':
                wort += zehner[2];
                break;
            case '5':
                wort += zehner[3];
                break;
            case '6':
                wort += zehner[4];
                break;
            case '7':
                wort += zehner[5];
                break;
            case '8':
                wort += zehner[6];
                break;
            case '9':
                wort += zehner[7];
                break;
        }
        return wort;
    }
}
