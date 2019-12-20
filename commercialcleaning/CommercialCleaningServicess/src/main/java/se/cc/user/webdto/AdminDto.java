package se.cc.user.webdto;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AdminDto {

	@NotEmpty
	private String firstname;

	@NotEmpty
	private String lastname;
	
	@NotEmpty
	private String username;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String password;
	
	private Date birthday;
	
	private String sex;
	
	private int power;
	
	private String dropdownSelectedValue;
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getDropdownSelectedValue() {
		return dropdownSelectedValue;
	}

	public void setDropdownSelectedValue(String dropdownSelectedValue) {
		this.dropdownSelectedValue = dropdownSelectedValue;
	}
}
