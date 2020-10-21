package com.github.parmag.examples.fixefidbean.bean;

import java.util.Arrays;
import java.util.List;

import com.github.parmag.examples.fixefidbean.validator.NameValidator;
import com.github.parmag.fixefid.record.bean.FixefidField;
import com.github.parmag.fixefid.record.bean.FixefidRecord;
import com.github.parmag.fixefid.record.field.FieldExtendedProperty;
import com.github.parmag.fixefid.record.field.FieldExtendedPropertyType;
import com.github.parmag.fixefid.record.field.FieldMandatory;
import com.github.parmag.fixefid.record.field.FieldType;

@FixefidRecord(recordLen = 498)
public class Person {
	public static List<FieldExtendedProperty> NAME_FIELD_EXTENDED_PROPERTIES = Arrays.asList(
		new FieldExtendedProperty(FieldExtendedPropertyType.VALIDATOR, new NameValidator())
	);
	
	@FixefidField(fieldLen = 10, fieldOrdinal = 1, fieldType = FieldType.N, fieldMandatory = FieldMandatory.INOUT)
	private Long personId;
	
	@FixefidField(fieldLen = 25, fieldOrdinal = 2, fieldType = FieldType.AN)
	private String firstName;
	
	@FixefidField(fieldLen = 25, fieldOrdinal = 3, fieldType = FieldType.AN)
	private String lastName;
	
	@FixefidField(fieldLen = 3, fieldOrdinal = 4, fieldType = FieldType.N)
	private Integer age;
	
	@FixefidField(fieldLen = 25, fieldOrdinal = 5, fieldType = FieldType.AN, fieldMandatory = FieldMandatory.OUT)
	private String fiscalCode;
	
	@FixefidField(fieldLen = 200, fieldOrdinal = 6, fieldType = FieldType.CMP)
	private Address address;
	
	@FixefidField(fieldLen = 210, fieldOrdinal = 7, fieldType = FieldType.CMP)
	private BirthInfo birthInfo;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BirthInfo getBirthInfo() {
		return birthInfo;
	}

	public void setBirthInfo(BirthInfo birthInfo) {
		this.birthInfo = birthInfo;
	}
}
