package com.wipro.CustomerAccountTracker.Service;

import com.wipro.CustomerAccountTracker.Bean.CustomerBean;
import com.wipro.CustomerAccountTracker.Dao.CustomerDao;
import com.wipro.CustomerAccountTracker.Exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.CustomerAccountTracker.Bean.AccountBean;
import com.wipro.CustomerAccountTracker.Dao.AccountDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class AccountService {
	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	AccountDao accountDao;

	@Autowired
	private CustomerDao customerDao;

	// Fetch account details by account number
	public AccountBean getAccountDetailsByAccountNumber(Long accountNumber) throws RecordNotFoundException {
		logger.info("Fetching account details for account number: {}", accountNumber);
		return accountDao.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new RecordNotFoundException("No account record found for Account Number: " + accountNumber));
	}

	// Fetch all accounts
	public List<AccountBean> getAllAccounts() {
		logger.info("Fetching all account details");
		return (List<AccountBean>) accountDao.findAll();
	}

	// Add account and customer
	public String addAccount(AccountBean accountBean) {
		logger.info("Adding new account for customer: {}", accountBean.getName());

		// Create customer details based on the account
		CustomerBean customerBean = new CustomerBean(
				accountBean.getAccountNumber(),
				accountBean.getName(),
				"Unknown",  // Placeholder if not provided
				"default@email.com",  // Placeholder email
				"0000000000",  // Placeholder contact number
				"0000-0000-0000",  // Placeholder Aadhar No
				accountBean.getAccountType()
		);

		// Save both account and customer
		customerDao.save(customerBean);
		accountDao.save(accountBean);

		return "Account and customer details successfully created.";
	}
}
