package com.github.parmag.examples.fixefidjpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.parmag.examples.fixefidjpa.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
	Customer findById(long id);
}
