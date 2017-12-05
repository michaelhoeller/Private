package oop.basics;

public class KreisNutzer {

	public static void main(String[] args) {
		// 1. deklariere eine Referenzvariable
		Kreis k;
		// 2. Intialisieren
		k = null;
//		System.out.println(k.berechneUmfang()); // Nullpointer
		// erzeuge ein Objekt
		k = new Kreis();
		k.setRadius(5);
		System.out.println(k.berechneUmfang()); 

	}

}
