package com.app.storage.controller;

import com.app.storage.domain.model.User;
import com.app.storage.service.UserService;
import com.app.storage.service.validation.LoginValidationService;
import com.app.storage.service.validation.SignUpValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for all user login/signup interaction.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    /** {@link Logger}. */
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    /** {@link SignUpValidationService} */
    private final SignUpValidationService signUpValidationService;

    /** {@link LoginValidationService} */
    private final LoginValidationService loginValidationService;

    /** {@link UserService} */
    private final UserService userService;

    /**
     * Constructor.
     *
     * @param signUpValidationService
     *         {@link SignUpValidationService}
     * @param userService
     *         {@link UserService}
     */
    @Autowired
    public LoginController(final SignUpValidationService signUpValidationService,
                           final LoginValidationService loginValidationService, final UserService userService) {

        this.signUpValidationService = signUpValidationService;
        this.loginValidationService = loginValidationService;
        this.userService = userService;
    }


    /**
     * Renders login view to container.
     *
     * @return Login.jsp
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLogin(final Model model) {
        model.addAttribute("userForm", new User());

        return "login/Login";
    }

    /**
     * Renders sign up view to container.
     *
     * @return Signup.jsp
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String renderSignup(final Model model) {
        model.addAttribute("userForm", new User());

        return "login/Signup";
    }

    /**
     * Registering new user
     *
     * @param userForm
     *         Filled in UserObject form.
     * @param bindingResult
     *         Error Handling.
     * @return redirect URL.
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") final User userForm, final BindingResult bindingResult) {
        LOG.debug("Signing up with user: {}", userForm);

        signUpValidationService.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "login/Signup";
        }

        userService.saveUser(userForm);
        userService.autologin(userForm.getEmail(), userForm.getPassword());

        return "about/Home";
    }

    /**
     * Login service.
     *
     * @param userForm
     *         {@link User}
     * @param bindingResult
     *         {@link BindingResult}
     * @return Redirect success/failure page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("userForm") final User userForm, final BindingResult bindingResult) {
        LOG.debug("Logging in with user: {}", userForm);

        loginValidationService.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "login/Login";
        }

        userService.autologin(userForm.getEmail(), userForm.getPassword());

        LOG.debug("Successfully logged in with user: {}", userForm.getFirstName());

        return "about/Home";
    }
}
