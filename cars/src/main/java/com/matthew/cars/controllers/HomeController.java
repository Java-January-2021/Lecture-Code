package com.matthew.cars.controllers;

import java.util.ArrayList;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.cars.models.Car;
import com.matthew.cars.models.Rating;
import com.matthew.cars.models.Registration;
import com.matthew.cars.models.User;
import com.matthew.cars.services.CarService;
import com.matthew.cars.services.RatingService;
import com.matthew.cars.services.RegistrationService;
import com.matthew.cars.services.UserService;
import com.matthew.cars.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private CarService cService;
	@Autowired 
	private RegistrationService rService;
	@Autowired
	private UserService uService;
	@Autowired
	private RatingService ratingService;
	@Autowired
	private UserValidator validator;

	
	
	// @RequestMapping(value="/", method=RequestMethod.POST)
	// @RequestMapping(value="/", method=RequestMethod.GET)
	// @RequestMapping("/");
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		
		return "landing.jsp";
	}
	
	// Register User
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			// if there are validation errors send them back to the front page
			return "landing.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/cars";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam("loginEmail") String email, @RequestParam("loginPassword") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/cars";
	}
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long carId = id;
		// User Object from Database
		User liker = this.uService.find(userId);
		Car likedCar = this.cService.getSingleCar(carId);
		// Tell the service to insert into database
		this.cService.addLiker(liker, likedCar);
		return "redirect:/cars";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long carId = id;
		// User Object from Database
		User unliker = this.uService.find(userId);
		Car unlikedCar = this.cService.getSingleCar(carId);
		// Tell the service to insert into database
		this.cService.removeLiker(unliker, unlikedCar);
		return "redirect:/cars";
	}
	
	@GetMapping("/user/{id}")
	public String userProfile(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("user", this.uService.find(id));
		return "profile.jsp";
	}
	
	@PostMapping("/rate/{id}")
	public String addRating(@PathVariable("id") Long id, @RequestParam("rating") Double rating, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.find(userId);
		Car ratedCar = this.cService.getSingleCar(id);
		Rating newRating = new Rating();
		newRating.setCar(ratedCar);
		newRating.setUser(user);
		newRating.setRating(rating);
		this.ratingService.createRating(newRating);
		return "redirect:/cars";
	}
	
	@GetMapping("/cars")
	public String landing(Model viewModel, HttpSession session) {
		if(session.getAttribute("user_id")== null) {
			return "redirect:/";
		}
		
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.find(userId);
		viewModel.addAttribute("cars", this.cService.getAllCars());
		viewModel.addAttribute("user", user);
		return "index.jsp";
	}
	
	@GetMapping("/add")
	public String add(@ModelAttribute("car") Car car) {
		return "add.jsp";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("tag") Registration registration, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.find(userId);
		viewModel.addAttribute("car", this.cService.getSingleCar(id));
		viewModel.addAttribute("user", user);
		return "show.jsp";

	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.cService.deleteCar(id);
		return "redirect:/cars";
	}
	
	@PostMapping("/addRegistration")
	public String addRegistration(@Valid @ModelAttribute("tag") Registration registration, BindingResult result, Model viewModel) {
		Long carID = registration.getCar().getId();
		if(result.hasErrors()) {
			viewModel.addAttribute("car", this.cService.getSingleCar(carID));
			return "show.jsp";
		} else {
			this.rService.create(registration);
			return "redirect:/" + carID;
		}
	}
	
	@PostMapping("/edit/{id}")
	public String updateCar(@Valid @ModelAttribute("car") Car updatedCar, BindingResult result, @PathVariable("id") Long id, @ModelAttribute("tag") Registration registration, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("car", this.cService.getSingleCar(id));
			return "show.jsp";
		}
		this.cService.updateCar(updatedCar);
		return "redirect:/" + id;
	}
	
	// Way that Doesn't Use Validations
	@PutMapping("/old/edit/{id}")
	public String oldUpdateCar(@PathVariable("id") Long id, @RequestParam("make") String make, @RequestParam("model") String model, @RequestParam("year") int year, @RequestParam("color") String color) {
		Car carToUpdate = this.cService.getSingleCar(id);
		carToUpdate.setMake(make);
		carToUpdate.setModel(model);
		carToUpdate.setYear(year);
		carToUpdate.setColor(color);
		this.cService.updateCar(carToUpdate);
		return "redirect:/" + id;
	}
	
	@PostMapping("/addCar")
	public String addCar(@Valid @ModelAttribute("car") Car car, BindingResult result, HttpSession session) {
		Long userID = (Long)session.getAttribute("user_id");
		User user = this.uService.find(userID);
		car.setUser(user);
		if(result.hasErrors()) {
			return "add.jsp";
		} else {
			this.cService.createCar(car);
			return "redirect:/cars";
		}	
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
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
