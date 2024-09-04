package com.wipro.CustomerAccountTracker.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.CustomerAccountTracker.Bean.AccountBean;
import com.wipro.CustomerAccountTracker.Bean.TransactionBean;
import com.wipro.CustomerAccountTracker.Dao.AccountDao;
import com.wipro.CustomerAccountTracker.Dao.TransactionDao;
import com.wipro.CustomerAccountTracker.Exception.RecordNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TransactionService {

	private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

	@Autowired
	TransactionDao transactionDao;

	@Autowired
	AccountDao accountDao;

	public String transferAmount(long accountNumber, TransactionBean transactionBean) throws RecordNotFoundException {
		Optional<AccountBean> accountOpt = accountDao.findByAccountNumber(accountNumber);

		if (accountOpt.isPresent()) {
			AccountBean account = accountOpt.get();

			if (account.getBalanceAmount() >= transactionBean.getAmount()) {
				account.setBalanceAmount(account.getBalanceAmount() - transactionBean.getAmount());
				accountDao.save(account);

				transactionBean.setBalanceAmount(account.getBalanceAmount());
				transactionDao.save(transactionBean);

				logger.info("Transaction successful for account number: {}", accountNumber);
				return "Transaction Successful";
			} else {
				logger.warn("Insufficient funds for account number: {}", accountNumber);
				return "Insufficient funds. Max amount available for transaction is " + account.getBalanceAmount();
			}
		} else {
			throw new RecordNotFoundException("Account Number Not Found: " + accountNumber);
		}
	}
}
