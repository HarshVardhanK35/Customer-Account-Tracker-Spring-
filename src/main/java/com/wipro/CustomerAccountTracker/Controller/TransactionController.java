package com.wipro.CustomerAccountTracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.CustomerAccountTracker.Service.TransactionService;
import com.wipro.CustomerAccountTracker.Exception.RecordNotFoundException;
import com.wipro.CustomerAccountTracker.DTO.TransferRequest;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	// Endpoint to transfer funds between accounts
	@PutMapping("/transferFunds")
	public ResponseEntity<String> transferAmount(@RequestBody TransferRequest transferRequest) throws RecordNotFoundException {
		// Call the service method with three parameters: fromAccount, toAccount, and amount
		String result = transactionService.transferAmount(
				transferRequest.getFromAccount(),
				transferRequest.getToAccount(),
				transferRequest.getAmount()
		);
		return ResponseEntity.ok(result);  // Return the result (could be "ID MISMATCH", "SUCCESS", etc.)
	}
}
