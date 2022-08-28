package polygoni.esikarsintatehtava;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PolygoniTest {
	Polygon testiPolygoni;

	@Before
	public void initialize() {
		testiPolygoni = new Polygon();
	}

	@Test
	public void testTarkistaKulmatHuomaaNollakulmanAlussa() {
		double pisteetNollakulmaAlussa[] = { 10.0, 10.0, 20.0, 20.0, 30.0, 30.0, 30.0, 10.0 };

		ArrayList<Double> nollakulmaAlussa = new ArrayList<>();
		for (int i = 0; i < pisteetNollakulmaAlussa.length; i++) {
			nollakulmaAlussa.add(pisteetNollakulmaAlussa[i]);
		}

		testiPolygoni.asetaKulmakoordinaatit(nollakulmaAlussa);
		boolean tulos = testiPolygoni.tarkistaKulmat();

		assertFalse(tulos);
	}

	@Test
	public void testTarkistaKulmatHuomaaNollakulmanLopussa() {
		double pisteetNollakulmaLopussa[] = { 100.0, 10.0, 150.0, 10.0, 50.0, 50.0, 50.0, 10.0 };
		ArrayList<Double> nollakulmaLopussa = new ArrayList<>();
		for (int i = 0; i < pisteetNollakulmaLopussa.length; i++) {
			nollakulmaLopussa.add(pisteetNollakulmaLopussa[i]);
		}

		testiPolygoni.asetaKulmakoordinaatit(nollakulmaLopussa);
		boolean tulos = testiPolygoni.tarkistaKulmat();

		assertFalse(tulos);
	}

}
