package com.github.parmag.examples.fixefidrest.domain;

public class RecordResponse {
	private Long requestId;
	private Long responseId;
	private String record;
	
	public RecordResponse(Long requestId, Long responseId, String record) {
		super();
		this.requestId = requestId;
		this.responseId = responseId;
		this.record = record;
	}
	
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public Long getResponseId() {
		return responseId;
	}
	public void setResponseId(Long responseId) {
		this.responseId = responseId;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
}
