package com.banking.Bank.Model;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerTransaction {
	//write id which is primary 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	
    private Long fromAccount ;
    
    private Long toAccount;
    
    private Double transferAmount;
    
    private LocalDateTime timestamp;
    private String transactionType;
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	public Double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	
	public CustomerTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public CustomerTransaction(Long transactionId, Long fromAccount, Long toAccount, Double transferAmount,
			LocalDateTime timestamp, String transactionType) {
		super();
		this.transactionId = transactionId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.transferAmount = transferAmount;
		this.timestamp = timestamp;
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "CustomerTransaction [transactionId=" + transactionId + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", transferAmount=" + transferAmount + ", timestamp=" + timestamp + ", transactionType="
				+ transactionType + "]";
	}

}
