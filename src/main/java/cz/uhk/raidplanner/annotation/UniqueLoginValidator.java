package cz.uhk.raidplanner.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cz.uhk.raidplanner.repository.UserRepository;

public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(UniqueLogin constraintAnnotation) {		
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if (userRepository == null) {
			return true;
		}
		return userRepository.findByLogin(username) == null;
	}

}
