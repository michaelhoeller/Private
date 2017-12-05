package oop.erbe.aufgabe;

public class Rechteck extends GeometrischeFigur {

	private int laenge;
	private int breite;

	public Rechteck(int i, int j) {
		this.breite = i;
		this.laenge = j;
		super.name = "Rechteck";
	}

	@Override
	public Double berechneUmfang() {

		return (double) (laenge * 2 + breite * 2);
	}

	public int getLaenge() {
		return laenge;
	}

	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

}
