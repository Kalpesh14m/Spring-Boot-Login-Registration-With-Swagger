package com.java.keep.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.java.keep.common.util.DateUtil;

import lombok.Data;

@Entity
@Data
@Table(name = "userInfo")
public class User {
	@Id
	@GenericGenerator(name = "userid", strategy = "increment")
	@GeneratedValue(generator = "userid")
	private Long id;

	@Size(min = 3, max = 20)
	@Column(name = "name")
	private String name;

	@Email
	@Column(name = "email", unique = true)
	private String email;

	@Size(min = 3)
	@Column(name = "password")
	private String password;

	@Size(min = 10, max = 10)
	@Column(name = "mobileNumber", unique = true)
	private String mobileNumber;

	@Column(name = "r_date_time")
	private LocalDateTime registerDateTime;

	@Column(name = "u_date_time")
	private LocalDateTime updateDateTime;

	User() {
	}

	public User(UserRegisterDAO request) {
		this.name = request.getName();
		this.mobileNumber = request.getMobileNumber();
		this.email = request.getEmail();
		this.password = request.getPassword();
		this.registerDateTime = DateUtil.today();
		this.updateDateTime = DateUtil.today();
	}

	public User(UserUpdateDetails request) {
		this.name = request.getName();
		this.mobileNumber = request.getMobileNumber();
		this.password = request.getPassword();
		this.updateDateTime = request.getUpdateDateAndTime();
	}

}
