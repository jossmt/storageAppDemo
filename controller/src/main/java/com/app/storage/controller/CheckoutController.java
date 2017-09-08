package com.app.storage.controller;

import com.app.storage.domain.model.Address;
import com.app.storage.domain.model.AddressType;
import com.app.storage.domain.model.User;
import com.app.storage.domain.model.payment.PaymentTransaction;
import com.app.storage.service.ItemListingService;
import com.app.storage.service.UserService;
import com.app.storage.service.payment.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Checkout and buy items controller.
 */
@Controller
@RequestMapping(value = "/")
public class CheckoutController {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(CheckoutController.class);

    /** {@link BasketController}. */
    private final BasketController basketController;

    /** {@link ItemListingService}. */
    private final ItemListingService itemListingService;

    /** {@link PaymentService}. */
    private final PaymentService paymentService;

    /** {@link UserService}. */
    private final UserService userService;

    /**
     * Controller
     *
     * @param basketController
     *         {@link BasketController}
     * @param itemListingService
     *         {@link BasketController}
     */
    public CheckoutController(final BasketController basketController,
                              final ItemListingService itemListingService,
                              final PaymentService paymentService,
                              final UserService userService) {

        this.basketController = basketController;
        this.itemListingService = itemListingService;
        this.paymentService = paymentService;
        this.userService = userService;
    }

    /**
     * Renders Checkout view to container.
     *
     * @return Checkout.jsp
     */
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView renderCheckout(final Principal principal) {

        paymentService.initialiseGateway();

        final Double totalPrice = itemListingService.calculateTotalPrice(basketController.getBasketSet());

        final User userInformation = userService.loadUserProfile(principal.getName());

        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("payment/Checkout");
        modelAndView.addObject("totalPrice", totalPrice);
        modelAndView.addObject("basketItems", basketController.getBasketSet());
        modelAndView.addObject("userToken", paymentService.generateClientToken());
        modelAndView.addObject("paymentTransaction", new PaymentTransaction());

        if (userInformation.getPaymentInformation() != null) {
            modelAndView.addObject("defaultPayment", userInformation.getPaymentInformation());
        }

        for (final Address address : userInformation.getAddressList()) {
            if (address.getAddressType().equals(AddressType.DELIVERY)) {
                modelAndView.addObject("defaultAddress", address);
            }
        }

        LOG.debug("Rendering checkout jsp");

        return modelAndView;
    }

    /**
     * Handles checkout payment and success/failure view redirect.
     *
     * @return {@link ModelAndView}
     */
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ModelAndView handleCheckout(@ModelAttribute("paymentInformation") final PaymentTransaction
                                               paymentTransaction,
                                       final Principal principal) {

        LOG.debug("Returning payment details: {}", paymentTransaction.toString());

        paymentTransaction.setBuyerUserRef(principal.getName());
        paymentTransaction.setTransactionAmount(itemListingService
                                                        .calculateTotalPrice(basketController.getBasketSet()));

        final boolean transactionResponse = paymentService.executeTransaction(paymentTransaction);

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("paymentTransaction", paymentTransaction);

        if (transactionResponse) {
            modelAndView.setViewName("payment/CheckoutSuccess");
        } else {
            modelAndView.setViewName("payment/CheckoutFailure");
        }

        LOG.debug("Returning model and view objects for {} transaction response", transactionResponse);

        return modelAndView;
    }
}
