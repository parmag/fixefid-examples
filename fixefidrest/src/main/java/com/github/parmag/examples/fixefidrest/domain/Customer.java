package com.github.parmag.examples.fixefidrest.domain;

import com.github.parmag.fixefid.record.bean.FixefidField;
import com.github.parmag.fixefid.record.bean.FixefidRecord;
import com.github.parmag.fixefid.record.field.FieldType;

@FixefidRecord
public class Customer {
	@FixefidField(fieldLen = 19, fieldOrdinal = 0, fieldType = FieldType.N)
	private Long id;
	
	@FixefidField(fieldLen = 50, fieldOrdinal = 1, fieldType = FieldType.AN)
	private String firstName;
	
	@FixefidField(fieldLen = 50, fieldOrdinal = 2, fieldType = FieldType.AN)
	private String lastName;

	protected Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
