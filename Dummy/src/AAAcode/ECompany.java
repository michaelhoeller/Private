package AAAcode;

import java.util.Random;

public enum ECompany {
    Bosch, Datev, Siemens, Semikron, Continental, N�rnbergerNachrichten, Novartis, GfK, Leoni, F�rst, Diehl, ErgoDirekt, MAN, Staedler, Prinovis, CortalConsors, Engelhardt, AlcatelLucent, INGDiba, UniVersa, VAG, SparkasseN�rnberg, nErgie, Baumuller;
    
    public static ECompany getRandomCompany() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
