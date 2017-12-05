package oop.basics.aufgabe;

public class Konto {
	private float dispo;
	private float kontostand;

	public Konto() {
		this.setKontostand(0);
	}

	void einzahlen(float temp) {
		if (temp > 0) {
			this.setKontostand(temp);
			System.out.println("Neuer Kontostand: " + this.getKontostand());
		}
	}

	void auszahlen(float temp) throws LimitException {
		try {
			if (this.getKontostand() - temp < (-this.getDispo())) {
				throw new LimitException();
			} else {
				this.setKontostand(getKontostand() - temp);
				System.out.println("Neuer Kontostand: " + this.getKontostand());
			}
		} catch (LimitException e) {
			System.out.println("Nicht möglich! Dispo wird überzogen");
		}
	}

	public float getDispo() {
		return dispo;
	}

	public void setDispo(float dispo) {
		this.dispo = dispo;
	}

	public float getKontostand() {
		return kontostand;
	}

	public void setKontostand(float kontostand) {
		this.kontostand = kontostand;
	}

}
