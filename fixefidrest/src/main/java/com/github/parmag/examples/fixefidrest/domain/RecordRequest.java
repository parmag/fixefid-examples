package com.github.parmag.examples.fixefidrest.domain;

public class RecordRequest {
	private Long requestId;
	private String record;

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
}
