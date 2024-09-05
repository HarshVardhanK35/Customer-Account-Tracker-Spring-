package com.wipro.CustomerAccountTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.CustomerAccountTracker.Bean.AccountBean;
import com.wipro.CustomerAccountTracker.Bean.CustomerBean;
import com.wipro.CustomerAccountTracker.Dao.AccountDao;
import com.wipro.CustomerAccountTracker.Dao.CustomerDao;
import java.util.List;
import java.util.Random;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private AccountDao accountDao;

	public long createCustomer(CustomerBean customerBean, AccountBean accountBean) {
		if (customerBean == null || accountBean == null) {
			throw new IllegalArgumentException("Customer or Account details are missing.");
		}

		// Set default values if necessary
		if (accountBean.getAccountType() == null || accountBean.getAccountType().isEmpty()) {
			accountBean.setAccountType("Savings");  // Default to "Savings"
		}

		if (accountBean.getName() == null || accountBean.getName().isEmpty()) {
			accountBean.setName(customerBean.getName());  // Use the customer's name for the account
		}

		// Generate account number
		long accountNumber = Math.abs(generateRandom(12));
		customerBean.setAccountNumber(accountNumber);
		accountBean.setAccountNumber(accountNumber);

		// Save customer and account to the database
		customerDao.save(customerBean);
		accountDao.save(accountBean);

		// Return the generated accountNumber
		return accountNumber;
	}

	// Helper method to generate a random account number
	private long generateRandom(int length) {
		Random random = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < length; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		return Long.parseLong(new String(digits));
	}

	// Method to get all customers
	public List<CustomerBean> getAllCustomers() {
		return (List<CustomerBean>) customerDao.findAll(); // Fetch all customers from the database
	}
}
