package com.app.storage.service.validation;

import com.app.storage.domain.model.User;
import com.app.storage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Implementation of {@link LoginValidationService}
 */
@Service
public class LoginValidationServiceHandler implements LoginValidationService, Validator {

    /** {@link UserService } */
    private final UserService userService;

    /**
     * Constructor.
     *
     * @param userService
     *         {@link UserService}
     */
    @Autowired
    public LoginValidationServiceHandler(final UserService userService) {
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

        if (userService.loadUserByUsername(user.getEmail()) == null) {
            errors.rejectValue("email", "NotExist.userForm.email");
        }
    }
}
