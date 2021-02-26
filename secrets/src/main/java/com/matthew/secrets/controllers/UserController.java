package com.matthew.secrets.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.secrets.models.User;
import com.matthew.secrets.services.UserService;
import com.matthew.secrets.validators.UserValidator;
@Controller
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		
		return "index.jsp";
	}
	
	// Register User
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			// if there are validation errors send them back to the front page
			return "index.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/secrets";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam("loginEmail") String email, @RequestParam("loginPassword") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/secrets";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
