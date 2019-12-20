package com.java.keep.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.keep.common.exception.BadRequestError;
import com.java.keep.model.Response;
import com.java.keep.model.User;
import com.java.keep.model.UserLoginDAO;
import com.java.keep.model.UserRegisterDAO;
import com.java.keep.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "LearningDemo", tags = { "UserController" })
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Register new data in database and return response")
	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<Response> registerUser(
			@ApiParam(value = "Registration object store in database table", required = true) @Valid @RequestBody UserRegisterDAO request) {
		try {
			Optional<User> maybeUser = userService.registerUser(request);
			if (!maybeUser.isPresent()) {
				return ResponseEntity.badRequest()
						.body(new Response("User Registration Failed", HttpStatus.BAD_REQUEST.value()));
			}
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new Response("User Registration Successfully done", HttpStatus.OK.value()));
		} catch (BadRequestError e) {
			return ResponseEntity.badRequest().body(new Response(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
		}
	}

	@ApiOperation(value = "Get list of all register info on basics of their Name, Mobile number, Registration Date, Email Id", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Register"),
			@ApiResponse(code = 400, message = "Bad Credentials in Admin Login"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@GetMapping("/users")
	public List<User> getUsers(@RequestParam(required = false, value = "name") String name,
			@RequestParam(required = false, value = "email") String email,
			@RequestParam(required = false, value = "mobileNumber") String mobileNumber,
			@RequestParam(required = false, value = "registerDate") String registerDate) {
		return userService.getUsers(name, email, mobileNumber, registerDate);
	}

	@ApiOperation(value = "Login User")
	@PostMapping(value = "/login", produces = "application/json")
	public ResponseEntity<Response> loginUser(
			@ApiParam(value = "login Exsiting User", required = true) @Valid @RequestBody UserLoginDAO request) {
		try {
			if (!userService.loginUser(request)) {
				return ResponseEntity.badRequest()
						.body(new Response("User Login Failed...!!!", HttpStatus.BAD_REQUEST.value()));
			}
			return ResponseEntity.status(HttpStatus.OK)
					.body(new Response("User Login Successfull...!!!", HttpStatus.OK.value()));
		} catch (BadRequestError e) {
			return ResponseEntity.badRequest()
					.body(new Response("User Registration Failed...!!!", HttpStatus.BAD_REQUEST.value()));
		}
	}

//	@ApiOperation(value = "Update Details of User")
//	@PutMapping("/updatestatus")
//	public ResponseEntity<Response> updateUser(@RequestBody List<UserUpdateDetails> users) {
//		String msg = userService.updateUser(users);
//		return ResponseEntity.status(HttpStatus.OK).body(new Response(msg, HttpStatus.OK.value()));
//	}

}
