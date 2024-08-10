package com.banking.Bank.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banking.Bank.Model.CustomerDetails;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Long> {

	@Query("SELECT CASE WHEN count(e) > 0 THEN true ELSE false END FROM CustomerDetails e where e.accountNumber = ?1")
	boolean existByAccountNumber(@Param("accountnumber") Long accountnumber);
	@Modifying
	@Query("UPDATE CustomerDetails SET accountBalance = accountBalance+ ?1 where accountNumber = ?2")
	void updateBalance( Double amount, @Param("accountnumber") Long fromAccount);
	@Modifying
	@Query("UPDATE CustomerDetails SET accountBalance = accountBalance- ?1 where accountNumber = ?2")
	void updateAfterTransferBalance(Double amount, Long fromAccount);
	

}
