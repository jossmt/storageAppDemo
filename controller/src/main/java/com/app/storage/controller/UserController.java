package com.app.storage.controller;

import com.app.storage.domain.model.User;
import com.app.storage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for all user based interaction.
 */
@Controller
@RequestMapping(value = "/")
public class UserController {

    /** {@link UserService} */
    private final UserService userService;

    /**
     * Controller.
     *
     * @param userService
     *         {@link UserService}
     */
    @Autowired
    public UserController(final UserService userService) {

        this.userService = userService;
    }
}
