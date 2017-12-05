package basic.aufgabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KaffeeAutomat {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Bitte eingeworfenen Betrag eingeben (in Euro)");
		float centsPayed = Float.parseFloat(br.readLine()) * 100;
		System.out.println("Bitte Preis eingeben (in Euro)");
		float centsPrice = Float.parseFloat(br.readLine()) * 100;

		br.close();

		int[] coinValue = { 200, 100, 50, 20, 10, 5, 2, 1 };
		int[] coinCunter = { 0, 0, 0, 0, 0, 0, 0, 0 };

		int difference = (int) (centsPayed - centsPrice);
		int restBetrag = (int) centsPayed;
		int coinCount = 0;

		int i = 0;
		while (restBetrag > 0) {
			restBetrag = difference % coinValue[i];
			coinCount = difference / coinValue[i];

			coinCunter[i] = coinCount;
			difference = restBetrag;

			++i;
		}
		System.out.println("-------------------------------------------");
		for (int j = 0; j < coinCunter.length; j++) {
			System.out.println("Anzahl der " + coinValue[j] + " Cent Münzen ist: " + coinCunter[j]);
		}
	}

}
