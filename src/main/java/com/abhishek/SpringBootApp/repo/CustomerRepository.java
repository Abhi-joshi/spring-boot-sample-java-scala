package com.abhishek.SpringBootApp.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.abhishek.SpringBootApp.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
}
