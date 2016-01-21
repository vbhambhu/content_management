package com.cms.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl implements UserService {
	
	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public boolean isEmailExists(String email) {
		
		String SQL = "select count(*) FROM users where email = ?";
		
		boolean result = false;
		int count = jdbcTemplate.queryForObject( SQL, new Object[] { email }, Integer.class);
	
		if (count > 0) {
			result = true;
		}

		return result;
	}
	
	@Override
	public boolean createAccount(String name,String email,String password) {
		
		//Password encrypt
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		
		String SQL = "insert into users (name, email, password) values (?, ?, ?)";
		jdbcTemplate.update( SQL, name, email, hashedPassword);
		return true;
		
	}

	
	
}

