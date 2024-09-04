package com.wipro.CustomerAccountTracker.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.CustomerAccountTracker.Bean.AccountBean;
import com.wipro.CustomerAccountTracker.Dao.AccountDao;
import com.wipro.CustomerAccountTracker.Exception.RecordNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	AccountDao accountDao;

	@Autowired
	CustomerService customerService;

	public AccountBean getAccountDetailsByAccountNumber(Long accountNumber) throws RecordNotFoundException {
		logger.info("Fetching account details for account number: {}", accountNumber);
		Optional<AccountBean> account = accountDao.findByAccountNumber(accountNumber);
		if (account.isPresent()) {
			return account.get();
		} else {
			throw new RecordNotFoundException("No Customer record exists for the given Account Number: " + accountNumber);
		}
	}
}
