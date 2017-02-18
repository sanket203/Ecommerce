package com.i3.ecom.utils;

public class ResponseMessage {

	public String status;
	
	public Object data;
	
	public String message;

	public ResponseMessage(String status, Object data, String message) {
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public ResponseMessage(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
