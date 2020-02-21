package br.com.credsystem.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import br.com.credsystem.test.entity.Customer;
import br.com.credsystem.test.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> list = service.getAllCostumers();

		return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) throws Exception {

		Customer entity = service.getCustomerById(id);

		return new ResponseEntity<Customer>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/new")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws Exception {
		
		Customer create = service.createCustomer(customer);
		return new ResponseEntity<Customer>(create, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws Exception {

		Customer updated = service.updateCustomer(customer);
		return new ResponseEntity<Customer>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteCustomerById(@PathVariable("id") Integer id) throws Exception {

		service.deleteCustomerById(id);
		return HttpStatus.FORBIDDEN;
	}

}
