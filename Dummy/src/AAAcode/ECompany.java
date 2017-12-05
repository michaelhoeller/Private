package AAAcode;

import java.util.Random;

public enum ECompany {
    Bosch, Datev, Siemens, Semikron, Continental, NÃrnbergerNachrichten, Novartis, GfK, Leoni, FÃrst, Diehl, ErgoDirekt, MAN, Staedler, Prinovis, CortalConsors, Engelhardt, AlcatelLucent, INGDiba, UniVersa, VAG, SparkasseNÃrnberg, nErgie, Baumuller;
    
    public static ECompany getRandomCompany() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
