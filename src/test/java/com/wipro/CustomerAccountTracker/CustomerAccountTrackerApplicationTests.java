package com.wipro.CustomerAccountTracker;

import static org.assertj.core.api.Assertions.assertThat;

import com.wipro.CustomerAccountTracker.Controller.AccountController;
import com.wipro.CustomerAccountTracker.Controller.CustomerController;
import com.wipro.CustomerAccountTracker.Controller.TransactionController;
import com.wipro.CustomerAccountTracker.Service.AccountService;
import com.wipro.CustomerAccountTracker.Service.CustomerService;
import com.wipro.CustomerAccountTracker.Service.TransactionService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerAccountTrackerApplicationTests {

	@Autowired
	private AccountController accountController;

	@Autowired
	private CustomerController customerController;

	@Autowired
	private TransactionController transactionController;

	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private TransactionService transactionService;

	@Test
	void contextLoads() {
		assertThat(accountController).isNotNull();
		assertThat(customerController).isNotNull();
		assertThat(transactionController).isNotNull();
		assertThat(accountService).isNotNull();
		assertThat(customerService).isNotNull();
		assertThat(transactionService).isNotNull();
	}

}
