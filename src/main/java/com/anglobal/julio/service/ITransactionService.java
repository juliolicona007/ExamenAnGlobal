package com.anglobal.julio.service;

import java.util.List;
import com.anglobal.julio.model.Transaction;

public interface ITransactionService {

	List<Transaction> historyAll(Integer account);
	
	List<Transaction> historyReceived(Integer account);
	
	List<Transaction> historySent(Integer account);
	
}
