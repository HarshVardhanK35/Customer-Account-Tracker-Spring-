package com.wipro.CustomerAccountTracker.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerDetails")
public class CustomerBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "AccountNumber", nullable = false, unique = true)
	private long accountNumber;

	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "Gender", nullable = false)
	private String gender;

	@Column(name = "Email", nullable = false, unique = true)
	private String email;

	@Column(name = "Contact", nullable = false)
	private String contact;

	@Column(name = "AadharNo", nullable = false, unique = true)
	private String aadharNo;

	@Column(name = "AccountType", nullable = false)
	private String accountType;

	// Constructors
	public CustomerBean() {
	}

	public CustomerBean(long accountNumber, String name, String gender, String email, String contact, String aadharNo, String accountType) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.contact = contact;
		this.aadharNo = aadharNo;
		this.accountType = accountType;
	}

	// Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "CustomerBean [userId=" + userId + ", accountNumber=" + accountNumber + ", name=" + name + ", gender="
				+ gender + ", email=" + email + ", contact=" + contact + ", aadharNo=" + aadharNo + ", accountType="
				+ accountType + "]";
	}
}
