package AAAcode;

import java.sql.Timestamp;

public class Dummy {

	// TODO: Zu bef�llende Datenbankfelder einrichten
	private ELastName lastName;
	private ESureName sureName;
	private Timestamp birthday;
	private String email;
	private ECompany company;
	private long phoneNumber;

	/**
	 * Speicherobjekt der Daten Nutzung zur temporären Speicherung der
	 * zufallsgenerierten Werte
	 */
	public Dummy(Utils utils) {
		setLastName(ELastName.getRandomLastName());
		setSureName(ESureName.getRandomSurename());
		setBirthday(Utils.getRandomTimestamp(utils.getStartAge(), utils.getEndAge()));
		setCompany(ECompany.getRandomCompany());
		setEmail(getSureName().toString().toLowerCase() + "." + getLastName().toString().toLowerCase() + "@"
				+ getCompany().toString().toLowerCase() + ".com");

	}

	public ELastName getLastName() {
		return lastName;
	}

	public void setLastName(ELastName lastName) {
		this.lastName = lastName;
	}

	public ESureName getSureName() {
		return sureName;
	}

	public void setSureName(ESureName sureName) {
		this.sureName = sureName;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public ECompany getCompany() {

		return company;
	}

	public void setCompany(ECompany company) {
		this.company = company;
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
