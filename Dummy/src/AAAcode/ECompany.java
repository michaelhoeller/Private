package AAAcode;

import java.util.Random;

public enum ECompany {
<<<<<<< HEAD
	Bosch, Datev, Siemens, Semikron, Continental, NuernbergerNachrichten, Novartis, GfK, Leoni, Fuerst, Diehl, ErgoDirekt, MAN, Staedler, Prinovis, CortalConsors, Engelhardt, AlcatelLucent, INGDiba, UniVersa, VAG, SparkasseNuernberg, nErgie, Baumuller;

	public static ECompany getRandomCompany() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
=======
    Bosch, Datev, Siemens, Semikron, Continental, NĂrnbergerNachrichten, Novartis, GfK, Leoni, FĂrst, Diehl, ErgoDirekt, MAN, Staedler, Prinovis, CortalConsors, Engelhardt, AlcatelLucent, INGDiba, UniVersa, VAG, SparkasseNĂrnberg, nErgie, Baumuller;
    
    public static ECompany getRandomCompany() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
>>>>>>> branch 'master' of https://github.com/michaelhoeller/Private.git
}
