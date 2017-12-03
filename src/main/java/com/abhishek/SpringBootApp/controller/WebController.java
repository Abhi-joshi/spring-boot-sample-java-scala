package com.abhishek.SpringBootApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.SpringBootApp.model.Customer;
import com.abhishek.SpringBootApp.repo.CustomerRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/customer")
@Api(value = "customer details", description = "Operations about Customer Details")
public class WebController {
	@Autowired
	CustomerRepository repository;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Customer> list() {

		List<Customer> customerList = new ArrayList<Customer>();
		for (Customer cust : repository.findAll()) {
			Customer customer = new Customer(cust.getId(), cust.getFirstName(), cust.getLastName());
			customerList.add(customer);
		}

		return customerList;
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public Customer showProduct(@PathVariable Long id) {
		Customer customer = repository.findOne(id);
		return customer;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> saveProduct(@RequestBody Customer customer) {
		repository.save(customer);
		return new ResponseEntity<String>("Customer details saved successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Customer customer) {
		Customer cust = repository.findOne(id);
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		repository.save(cust);
		return new ResponseEntity<String>("Customer deatils updated successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		repository.delete(id);
		return new ResponseEntity<String>("Customer details deleted successfully", HttpStatus.OK);

	}
}
