package com.cms.Controllers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

import com.cms.validations.ValidEmail;

public class User {
	
	@Size(min=2, max=30)
    private String name;

	@NotNull
	@NotEmpty
	@Size(min=5, max=30)
	private String password;
	 
	@NotNull
	@NotEmpty
	@Size(max=100)
	@ValidEmail
	private String email;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
