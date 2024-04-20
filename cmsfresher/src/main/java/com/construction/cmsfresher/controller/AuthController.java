package com.construction.cmsfresher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construction.cmsfresher.dto.request.SingInForm;
import com.construction.cmsfresher.dto.response.JWTResponse;
import com.construction.cmsfresher.model.MdAccount;
import com.construction.cmsfresher.model.MdEmployee;
import com.construction.cmsfresher.security.jwt.JwtTokenProvider;
import com.construction.cmsfresher.security.userdetail.UserDetailImpl;
import com.construction.cmsfresher.service.impl.AccountServiceImpl;
import com.construction.cmsfresher.service.impl.EmployeeServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AccountServiceImpl accountServiceImpl;

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider jwtProvider;
	
	@Autowired
	HttpSession session;

	@PostMapping("/signup")
	private MdAccount signUp(@RequestBody SingInForm loginRequest) {

		MdAccount account = new MdAccount();
		account.setUsername(loginRequest.getUsername());
		account.setPassword(encoder.encode(loginRequest.getPassword()));

		MdEmployee employee = employeeServiceImpl.findById(1);

		account.setMdEmployee(employee);
		account = accountServiceImpl.save(account);

		return account;
	}

	@PostMapping("/login")
	private ResponseEntity<JWTResponse> login(@RequestBody SingInForm singInForm) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(singInForm.getUsername(), singInForm.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtProvider.generateToken(authentication);
		UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();
		if (userDetails == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		session.setAttribute("user", userDetails);

		JWTResponse jwtResponse = new JWTResponse();
		jwtResponse.setToken(token);
		jwtResponse.setId(userDetails.getId());
		jwtResponse.setUsername(userDetails.getUsername());
		jwtResponse.setRoles(userDetails.getRoles());
		return new ResponseEntity<JWTResponse>(jwtResponse, HttpStatus.OK);
	}

	@GetMapping("/list")
	private List<MdAccount> findAll() {
		return accountServiceImpl.findAll();
	}
}
