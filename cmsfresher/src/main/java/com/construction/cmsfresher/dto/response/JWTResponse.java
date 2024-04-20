package com.construction.cmsfresher.dto.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JWTResponse {
	private Integer id;
	private String username;
	private String token;
	private String type = "Bearer";
	private Collection<? extends GrantedAuthority> roles;

	
	public JWTResponse(Integer id, String username, String token, String type,
			Collection<? extends GrantedAuthority> roles) {
		super();
		this.id = id;
		this.username = username;
		this.token = token;
		this.type = type;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public JWTResponse() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}

	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}
	

}
