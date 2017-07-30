package com.app.storage.service.validation;

import com.app.storage.domain.model.User;
import org.springframework.validation.Errors;

/**
 * Login validation service.
 */
public interface LoginValidationService {

    /**
     * User form validation.
     *
     * @param user
     *         {@link User}
     * @param errors
     *         {@link Errors}
     */
    void validate(Object user, Errors errors);
}
