package com.projectdb.error;

public class LaneNotFoundException extends Exception {

	@Override
	public String getMessage() {
		return "lane not found";
	}
}
