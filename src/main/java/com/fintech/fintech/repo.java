package com.fintech.fintech;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface repo extends JpaRepository <ledgerentry,Long>{ 
 @Query("SELECT SUM( CASE WHEN e.transactionType = 'CREDIT' THEN e.amount WHEN e.transactionType = 'DEBIT' THEN -e.amount ELSE 0 END ) FROM ledgerentry e WHERE e.accountNumber = :accountNumber")

 Double calculateBalance(@Param("accountNumber") String accountNumber);




 
}
