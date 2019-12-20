package com.java.keep.common.exception;

public class BadRequestError extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadRequestError() {
		super("Opps...!!! Something Went worng");
	}

	public BadRequestError(String errorMsg) {
		super(errorMsg);
	}

	public BadRequestError(String errorMsg, Throwable error) {
		super(errorMsg, error);
	}
}
