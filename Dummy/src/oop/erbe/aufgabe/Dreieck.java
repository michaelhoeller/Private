package oop.erbe.aufgabe;

public class Dreieck extends GeometrischeFigur {
	private int seiteA;
	private int seiteB;
	private int seiteC;

	public Dreieck(int i, int j, int k) {
		this.seiteA = i;
		this.seiteB = j;
		this.seiteC = k;
		super.name = "Dreieck";
	}

	@Override
	public Double berechneUmfang() {

		return (double) (seiteA + seiteB + seiteC);
	}

	public int getSeiteA() {
		return seiteA;
	}

	public void setSeiteA(int seiteA) {
		this.seiteA = seiteA;
	}

	public int getSeiteB() {
		return seiteB;
	}

	public void setSeiteB(int seiteB) {
		this.seiteB = seiteB;
	}

	public int getSeiteC() {
		return seiteC;
	}

	public void setSeiteC(int seiteC) {
		this.seiteC = seiteC;
	}

}
