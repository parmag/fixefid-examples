package com.github.parmag.examples.fixefidenum.format;

import com.github.parmag.fixefid.record.format.CustomFormat;

public class MaskCustomFormat implements CustomFormat {

	@Override
	public String format(String value) {
		if (value.length() < 10) {
			return "XXXX-XXXX-XXXX";
		} else {
			return "XXXX" + value.substring(4, 10) + "XXXX";
		}
	}

	@Override
	public String parse(String value) {
		return value;
	}

}
