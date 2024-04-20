package com.construction.cmsfresher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.cmsfresher.model.MdAccount;

public interface IAccountRepository extends JpaRepository<MdAccount, Integer>{
	@Query("Select u from MdAccount u where u.username = ?1 and u.password = ?2")
     MdAccount login(String username, String password);
	
	
	MdAccount findByUsername(String name);
}
