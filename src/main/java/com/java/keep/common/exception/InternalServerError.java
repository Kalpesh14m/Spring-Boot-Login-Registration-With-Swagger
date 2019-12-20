package com.java.keep.common.exception;

public class InternalServerError extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InternalServerError() {
		super("Oops!!!!! Something went wrong......");
	}

	public InternalServerError(String errorMsg) {
		super(errorMsg);
	}

	public InternalServerError(String errorMsg, Throwable error) {
		super(errorMsg, error);
	}
}
