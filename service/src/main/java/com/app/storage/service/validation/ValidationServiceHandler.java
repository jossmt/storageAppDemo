package com.app.storage.service.validation;

import com.app.storage.domain.model.User;
import com.app.storage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Implementation of {@link ValidationService}
 */
@Service
public class ValidationServiceHandler implements ValidationService, Validator {

    /** {@link UserService } */
    private final UserService userService;

    /**
     * Constructor.
     *
     * @param userService
     *         {@link UserService}
     */
    @Autowired
    public ValidationServiceHandler(final UserService userService) {
        this.userService = userService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate(final Object target, final Errors errors) {

        final User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        if (user.getFirstName().length() < 3 || user.getFirstName().length() > 32) {
            errors.rejectValue("firstName", "Size.userForm.firstName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        if (user.getLastName().length() < 3 || user.getLastName().length() > 32) {
            errors.rejectValue("lastName", "Size.userForm.lastName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if(!user.getEmail().contains("@") || !user.getEmail().contains(".")){
            errors.rejectValue("email", "Email.userForm.email");
        }

        if (userService.loadUserByUsername(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty");
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }

    }
}
