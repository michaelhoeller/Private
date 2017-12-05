package oop.erbe.aufgabe;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * DIESE DATEI NICHT VERÄNDERN!
 * 
 * 1. Kopie erstellen
 * 
 * 2. Eclipse glücklich machen
 * 
 * 3. Umfang berechnen und ausgeben
 * 
 * @author tz
 *
 */
public class Malkasten {

	public static void main(String[] args) {

		DecimalFormat df = new DecimalFormat("##.##");
		df.setRoundingMode(RoundingMode.DOWN);

		GeometrischeFigur[] elemente = new GeometrischeFigur[3];

		elemente[0] = new Kreis(15); // mit Radius
		elemente[1] = new Rechteck(10, 20); // mit Breite und Höhe
		elemente[2] = new Dreieck(2, 5, 7); // mit drei Seitenlängen

		for (int i = 0; i < elemente.length; i++) {
			System.out.println("Umfang von Element " + elemente[i].getName() + " beträgt: "
					+ df.format(elemente[i].berechneUmfang()));
		}
	}
}
