package com.wipro.CustomerAccountTracker.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AccountDetails")
public class AccountBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "AccountNumber", nullable = false, unique = true)
	private long accountNumber;

	@Column(name = "AccountType", nullable = false)
	private String accountType;

	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "BalanceAmount", nullable = false)
	private int balanceAmount;

	// Constructors
	public AccountBean() {
	}

	public AccountBean(long accountNumber, String accountType, String name, int balanceAmount) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.name = name;
		this.balanceAmount = balanceAmount;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	// Override toString method for better output readability
	@Override
	public String toString() {
		return "AccountBean [userId=" + userId + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", name=" + name + ", balanceAmount=" + balanceAmount + "]";
	}
}
