package polygoni.esikarsintatehtava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
	
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
	}
}
