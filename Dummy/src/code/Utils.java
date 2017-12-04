package code;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    
    private Integer dummyAmount;
    
    public Utils() {
        configure();
    }
    
    public void configure() {
        Properties props = ResourceFinder.findProperties("dummy.properties");
        
        String amount = props.getProperty("numberOfDummys");
        this.setDummyAmount(Integer.parseInt(amount));
        System.out.println("Anzahl der zu generierenden Dummys: " + amount);
    }
    
    public static int getRandomAge(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    
    public static Timestamp getRandomTimestamp(String beginTime, String endTime) {
        long offset = Timestamp.valueOf(beginTime).getTime();
        long end = Timestamp.valueOf(endTime).getTime();
        
        long diff = end - offset + 1;
        Timestamp rand = new Timestamp(offset + (long) (Math.random() * diff));
        return rand;
    }
    
    public static void printHeaderToFile(PrintWriter out) {
        out.println();
        
    }
    
    // INSERT INTO table_name (column1, column2, column3, ...)
    // VALUES (value1, value2, value3, ...);
    
    public static void printDummyToFile(PrintWriter out, Dummy dummy) {
        out.println("Insert into Users (USER_NAME, USER_LASTNAME, BIRTHDAY) VALUES (" + dummy.getSureName() + ", " + dummy.getLastName() + ", " + dummy.getBirthday() + ");");
    }
    
    public Integer getDummyAmount() {
        return dummyAmount;
    }
    
    public void setDummyAmount(Integer dummyAmount) {
        this.dummyAmount = dummyAmount;
    }
    
}
