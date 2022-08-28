package polygoni.esikarsintatehtava;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Selvitys {
	private ArrayList<String> polygoninPisteet;
	private ArrayList<String> viivanPaalla;
	private ArrayList<String> kuvionSisalla;
	private ArrayList<String> kuvionUlkopuolella;

	public Selvitys(ArrayList<String> polygoninPisteet, ArrayList<String> viivanPaalla, ArrayList<String> kuvionSisalla,
			ArrayList<String> kuvionUlkopuolella) {
		this.polygoninPisteet = polygoninPisteet;
		this.viivanPaalla = viivanPaalla;
		this.kuvionSisalla = kuvionSisalla;
		this.kuvionUlkopuolella = kuvionUlkopuolella;
	}

	public boolean luoSelvitys() {

		String tiedostonimi = "selvitys.txt";

		File tiedosto = new File(tiedostonimi);
		tiedosto.delete();
		try {
			tiedosto.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileWriter tiedostoKirjoittaja = new FileWriter(tiedostonimi);
			tiedostoKirjoittaja.write("Polygonin koordinaatti pisteet: ");
			for (int i = 0; i < polygoninPisteet.size(); i++) {
				tiedostoKirjoittaja.write(polygoninPisteet.get(i));
				if (i == polygoninPisteet.size() - 1) {
					tiedostoKirjoittaja.write("\n\n");
				} else {
					tiedostoKirjoittaja.write(", ");
				}
			}
			for (int i = 0; i < viivanPaalla.size(); i++) {
				tiedostoKirjoittaja.write("Piste: " + viivanPaalla.get(i) + " on viivan päällä.\n");
			}
			for (int i = 0; i < kuvionSisalla.size(); i++) {
				tiedostoKirjoittaja.write("Piste: " + kuvionSisalla.get(i) + " on kuvion sisällä.\n");
			}
			for (int i = 0; i < kuvionUlkopuolella.size(); i++) {
				tiedostoKirjoittaja.write("Piste: " + kuvionUlkopuolella.get(i) + " on kuvion ulkopuolella.\n");
			}
			tiedostoKirjoittaja.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
}
