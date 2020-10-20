package com.github.parmag.examples.fixefidbean.bean;

import java.util.Arrays;
import java.util.List;

import com.github.parmag.fixefid.record.bean.FixefidField;
import com.github.parmag.fixefid.record.bean.FixefidRecord;
import com.github.parmag.fixefid.record.field.FieldExtendedProperty;
import com.github.parmag.fixefid.record.field.FieldExtendedPropertyType;
import com.github.parmag.fixefid.record.field.FieldMandatory;
import com.github.parmag.fixefid.record.field.FieldType;
import com.github.parmag.fixefid.record.format.BooleanFormat;

@FixefidRecord(recordLen = 600)
public class Student extends Person {
	public static List<FieldExtendedProperty> ENABLED_FIELD_EXTENDED_PROPERTIES = Arrays.asList(
		new FieldExtendedProperty(FieldExtendedPropertyType.BOOLEAN_FORMAT, new BooleanFormat() {
			@Override
			public String format(Boolean value) {
				return (value != null && value.booleanValue()) ? "Y" : "N";
			}
		
			@Override
			public Boolean parse(String value) {
				return "Y".equals(value) ? true : false;
			}
		})
	);
	
	@FixefidField(fieldLen = 10, fieldOrdinal = 8, fieldType = FieldType.N, fieldMandatory = FieldMandatory.OUT)
	private Long studentId;
	
	@FixefidField(fieldLen = 1, fieldOrdinal = 9, fieldType = FieldType.AN)
	private boolean enabled;
	
	@FixefidField(fieldLen = 2, fieldOrdinal = 10, fieldType = FieldType.N)
	private int level;

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
}
