package com.github.parmag.examples.fixefidbean.bean;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.github.parmag.fixefid.record.bean.FixefidField;
import com.github.parmag.fixefid.record.bean.FixefidRecord;
import com.github.parmag.fixefid.record.field.FieldExtendedProperty;
import com.github.parmag.fixefid.record.field.FieldExtendedPropertyType;
import com.github.parmag.fixefid.record.field.FieldType;

@FixefidRecord(recordLen = 210)
public class BirthInfo {
	public static List<FieldExtendedProperty> BIRTH_DATE_FIELD_EXTENDED_PROPERTIES = Arrays.asList(
		new FieldExtendedProperty(FieldExtendedPropertyType.DATE_FORMAT, new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH))
	);
	
	@FixefidField(fieldLen = 10, fieldOrdinal = 1, fieldType = FieldType.AN)
	private Date birthDate;
	
	@FixefidField(fieldLen = 200, fieldOrdinal = 2, fieldType = FieldType.CMP)
	private Address birthAddress = new Address(); ;

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Address getBirthAddress() {
		return birthAddress;
	}

	public void setBirthAddress(Address birthAddress) {
		this.birthAddress = birthAddress;
	}
}
