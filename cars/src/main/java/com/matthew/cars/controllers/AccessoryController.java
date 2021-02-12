package com.matthew.cars.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.cars.models.Accessory;
import com.matthew.cars.services.AccessoryService;
import com.matthew.cars.services.CarService;

@Controller
@RequestMapping("/accessory")
public class AccessoryController {
	@Autowired
	private AccessoryService aService;
	@Autowired
	private CarService cService;
	
	@GetMapping("/new")
	public String createAccessory(@ModelAttribute("accessory") Accessory accessory, Model viewModel) {
		viewModel.addAttribute("cars", this.cService.getAllCars());
		return "accessory/new.jsp";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("accessory") Accessory accessory, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("cars", this.cService.getAllCars());
			return "accessory/new.jsp";
		}
		this.aService.create(accessory);
		return "redirect:/";
	}
	
}
