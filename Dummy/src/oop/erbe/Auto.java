package oop.erbe;

public class Auto {

	private int ps;
	private String marke;

	// Standard-Konstruktor
	public Auto() {
		this(50, "Trabi");
	}
	
	public Auto(int ps, String marke) {
		super();
		this.ps = ps;
		this.marke = marke;
	}

	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public String getMarke() {
		return marke;
	}
	public void setMarke(String marke) {
		this.marke = marke;
	}
	
	
}
