package com.luv2code.springdemo.mvc.validator;

import com.luv2code.springdemo.mvc.annotation.CourseCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String courseCode, ConstraintValidatorContext constraintValidatorContext) {
        if (courseCode != null) return courseCode.startsWith(coursePrefix);
        else return false;
    }
}
