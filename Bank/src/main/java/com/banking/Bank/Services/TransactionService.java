package com.banking.Bank.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.Bank.Model.CustomerDetails;
import com.banking.Bank.Model.CustomerTransaction;
import com.banking.Bank.repository.CustomerRepository;
import com.banking.Bank.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {
	@Autowired
	private CustomerRepository cr;
	
	@Autowired
	private TransactionRepository transaction;
	
	CustomerDetails cd;
	@Transactional
	public void transfer(Long fromAccount, Long toAccount, Double amount) {
		boolean ce = cr.existByAccountNumber(fromAccount);
		if(ce) {
		cr.updateBalance(amount,fromAccount);
		CustomerTransaction tr = new CustomerTransaction();
		tr.setFromAccount(fromAccount);
		tr.setToAccount(toAccount);
		tr.setTransferAmount(amount);
		tr.setTimestamp(LocalDateTime.now());
		tr.setTransactionType("Self-Deposit");
		transaction.save(tr);
		
		}
		
		
		
		
	}
	@Transactional
	public void transfertoOther(Long fromAccount, Long toAccount, Double amount) {
		boolean ce = cr.existByAccountNumber(fromAccount);
		boolean cd = cr.existByAccountNumber(toAccount);
		if(ce && cd) {
		cr.updateBalance(amount,toAccount);
		cr.updateAfterTransferBalance(amount,fromAccount);
		CustomerTransaction tr = new CustomerTransaction();
		tr.setFromAccount(fromAccount);
		tr.setToAccount(toAccount);
		tr.setTransferAmount(amount);
		tr.setTimestamp(LocalDateTime.now());
		tr.setTransactionType("Transfer");
		transaction.save(tr);
		
		}
		
		
		
		
	}
	@Transactional
	public void withdrawl(Long fromAccount, Long toAccount, Double amount) {
		// TODO Auto-generated method stub
		boolean ce = cr.existByAccountNumber(fromAccount);
		boolean cd = cr.existByAccountNumber(toAccount);
		if(ce && cd) {
		cr.updateAfterTransferBalance(amount,fromAccount);
		CustomerTransaction tr = new CustomerTransaction();
		tr.setFromAccount(fromAccount);
		tr.setToAccount(toAccount);
		tr.setTransferAmount(amount);
		tr.setTimestamp(LocalDateTime.now());
		tr.setTransactionType("Withdrawl");
		transaction.save(tr);
		
	}
	

	}
	public List<CustomerTransaction> getRecentTransaction(Long accountnumber) {
		// TODO Auto-generated method stub
		return transaction.getRecentTransaction(accountnumber);
	}
}
