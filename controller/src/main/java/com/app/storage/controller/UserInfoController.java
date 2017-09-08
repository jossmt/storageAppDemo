package com.app.storage.controller;

import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.AddressType;
import com.app.storage.domain.model.User;
import com.app.storage.domain.model.payment.CardType;
import com.app.storage.domain.model.payment.PaymentInformation;
import com.app.storage.service.UserService;
import com.app.storage.service.validation.LoginValidationService;
import com.app.storage.service.validation.SignUpValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Controller for all user login/signup interaction.
 */
@Controller
@RequestMapping("/")
public class UserInfoController {

    /** {@link Logger}. */
    private static final Logger LOG = LoggerFactory.getLogger(UserInfoController.class);

    /** {@link SignUpValidationService} */
    private final SignUpValidationService signUpValidationService;

    /** {@link LoginValidationService} */
    private final LoginValidationService loginValidationService;

    /** {@link UserService} */
    private final UserService userService;

    /** {@link BCryptPasswordEncoder} */
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Constructor.
     *
     * @param signUpValidationService
     *         {@link SignUpValidationService}
     * @param userService
     *         {@link UserService}
     */
    @Autowired
    public UserInfoController(final SignUpValidationService signUpValidationService,
                              final LoginValidationService loginValidationService, final UserService userService,
                              final BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.signUpValidationService = signUpValidationService;
        this.loginValidationService = loginValidationService;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
     * Renders sign up view to container.
     *
     * @return Profile.jsp
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView renderProfile(final Principal principal) {

        LOG.debug("Loading user profile");

        final ModelAndView modelAndView = new ModelAndView();

        final User userDetails = userService.loadUserProfile(principal.getName());

        modelAndView.setViewName("profile/Profile");
        modelAndView.addObject("cardTypes", CardType.values());
        modelAndView.addObject("userModel", userDetails);

        LOG.debug("Successfully loaded user: {}", userDetails);

        return modelAndView;
    }

    /**
     * Function to allow logged in user to update name.
     *
     * @return Profile.jsp
     */
    @RequestMapping(value = "/profile/edit/name", method = RequestMethod.POST)
    public String updateUsername(final Principal principal, @RequestParam("fname") final String firstName,
                                 @RequestParam("lname") final String lastName) {

        LOG.debug("Updating user: {} with first name: {} and last name: {}", principal.getName(), firstName, lastName);

        userService.updateUsername(principal.getName(), firstName, lastName);

        LOG.debug("Successfully updated user name information");

        return "redirect:/profile";
    }

    /**
     * Function to allow logged in user to update email.
     *
     * @return Profile.jsp
     */
    @RequestMapping(value = "/profile/edit/email", method = RequestMethod.POST)
    public String updateUserEmail(final Principal principal,
                                  @RequestParam("email") final String email,
                                  @RequestParam("password") final String password) {

        LOG.debug("Updating user: {} with new email: {}", principal.getName(), email);

        userService.updateUserEmail(principal.getName(), email);

        userService.autologin(email, password);

        LOG.debug("Successfully updated user name information");

        return "redirect:/profile";
    }

    /**
     * Function to allow logged in user to update password.
     *
     * @return Profile.jsp
     */
    @RequestMapping(value = "/profile/edit/password", method = RequestMethod.POST)
    public String updateUserPassword(final Principal principal, @RequestParam("password") final String password,
                                     @RequestParam("passwordConfirm") final String passwordConfirm) {

        LOG.debug("Updating user: {} with new password", principal.getName());

        if (!password.equals(passwordConfirm)) {
            throw new IllegalArgumentException("Passwords don't match");
        }

        userService.updateUserPassword(principal.getName(), password);

        LOG.debug("Successfully updated user name information");

        return "redirect:/profile";
    }

    /**
     * Function to allow logged in user to update address.
     *
     * @return Profile.jsp
     */
    @RequestMapping(value = "/profile/edit/address", method = RequestMethod.POST)
    public String updateUserAddress(final Principal principal, @RequestParam("streetAddress") final String
            streetAddress,
                                    @RequestParam("postcode") final String postcode,
                                    @RequestParam("region") final String region,
                                    @RequestParam("country") final String country,
                                    @RequestParam("addressType") final AddressType addressType) {

        final Address address = new Address();
        address.setStreetAddress(streetAddress);
        address.setDefault(true);
        address.setAddressType(addressType);
        address.setCountryName(country);
        address.setPostcode(postcode);
        address.setRegion(region);

        LOG.debug("Updating user: {} with new address: {}", principal.getName(), address);

        userService.updateUserAddress(principal.getName(), address);

        LOG.debug("Successfully updated user address information");

        return "redirect:/profile";
    }

    /**
     * Function to allow logged in user to update paypal.
     *
     * @return Profile.jsp
     */
    @RequestMapping(value = "/profile/edit/paypal", method = RequestMethod.POST)
    public String updateUserPaypal(final Principal principal, @RequestParam("paypalUsername") final String
            paypalUsername) {

        LOG.debug("Updating user: {} with new paypal: {}", principal.getName(), paypalUsername);

        final PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setPaypalUsername(paypalUsername);

        userService.updateUserPaymentInformation(principal.getName(), paymentInformation);

        LOG.debug("Successfully updated user paypal information");

        return "redirect:/profile";
    }

    /**
     * Function to allow logged in user to update card.
     *
     * @return Profile.jsp
     */
    @RequestMapping(value = "/profile/edit/card", method = RequestMethod.POST)
    public String updateUserCard(final Principal principal, @RequestParam("cardHolderName") final String cardholdername,
                                 @RequestParam("cardNumber") final Long cardNumber,
                                 @RequestParam("cvv") final Integer cvv,
                                 @RequestParam("cardType") final CardType cardType,
                                 @RequestParam("expMonth") final Integer expirationMonth,
                                 @RequestParam("expYear") final Integer expirationYear) {

        final PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCardHolderName(cardholdername);
        paymentInformation.setCardNumber(cardNumber);
        paymentInformation.setCardType(cardType);
        paymentInformation.setCvvValue(cvv);
        paymentInformation.setExpirationMonth(expirationMonth);
        paymentInformation.setExpirationYear(expirationYear);

        LOG.debug("Updating user: {} with new card: {}", principal.getName(), paymentInformation);

        userService.updateUserPaymentInformation(principal.getName(), paymentInformation);

        LOG.debug("Successfully updated user paypal information");

        return "redirect:/profile";
    }
}
