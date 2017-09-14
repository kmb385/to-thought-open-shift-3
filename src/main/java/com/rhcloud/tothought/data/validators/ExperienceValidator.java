package com.rhcloud.tothought.data.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.rhcloud.tothought.data.entities.Experience;

public class ExperienceValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Experience.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Experience experience = (Experience)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", "institution.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organization", "organization.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "startDate.empty");
		
		if(experience.getEndDate() == null && experience.getIsPresent() == false){
			errors.rejectValue("endDate", "endDate.unspecified");
			errors.rejectValue("isPresent", "isPresent.unspecified");
		}
	}
}
