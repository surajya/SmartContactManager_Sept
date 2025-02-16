package com.sme.controller;

import java.security.Principal;

import com.sme.model.Contacts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	//method for common data binding
	@ModelAttribute
	public void getCommondata(Model model, Principal principal) {
		String name = principal.getName();
		User userName = userRepositoryImpl.getUserByUserName(name);
		// System.out.println(userName);
		model.addAttribute("user", userName);
	}



	//UserDashboard home
	@GetMapping("/index")
	public String userDashboard(Model model, Principal principal) {
		model.addAttribute("title", "User Dashboard");
		return "/normal/User_DashBoard";
	}

	//open add-form handler
	@GetMapping("/addContact")
	public String openAddContactForm(Model model, Principal principal) {
		model.addAttribute("title", "Add Contact");
		model.addAttribute("addContact", new Contacts());
		return "/normal/add_contact_form";
	}


}
