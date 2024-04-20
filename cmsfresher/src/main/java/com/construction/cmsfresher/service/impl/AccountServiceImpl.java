package com.construction.cmsfresher.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.model.MdAccount;
import com.construction.cmsfresher.repository.IAccountRepository;
import com.construction.cmsfresher.service.DaoService;
import com.construction.cmsfresher.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService, DaoService<MdAccount, Integer> {

	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public MdAccount findByUserName(String username) {
		// TODO Auto-generated method stub
		MdAccount account = accountRepository.findByUsername(username);
		return account != null ? account : null;
	}

	@Override
	public MdAccount save(MdAccount entity) {
		// TODO Auto-generated method stub
		return accountRepository.save(entity);
	}

	@Override
	public MdAccount findById(Integer id) {
		MdAccount account = accountRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("Not found Account"));
		return account;
	}

	@Override
	public List<MdAccount> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

}
