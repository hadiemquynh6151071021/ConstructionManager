package com.construction.cmsfresher.security.userdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.exception.NotFoundException;
import com.construction.cmsfresher.model.MdAccount;
import com.construction.cmsfresher.service.impl.AccountServiceImpl;

import jakarta.servlet.http.HttpSession;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) {
		// Kiểm tra xem user có tồn tại trong database không?
		MdAccount user = accountServiceImpl.findByUserName(username);
		if (user == null) {
			throw new NotFoundException("Account không tồn tại trong hệ thống");
		}
		return UserDetailImpl.build(user);
	}

}
