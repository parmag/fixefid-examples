package com.github.parmag.examples.fixefidrest.domain;

public class CustomerResponse {
	private Long requestId;
	private Long responseId;
	private Customer customer;
	
	public CustomerResponse(Long requestId, Long responseId, Customer customer) {
		this.requestId = requestId;
		this.responseId = responseId;
		this.customer = customer;
	}
	
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public Long getResponseId() {
		return responseId;
	}
	public void setResponseId(Long responseId) {
		this.responseId = responseId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
