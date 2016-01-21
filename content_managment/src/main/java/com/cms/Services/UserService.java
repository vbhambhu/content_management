package com.cms.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public interface UserService {
	
	@Transactional
	boolean isEmailExists(String email);
	
	
	@Transactional
	boolean createAccount(String nmae,String email,String password);

}