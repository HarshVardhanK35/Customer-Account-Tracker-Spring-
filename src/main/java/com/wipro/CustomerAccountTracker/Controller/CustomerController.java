package com.wipro.CustomerAccountTracker.Controller;

import com.wipro.CustomerAccountTracker.Bean.CustomerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.CustomerAccountTracker.DTO.CustomerAccountDTO;
import com.wipro.CustomerAccountTracker.Service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<String> createCustomer(@RequestBody CustomerAccountDTO customerAccountDTO) {
		if (customerAccountDTO == null || customerAccountDTO.getCustomerBean() == null || customerAccountDTO.getAccountBean() == null) {
			return ResponseEntity.badRequest().body("Invalid request. Customer and Account details must be provided.");
		}

		// Call the service method to create the customer and get the account number
		long accountNumber = customerService.createCustomer(customerAccountDTO.getCustomerBean(), customerAccountDTO.getAccountBean());

		// Return the account number in the response
		return ResponseEntity.ok("Customer added successfully. Account Number: " + accountNumber);
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<CustomerBean>> getAllCustomers() {
		List<CustomerBean> customers = customerService.getAllCustomers();
		return ResponseEntity.ok(customers);
	}
}
