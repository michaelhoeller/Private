package code;

import java.util.Random;

public enum Company {
	Bosch,
	Datev,
	Siemens,
	Semikron,
	Continental,
	NürnbergerNachrichten,
	Novartis, 
	GfK, 
	Leoni, 
	Fürst, 
	Diehl, 
	ErgoDirekt, 
	MAN, 
	Staedler, 
	Prinovis, 
	CortalConsors, 
	Engelhardt, 
	AlcatelLucent, 
	INGDiba, 
	UniVersa, 
	VAG, 
	SparkasseNürnberg, 
	nErgie, 
	Baumuller;
	
    public static Company getRandomCompany() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
