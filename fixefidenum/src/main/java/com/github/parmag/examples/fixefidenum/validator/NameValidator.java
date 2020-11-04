package com.github.parmag.examples.fixefidenum.validator;

import java.util.List;

import com.github.parmag.fixefid.record.field.FieldExtendedProperty;
import com.github.parmag.fixefid.record.field.FieldMandatory;
import com.github.parmag.fixefid.record.field.FieldType;
import com.github.parmag.fixefid.record.field.FieldValidationInfo;
import com.github.parmag.fixefid.record.field.FieldValidationInfo.RecordFieldValidationStatus;
import com.github.parmag.fixefid.record.field.FieldValidator;

public class NameValidator implements FieldValidator {

	@Override
	public FieldValidationInfo valid(String name, int index, FieldType type, FieldMandatory mandatory, String value,
			List<FieldExtendedProperty> fieldExtendedProperties) {
		if (value.contains("-") || value.contains("_")) {
			return new FieldValidationInfo(RecordFieldValidationStatus.ERROR, "The field " + name + " with value=[" + value + "] cannot contains - or _");
		} else {
			return new FieldValidationInfo();
		}
	}

}
