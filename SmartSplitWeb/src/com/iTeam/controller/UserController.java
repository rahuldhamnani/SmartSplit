package com.iTeam.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iTeam.common.UserLogin;
import com.iTeam.common.Users;
import com.iTeam.service.UserService;
import com.iTeam.service.UserServiceImpl;

@Controller
public class UserController {
	@Resource(name="userService")
	UserService userService;

	public UserService getUserServe() {
		return userService;
	}


	public void setUserServe(UserService userServe) {
		this.userService = userServe;
	}
	
	@RequestMapping(value = "/reg",method = RequestMethod.GET)
	public String tp()
	{
		return "register";
	}

	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String showFriendsTransactions(@ModelAttribute("users") Users usr,BindingResult result)
	{
		String json = "", res = "failure";
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (result.hasErrors()) {
				System.out.println("Error");
				
			     return "tp";
			   }
			System.out.println(usr.getFirstName());
			res = userService.addUser(usr);
		}
		catch(Exception e)
		{
			System.out.println("Error in friend's page-------------------------------------------------");
			e.printStackTrace();
		}
		
		return "hello";
	}
}
