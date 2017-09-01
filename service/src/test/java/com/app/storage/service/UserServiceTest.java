package com.app.storage.service;

import com.app.storage.domain.model.User;
import com.app.storage.persistence.service.UserPersistenceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;

/**
 * Test for {@link UserService}
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    /** {@link AuthenticationManager}. */
    @Mock
    private AuthenticationProvider authenticationProvider;

    /** {@link UserPersistenceService}. */
    @Mock
    private UserPersistenceService userPersistenceService;

    /** {@link UserService}. */
    @Mock
    private UserService userService;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        userService = new UserServiceHandler(userPersistenceService, authenticationProvider);
    }

    /**
     * Save user test.
     */
    @Test
    public void saveUserTest() {
        //Setup
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setEmail("email");
        user.setPassword("pass");
        user.setPasswordConfirm("pass");

        //Mock
        Mockito.when(userPersistenceService.saveUser(user)).thenReturn(user);

        //Test
        final User actualUser = userService.saveUser(user);

        //Verify
        Mockito.verify(userPersistenceService).saveUser(user);

        //Assert
        Assert.assertEquals(actualUser, user);
    }


    /**
     * Load by username test.
     */
    @Test
    public void loadByUsernameTest() {

        //Setup
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setEmail("email");
        user.setPassword("pass");
        user.setPasswordConfirm("pass");

        //Mock
        Mockito.when(userPersistenceService.findUserByEmail("email")).thenReturn(user);

        //Test
        final User actualUserDetails = userService.loadUserByUsername("email");

        //Verify
        Mockito.verify(userPersistenceService).findUserByEmail("email");

        //Assert
        Assert.assertEquals(user, actualUserDetails);
    }

}
