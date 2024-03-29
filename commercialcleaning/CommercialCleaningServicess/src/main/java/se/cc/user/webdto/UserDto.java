package se.cc.user.webdto;

import java.sql.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

import se.cc.user.constraint.ValidPassword;

public class UserDto {
	@NotEmpty
	private String username;
	@NotEmpty
	@ValidPassword
	private String password;
	@NotEmpty
	@ValidPassword
	private String confirmpassword;
	private Date birthday;
	private int age;
	@NotEmpty
	private String email;
	@NotEmpty
	private String firstname;
	@NotEmpty
	private String lastname;
	private final int power = 1;
	@AssertTrue
	private Boolean terms;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Boolean getTerms() {
		return terms;
	}

	public void setTerms(Boolean terms) {
		this.terms = terms;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getPower() {
		return power;
	}
	
}
