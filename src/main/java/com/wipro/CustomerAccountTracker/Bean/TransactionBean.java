package com.wipro.CustomerAccountTracker.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TransactionDetails")
public class TransactionBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "BeneficiaryName", nullable = false)
	private String beneficiaryName;

	@Column(name = "BeneficiaryAccountNumber", nullable = false)
	private long beneficiaryAccountNumber;

	@Column(name = "Amount", nullable = false)
	private int amount;

	@Column(name = "BalanceAmount", nullable = false)
	private int balanceAmount;

	// Constructors
	public TransactionBean() {}

	public TransactionBean(String beneficiaryName, long beneficiaryAccountNumber, int amount, int balanceAmount) {
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.amount = amount;
		this.balanceAmount = balanceAmount;
	}

	// Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	@Override
	public String toString() {
		return "TransactionBean [userId=" + userId + ", beneficiaryName=" + beneficiaryName
				+ ", beneficiaryAccountNumber=" + beneficiaryAccountNumber + ", amount=" + amount + ", balanceAmount="
				+ balanceAmount + "]";
	}
}
