package com.anglobal.julio.service.impl;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.anglobal.julio.dao.IAccountDao;
import com.anglobal.julio.dao.ITransactionDao;
import com.anglobal.julio.model.Account;
import com.anglobal.julio.model.Transaction;
import com.anglobal.julio.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	IAccountDao accountDao;
	
	@Autowired
	ITransactionDao transactionDao;
	
	@Override
	@Transactional()
	public void doTransfer(Transaction transaction) {
		if(transaction != null) {
			Account fAccount = accountDao.findByNumberAccount(transaction.getFromAccount());
			Account tAccount = accountDao.findByNumberAccount(transaction.getToAccount());
			if(transaction.getAmount().intValue() > 0 && 
				fAccount != null && fAccount.getBalance().intValue() > transaction.getAmount().intValue() && 
				tAccount != null) {
				fAccount.setBalance(fAccount.getBalance().subtract(transaction.getAmount()));
				accountDao.save(fAccount);
				tAccount.setBalance(tAccount.getBalance().add(transaction.getAmount()));
				accountDao.save(tAccount);
				transaction.setSentAt(LocalDateTime.now());
				transactionDao.save(transaction);
			}
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Account getBalance(Integer account) {
		return accountDao.findByNumberAccount(account);
	}

}
