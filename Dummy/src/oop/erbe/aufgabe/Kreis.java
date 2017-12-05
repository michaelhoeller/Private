package oop.erbe.aufgabe;

public class Kreis extends GeometrischeFigur {
	private float radius;

	public Kreis(int i) {
		this.radius = i;
		super.name = "Kreis";
	}

	@Override
	public Double berechneUmfang() {

		return radius * Math.PI * 2;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
