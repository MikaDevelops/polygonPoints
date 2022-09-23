package polygoni.esikarsintatehtava;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage stage) {
		Pane ruutu = new Pane();
		Label infoTeksti = new Label();
		
		Polygon polygoni = new Polygon();
		try {
			polygoni.lataaPolygoninKulmakoordinaatit();
			ArrayList<Double> kulmaKoordinaatit = polygoni.haeKoordinaatit();
			if (kulmaKoordinaatit.size() < 3) {
				infoTeksti.setText("janoja alle kolme -> ei polygoni");
			} else {
				javafx.scene.shape.Polygon polygoniPiirros = luoPolygonPiirros(kulmaKoordinaatit);
				ruutu.getChildren().add(polygoniPiirros);
			}
		} catch (FileNotFoundException e) {
			infoTeksti.setText("Tiedostoa polygon.txt ei löytynyt");
		}

		Point pisteet = new Point();
		try {
			pisteet.lataaPisteet();
		} catch (FileNotFoundException e) {
			infoTeksti.setText("Tiedostoa pisteet.txt ei löytynyt");
		} catch (IdenttisiaPisteitaException e) {
			infoTeksti.setText("Identtisiä koordinaatiopisteitä löytyi" + "pisteet.txt tiedostosta");
		}

		ruutu.getChildren().add(infoTeksti);

		Scene scene = new Scene(ruutu, 640, 480);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

	/**
	 * luoPolygonPiirros luo piirroksen pisteiden mukaan ikkunaan.
	 * 
	 * @param kulmapisteet ArrayList<Double>
	 */
	private static javafx.scene.shape.Polygon luoPolygonPiirros(ArrayList<Double> kulmapisteet) {
		javafx.scene.shape.Polygon monikulmaPiirros = new javafx.scene.shape.Polygon();
		monikulmaPiirros.setFill(Color.LIGHTGRAY);
		monikulmaPiirros.setStroke(Color.BLACK);
		monikulmaPiirros.setStrokeWidth(1);
		ObservableList<Double> kulmalista = monikulmaPiirros.getPoints();
		for (int i = 0; i < kulmapisteet.size(); i++) {
			kulmalista.add(kulmapisteet.get(i));
		}

		return monikulmaPiirros;
	}

}