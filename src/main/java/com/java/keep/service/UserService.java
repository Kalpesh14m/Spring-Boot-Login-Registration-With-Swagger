package com.java.keep.service;

import java.util.List;
import java.util.Optional;

import com.java.keep.model.User;
import com.java.keep.model.UserLoginDAO;
import com.java.keep.model.UserRegisterDAO;

public interface UserService {
	Optional<User> registerUser(UserRegisterDAO request);

	List<User> getUsers(String name, String email, String mobileNumber, String registerDate);

	boolean loginUser(UserLoginDAO request);

//	String updateUser(List<UserUpdateDetails> users);
}
