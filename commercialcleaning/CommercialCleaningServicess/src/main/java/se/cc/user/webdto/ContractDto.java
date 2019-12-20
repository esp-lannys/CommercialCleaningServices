package se.cc.user.webdto;

import javax.validation.constraints.NotEmpty;

public class ContractDto {
	@NotEmpty
	private String phone;
	@NotEmpty
	private String address;
	@NotEmpty
	private int packNumber;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPackNumber() {
		return packNumber;
	}
	public void setPackNumber(int packNumber) {
		this.packNumber = packNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
