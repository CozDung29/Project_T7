package com.managepage.dto.error;

import java.util.List;

public class ErrorReponseDTO {
	private Integer statusCode;
    private String errorMessage;
    private List<String> errorDetails;
    private String timestamp;
    
    public List<String> getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(List<String> errorDetails) {
		this.errorDetails = errorDetails;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
    
}
