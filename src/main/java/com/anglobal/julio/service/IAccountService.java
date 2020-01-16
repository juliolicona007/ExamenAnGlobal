package com.anglobal.julio.service;

import com.anglobal.julio.model.Account;
import com.anglobal.julio.model.Transaction;

public interface IAccountService {

	void doTransfer(Transaction transaction);
	
	Account getBalance(Integer account);
	
}
