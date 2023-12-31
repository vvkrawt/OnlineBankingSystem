package com.batch8group4.onlinebank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batch8group4.onlinebank.model.Customer;
import com.batch8group4.onlinebank.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomersResponse ()
	{
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomerByIdResponse(@PathVariable String id)
	{
		return customerService.getCustomerById(id);
	}
	
	@PostMapping("/open/account")
	public ResponseEntity<Customer> postCustomerRequest( @RequestBody Customer customer)
	{
		Customer createdCustomer=customerService.createCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCustomerRequest( @PathVariable String id)
	{
		customerService.deleteCustomerById(id);

	}
	
	//put mapping for changing the phone number
	@PutMapping("/change/phone/number/{id}/mobile-number")
	public ResponseEntity<Customer> updatePhoneNumberRequest(@PathVariable String id, @RequestParam String newMobileNumber )
	{
		Customer updatedCustomer=customerService.changePhoneNumber(id, newMobileNumber);
		if (updatedCustomer !=null)
		{
			return ResponseEntity.ok(updatedCustomer);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}

}
