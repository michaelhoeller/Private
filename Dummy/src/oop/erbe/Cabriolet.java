package oop.erbe;

public class Cabriolet extends Auto {
	public Cabriolet() {
		super(400, "Porsche");
	}

	public Cabriolet(int ps, String marke) {
		super(ps, marke);
	}
	
	public void oeffneVerdeck() {
		System.out.println("öffne das Verdeck!");
	}

	@Override
	public String toString() {
		
		return "Cabriolet: "+super.toString();
	}
}
