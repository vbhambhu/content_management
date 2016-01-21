package com.cms.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminC {
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
    public String dashboradPage(Model model) {
		
		model.addAttribute("metaTitle", "Hello" );
        return "admin/home";
    }
	
	@RequestMapping(value="/admin/login", method=RequestMethod.GET)
    public String adminLoginPage() {
        return "admin/login";
    }


}