package com.sme.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sme.model.User;
import com.sme.repository.UserRepositoryImpl;

@Controller

@RequestMapping("/userControll")
public class UserController {

	UserRepositoryImpl userRepositoryImpl;

	UserController(UserRepositoryImpl uri) {
		userRepositoryImpl = uri;
	}

	@GetMapping("/index")
	public String userDashboard(Model model, Principal principal) {
		String name = principal.getName();
		User userName = userRepositoryImpl.getUserByUserName(name);
		// System.out.println(userName);
		model.addAttribute("user", userName);
		return "/normal/User_DashBoard";
	}
}
