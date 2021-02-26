package com.matthew.secrets.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.matthew.secrets.models.User;
import com.matthew.secrets.repositories.UserRepository;
@Component
public class UserValidator {

		@Autowired
		private UserRepository uRepo;
		
		public boolean supports(Class<?> clazz) {
			return User.class.equals(clazz);
		}
		
		public void validate(Object target, Errors errors) {
			User user = (User) target;
			
			if(!user.getPassword().equals(user.getConfirmPassword())) {
				errors.rejectValue("password", "Match", "Passwords not match!!!!!!!!!!!!!!!!!!!!!!!");
			}
			
			if(this.uRepo.existsByEmail(user.getEmail())) {
				errors.rejectValue("email", "Unique", "hey there, that email has been taken! Snooze ya lose");
			}
			
			if(user.getFirstName().equals("Matt")) {
				errors.rejectValue("firstName", "noMattsAllowed", "Sorry we're not accepting Matt's at this time");
			}
		}
	}

