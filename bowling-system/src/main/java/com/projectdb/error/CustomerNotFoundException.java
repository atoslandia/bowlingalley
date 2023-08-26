package com.projectdb.error;

public class CustomerNotFoundException extends Exception {

	@Override
	public String getMessage() {
		return "customer not found";
	}
}
