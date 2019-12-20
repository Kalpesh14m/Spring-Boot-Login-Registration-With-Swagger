package com.java.keep.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.keep.model.User;
import com.java.keep.model.UserLoginDAO;
import com.java.keep.model.UserRegisterDAO;
import com.java.keep.repository.UserRepository;
import com.java.keep.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Optional<User> registerUser(UserRegisterDAO request) {
//		User u = new User(request);
//		u.setPassword(request.getPassword());
		Optional<User> maybeUser = Optional.ofNullable(userRepository.save(new User(request)));
		return maybeUser;
	}

	@Override
	public List<User> getUsers(String name, String email, String mobileNumber, String registerDate) {
		return userRepository.getUsers(name, email, mobileNumber, registerDate);
	}

	@Override
	public boolean loginUser(UserLoginDAO request) {
		return userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword()).isPresent();
	}

//	@Override
//	public String updateUser(List<UserUpdateDetails> users) {
//		User u = new User(request);
//		for (User u : users) {
//			u.setUpdateDateAndTime((DateUtil.today()));
//			userRepository.save(u);
//		}
//		return "User Update Successfully";
//	}

}
