import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class EMailAdressBuch {
    private HashMap<String, String> map = new HashMap<>();

    /**
     * Konstruiert ein neues EMailAddressBuch-Objekt
     */
    public EMailAdressBuch() {
        map = new HashMap<>();
    }

    /**
     * Fügt einen neuen Kontakt zum Adressbuch hinzu
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
        for(String s: map.keySet()){
            String vorname = s.split(" ",2)[0];
            if(s.equals(map.keySet().toArray()[map.keySet().size()-1])) builder.append(vorname+"}");
            else builder.append(vorname+"="+abfrage(s)+", ");
        }
        return builder.toString();
    }

    /**
     *  Liest Emails von einer lokalen Datei
     * @param dateiname Name der Datei
     * @throws FileNotFoundException falls die Datei nicht vorhanden ist
     */
    public void einlesen(String dateiname) throws FileNotFoundException {
        File f = new File(dateiname);
        Scanner sc = new Scanner(f);

        while(sc.hasNextLine()){
            String current=sc.nextLine();
            String[] temp = current.split(";");
            einfuegen(temp[0],temp[1]);
        }
        sc.close();
    }
}
