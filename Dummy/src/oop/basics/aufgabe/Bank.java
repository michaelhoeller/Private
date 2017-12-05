package oop.basics.aufgabe;

/*
 * DIESE KLASSE NICHT VERÄNDERN!!!!
 * 
 *  1. Macht ein Kopie der Aufgabe in eurem Projekt
 *  	==> Commit und Push
 * 
 *  2. Macht Eclipse glücklich!
 *  	==> Commit und Push
 *  
 *  3. Sorgt dafür dass kein Fehler mehr ausgegeben wird.
 *  	==> Commit und Push
 *  
 */
public class Bank {

	public static void main(String[] args) throws LimitException {
		Konto k = new Konto();

		k.setDispo(1000);

		if (k.getKontostand() != 0) {
			System.out.println("Fehler 1");
		}
		if (k.getDispo() != 1000) {
			System.out.println("Fehler 2");
		}

		k.einzahlen(500);
		if (k.getKontostand() != 500) {
			System.out.println("Fehler 3");
		}
		k.einzahlen(-500);
		if (k.getKontostand() != 500) {
			System.out.println("Fehler 4");
		}
		k.auszahlen(300);
		if (k.getKontostand() != 200) {
			System.out.println("Fehler 5");
		}

		k.auszahlen(400);
		if (k.getKontostand() != -200) {
			System.out.println("Fehler 6");
		}
		k.auszahlen(1000);
		if (k.getKontostand() != -200) {
			System.out.println("Fehler 7");
		}
	}

}
