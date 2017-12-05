package oop.erbe;

public class Parkplatz {

	public static void main(String[] args) {
		
		Auto[] autos = new Auto[4];
		autos[0] = new Auto(70, "VW");
		
		Cabriolet c = new Cabriolet(120, "Opel");
		autos[1] = c;
		autos[2] = new Cabriolet();
		autos[3] = new Auto();
		
		for (int i = 0; i < autos.length; i++) {
			System.out.println(autos[i].toString());
			if (autos[i] instanceof Cabriolet) {
				Cabriolet cTemp = (Cabriolet) autos[i];
				cTemp.oeffneVerdeck();
			}
		}
		
	}

}
