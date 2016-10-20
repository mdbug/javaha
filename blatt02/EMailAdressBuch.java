import java.util.HashMap;

public class EMailAdressBuch {
	private HashMap<String, String> map;

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
	 * 
	 */
	public String toString() {
		// TODO
		return null;
	}
}
