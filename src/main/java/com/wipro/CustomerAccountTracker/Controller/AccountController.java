package com.wipro.CustomerAccountTracker.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wipro.CustomerAccountTracker.Bean.AccountBean;
import com.wipro.CustomerAccountTracker.Exception.RecordNotFoundException;
import com.wipro.CustomerAccountTracker.Service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accountDetails")

public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping("/{accountNumber}")
	public ResponseEntity<AccountBean> getAccountDetailsByAccountNumber(@PathVariable("accountNumber") Long accountNumber) throws RecordNotFoundException {
		AccountBean account = accountService.getAccountDetailsByAccountNumber(accountNumber);
		return ResponseEntity.ok(account);
	}

	// Endpoint to fetch all accounts
	@GetMapping("/getAllAccounts")
	public ResponseEntity<List<AccountBean>> getAllAccounts() {
		List<AccountBean> accounts = accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
	}

	// Add account and customer
	@PostMapping("/addAccount")
	public ResponseEntity<String> addAccount(@RequestBody AccountBean accountBean) {
		String response = accountService.addAccount(accountBean);
		return ResponseEntity.ok(response);
	}
}