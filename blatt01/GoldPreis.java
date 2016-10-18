import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class GoldPreis {
	private ArrayList<GoldTagespreis> list;
	
	/**
	 * Konstruiert ein GoldPreis Objekt und liest die Goldpreise aus der angegebenen Datei ein
	 * @param dateiname der Dateiname der Goldpeisliste
	 * @throws FileNotFoundException falls die Datei nicht gefunden wurde
	 */
	public GoldPreis(String dateiname) throws FileNotFoundException {
		NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMANY);
		try(Scanner scan = new Scanner(new File(dateiname))) {
			this.list = new ArrayList<>();
			while(scan.hasNextLine()) {
				String zeile = scan.nextLine();
				//Teilt die Zeile bei den ersten Whitespace-Zeichen
				String[] split = zeile.split("\\s+", 2);
				String datum = split[0];
				double preis;
				try {
					Number number = numberFormat.parse(split[1]);
					preis = number.doubleValue();
				} catch (ParseException e) {
					preis = -1;
				}
				list.add(new GoldTagespreis(datum, preis));
			}
		}
	}
	
	/**
	 * Gibt den Goldpreis des angebegenen Tages zurueck
	 * @param datum Das Datum als String in der Form YYYY-MM-DD
	 * @return den Goldpreis in Euro
	 * @throws NumberFormatException falls der String zu keinem Tag in der Liste passt
	 */
	public double getPreis(String datum) throws NumberFormatException {
		for(GoldTagespreis p : list) {
			if (p.getDatum().equals(datum)) {
				return p.getPreis();
			}
		}
		throw new NumberFormatException("String passt zu keinem Tag in der Liste");
	}
	
	private double min() {
		double min = Double.MAX_VALUE;
		for (GoldTagespreis p : list) {
			if (p.getPreis() != -1) {
				min = Math.min(p.getPreis(), min);
			}
		}
		return min;
	}
	
	private double max() {
		double max = Double.MIN_VALUE;
		for (GoldTagespreis p : list) {
			max = Math.max(p.getPreis(), max);
		}
		return max;
	}
	
	/**
	 * Gibt alle Tage aus, an denen Gold am billigsten bzw. am teuersten war
	 */
	public void printMinMax() {
		double min = min();
		double max = max();
		System.out.println("Den niedrigsten Goldpreis von " + min + " gab es an folgenden Tagen:");
		for (GoldTagespreis p : list) {
			if (p.getPreis() == min) {
				System.out.println(p.getDatum());
			}
		}
		System.out.println("Den hoechsten Goldpreis von " + max + " gab es an folgenden Tagen:");
		for (GoldTagespreis p : list) {
			if (p.getPreis() == max) {
				System.out.println(p.getDatum());
			}
		}
	}
}
