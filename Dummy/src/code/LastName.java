package code;
import java.util.Random;

public enum LastName {
    Abek, Aiger, Altzinger, Antholzner, Aner, Abel, Aiginger, Alvarez, Anthonys, Assolino, Abele;
    
    public static LastName getRandomLastName() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
