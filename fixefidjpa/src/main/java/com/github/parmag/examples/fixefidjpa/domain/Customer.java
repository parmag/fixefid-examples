package com.github.parmag.examples.fixefidjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.github.parmag.fixefid.record.bean.FixefidField;
import com.github.parmag.fixefid.record.bean.FixefidRecord;
import com.github.parmag.fixefid.record.field.FieldType;

@Entity
@FixefidRecord
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
