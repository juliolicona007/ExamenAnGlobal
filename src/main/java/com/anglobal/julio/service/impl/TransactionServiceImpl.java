package com.anglobal.julio.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.anglobal.julio.dao.ITransactionDao;
import com.anglobal.julio.model.Transaction;
import com.anglobal.julio.service.ITransactionService;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	ITransactionDao transactionDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Transaction> historyAll(Integer account) {
		return transactionDao.findAllByFromAccountOrToAccountOrderBySentAtAsc(account, account);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Transaction> historyReceived(Integer account) {
		return transactionDao.findAllByToAccountOrderBySentAtAsc(account);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Transaction> historySent(Integer account) {
		return transactionDao.findAllByFromAccountOrderBySentAtAsc(account);
	}

}
