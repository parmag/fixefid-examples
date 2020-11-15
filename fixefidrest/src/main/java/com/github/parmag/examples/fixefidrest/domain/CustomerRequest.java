package com.github.parmag.examples.fixefidrest.domain;

public class CustomerRequest {
	private Long requestId;
	private Customer customer;
	
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
