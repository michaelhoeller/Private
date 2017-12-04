package code;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    
    /**
     * getRandomLastName()
     * getRandomSureName()
     * 
     * @throws FileNotFoundException
     */
    
    // Main Methode
    public static void main(String[] args) throws FileNotFoundException {
        Utils utils = new Utils();
        PrintWriter out = new PrintWriter("TestFile.txt");
        
        for (int i = 0; i < utils.getDummyAmount(); i++) {
            Dummy temp = new Dummy();
            System.out.println(temp.getSureName() + " " + temp.getLastName());
            System.out.println(temp.getBirthday());
            Utils.printDummyToFile(out, temp);
        }
        out.close();
        
    }
    
}
