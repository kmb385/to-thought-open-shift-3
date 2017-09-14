package com.rhcloud.tothought.data.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.rhcloud.tothought.data.entities.Post;

public class PostValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Post.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty");
	}

}
