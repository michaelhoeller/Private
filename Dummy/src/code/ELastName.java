package code;
import java.util.Random;

public enum ELastName {
    Abek, Aiger, Altzinger, Antholzner, Aner, Abel, Aiginger, Alvarez, Anthonys, Assolino, Abele;
    
    public static ELastName getRandomLastName() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
