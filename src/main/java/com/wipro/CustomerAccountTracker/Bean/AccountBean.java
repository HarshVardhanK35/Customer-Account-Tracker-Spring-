package com.wipro.CustomerAccountTracker.Bean;

import javax.persistence.*;

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
	private double balanceAmount;

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

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
}
