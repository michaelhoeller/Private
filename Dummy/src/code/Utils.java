package code;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    
    private Integer dummyAmount;
    private String  startAge;
    private String  endAge;
    private String  outPutLoc;
    
    public Utils() {
        configure();
    }
    
    public void configure() {
        Properties props = ResourceFinder.findProperties("dummy.properties");
        
        // Setzen der DummyAnzahl
        String amount = props.getProperty("numberOfDummys");
        this.setDummyAmount(Integer.parseInt(amount));
        
        // Setzen des Output-Pfades
        String outPutLoc = props.getProperty("outPutLoc");
        this.setOutPutLoc(outPutLoc);
        
        // Setzen der Altersbeschränkung
        String startAge = props.getProperty("startAge");
        this.setStartAge(startAge);
        
        // Ende der Altersbeschränkung
        String endAge = props.getProperty("endAge");
        this.setEndAge(endAge);
        
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
    
    public static void printHeaderToFile(PrintWriter out, int count) {
        out.println("PROMPT Einfügen von " + count + " Dummys erfolgt:");
        
    }
    
    public static void printDummyToFile(PrintWriter out, Dummy dummy) {
        out.println("Insert into Users (USER_NAME, USER_LASTNAME, BIRTHDAY) VALUES (" + dummy.getSureName() + ", "
            + dummy.getLastName() + ", " + dummy.getBirthday() + ");");
    }
    
    public static void printEndingToFile(PrintWriter out) {
        out.println("commit;");
    }
    
    public Integer getDummyAmount() {
        return dummyAmount;
    }
    
    public void setDummyAmount(Integer dummyAmount) {
        this.dummyAmount = dummyAmount;
    }
    
    public String getEndAge() {
        return endAge;
    }
    
    public void setEndAge(String endAge) {
        this.endAge = endAge;
    }
    
    public String getStartAge() {
        return startAge;
    }
    
    public void setStartAge(String startAge) {
        this.startAge = startAge;
    }
    
    public String getOutPutLoc() {
        return outPutLoc;
    }
    
    public void setOutPutLoc(String outPutLoc) {
        this.outPutLoc = outPutLoc;
    }
    
}
