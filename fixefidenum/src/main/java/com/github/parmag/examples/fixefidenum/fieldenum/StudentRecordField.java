package com.github.parmag.examples.fixefidenum.fieldenum;

import java.util.List;

import com.github.parmag.fixefid.record.field.FieldExtendedProperty;
import com.github.parmag.fixefid.record.field.FieldMandatory;
import com.github.parmag.fixefid.record.field.FieldProperty;
import com.github.parmag.fixefid.record.field.FieldType;

public enum StudentRecordField implements FieldProperty {
	personId(10, FieldType.N, FieldMandatory.INOUT, null, null),
	firstName(25, FieldType.AN, FieldMandatory.NO, FieldExtendedPropertyUtil.NAME_EXTENDED_PROPERTY_LIST, null),
	lastName(25, FieldType.AN, FieldMandatory.NO, FieldExtendedPropertyUtil.NAME_EXTENDED_PROPERTY_LIST, null),
	age(3, FieldType.N, FieldMandatory.NO, null, null),
	fiscalCode(25, FieldType.AN, FieldMandatory.NO, null, null),
	address(50, FieldType.AN, FieldMandatory.NO, null, null),
	num(10, FieldType.AN, FieldMandatory.NO, null, null),
	place(50, FieldType.AN, FieldMandatory.NO, null, null),
	location(50, FieldType.AN, FieldMandatory.NO, null, null),
	district(2, FieldType.AN, FieldMandatory.NO, null, null),
	postalCode(5, FieldType.AN, FieldMandatory.NO, null, null),
	nation(3, FieldType.AN, FieldMandatory.NO, null, FieldExtendedPropertyUtil.NATION_DEFAULT_VALUE),
	addressFiller(30, FieldType.AN, FieldMandatory.NO, null, null),
	birthDate(10, FieldType.AN, FieldMandatory.NO, FieldExtendedPropertyUtil.BIRTH_DATE_PROPERTY_LIST, null),
	birthAddress(50, FieldType.AN, FieldMandatory.NO, null, null),
	birthNum(10, FieldType.AN, FieldMandatory.NO, null, null),
	birthPlace(50, FieldType.AN, FieldMandatory.NO, null, null),
	birthLocation(50, FieldType.AN, FieldMandatory.NO, null, null),
	birthDistrict(2, FieldType.AN, FieldMandatory.NO, null, null),
	birthPostalCode(5, FieldType.AN, FieldMandatory.NO, null, null),
	birthNation(3, FieldType.AN, FieldMandatory.NO, null, FieldExtendedPropertyUtil.NATION_DEFAULT_VALUE),
	birthAddressFiller(30, FieldType.AN, FieldMandatory.NO, null, null),
	studentId(10, FieldType.N, FieldMandatory.INOUT, null, null),
	enabled(1, FieldType.AN, FieldMandatory.NO, FieldExtendedPropertyUtil.ENABLED_PROPERTY_LIST, null),
	level(2, FieldType.N, FieldMandatory.NO, null, null),
	cardNumber(14, FieldType.AN, FieldMandatory.NO, FieldExtendedPropertyUtil.CARD_NUMBER_PROPERTY_LIST, null),
	taxAmount(10, FieldType.N, FieldMandatory.NO, FieldExtendedPropertyUtil.TAX_AMOUNT_FIELD_EXTENDED_PROPERTIES, null),
	collage(50, FieldType.AN, FieldMandatory.NO, FieldExtendedPropertyUtil.COLLAGE_FIELD_EXTENDED_PROPERTIES, null),
	filler(15, FieldType.AN, FieldMandatory.NO, null, null);
	
	private int fieldLen; 
	private FieldType fieldType;
	private FieldMandatory fieldMandatory;
	private List<FieldExtendedProperty> fieldExtendedProperties;
	private String defaultValue; 
	
	private StudentRecordField(int fieldLen, FieldType fieldType, FieldMandatory fieldMandatory, 
			List<FieldExtendedProperty> fieldExtendedProperties, String defaultValue) {
		this.fieldLen = fieldLen;
		this.fieldType = fieldType; 
		this.fieldMandatory = fieldMandatory;
		this.fieldExtendedProperties = fieldExtendedProperties;
		this.defaultValue = defaultValue; 
	}

	@Override
	public FieldType fieldType() {
		return fieldType;
	}

	@Override
	public int fieldLen() {
		return fieldLen;
	}

	@Override
	public FieldMandatory fieldMandatory() {
		return fieldMandatory;
	}

	@Override
	public String fieldDefaultValue() {
		return defaultValue;
	}

	@Override
	public List<FieldExtendedProperty> fieldExtendedProperties() {
		return fieldExtendedProperties;
	}

}
