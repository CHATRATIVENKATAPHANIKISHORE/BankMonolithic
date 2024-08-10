package com.banking.Bank.Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;

@Entity
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountNumber;
	

	
	private String customerName;
	
	private Double accountBalance = 500.0;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "CustomerDetails [accountNumber=" + accountNumber + ", customerName=" + customerName
				+ ", accountBalance=" + accountBalance + "]";
	}
	public CustomerDetails(Long accountNumber, String customerName, Double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}
	public CustomerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	}
