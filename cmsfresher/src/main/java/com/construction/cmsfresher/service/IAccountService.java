package com.construction.cmsfresher.service;

import com.construction.cmsfresher.model.MdAccount;

public interface IAccountService {
		
	MdAccount findByUserName(String username);
}
