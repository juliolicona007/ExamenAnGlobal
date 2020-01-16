package com.anglobal.julio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.anglobal.julio.model.Transaction;

@Repository
public interface ITransactionDao extends JpaRepository<Transaction, Long> {

	List<Transaction> findAllByFromAccountOrToAccountOrderBySentAtAsc(Integer fromAccount, Integer toAccount);
	
	List<Transaction> findAllByFromAccountOrderBySentAtAsc(Integer account);
	
	List<Transaction> findAllByToAccountOrderBySentAtAsc(Integer account);
	
}
