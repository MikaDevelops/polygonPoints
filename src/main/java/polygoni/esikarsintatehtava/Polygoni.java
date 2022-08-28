package polygoni.esikarsintatehtava;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Polygoni luokka käsittelee kuvion kulmapisteitä.
 */
public class Polygoni {

	private List<Double> kulmakoordinaatit = new ArrayList<>();

	public void asetaKulmakoordinaatit(ArrayList<Double> koordinaatit) {
		this.kulmakoordinaatit = koordinaatit;
	}

	/**
	 * Lataa tiedostosta janojen koordinaatit.
	 * 
	 * @throws FileNotFoundException
	 */
	public void lataaPolygoninKulmakoordinaatit() throws FileNotFoundException {
		File polygoniTiedosto = new File("polygoni.txt");
		Scanner tiedostolukija = new Scanner(polygoniTiedosto);
		while (tiedostolukija.hasNextLine()) {
			String rivi = tiedostolukija.nextLine();
			String[] rivinLuvut = rivi.split(",");
			for (int i = 0; i < rivinLuvut.length; i++) {
				kulmakoordinaatit.add(Double.valueOf(rivinLuvut[i]));
			}
		}
		tiedostolukija.close();
		tarkistaKulmat();
	}

	public ArrayList<Double> haeKoordinaatit() {
		return (ArrayList<Double>) kulmakoordinaatit;
	}

	/**
	 * Tarkastaa, että annettujen pisteiden kulmakertoimet poikkeavat edellisestä 
	 * (ei nollakulma).
	 * */
	public boolean tarkistaKulmat() {
		boolean kulmatKunnossa = true;

		double xEnsimmainenErotus = kulmakoordinaatit.get(2) - kulmakoordinaatit.get(0);
		double yEnsimmainenErotus = kulmakoordinaatit.get(3) - kulmakoordinaatit.get(1);
		double edellinenKulmakerroin = pyoristaDouble(yEnsimmainenErotus / xEnsimmainenErotus, 3);

		for (int i = 2; i < kulmakoordinaatit.size(); i += 2) {
			// TODO: tarkastus ja korjaus, ei ota kiinni viimeisen pisteen kulmaan.
			if (i == kulmakoordinaatit.size() - 2) {
				double xErotus = kulmakoordinaatit.get(0) - kulmakoordinaatit.get(i);
				double yErotus = kulmakoordinaatit.get(1) - kulmakoordinaatit.get(i + 1);
				double kulmakerroin = pyoristaDouble(yErotus / xErotus, 3);
				if (edellinenKulmakerroin == kulmakerroin) {
					kulmatKunnossa = false;
					break;
				}
			} else {
				double xErotus = kulmakoordinaatit.get(i + 2) - kulmakoordinaatit.get(i);
				double yErotus = kulmakoordinaatit.get(i + 3) - kulmakoordinaatit.get(i + 1);
				double kulmakerroin = pyoristaDouble(yErotus / xErotus, 3);
				if (kulmakerroin == edellinenKulmakerroin) {
					kulmatKunnossa = false;
					break;
				}
				edellinenKulmakerroin = kulmakerroin;
			}
		}
		return kulmatKunnossa;
	}

	private static double pyoristaDouble(double arvo, int desimaalit) {
		BigDecimal bd = BigDecimal.valueOf(arvo);
		bd = bd.setScale(desimaalit, RoundingMode.HALF_UP);
		return bd.doubleValue();

	}
}
