package com.app.storage.service;

import com.app.storage.domain.model.User;
import com.app.storage.service.validation.ValidationService;
import com.app.storage.service.validation.ValidationServiceHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

/**
 * Test for {@link ValidationService}
 */
public class ValidationServiceTest {

    /** {@link UserService}. */
    @Mock
    private UserService userService;

    /** {@link ValidationService}. */
    @Mock
    private ValidationService validationService;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        validationService = new ValidationServiceHandler(userService);
    }

    /**
     * User validation test.
     */
    @Test
    public void validateUserValidTest() {

    }
}
