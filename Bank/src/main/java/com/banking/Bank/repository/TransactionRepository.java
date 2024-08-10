package com.banking.Bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.banking.Bank.Model.CustomerDetails;
import com.banking.Bank.Model.CustomerTransaction;

public interface TransactionRepository extends JpaRepository<CustomerTransaction, Long> {

	@Query("select c from CustomerTransaction c where c.fromAccount = :accountnumber or "
			+ "c.toAccount = :accountnumber order by c.timestamp desc")
	List<CustomerTransaction> getRecentTransaction(Long accountnumber);

}
