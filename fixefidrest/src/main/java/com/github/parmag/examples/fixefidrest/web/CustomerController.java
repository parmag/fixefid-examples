package com.github.parmag.examples.fixefidrest.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.parmag.examples.fixefidrest.domain.Customer;
import com.github.parmag.examples.fixefidrest.domain.CustomerRequest;
import com.github.parmag.examples.fixefidrest.domain.CustomerResponse;
import com.github.parmag.examples.fixefidrest.domain.RecordRequest;
import com.github.parmag.examples.fixefidrest.domain.RecordResponse;
import com.github.parmag.fixefid.record.BeanRecord;

@RestController
public class CustomerController {
	private final AtomicLong counter = new AtomicLong();
	
	@PostMapping(path = "/recordtocustomer", consumes = "application/json", produces = "application/json")
	public CustomerResponse recordToCustomer(@RequestBody RecordRequest request) {
		Customer customer = new Customer(null, null);
		new BeanRecord(customer, request.getRecord());
		return new CustomerResponse(request.getRequestId(), counter.incrementAndGet(), customer);
	}
	
	@PostMapping(path = "/customertorecord", consumes = "application/json", produces = "application/json")
	public RecordResponse customerToRecord(@RequestBody CustomerRequest request) {
		Customer customer = request.getCustomer();
		BeanRecord beanRecord = new BeanRecord(customer);
		return new RecordResponse(request.getRequestId(), counter.incrementAndGet(), beanRecord.toString());
	}
}
