package com.app.storage.controller;

import com.app.storage.domain.model.User;
import com.app.storage.service.UserService;
import com.app.storage.service.validation.ValidationService;
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

    /** {@link ValidationService} */
    private final ValidationService validationService;

    /** {@link UserService} */
    private final UserService userService;

    /**
     * Constructor.
     *
     * @param validationService
     *         {@link ValidationService}
     * @param userService
     *         {@link UserService}
     */
    @Autowired
    public LoginController(final ValidationService validationService, final UserService userService) {

        this.validationService = validationService;
        this.userService = userService;
    }


    /**
     * Renders login view to container.
     *
     * @return Login.jsp
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLogin() {
        return "login/Login";
    }

    /**
     * Renders sign up view to container.
     *
     * @return Signup.jsp
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String renderSignup(final Model model) {
        model.addAttribute("userForm",new User());

        return "login/Signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

        LOG.debug("Signing up with user: {}", userForm);

        validationService.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "login/Signup";
        }

        userService.saveUser(userForm);
        userService.autologin(userForm.getEmail(), userForm.getPasswordConfirm());

        return "about/Home";
    }
}
