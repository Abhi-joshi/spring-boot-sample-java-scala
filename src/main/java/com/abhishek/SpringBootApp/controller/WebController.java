package com.abhishek.SpringBootApp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.SpringBootApp.model.Customer;
import com.abhishek.SpringBootApp.repo.CustomerRepository;
 
@RestController
public class WebController {
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping("/save")
	public String process(){
		// save a single Customer
		repository.save(new Customer("Jack", "Smith"));
		
		// save a list of Customers
		repository.save(Arrays.asList(new Customer("Adam", "Johnson"), new Customer("Kim", "Smith"),
										new Customer("David", "Williams"), new Customer("Peter", "Davis")));
		
		return "Done";
	}
	
	
	@RequestMapping("/findall")
	public List<Customer> findAll(){
		
		List<Customer> customerList = new ArrayList<Customer>(); 
		for(Customer cust : repository.findAll()){
			Customer customer = new Customer(cust.getId(), cust.getFirstName(), cust.getLastName());
			customerList.add(customer);
		}
		
		return customerList;
	}
	
	@RequestMapping("/findbyid")
	public Customer findById(@RequestParam("id") long id){
		
		Customer customer = repository.findOne(id);
		return customer;
	}
	
	@RequestMapping("/findbylastname")
	public List<Customer> fetchDataByLastName(@RequestParam("lastname") String lastName){
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		for(Customer cust: repository.findByLastName(lastName)){
			Customer customer = new Customer(cust.getId(), cust.getFirstName(), cust.getLastName());
			customerList.add(customer);
		}
		
		return customerList;
	}
}
