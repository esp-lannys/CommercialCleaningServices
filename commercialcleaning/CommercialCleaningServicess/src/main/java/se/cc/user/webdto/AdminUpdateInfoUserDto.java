package se.cc.user.webdto;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import se.cc.user.constraint.FieldMatch;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
})
public class AdminUpdateInfoUserDto {
	
	private long id;
	
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

	@NotEmpty
	private String confirmpassword;
	
	private int power;
	
	private Timestamp update_date;
	
	private String dropdownSelectedValue;
	
	private Date birthday;
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public Timestamp getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date() {
		java.util.Date date= new java.util.Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		this.update_date = ts;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmPassword) {
		this.confirmpassword = confirmPassword;
	}

	public String getDropdownSelectedValue() {
		return dropdownSelectedValue;
	}

	public void setDropdownSelectedValue(String dropdownSelectedValue) {
		this.dropdownSelectedValue = dropdownSelectedValue;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
