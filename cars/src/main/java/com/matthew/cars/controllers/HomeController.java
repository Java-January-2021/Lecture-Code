package com.matthew.cars.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.cars.models.Car;
import com.matthew.cars.services.CarService;

@Controller
public class HomeController {
	@Autowired
	private CarService cService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("cars", this.cService.getAllCars());
		return "index.jsp";
	}
	
	@GetMapping("/add")
	public String add(@ModelAttribute("car") Car car) {
		return "add.jsp";
	}
	
	
	@PostMapping("/addCar")
	public String addCar(@Valid @ModelAttribute("car") Car car, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		} else {
			this.cService.createCar(car);
			return "redirect:/";
		}
		
		
	}
	
	//Old Way
	@PostMapping("/oldaddCar")
	public String oldAddCar(@RequestParam("make") String make, @RequestParam("model") String model, @RequestParam("year") int year, @RequestParam("color") String color, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(model.equals("")) {
			errors.add("Hey there, you forgot to add a name");
		}
		if(errors.size() > 0) {
			for(String e : errors) {
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/add";
		}
		this.cService.createCar(make, model, year, color);
		return "redirect:/";
	}
	
	
}
