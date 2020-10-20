package com.github.parmag.examples.fixefidbean.bean;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.github.parmag.examples.fixefidbean.format.MaskCustomFormat;
import com.github.parmag.examples.fixefidbean.format.YNBooleanFormat;
import com.github.parmag.fixefid.record.bean.FixefidField;
import com.github.parmag.fixefid.record.bean.FixefidRecord;
import com.github.parmag.fixefid.record.field.FieldExtendedProperty;
import com.github.parmag.fixefid.record.field.FieldExtendedPropertyType;
import com.github.parmag.fixefid.record.field.FieldMandatory;
import com.github.parmag.fixefid.record.field.FieldType;

@FixefidRecord(recordLen = 600)
public class Student extends Person {
	public static List<FieldExtendedProperty> ENABLED_FIELD_EXTENDED_PROPERTIES = Arrays.asList(
		new FieldExtendedProperty(FieldExtendedPropertyType.BOOLEAN_FORMAT, new YNBooleanFormat())
	);
	
	public static List<FieldExtendedProperty> CARD_NUMBER_FIELD_EXTENDED_PROPERTIES = Arrays.asList(
		new FieldExtendedProperty(FieldExtendedPropertyType.CUSTOM_FORMAT, new MaskCustomFormat())
	);
	
	public static List<FieldExtendedProperty> TAX_AMOUNT_FIELD_EXTENDED_PROPERTIES = Arrays.asList(
		new FieldExtendedProperty(FieldExtendedPropertyType.REMOVE_DECIMAL_SEPARATOR, true),
		new FieldExtendedProperty(FieldExtendedPropertyType.DECIMAL_FORMAT, new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.ENGLISH)))
	);
	
	public static List<FieldExtendedProperty> COLLEGE_FIELD_EXTENDED_PROPERTIES = Arrays.asList(
		new FieldExtendedProperty(FieldExtendedPropertyType.LPAD, ".")
	);
	
	@FixefidField(fieldLen = 10, fieldOrdinal = 8, fieldType = FieldType.N, fieldMandatory = FieldMandatory.OUT)
	private Long studentId;
	
	@FixefidField(fieldLen = 1, fieldOrdinal = 9, fieldType = FieldType.AN)
	private boolean enabled;
	
	@FixefidField(fieldLen = 2, fieldOrdinal = 10, fieldType = FieldType.N)
	private int level;
	
	@FixefidField(fieldLen = 14, fieldOrdinal = 11, fieldType = FieldType.AN)
	private String cardNumber;

	@FixefidField(fieldLen = 10, fieldOrdinal = 12, fieldType = FieldType.N)
	private BigDecimal taxAmount;
	
	@FixefidField(fieldLen = 50, fieldOrdinal = 13, fieldType = FieldType.AN)
	private String college;
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}
}
