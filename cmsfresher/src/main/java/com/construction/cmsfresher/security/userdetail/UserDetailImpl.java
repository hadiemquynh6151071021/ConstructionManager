package com.construction.cmsfresher.security.userdetail;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.construction.cmsfresher.model.MdAccount;

public class UserDetailImpl implements UserDetails {
	private Integer id;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public static UserDetailImpl build(MdAccount user) {
		List<GrantedAuthority> authorities = user.getMdRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRolename())).collect(Collectors.toList());
		System.out.println("ko coooo");
		return new UserDetailImpl(user.getAccountid(),user.getUsername(), user.getPassword(), authorities);
	}

	public UserDetailImpl() {
	}

	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}

	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDetailImpl(Integer id, String username, String password, Collection<? extends GrantedAuthority> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}



}
