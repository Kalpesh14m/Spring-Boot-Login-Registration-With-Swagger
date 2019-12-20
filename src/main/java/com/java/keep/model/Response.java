package com.java.keep.model;

import lombok.Data;

@Data
public class Response {
	private int statusCode;
	private String msg;
	private Object object;

	Response() {
	}

	public Response(int statusCode) {
		this.statusCode = statusCode;
	}

	public Response(String msg, int statusCode) {
		this(statusCode);
		this.msg = msg;
	}

	public Response(int statusCode, String msg, Object obj) {
		this(msg, statusCode);
		this.object = obj;
	}
}
