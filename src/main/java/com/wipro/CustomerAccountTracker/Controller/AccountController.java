package com.wipro.CustomerAccountTracker.Controller;

import com.wipro.CustomerAccountTracker.Exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wipro.CustomerAccountTracker.Bean.AccountBean;
import com.wipro.CustomerAccountTracker.Bean.CustomerBean;
import com.wipro.CustomerAccountTracker.Service.AccountService;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/accountDetails")
public class AccountController {

	@Autowired
	AccountService accountService;

	// Fetch account details by account number
	@GetMapping("/{accountNumber}")
	public ResponseEntity<AccountBean> getAccountDetailsByAccountNumber(@PathVariable("accountNumber") Long accountNumber) throws RecordNotFoundException, RecordNotFoundException {
		AccountBean account = accountService.getAccountDetailsByAccountNumber(accountNumber);
		return ResponseEntity.ok(account);
	}

	// Fetch all accounts
	@GetMapping("/getAllAccounts")
	public ResponseEntity<List<AccountBean>> getAllAccounts() {
		List<AccountBean> accounts = accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
	}

	// Add account and customer from the new unified request
	@PostMapping("/addAccount")
	public ResponseEntity<String> addAccount(@RequestBody Map<String, Object> requestBody) {
		// Extract the account details from the request
		AccountBean accountBean = new AccountBean();
		accountBean.setAccountNumber(Long.parseLong(requestBody.get("accountNumber").toString()));
		accountBean.setName(requestBody.get("name").toString());
		accountBean.setAccountType(requestBody.get("accountType").toString());
		accountBean.setBalanceAmount(Double.parseDouble(requestBody.get("balanceAmount").toString()));

		// Extract customer details
		Map<String, Object> customerDetails = (Map<String, Object>) requestBody.get("customerDetails");
		CustomerBean customerBean = new CustomerBean();
		customerBean.setGender(customerDetails.get("gender").toString());
		customerBean.setEmail(customerDetails.get("email").toString());
		customerBean.setContact(customerDetails.get("contact").toString());
		customerBean.setAadharNo(customerDetails.get("aadharNo").toString());

		// Pass both account and customer details to the service
		String response = accountService.addAccount(accountBean, customerBean);
		return ResponseEntity.ok(response);
	}
}
