package com.java.keep.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.util.StringUtils;

import com.java.keep.model.User;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<User> getUsers(String name, String email, String mobileNumber, String registerDate) {

		String sql = "select u from User u where 1=1 ";
		if (!StringUtils.isEmpty(name)) {
			sql += String.format("and u.name = '%s' ", name);
		}
		if (!StringUtils.isEmpty(email)) {
			sql += String.format("and u.email = '%s' ", email);
		}
		if (!StringUtils.isEmpty(mobileNumber)) {
			sql += String.format("and u.mobile_number = '%s' ", mobileNumber);
		}
		if (!StringUtils.isEmpty(registerDate)) {
			sql += String.format("and u.r_date_time = '%s' ", registerDate);
		}
		return entityManager.createQuery(sql, User.class).getResultList();
	}
}
