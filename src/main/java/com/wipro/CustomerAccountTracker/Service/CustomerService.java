package com.wipro.CustomerAccountTracker.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wipro.CustomerAccountTracker.Bean.AccountBean;
import com.wipro.CustomerAccountTracker.Bean.CustomerBean;
import com.wipro.CustomerAccountTracker.Dao.AccountDao;
import com.wipro.CustomerAccountTracker.Dao.CustomerDao;
import com.wipro.CustomerAccountTracker.Exception.RecordNotFoundException;

@Service
public class CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private AccountDao accountDao;

	public String createCustomer(CustomerBean customerBean, AccountBean accountBean) {
		long accountNumber = Math.abs(generateRandom(12));
		customerBean.setAccountNumber(accountNumber);
		accountBean.setAccountNumber(accountNumber);
		accountBean.setBalanceAmount(10000);
		customerDao.save(customerBean);
		accountDao.save(accountBean);
		logger.info("Customer created successfully with Account Number: {}", accountNumber);
		return "Customer Added Successfully";
	}

	public String updateCustomer(CustomerBean customerBean) throws RecordNotFoundException {
		Optional<CustomerBean> customer = customerDao.findByAccountNumber(customerBean.getAccountNumber());
		if (customer.isPresent()) {
			CustomerBean existingCustomer = customer.get();
			existingCustomer.setName(customerBean.getName());
			existingCustomer.setGender(customerBean.getGender());
			existingCustomer.setAadharNo(customerBean.getAadharNo());
			existingCustomer.setContact(customerBean.getContact());
			existingCustomer.setEmail(customerBean.getEmail());
			existingCustomer.setAccountType(customerBean.getAccountType());
			customerDao.save(existingCustomer);
			logger.info("Customer updated successfully for Account Number: {}", customerBean.getAccountNumber());
			return "Updated Successfully";
		} else {
			throw new RecordNotFoundException("Account Number not found");
		}
	}

	public List<CustomerBean> getAllCustomers() {
		List<CustomerBean> customers = (List<CustomerBean>) customerDao.findAll();
		logger.info("Fetched {} customers from the database", customers.size());
		return customers.size() > 0 ? customers : new ArrayList<>();
	}

	public CustomerBean getCustomerByAccountNumber(Long accountNumber) throws RecordNotFoundException {
		Optional<CustomerBean> customer = customerDao.findByAccountNumber(accountNumber);
		if (customer.isPresent()) {
			logger.info("Customer found for Account Number: {}", accountNumber);
			return customer.get();
		} else {
			throw new RecordNotFoundException("No Customer record exists for the given Account Number: " + accountNumber);
		}
	}

	@Transactional
	public String deleteCustomerByAccountNumber(Long accountNumber) {
		Optional<CustomerBean> customer = customerDao.findByAccountNumber(accountNumber);
		if (customer.isPresent()) {
			customerDao.deleteByAccountNumber(accountNumber);
			logger.info("Customer deleted for Account Number: {}", accountNumber);
			return "Customer Deleted";
		} else {
			return "No Customer record exists for the given Account Number";
		}
	}

	private long generateRandom(int length) {
		Random random = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < length; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		return Long.parseLong(new String(digits));
	}
}