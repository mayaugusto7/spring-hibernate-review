package br.com.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidador implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;

	@Override
	public void initialize(CourseCode theCourseCode) {
		this.coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean result;
		
		if (theCode != null) {
			result = theCode.startsWith(this.coursePrefix);
		} else {
			result = true;
		}
		
		return result;
	}

}
