import java.util.Locale;

public class GoldTagespreis {
	private String datum;
	private double preis;

	/**
	 * @return Gibt das Datum zurueck
	 */
	public String getDatum() {
		return datum;
	}

	/**
	 * @return Gibt den Preis zurueck
	 */
	public double getPreis() {
		return preis;
	}
	
	/**
	 * Konstruiert einen neuen GoldTagespreis
	 * @param datum Das Datum in der Form YYYY-MM-DD
	 * @param preis Der Goldpreis in Euro
	 */
	public GoldTagespreis(String datum, double preis) {
		this.datum = datum;
		this.preis = preis;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return String.format(Locale.GERMANY, "%s  %,9.2f", datum, preis);
	}
}
