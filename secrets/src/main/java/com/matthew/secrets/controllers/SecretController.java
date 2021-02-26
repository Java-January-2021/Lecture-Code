package com.matthew.secrets.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.secrets.models.Secret;
import com.matthew.secrets.models.User;
import com.matthew.secrets.services.SecretService;
import com.matthew.secrets.services.UserService;

@Controller
@RequestMapping("/secrets")
public class SecretController {
	@Autowired
	private UserService uService;
	@Autowired
	private SecretService sService;
	
	
	@GetMapping("")
	public String landing(@ModelAttribute("secret") Secret secret, Model viewModel, HttpSession session) {
		List<Secret> topSecrets = this.sService.getSecrets();
		viewModel.addAttribute("secrets", topSecrets);
		viewModel.addAttribute("user", this.uService.find((long)session.getAttribute("user_id")));
		return "landing.jsp";
	}
	
	@PostMapping("/addSecret")
	public String addSecret(@Valid @ModelAttribute("secret") Secret secret, BindingResult result, HttpSession session, Model viewModel){
		if(result.hasErrors()) {
			List<Secret> topSecrets = this.sService.getSecrets();
			viewModel.addAttribute("secrets", topSecrets);
			return "landing.jsp";
		}
		Long userID = (Long)session.getAttribute("user_id");
		User user = this.uService.find(userID);
		secret.setCreator(user);
		this.sService.create(secret);
		return "redirect:/secrets";	
	}
	
	@GetMapping("/like/{id}")
	public String like(HttpSession session, @PathVariable("id") Long id) {
		Long userId = (Long)session.getAttribute("user_id");
		User userWhoLiked = this.uService.find(userId);
		Secret secretLiked = this.sService.getSingleSecret(id);
		this.sService.addLiker(userWhoLiked, secretLiked);
		return "redirect:/secrets";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.sService.delete(id);
		return "redirect:/secrets";
	}
}
