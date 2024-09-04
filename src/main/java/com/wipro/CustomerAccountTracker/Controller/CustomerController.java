package com.wipro.CustomerAccountTracker.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.CustomerAccountTracker.Bean.AccountBean;
import com.wipro.CustomerAccountTracker.Bean.CustomerBean;
import com.wipro.CustomerAccountTracker.Exception.RecordNotFoundException;
import com.wipro.CustomerAccountTracker.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<String> createCustomer(@RequestBody CustomerBean customerBean, @RequestBody AccountBean accountBean) {
		return ResponseEntity.ok(customerService.createCustomer(customerBean, accountBean));
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<String> updateCustomer(@RequestBody CustomerBean customerBean) throws RecordNotFoundException {
		return ResponseEntity.ok(customerService.updateCustomer(customerBean));
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<CustomerBean>> getAllCustomers() {
		return ResponseEntity.ok(customerService.getAllCustomers());
	}

	@GetMapping("/getByAccNum/{accountNumber}")
	public ResponseEntity<CustomerBean> getCustomerByAccountNumber(@PathVariable("accountNumber") Long accountNumber) throws RecordNotFoundException {
		return ResponseEntity.ok(customerService.getCustomerByAccountNumber(accountNumber));
	}

	@DeleteMapping("/deleteCustomerByAccNum/{accountNumber}")
	public ResponseEntity<String> deleteCustomerByAccountNumber(@PathVariable("accountNumber") Long accountNumber) {
		return ResponseEntity.ok(customerService.deleteCustomerByAccountNumber(accountNumber));
	}
}
