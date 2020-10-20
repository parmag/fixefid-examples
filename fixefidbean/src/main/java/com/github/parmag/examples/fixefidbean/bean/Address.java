package com.github.parmag.examples.fixefidbean.bean;

import com.github.parmag.fixefid.record.bean.FixefidField;
import com.github.parmag.fixefid.record.bean.FixefidRecord;
import com.github.parmag.fixefid.record.field.FieldType;

@FixefidRecord(recordLen = 200)
public class Address {
	@FixefidField(fieldLen = 50, fieldOrdinal = 1, fieldType = FieldType.AN)
	private String address;
	
	@FixefidField(fieldLen = 10, fieldOrdinal = 2, fieldType = FieldType.AN)
	private String num;
	
	@FixefidField(fieldLen = 50, fieldOrdinal = 3, fieldType = FieldType.AN)
	private String place;
	
	@FixefidField(fieldLen = 50, fieldOrdinal = 4, fieldType = FieldType.AN)
	private String location;
	
	@FixefidField(fieldLen = 2, fieldOrdinal = 5, fieldType = FieldType.AN)
	private String district;
	
	@FixefidField(fieldLen = 5, fieldOrdinal = 6, fieldType = FieldType.AN)
	private String postalCode;
	
	@FixefidField(fieldLen = 3, fieldOrdinal = 7, fieldType = FieldType.AN, fieldDefaultValue = "ITA")
	private String nation;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
}
