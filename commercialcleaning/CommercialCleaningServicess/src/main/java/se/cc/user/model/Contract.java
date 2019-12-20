package se.cc.user.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "contract")
public class Contract {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="phone")
	private String phone;
	@Column(name="address", columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin")
	private String address;
	@OneToOne(cascade =  CascadeType.ALL )
	@JoinColumn(name = "userid")
	private User user;
	@Column(name="packNumber")
	private int packNumber;
	
	private String firstName;
	
	private String lastName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
