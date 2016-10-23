import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Klasse zur Verwaltung von Personennamen und E-Mailadressen
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 */
public class EMailAdressBuch {
    private HashMap<String, String> map = new HashMap<>();

    /**
     * Konstruiert ein neues EMailAddressBuch-Objekt
     */
    public EMailAdressBuch() {
        map = new HashMap<>();
    }

    /**
     * Fuegt einen neuen Kontakt zum Adressbuch hinzu
     * oder aktuallisiert die E-Mail-Adresse eines Kontakts.
     * @param name der Name des Kontakts
     * @param email die Email Adresse des Kontakts
     */
    public void einfuegen(String name, String email) {
        map.put(name, email);
    }

    /**
     * Liefert die E-Mail-Adresse fuer einen gegebenen Namen zurueck
     * @param name der Name des Kontakts
     * @return die Emailadresse des Kontakts
     * @throws UnknownNameException falls der Name nicht im Adressbuch vorhanden ist
     */
    public String abfrage(String name) {
        if (!map.containsKey(name))
            throw new UnknownNameException("Name " + name+ " nicht gefunden");

        return map.get(name);
    }

    /**
     * Liefert einen String zurueck, der saemtliche Namen mit entsprechender E-Mail enthaelt
     * @return Namen und EMails
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        builder.append(map.size());
        int i = 0;
        for(String s : map.keySet()){
            // Anmerkung: Aus der Aufgabenstellung wurde nicht eindeutig klar
            // ob der ganze Name oder nur der Vorname ausgegeben werden soll
//          String vorname = s.split(" +",2)[0];
//          builder.append(vorname).append("=").append(abfrage(s));
            builder.append(s).append("=").append(abfrage(s));
            //Wenn es nicht der letzte Eintrag ist, Komma angehängen.
            if (i<map.size()-1) {
                builder.append(", ");
            }
            i++;
        }
        builder.append("}");
        return builder.toString();
    }
    
    private void einlesen(Scanner scanner) {
        while(scanner.hasNextLine()){
            String current = scanner.nextLine();
            String[] temp = current.split(";");
            einfuegen(temp[0],temp[1]);
        }
    }

    /**
     * Liest E-Mailadressen von einer lokalen Datei
     * @param dateiname Name der Datei
     * @throws FileNotFoundException falls die Datei nicht vorhanden ist
     */
    public void einlesen(String dateiname) throws FileNotFoundException {
        File f = new File(dateiname);
        Scanner sc = new Scanner(f);
        einlesen(sc);
        sc.close();
    }
    
    /**
     * Liest E-Mailadressen von einer Datei aus dem Internet
     * @param url Die URL von der die Daten eingelesen werden sollen
     * @throws IOException
     */
    public void mitarbeiterEinlesen(URL url) throws IOException {
        URLConnection con = url.openConnection();
        Object content = con.getContent();
        Scanner sc = new Scanner((InputStream)content);
        einlesen(sc);
        sc.close();
    }
}
