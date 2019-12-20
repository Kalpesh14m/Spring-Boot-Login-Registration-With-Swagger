package com.java.keep.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserUpdateDetails {
	private String name;
	private String password;
	private String mobileNumber;
	private LocalDateTime updateDateAndTime;

	public UserUpdateDetails() {
	}
}
