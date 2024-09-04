package com.wipro.CustomerAccountTracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.CustomerAccountTracker.Bean.AccountBean;
import com.wipro.CustomerAccountTracker.Exception.RecordNotFoundException;
import com.wipro.CustomerAccountTracker.Service.AccountService;

@RestController
@RequestMapping("/accountDetails")
public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping("/{accountNumber}")
	public ResponseEntity<AccountBean> getAccountDetailsByAccountNumber(@PathVariable("accountNumber") Long accountNumber) throws RecordNotFoundException {
		AccountBean account = accountService.getAccountDetailsByAccountNumber(accountNumber);
		return ResponseEntity.ok().body(account);
	}
}
