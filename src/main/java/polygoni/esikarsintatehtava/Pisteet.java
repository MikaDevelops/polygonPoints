package polygoni.esikarsintatehtava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pisteet {

	private List<Double> pisteet = new ArrayList<>();

	public void lataaPisteet() throws FileNotFoundException, IdenttisiaPisteitaException {

		File pisteetTiedosto = new File("pisteet.txt");

		Scanner tiedostolukija = new Scanner(pisteetTiedosto);

		while (tiedostolukija.hasNextLine()) {
			String rivi = tiedostolukija.nextLine();
			String[] rivinLuvut = rivi.split(",");
			for (int i = 0; i < rivinLuvut.length; i++) {
				pisteet.add(Double.valueOf(rivinLuvut[i]));
			}
		}
		tiedostolukija.close();

		Boolean tarkastuksenTulos = tarkistaPisteet();
		if (!tarkastuksenTulos) {
			throw new IdenttisiaPisteitaException("Samoja koordinaatiopisteitä löytyi");
		}

	}

	public ArrayList<Double> haePisteet() {
		return (ArrayList<Double>) pisteet;
	}

	/**
	 * Luokan sisäinen metodi annettujen pisteiden tarkastamiseen täysin samojen
	 * arvojen varalta.
	 */
	private boolean tarkistaPisteet() {
		boolean tarkistustulos = false;
		for (int i = 0; i < pisteet.size() / 2; i += 2) {

			if (pisteet.get(i).equals(pisteet.get(i + 2)) && pisteet.get(i + 1).equals(pisteet.get(i + 1 + 2))) {
				tarkistustulos = false;
			} else {
				tarkistustulos = true;
			}
		}
		return tarkistustulos;
	}
}
