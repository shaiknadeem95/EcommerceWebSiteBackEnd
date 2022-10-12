package com.shopping.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopping.admin.user.serviceImpl.UserServiceImpl;
import com.shopping.common.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping(value = "/users")
	public String fetchAllUserDetails(Model model) {
		List<User> listOfAllUsers = userServiceImpl.fetchAllUsers();
		model.addAttribute("listUser", listOfAllUsers);
		return "userPage";
	}

	@GetMapping(value = "/users/new")
	public String returnUserCretionPage(Model model) {
		System.out.println("from returnUserCreationPage");
		User userBean = new User();
		System.out.println(userServiceImpl.fetchAllRoles());
		model.addAttribute("allRoles",userServiceImpl.fetchAllRoles());
		model.addAttribute("user", userBean);
		return "userFormPage";
	}

	@PostMapping(value = "/users/save")
	public String saveNewRoleRecord(User user, RedirectAttributes redirect) {
		System.out.println(user);
		userServiceImpl.saveUserRepo(user);
		redirect.addFlashAttribute("message", "The user has been saved successfully.");
		return "redirect:/users";
	}
}
