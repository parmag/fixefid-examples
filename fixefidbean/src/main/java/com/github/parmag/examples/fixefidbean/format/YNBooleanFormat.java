package com.github.parmag.examples.fixefidbean.format;

import com.github.parmag.fixefid.record.format.BooleanFormat;

public class YNBooleanFormat implements BooleanFormat {

	@Override
	public String format(Boolean value) {
		return (value != null && value.booleanValue()) ? "Y" : "N";
	}

	@Override
	public Boolean parse(String value) {
		return "Y".equals(value) ? true : false;
	}

}
