package com.cms.Controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.cms.Services.UserService;


@Controller
public class Home {
	
	@Autowired
    private UserService userService;

	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String homePage() {
        return "home";
    }
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
    public String showForm(User user) {
        return "register";
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String checkPersonInfo(@Valid User user, BindingResult bindingResult) {
 
    	if (bindingResult.hasErrors()) {
            return "register";
        }
    	
    	boolean isExists = userService.isEmailExists(user.getEmail());
    	
    	if(isExists){
    		bindingResult.rejectValue("email", "error.user", "An account already exists for this email.");
    	}
    	
    	if (bindingResult.hasErrors()) {
            return "register";
        }
    	
    	userService.createAccount(user.getName(), user.getEmail(), user.getPassword());
    
        return "redirect:/success";
    }

}
