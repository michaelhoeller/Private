package oop.basics;

public class Kreis {
	private int radius;
	
	
	double berechneUmfang() {
		int multiplikator = 2;
		
		return multiplikator * Math.PI * radius;
	}


	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		if (radius >= 0) {
			this.radius = radius;
		} else {
			// Mecker!
		}
	}
}
