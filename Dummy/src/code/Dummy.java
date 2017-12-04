package code;

import java.sql.Timestamp;

public class Dummy {
    
    // TODO: Zu befüllende Datenbankfelder einrichten
    private LastName  lastName;
    private SureName  sureName;
    private Timestamp birthday;
    private String    email;
    private long      phoneNumber;
    
    public Dummy(Utils utils) {
        setLastName(LastName.getRandomLastName());
        setSureName(SureName.getRandomSurename());
        setBirthday(Utils.getRandomTimestamp(utils.getStartAge(), utils.getEndAge()));
    }
    
    public LastName getLastName() {
        return lastName;
    }
    
    public void setLastName(LastName lastName) {
        this.lastName = lastName;
    }
    
    public SureName getSureName() {
        return sureName;
    }
    
    public void setSureName(SureName sureName) {
        this.sureName = sureName;
    }
    
    public Timestamp getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public long getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
