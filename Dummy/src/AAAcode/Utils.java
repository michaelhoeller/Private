package AAAcode;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        out.println("PROMPT Insert of " + count + " dummys:");
        
    }
    
    public static void printDummyToFile(PrintWriter out, Dummy dummy) {
        out.println("Insert into Users (USER_NAME, USER_LASTNAME, BIRTHDAY, EMAIL) VALUES (" + dummy.getSureName()
            + ", " + dummy.getLastName() + ", " + dummy.getBirthday() + ", " + dummy.getEmail() + ");");
    }
    
    public static void printEndingToFile(PrintWriter out) {
        out.println("commit;");
    }
    
    public void configure() {
        Properties props = findProperties("dummy.properties");
        
        // Setzen der DummyAnzahl
        String amount = props.getProperty("numberOfDummys");
        this.setDummyAmount(Integer.parseInt(amount));
        
        // Setzen des Output-Pfades
        String outPutLoc = props.getProperty("outPutLoc");
        this.setOutPutLoc(outPutLoc);
        
        // Setzen der Altersbeschr�nkung
        String startAge = props.getProperty("startAge");
        this.setStartAge(startAge);
        
        // Ende der Altersbeschr�nkung
        String endAge = props.getProperty("endAge");
        this.setEndAge(endAge);
        
    }
    
    public static Properties findProperties(String filename) {
        InputStream is = null;
        Properties props = new Properties();
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (is == null) {
            try {
                is = Utils.class.getResourceAsStream(filename);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        if (is == null) {
            try {
                is = Utils.class.getClassLoader().getResourceAsStream(filename);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        try {
            if (is != null) {
                is = new BufferedInputStream(is);
                // System.out.println("the specified file : '" + filename + "' from the class
                // resource path.");
            }
            else {
                is = new BufferedInputStream(new FileInputStream(filename));
                // System.out.println("the specified file : '" + filename + "'");
            }
            props.load(is);
        }
        catch (IOException ioe) {
            throw new RuntimeException("Properties file: '" + filename + "' could not be read.", ioe);
        }
        finally {
            if (is != null)
                try {
                    is.close();
                }
                catch (IOException ignore) {
                }
        }
        return props;
        
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
