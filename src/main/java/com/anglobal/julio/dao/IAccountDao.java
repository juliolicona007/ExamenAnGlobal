package com.anglobal.julio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.anglobal.julio.model.Account;

@Repository
public interface IAccountDao extends JpaRepository<Account, Long> {

	Account findByNumberAccount(Integer account);
	
}
