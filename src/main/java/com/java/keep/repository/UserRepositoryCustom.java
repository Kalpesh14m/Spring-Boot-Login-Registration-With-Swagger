package com.java.keep.repository;

import java.util.List;

import com.java.keep.model.User;

public interface UserRepositoryCustom {
	List<User> getUsers(String name, String email, String mobileNumber, String registerDate);
}
