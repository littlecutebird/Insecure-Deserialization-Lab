package beans;

import java.io.Serializable;

public class Account implements Serializable {
	private String username, email, sex, year;
	public Account(String username, String email, String sex, String year) {
		super();
		this.username = username;
		this.email = email;
		this.sex = sex;
		this.year = year;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

}
