package com.github.parmag.examples.fixefidenum.fieldenum;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.github.parmag.examples.fixefidenum.format.MaskCustomFormat;
import com.github.parmag.examples.fixefidenum.format.YNBooleanFormat;
import com.github.parmag.examples.fixefidenum.validator.NameValidator;
import com.github.parmag.fixefid.record.field.FieldExtendedProperty;
import com.github.parmag.fixefid.record.field.FieldExtendedPropertyType;

public class FieldExtendedPropertyUtil {
	public static final String NATION_DEFAULT_VALUE = "ITA";
	
	public static final List<FieldExtendedProperty> NAME_EXTENDED_PROPERTY_LIST = Arrays.asList(
			new FieldExtendedProperty(FieldExtendedPropertyType.VALIDATOR, new NameValidator())
	);
	
	public static final List<FieldExtendedProperty> BIRTH_DATE_PROPERTY_LIST = Arrays.asList(
			new FieldExtendedProperty(FieldExtendedPropertyType.DATE_FORMAT, new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH))
	);
	
	public static final List<FieldExtendedProperty> ENABLED_PROPERTY_LIST = Arrays.asList(
			new FieldExtendedProperty(FieldExtendedPropertyType.BOOLEAN_FORMAT, new YNBooleanFormat())
	);
	
	public static final List<FieldExtendedProperty> CARD_NUMBER_PROPERTY_LIST = Arrays.asList(
			new FieldExtendedProperty(FieldExtendedPropertyType.CUSTOM_FORMAT, new MaskCustomFormat())
	);
	
	public static final List<FieldExtendedProperty> TAX_AMOUNT_FIELD_EXTENDED_PROPERTIES = Arrays.asList(
			new FieldExtendedProperty(FieldExtendedPropertyType.REMOVE_DECIMAL_SEPARATOR, true),
			new FieldExtendedProperty(FieldExtendedPropertyType.DECIMAL_FORMAT, new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.ENGLISH)))
	);
	
	public static final List<FieldExtendedProperty> COLLAGE_FIELD_EXTENDED_PROPERTIES = Arrays.asList(
			new FieldExtendedProperty(FieldExtendedPropertyType.LPAD, " ")
	);
}
